package br.com.gradeacademic.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.entidade.Professor;
import br.com.gradeacademic.visao.Login;

public class ValidarLogin extends Login {

	public static void validarLogin(JTextField tCampoUsuario, JPasswordField tCampoSenha) {

		String usuario = tCampoUsuario.getText();
		String senha = new String(tCampoSenha.getPassword());

		boolean valido = validarLogin(usuario, senha);

		if (valido) {

			JOptionPane.showMessageDialog(null, "Logado com Sucesso!");

			internalLogin.dispose();

			MenuBar();

		} else {

			JOptionPane.showMessageDialog(null, "Usuario ou senha incorreta.");
			tCampoUsuario.setText("");
			tCampoSenha.setText("");
			tCampoUsuario.requestFocus();

		}

	}

	public static String validarNivelDeAcesso(Acesso acesso) {
		String nivel = "Professor";
		if (acesso.getNivel() == 1) {
			nivel = "Coordenador";
		} else if (acesso.getNivel() == 2) {
			nivel = "Administrador";
		}
		return nivel;
	}

	public static String validarStatus(Acesso acesso) {
		String status = "Ativo";
		if (acesso.getStatus() == 1) {
			status = "Inativo";
		}
		return status;
	}

	public static boolean validarConfirmarSenha(String senha, String confirmarSenha) {

		if (senha.equals(confirmarSenha)) {
			return true;
		}
		return false;
	}

	public static boolean validarLogin(String usuario, String senha) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_PROFESSOR WHERE pro_cpf = ?");
			parametro.setString(1, usuario);
			ResultSet resultAcesso = parametro.executeQuery();

			if (resultAcesso.next()) {

				Professor professor = new Professor();
				professor.setId(resultAcesso.getInt("pro_id"));
				professor.setNome(resultAcesso.getString("pro_nome"));
				professor.setCpf(resultAcesso.getString("pro_cpf"));
				professor.setSenha(resultAcesso.getString("pro_senha"));
				professor.setNivelAcesso(Integer.parseInt(resultAcesso.getString("pro_nivel_acesso")));
				professor.setStatus(resultAcesso.getInt("pro_status"));

				if (senha.equals(professor.getSenha()) && professor.getStatus() == 1) {
					return true;
				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao validar login.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return false;

	}

}
