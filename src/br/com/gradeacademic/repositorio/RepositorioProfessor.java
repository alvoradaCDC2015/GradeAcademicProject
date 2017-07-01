package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Professor;

public class RepositorioProfessor {

	public static void salvarProfessor(Professor professor) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement(
					"INSERT INTO PGA_PROFESSOR (pro_nome, pro_contato_email, pro_cpf, pro_senha, pro_nivel_acesso, pro_administrador, pro_coordenador, pro_status,pro_data_nascimento,pro_naturalidade,pro_nacionalidade,pro_contato_telefone_residencial,pro_contato_celular,pro_endereco) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			parametro.setString(1, professor.getNome());
			parametro.setString(2, professor.getEmail());
			parametro.setString(3, professor.getCpf());
			parametro.setString(4, professor.getSenha());
			parametro.setInt(5, professor.getNivelAcesso());
			parametro.setBoolean(6, professor.getAdministrador());
			parametro.setString(7, professor.getCoordenador());
			parametro.setString(8, professor.getStatus());
			parametro.setString(9, professor.getDataNascimento());
			parametro.setString(10, professor.getNaturalidade());
			parametro.setString(11, professor.getNacionalidade());
			parametro.setLong(12, professor.getTelefoneResidencial());
			parametro.setLong(13, professor.getCelular());
			parametro.setInt(14, professor.getEnderecoProfessor());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Usuario Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

}
