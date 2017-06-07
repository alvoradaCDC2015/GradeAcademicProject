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

public class RepositorioEstado {
	public static boolean salvar(Estado estado) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

				estado.setId(1);
				criar(estado);
				return true;

	}

	public static void criar(Estado estado) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao
					.prepareStatement("INSERT INTO PGA_ESTADO (est_descricao, est_sigla, est_pais) VALUES (?,?,?)");
			parametro.setString(1, estado.getDescricao());
			parametro.setString(2, estado.getSigla());
			parametro.setString(3, estado.getPais());
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
					"UPDATE PGA_ESTADO SET est_descricao = ?, est_sigla = ?, est_pais = ? WHERE id = ?");
			parametro.setString(1, estado.getDescricao());
			parametro.setString(2, estado.getSigla());
			parametro.setString(3, estado.getPais());
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
				estado.setId(resultEstado.getInt("id"));
				estado.setNome(resultEstado.getString("nome"));
				estado.setDescricao(resultEstado.getString("descricao"));
				estado.setSigla(resultEstado.getString("sigla"));
				estado.setStatus((resultEstado.getBoolean("status")));
				estado.setPais((resultEstado.getString("pais")));
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

			parametro = conexao.prepareStatement("UPDATE PGA_ESTADO SET status = ? WHERE id = ?");
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

			parametro = conexao.prepareStatement("SELECT MAX(id) FROM PGA_ESTADO");
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
