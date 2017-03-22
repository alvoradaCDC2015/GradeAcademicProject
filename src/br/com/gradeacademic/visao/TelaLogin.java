package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.gradeacademic.servico.AcaoTelaLogin;

public class TelaLogin extends TelaPrincipal {

	protected static JInternalFrame internalLogin;

	public static void login() {

		internalLogin = new JInternalFrame("Login");
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

		JTextField tLogoProvisoria = new JTextField();
		internalLogin.add(tLogoProvisoria);
		tLogoProvisoria.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tLogoProvisoria.setBounds(143, 82, 218, 71);
		tLogoProvisoria.setEnabled(false);
		tLogoProvisoria.setHorizontalAlignment(SwingConstants.CENTER);
		tLogoProvisoria.setText("LOGO");
		tLogoProvisoria.setColumns(10);

		JLabel lUsuario = new JLabel("Usuário");
		internalLogin.add(lUsuario);
		lUsuario.setBounds(143, 191, 218, 17);
		lUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tCampoUsuario = new JTextField();
		internalLogin.add(tCampoUsuario);
		tCampoUsuario.setBounds(143, 211, 218, 29);
		tCampoUsuario.requestFocus();

		JLabel lSenha = new JLabel("Senha");
		internalLogin.add(lSenha);
		lSenha.setBounds(143, 263, 218, 17);
		lSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JPasswordField tCampoSenha = new JPasswordField();
		internalLogin.add(tCampoSenha);
		tCampoSenha.setBounds(143, 282, 218, 29);
		AcaoTelaLogin.campoSenha(tCampoUsuario, tCampoSenha);

		JButton bAcessar = new JButton("Acessar");
		internalLogin.add(bAcessar);
		bAcessar.setBounds(143, 335, 119, 43);
		AcaoTelaLogin.botaoAcessar(bAcessar, tCampoUsuario, tCampoSenha);

		JButton bCancelar = new JButton("Cancelar");
		internalLogin.add(bCancelar);
		bCancelar.setBounds(272, 335, 88, 43);
		AcaoTelaLogin.botaoCancelar(bCancelar);

	}
}
