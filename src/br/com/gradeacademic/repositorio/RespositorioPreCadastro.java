package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Acesso;

public class RespositorioPreCadastro {

	public static void salvar(Acesso acesso) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao
					.prepareStatement("INSERT INTO acesso (nome, usuario, senha, nivel, status) VALUES (?,?,?,?,?)");
			parametro.setString(1, acesso.getNome());
			parametro.setString(2, acesso.getUsuario());
			parametro.setString(3, acesso.getSenha());
			parametro.setInt(4, acesso.getNivel());
			parametro.setInt(5, acesso.getStatus());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

}
