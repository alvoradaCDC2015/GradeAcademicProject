package br.com.gradeacademic.servico;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.repositorio.RepositorioAcesso;
import br.com.gradeacademic.visao.Login;

public class ValidarAcesso extends Login {

	public static void validarLogin(JTextField tCampoUsuario, JPasswordField tCampoSenha) {

		String usuario = tCampoUsuario.getText();
		String senha = new String(tCampoSenha.getPassword());

		boolean valido = RepositorioAcesso.validarLogin(usuario, senha);

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

}
