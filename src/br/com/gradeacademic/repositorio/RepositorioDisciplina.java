package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Disciplina;

public class RepositorioDisciplina {

	public static void salvarDisciplina(Disciplina disciplina) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("INSERT INTO pga_disciplina (dis_nome, dis_status) VALUES (?,?)");
			parametro.setString(1, disciplina.getNome());
			parametro.setInt(2, disciplina.getStatus());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Disciplina Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

	public static Disciplina buscarPorId(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet result = null;
		Disciplina disciplina = new Disciplina();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM pga_disciplina WHERE dis_id = ?");
			parametro.setInt(1, id);
			result = parametro.executeQuery();

			if (result.next()) {

				disciplina.setId(result.getInt("dis_id"));
				disciplina.setNome(result.getString("dis_nome"));
				disciplina.setStatus(result.getInt("dis_status"));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return disciplina;

	}

	public static void editar(Disciplina disciplina) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao
					.prepareStatement("UPDATE pga_disciplina SET dis_nome = ?, dis_status = ? WHERE dis_id = ?");
			parametro.setString(1, disciplina.getNome());
			parametro.setInt(2, disciplina.getStatus());
			parametro.setInt(3, disciplina.getId());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Disciplina Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

	public static List<Disciplina> listar() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet result = null;
		List<Disciplina> disciplinas = new ArrayList<>();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM pga_disciplina ORDER BY dis_id");
			result = parametro.executeQuery();

			while (result.next()) {

				Disciplina disciplina = new Disciplina();
				disciplina.setId(result.getInt("dis_id"));
				disciplina.setNome(result.getString("dis_nome"));
				disciplina.setStatus(result.getInt("dis_status"));

				disciplinas.add(disciplina);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return disciplinas;
	}
	
	public static void excluir(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("DELETE FROM pga_disciplina WHERE dis_id = ?");
			parametro.setInt(1, id);
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Disciplina " + id + " Excluida!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

}
