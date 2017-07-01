package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Cidade;
import br.com.gradeacademic.entidade.Estado;
import br.com.gradeacademic.entidade.Local;
import br.com.gradeacademic.entidade.Pais;
import br.com.gradeacademic.visao.CadastraCidade;

public class RepositorioCidade {
	

	public static boolean salvar(Cidade cidade) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement("SELECT * FROM pga_cidade WHERE cid_id = ?");
			parametro.setInt(1, Integer.parseInt(CadastraCidade.tIDCidade.getText()));
			rs = parametro.executeQuery();

			if (!rs.next()) {

				cidade.setId(retornarUltimoId());
				criar(cidade);
				return true;

			} else {

				cidade.setId(Integer.parseInt(CadastraCidade.tIDCidade.getText()));
				atualizar(cidade);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return false;
	}

	public static void criar(Cidade cidade) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao
					.prepareStatement("INSERT INTO pga_cidade (cid_nome,cid_status,cid_estado) VALUES (?,?,?)");
			parametro.setString(1, cidade.getNome());
			parametro.setBoolean(2, cidade.getStatus());
			parametro.setInt(3, 1);
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cidade" + retornarUltimoId() + " Salva!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static void atualizar(Cidade cidade) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("UPDATE pga_cidade SET nome = ?, status = ? WHERE id = ?");
			parametro.setString(1, cidade.getNome());
			parametro.setBoolean(2, cidade.getStatus());
			parametro.setInt(3, cidade.getId());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cidade " + cidade.getId() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static List<Local> listar() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet resultLocal = null;
		List<Local> locais = new ArrayList<>();

		try {

			parametro = conexao.prepareStatement(
					"SELECT c.cid_id, c.cid_nome, e.est_id, e.est_nome, p.pai_id, p.pai_nome FROM pga_cidade c inner join pga_estado  e on c.cid_estado = e.est_id inner join pga_pais p on p.pai_id = e.est_pais");
			resultLocal = parametro.executeQuery();

			while (resultLocal.next()) {

				Cidade cidade = new Cidade();
				cidade.setId(resultLocal.getInt("cid_id"));
				cidade.setNome(resultLocal.getString("cid_nome"));
				
				Estado estado = new Estado();
				estado.setId(resultLocal.getInt("est_id"));
				estado.setDescricao(resultLocal.getString("est_nome"));
				
				Pais pais = new Pais();
				pais.setId(resultLocal.getInt("pai_id"));
				pais.setNome(resultLocal.getString("est_nome"));

				Local local = new Local();
				local.setNome_cidade(cidade);
				local.setNome_estado(estado);
				local.setNome_pais(pais);
				
				locais.add(local);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return locais;
	}

	public static void inativar(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int statusInativo = 1;

		try {

			parametro = conexao.prepareStatement("UPDATE pga_cidade SET status = ? WHERE id = ?");
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

			parametro = conexao.prepareStatement("SELECT MAX(cid_id) FROM pga_cidade");
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