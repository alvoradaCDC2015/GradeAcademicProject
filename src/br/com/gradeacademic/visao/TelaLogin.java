package br.com.gradeacademic.visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.gradeacademic.servico.ValidarAcesso;

public class TelaLogin extends TelaPrincipal {

	protected static JTextField tCampoUsuario;
	protected static JPasswordField tCampoSenha;
	protected static JTextField tLogoProvisoria;
	protected static JInternalFrame internalLogin = new JInternalFrame("Login");

	public static void login() {

		desktopPane.add(internalLogin);
		internalLogin.setVisible(true);
		internalLogin.setClosable(true);
		internalLogin.setLayout(null);
		internalLogin.setBounds(100, 51, 520, 528);

		JMenuBar mMenuBarLogin = new JMenuBar();
		mMenuBarLogin.setBounds(0, 0, 514, 23);
		internalLogin.add(mMenuBarLogin);

		JMenu mMenuAjuda = new JMenu("Ajuda");
		mMenuBarLogin.add(mMenuAjuda);

		tLogoProvisoria = new JTextField();
		tLogoProvisoria.setFont(new Font("Dialog", Font.PLAIN, 12));
		tLogoProvisoria.setBounds(148, 82, 218, 71);
		internalLogin.add(tLogoProvisoria);
		tLogoProvisoria.setEnabled(false);
		tLogoProvisoria.setEditable(false);
		tLogoProvisoria.setHorizontalAlignment(SwingConstants.CENTER);
		tLogoProvisoria.setText("LOGO");
		tLogoProvisoria.setColumns(10);

		JButton bCancelar = new JButton("Cancelar");
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);

			}
		});
		bCancelar.setBounds(278, 335, 88, 43);
		internalLogin.add(bCancelar);
		bCancelar.setFont(new Font("Dialog", Font.PLAIN, 14));

		JButton bAcessar = new JButton("Acessar");
		bAcessar.setBounds(148, 335, 119, 43);
		internalLogin.add(bAcessar);
		bAcessar.setFont(new Font("Dialog", Font.PLAIN, 14));
		bAcessar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ValidarAcesso.validar();

			}

		});

		tCampoUsuario = new JTextField();
		tCampoUsuario.setBounds(148, 211, 218, 29);
		internalLogin.add(tCampoUsuario);
		tCampoUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoUsuario.setColumns(10);
		tCampoUsuario.requestFocus();

		tCampoSenha = new JPasswordField();
		tCampoSenha.setBounds(148, 282, 218, 29);
		internalLogin.add(tCampoSenha);
		tCampoSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoSenha.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					ValidarAcesso.validar();

				}

			}
		}

		);

		JLabel lUsuario = new JLabel("Usu\u00E1rio");
		lUsuario.setBounds(148, 182, 218, 17);

		internalLogin.add(lUsuario);
		lUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));

		JLabel lSenha = new JLabel("Senha");
		lSenha.setBounds(148, 252, 218, 17);
		internalLogin.add(lSenha);
		lSenha.setFont(new Font("Dialog", Font.PLAIN, 14));

	}
}
