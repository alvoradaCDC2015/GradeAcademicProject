package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Estado;
import br.com.gradeacademic.visao.CadastraEstado;

public class RepositorioEstado {
	public static boolean salvar(Estado estado) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement("SELECT * FROM pga_estado WHERE est_id = ?");
			parametro.setInt(1, Integer.parseInt(CadastraEstado.tID.getText() + 1));
			rs = parametro.executeQuery();

			if (!rs.next()) {

				estado.setId(retornarUltimoId());
				criar(estado);
				return true;

			} else {

				estado.setId(Integer.parseInt(CadastraEstado.tID.getText()));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return false;
	}

	public static void criar(Estado estado) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement(
					"INSERT INTO PGA_ESTADO (est_pais,est_nome,est_descricao, est_sigla, est_status) VALUES (?,?, ?,?,?)");
			parametro.setInt(1, estado.getPais());
			parametro.setString(2, estado.getNome());
			parametro.setString(3, estado.getDescricao());
			parametro.setString(4, estado.getSigla());
			parametro.setBoolean(5, estado.getStatus());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Estado " + retornarUltimoId() + " Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static void atualizar(Estado estado) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement(
					"UPDATE PGA_ESTADO SET est_pais = ?,est_nome = ?, est_descricao = ?, est_sigla = ?,  WHERE est_id = ?");
			parametro.setString(1, estado.getDescricao());
			parametro.setString(2, estado.getSigla());
			parametro.setInt(3, estado.getPais());
			parametro.setInt(4, estado.getId());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Estado " + estado.getId() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static List<Estado> listar() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet resultEstado = null;
		List<Estado> estados = new ArrayList<>();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_Estado ORDER BY est_id");
			resultEstado = parametro.executeQuery();

			while (resultEstado.next()) {

				Estado estado = new Estado();
				estado.setId(resultEstado.getInt("est_id"));
				estado.setPais((resultEstado.getInt("est_pais")));
				estado.setNome(resultEstado.getString("est_nome"));
				estado.setDescricao(resultEstado.getString("est_descricao"));
				estado.setSigla(resultEstado.getString("est_sigla"));
				estado.setStatus((resultEstado.getBoolean("est_status")));
				estados.add(estado);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return estados;
	}

	public static void inativar(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int statusInativo = 1;

		try {

			parametro = conexao.prepareStatement("UPDATE PGA_ESTADO SET est_status = ? WHERE est_id = ?");
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

			parametro = conexao.prepareStatement("SELECT MAX(est_id) FROM pga_estado");
			ResultSet rs = parametro.executeQuery();

			if (rs.next()) {
				id = rs.getInt("max");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao retornar ultimo ID.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return id;
	}

}
