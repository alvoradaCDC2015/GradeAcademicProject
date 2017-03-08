package br.com.gradeacademic.servico;

import javax.swing.JOptionPane;

import br.com.gradeacademic.visao.TelaLogin;

public class ValidarAcesso extends TelaLogin {

	public static void validar() {

		String admin = "admin";
		String senhaAdmin = "admin";

		String usuario = tCampoUsuario.getText();
		String senha = new String(tCampoSenha.getPassword());

		if (usuario.equals(admin) && senha.equals(senhaAdmin)) {

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

}
