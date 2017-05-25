package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import br.com.gradeacademic.visao.Login;
import br.com.gradeacademic.visao.PreCadastro;

public class AcaoLogin extends Login {

	public static void botaoCancelar(JButton bCancelar) {
		bCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);

			}
		});
	}

	public static void botaoAcessar() {
		bAcessar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ValidarAcesso.validarLogin(tCampoUsuario, tCampoSenha);

			}
		});
	}

	public static void campoSenha(JTextField tUsuario, JPasswordField tSenha) {
		tSenha.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					ValidarAcesso.validarLogin(tUsuario, tSenha);

				}
			}
		});
	}

	public static void fecharAplicacao(JInternalFrame internalLogin) {

		internalLogin.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

				internalLogin.dispose();
			}
		});

	}

	public static void botaoCadastrar(JButton bCadastrar) {
		bCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tCampoUsuario.setEnabled(false);
				tCampoSenha.setEnabled(false);
				bAcessar.setEnabled(false);
				bSair.setEnabled(false);
				bCadastrar.setEnabled(false);
				PreCadastro.JanelaPreCadastro();
			}
		});
	}

}
