package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AcaoTelaLogin {

	public static void botaoCancelar(JButton bCancelar) {
		bCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);

			}
		});
	}

	public static void botaoAcessar(JButton bAcessar, JTextField tCampoUsuario, JPasswordField tCampoSenha) {
		bAcessar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ValidarAcesso.validar(tCampoUsuario, tCampoSenha);

			}
		});
	}

	public static void campoSenha(JTextField tCampoUsuario, JPasswordField tCampoSenha) {
		tCampoSenha.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					ValidarAcesso.validar(tCampoUsuario, tCampoSenha);

				}
			}
		});
	}

}
