package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Professor;

public class RepositorioPreCadastroProfessor {

	public static void salvar(Professor professor) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement(
					"INSERT INTO PGA_PROFESSOR (pro_nome, pro_contato_email, pro_cpf, pro_senha, pro_nivel_acesso, pro_administrador, pro_coordenador, pro_status) VALUES (?,?,?,?,?,?,?,?)");
			parametro.setString(1, professor.getNome());
			parametro.setString(2, professor.getEmail());
			parametro.setString(3, professor.getCpf());
			parametro.setString(4, professor.getSenha());
			parametro.setInt(5, professor.getNivelAcesso());
			parametro.setBoolean(6, professor.getAdministrador());
			parametro.setString(7, professor.getCoordenador());
			parametro.setString(8, professor.getStatus());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Usuario Salvo! \n Entre com seu CPF e Senha cadastrado.");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

}
