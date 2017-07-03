package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Professor;

public class RepositorioProfessor {

	public static void salvarProfessor(Professor professor) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("INSERT INTO PGA_PROFESSOR (" + "pro_nome, " + "pro_contato_email, "
					+ "pro_cpf, " + "pro_senha, " + "pro_nivel_acesso, " + "pro_administrador, " + "pro_coordenador, "
					+ "pro_status, " + "pro_data_nascimento, " + "pro_naturalidade, " + "pro_nacionalidade, "
					+ "pro_contato_telefone_residencial, " + "pro_contato_celular, " + "pro_endereco, " + "pro_numero, "
					+ "pro_bairro, " + "pro_cep, " + "pro_cidade ) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			parametro.setString(1, professor.getNome());
			parametro.setString(2, professor.getEmail());
			String cpf = professor.getCpf().replace(".", "");
			cpf = cpf.replace("-", "");
			parametro.setString(3, cpf);
			parametro.setString(4, professor.getSenha());
			parametro.setInt(5, professor.getNivelAcesso());
			parametro.setInt(6, professor.getAdministrador());
			parametro.setInt(7, professor.getCoordenador());
			parametro.setInt(8, professor.getStatus());
			parametro.setString(9, professor.getDataNascimento());
			parametro.setString(10, professor.getNaturalidade());
			parametro.setString(11, professor.getNacionalidade());
			parametro.setLong(12, professor.getTelefoneResidencial());
			parametro.setLong(13, professor.getCelular());
			parametro.setString(14, professor.getEndEndereco());
			parametro.setInt(15, professor.getEndNumero());
			parametro.setString(16, professor.getEndBairro());
			parametro.setString(17, professor.getEndCep());
			parametro.setString(18, professor.getEndCidade());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Professor Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar professor.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

	public static List<Professor> listar() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet resultProfessor = null;
		List<Professor> professores = new ArrayList<>();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM pga_professor ORDER BY pro_id");
			resultProfessor = parametro.executeQuery();

			while (resultProfessor.next()) {

				Professor professor = new Professor();
				professor.setId(resultProfessor.getInt("pro_id"));
				professor.setNome(resultProfessor.getString("pro_nome"));
				professor.setCpf(resultProfessor.getString("pro_cpf"));
				professor.setEmail(resultProfessor.getString("pro_contato_email"));
				professor.setCoordenador(resultProfessor.getInt("pro_coordenador"));

				professores.add(professor);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return professores;
	}

	public static Professor buscarPorId(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet resultProfessor = null;
		Professor professor = new Professor();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM pga_professor WHERE pro_id = ?");
			parametro.setInt(1, id);
			resultProfessor = parametro.executeQuery();

			if (resultProfessor.next()) {

				professor.setId(resultProfessor.getInt("pro_id"));
				professor.setNivelAcesso(resultProfessor.getInt("pro_nivel_acesso"));
				professor.setNome(resultProfessor.getString("pro_nome"));
				professor.setDataNascimento(resultProfessor.getString("pro_data_nascimento"));
				professor.setCpf(resultProfessor.getString("pro_cpf"));
				professor.setNaturalidade(resultProfessor.getString("pro_naturalidade"));
				professor.setNacionalidade(resultProfessor.getString("pro_nacionalidade"));
				professor.setCoordenador(resultProfessor.getInt("pro_coordenador"));
				professor.setAdministrador(resultProfessor.getInt("pro_administrador"));
				professor.setTelefoneResidencial(resultProfessor.getLong("pro_contato_telefone_residencial"));
				professor.setCelular(resultProfessor.getLong("pro_contato_celular"));
				professor.setEmail(resultProfessor.getString("pro_contato_email"));
				professor.setSenha(resultProfessor.getString("pro_senha"));
				professor.setStatus(resultProfessor.getInt("pro_status"));
				professor.setEndEndereco(resultProfessor.getString("pro_endereco"));
				professor.setEndNumero(resultProfessor.getInt("pro_numero"));
				professor.setEndBairro(resultProfessor.getString("pro_numero"));
				professor.setEndCep(resultProfessor.getString("pro_cep"));
				professor.setEndCidade(resultProfessor.getString("pro_cidade"));

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return professor;

	}

	public static void atualizar(Professor professor) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("UPDATE pga_professor SET " + "pro_nome = ?, "
					+ "pro_contato_email = ?, " + "pro_cpf = ?, " + "pro_senha = ?, " + "pro_nivel_acesso = ?,  "
					+ "pro_administrador = ?, " + "pro_coordenador = ?, " + "pro_status = ?, "
					+ "pro_data_nascimento = ?, " + "pro_naturalidade = ?, " + "pro_nacionalidade = ?, "
					+ "pro_contato_telefone_residencial = ?, " + "pro_contato_celular = ?, " + "pro_endereco = ?, "
					+ "pro_numero = ?, " + "pro_bairro = ?, " + "pro_cep = ?, " + "pro_cidade = ? "
					+ "WHERE pro_id = ?");
			parametro.setString(1, professor.getNome());
			parametro.setString(2, professor.getEmail());
			parametro.setString(3, professor.getCpf());
			parametro.setString(4, professor.getSenha());
			parametro.setInt(5, professor.getNivelAcesso());
			parametro.setInt(6, professor.getAdministrador());
			parametro.setInt(7, professor.getCoordenador());
			parametro.setInt(8, professor.getStatus());
			parametro.setString(9, professor.getDataNascimento());
			parametro.setString(10, professor.getNaturalidade());
			parametro.setString(11, professor.getNacionalidade());
			parametro.setLong(12, professor.getTelefoneResidencial());
			parametro.setLong(13, professor.getCelular());
			parametro.setString(14, professor.getEndEndereco());
			parametro.setInt(15, professor.getEndNumero());
			parametro.setString(16, professor.getEndBairro());
			parametro.setString(17, professor.getEndCep());
			parametro.setString(18, professor.getEndCidade());
			parametro.setInt(19, professor.getId());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Professor " + professor.getId() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

	public static void excluir(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("DELETE FROM pga_professor WHERE PRO_ID = ?");
			parametro.setInt(1, id);
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Professor " + id + " Excluido!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

}
