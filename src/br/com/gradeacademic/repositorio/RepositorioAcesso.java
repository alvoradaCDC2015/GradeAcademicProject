package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Acesso;

public class RepositorioAcesso {

	public static void criar(Acesso acesso) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("INSERT INTO acesso (id,nome, usuario, senha) VALUES (?,?,?,?)");
			parametro.setInt(1, acesso.getId());
			parametro.setString(2, acesso.getNome());
			parametro.setString(3, acesso.getUsuario());
			parametro.setString(4, acesso.getSenha());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso " + acesso.getNome() + " Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: '" + e.getMessage() + "' ao salvar.");
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

				acessos.add(acesso);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: '" + e.getMessage() + "' ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return acessos;

	}
	
	public static void atualizar(Acesso acesso) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("UPDATE acesso SET id = ?,nome = ?, usuario = ?, senha = ? WHERE id = ?");
			parametro.setInt(1, acesso.getId());
			parametro.setString(2, acesso.getNome());
			parametro.setString(3, acesso.getUsuario());
			parametro.setString(4, acesso.getSenha());
			parametro.setInt(5, acesso.getId());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso " + acesso.getNome() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: '" + e.getMessage() + "' ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}
	
	public static void deletar(Acesso acesso) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("DELETE FROM acesso WHERE id = ?");
			parametro.setInt(1, acesso.getId());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso " + acesso.getNome() + " Excluido!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: '" + e.getMessage() + "' ao Excluir.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

}
