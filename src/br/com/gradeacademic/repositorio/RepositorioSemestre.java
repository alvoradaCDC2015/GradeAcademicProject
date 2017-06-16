package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Semestre;
import br.com.gradeacademic.visao.CadastraSemestre;

public class RepositorioSemestre {

	public static boolean salvar(Semestre semestre) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_SEMESTRE WHERE sem_id = ?");
			parametro.setInt(1, Integer.parseInt(CadastraSemestre.tID.getText()));
			rs = parametro.executeQuery();

			if (!rs.next()) {

				semestre.setId(retornarUltimoId());
				criar(semestre);
				return true;

			} else {

				semestre.setId(Integer.parseInt(CadastraSemestre.tID.getText()));
				atualizar(semestre);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return false;
	}

	public static void criar(Semestre semestre) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("INSERT INTO PGA_SEMESTRE (sem_descricao, sem_observacao) VALUES (?,?)");
			parametro.setString(1, semestre.getDescricao());
			parametro.setString(2, semestre.getObservacao());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Semestre " + retornarUltimoId() + " Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static void atualizar(Semestre semestre) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("UPDATE PGA_SEMESTRE SET sem_descricao = ?, sem_observacao = ? WHERE sem_id= ?");
			parametro.setString(1, semestre.getDescricao());
			parametro.setString(2, semestre.getObservacao());
			parametro.setInt(3, semestre.getId());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Semestre " + semestre.getId() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static List<Semestre> listar() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet resultSemestre = null;
		List<Semestre> semestres = new ArrayList<>();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_SEMESTRE ORDER BY sem_id");
			resultSemestre = parametro.executeQuery();

			while (resultSemestre.next()) {

				Semestre semestre = new Semestre();
				semestre.setId(resultSemestre.getInt("sem_id"));
				semestre.setDescricao(resultSemestre.getString("sem_descricao"));
				semestre.setObservacao(resultSemestre.getString("sem_observacao"));
				semestre.setStatus(Integer.parseInt(resultSemestre.getString("sem_status")));
				semestres.add(semestre);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return semestres;
	}

	public static void inativar(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int statusInativo = 0;

		try {

			parametro = conexao.prepareStatement("UPDATE PGA_SEMESTRE SET sem_status = ? WHERE sem_id = ?");
			parametro.setInt(1, statusInativo);
			parametro.setInt(2, id);
			parametro.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao remover Semestre.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static int retornarUltimoId() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int id = 0;

		try {

			parametro = conexao.prepareStatement("SELECT MAX(sem_id) FROM PGA_SEMESTRE");
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
