package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AcaoLogin {

	public static void botaoCancelar(JButton bCancelar) {
		bCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);

			}
		});
	}

	public static void botaoAcessar(JButton bAcessar, JTextField tUsuario, JPasswordField tSenha) {
		bAcessar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ValidarAcesso.validar(tUsuario, tSenha);

			}
		});
	}

	public static void campoSenha(JTextField tUsuario, JPasswordField tSenha) {
		tSenha.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					ValidarAcesso.validar(tUsuario, tSenha);

				}
			}
		});
	}

}
