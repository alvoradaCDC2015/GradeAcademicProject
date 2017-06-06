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
import br.com.gradeacademic.visao.CadastraProfessor;

public class RepositorioProfessor {

	public static boolean salvar(Professor professor) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_PROFESSOR WHERE pro_id = ?");
			parametro.setInt(1, 1);
			rs = parametro.executeQuery();

			if (!rs.next()) {

				professor.setId(15);
				criar(professor);
				return true;

			} else {

				professor.setId(Integer.parseInt(CadastraProfessor.tID.getText()));
				atualizar(professor);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return false;
	}

	public static void criar(Professor professor) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement(
					"INSERT INTO PGA_PROFESSOR (pro_nome, pro_cpf, pro_data_nascimento, pro_status) VALUES (?,?,?,?)");
			parametro.setString(1, professor.getNome());
			parametro.setString(2, professor.getCpf());
			parametro.setDate(3, professor.getDataNascimento());
			parametro.setInt(4, professor.getSituacao());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso " + retornarUltimoId() + " Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static void atualizar(Professor professor) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement(
					"UPDATE PGA_PROFESSOR SET pro_nome = ?, pro_cpf = ?, pro_data_nascimento = ?, pro_status = ? WHERE id = ?");
			parametro.setString(1, professor.getNome());
			parametro.setString(2, professor.getCpf());
			parametro.setDate(3, professor.getDataNascimento());
			parametro.setInt(4, professor.getSituacao());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Professor " + professor.getId() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
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

			parametro = conexao.prepareStatement("SELECT * FROM PGA_PROFESSOR ORDER BY pro_id");
			resultProfessor = parametro.executeQuery();

			while (resultProfessor.next()) {

				Professor professor = new Professor();
				professor.setNome(resultProfessor.getString("nome"));
				professor.setCpf(resultProfessor.getString("cpf"));
				professor.setDataNascimento(resultProfessor.getDate("data_nascimento"));
				professor.setSituacao(resultProfessor.getInt("situacao"));
				professores.add(professor);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return professores;
	}

	public static void inativar(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int statusInativo = 1;

		try {

			parametro = conexao.prepareStatement("UPDATE PGA_PROFESSOR SET status = ? WHERE pro_id = ?");
			parametro.setInt(1, statusInativo);
			parametro.setInt(2, id);
			parametro.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao excluir.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static int retornarUltimoId() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int id = 0;

		try {

			parametro = conexao.prepareStatement("SELECT MAX(id) FROM PGA_PROFESSOR");
			ResultSet rs = parametro.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao retornar ultimo ID.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return id;
	}
}

