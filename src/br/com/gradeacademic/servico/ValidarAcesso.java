package br.com.gradeacademic.servico;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.gradeacademic.visao.Login;

public class ValidarAcesso extends Login {

	public static void validar(JTextField tCampoUsuario, JPasswordField tCampoSenha) {

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
