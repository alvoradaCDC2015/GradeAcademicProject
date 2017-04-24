package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.visao.CadastraAcesso;
import br.com.gradeacademic.visao.VisualizaAcesso;

public class RepositorioAcesso {

	public static void salvar(Acesso acesso) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement("SELECT * FROM acesso WHERE id = ?");
			parametro.setInt(1, Integer.parseInt(CadastraAcesso.tID.getText()));
			rs = parametro.executeQuery();

			String status = null;
			if (acesso.getStatus() == 0) {
				status = "Ativo";
			} else {
				status = "Inativo";
			}

			if (!rs.next()) {
				acesso.setId(retornarUltimoId());
				criar(acesso);

				if (VisualizaAcesso.tabela != null) {
					DefaultTableModel model = (DefaultTableModel) VisualizaAcesso.tabela.getModel();
					model.addRow(new Object[] { retornarUltimoId(), acesso.getNome(), acesso.getUsuario(),
							acesso.getSenha(), acesso.getNivel(), status });
				}

			} else {
				acesso.setId(Integer.parseInt(CadastraAcesso.tID.getText()));
				atualizar(acesso);

				if (VisualizaAcesso.tabela != null) {
					VisualizaAcesso.tabela.setValueAt(acesso.getId() + 1, VisualizaAcesso.tabela.getSelectedRow(), 0);
					VisualizaAcesso.tabela.setValueAt(acesso.getNome(), VisualizaAcesso.tabela.getSelectedRow(), 1);
					VisualizaAcesso.tabela.setValueAt(acesso.getUsuario(), VisualizaAcesso.tabela.getSelectedRow(), 2);
					VisualizaAcesso.tabela.setValueAt(acesso.getSenha(), VisualizaAcesso.tabela.getSelectedRow(), 3);
					VisualizaAcesso.tabela.setValueAt(acesso.getNivel(), VisualizaAcesso.tabela.getSelectedRow(), 4);
					VisualizaAcesso.tabela.setValueAt(status, VisualizaAcesso.tabela.getSelectedRow(), 5);
				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

	public static void criar(Acesso acesso) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		try {

			parametro = conexao
					.prepareStatement("INSERT INTO acesso (nome, usuario, senha, nivel, status) VALUES (?,?,?,?,?)");
			parametro.setString(1, acesso.getNome());
			parametro.setString(2, acesso.getUsuario());
			parametro.setString(3, acesso.getSenha());
			parametro.setString(4, acesso.getNivel());
			parametro.setInt(5, acesso.getStatus());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso " + retornarUltimoId() + " Criado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

	public static void atualizar(Acesso acesso) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement(
					"UPDATE acesso SET nome = ?, usuario = ?, senha = ?, nivel = ?, status = ? WHERE id = ?");
			parametro.setString(1, acesso.getNome());
			parametro.setString(2, acesso.getUsuario());
			parametro.setString(3, acesso.getSenha());
			parametro.setString(4, acesso.getNivel());
			parametro.setInt(5, acesso.getStatus());
			parametro.setInt(6, acesso.getId());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso " + acesso.getId() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

	public static List<Acesso> listar() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet resultAcesso = null;
		List<Acesso> acessos = new ArrayList<>();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM acesso");
			resultAcesso = parametro.executeQuery();

			while (resultAcesso.next()) {

				Acesso acesso = new Acesso();
				acesso.setId(resultAcesso.getInt("id"));
				acesso.setNome(resultAcesso.getString("nome"));
				acesso.setUsuario(resultAcesso.getString("usuario"));
				acesso.setSenha(resultAcesso.getString("senha"));
				acesso.setNivel(resultAcesso.getString("nivel"));
				acesso.setStatus(Integer.parseInt(resultAcesso.getString("status")));

				acessos.add(acesso);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return acessos;

	}

	public static void deletar(int id) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("DELETE FROM acesso WHERE id = ?");
			parametro.setInt(1, id);

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

			parametro = conexao.prepareStatement("SELECT MAX(id) FROM acesso");
			ResultSet rs = parametro.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage() + " - ao retornar ultimo ID.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return id;

	}

}
