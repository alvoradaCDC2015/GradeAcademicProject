package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Pais;
import br.com.gradeacademic.visao.CadastraPais;

public class RepositorioPais {

	public static boolean salvar(Pais pais) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_PAIS WHERE pais_id = ?");
			parametro.setInt(1, Integer.parseInt(CadastraPais.tID.getText() + 1));
			rs = parametro.executeQuery();

			if (!rs.next()) {

				pais.setId(retornarUltimoId());
				criar(pais);

				return true;

			} else {

				pais.setId(Integer.parseInt(CadastraPais.tID.getText()));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return false;
	}

	public static void criar(Pais pais) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("INSERT INTO PGA_PAIS (pais_nome) VALUES (?)");
			parametro.setString(1, pais.getNome());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Pais de id " + retornarUltimoId() + " Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static void atualizar(Pais pais) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("UPDATE PGA_PAIS SET pais_nome = ? WHERE pais_id= ?");
			parametro.setString(1, pais.getNome());
			parametro.setInt(2, pais.getId());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Pais " + pais.getId() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static List<Pais> listar() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet resultPais = null;
		List<Pais> paises = new ArrayList<>();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_PAIS ORDER BY pais_id");
			resultPais = parametro.executeQuery();

			while (resultPais.next()) {

				Pais pais = new Pais();
				pais.setId(resultPais.getInt("pais_id"));
				pais.setNome(resultPais.getString("pais_nome"));
				paises.add(pais);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return paises;
	}

	public static int retornarUltimoId() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int id = 0;

		try {

			parametro = conexao.prepareStatement("SELECT MAX(pais_id) FROM PGA_PAIS");
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