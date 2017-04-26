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

import br.com.gradeacademic.servico.AcaoLogin;

public class Login extends Principal {

	protected static JInternalFrame internalLogin;
	public static JTextField tCampoUsuario;
	public static JPasswordField tCampoSenha;
	public static JButton bAcessar;
	public static JButton bSair;
	public static JButton bCadastrar;

	public static void visualizarLogin() {

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

		tCampoUsuario = new JTextField();
		internalLogin.add(tCampoUsuario);
		tCampoUsuario.setBounds(143, 211, 218, 29);
		tCampoUsuario.requestFocus();

		JLabel lSenha = new JLabel("Senha");
		internalLogin.add(lSenha);
		lSenha.setBounds(143, 263, 218, 17);
		lSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		tCampoSenha = new JPasswordField();
		internalLogin.add(tCampoSenha);
		tCampoSenha.setBounds(143, 282, 218, 29);
		AcaoLogin.campoSenha(tCampoUsuario, tCampoSenha);

		bAcessar = new JButton("Acessar");
		internalLogin.add(bAcessar);
		bAcessar.setBounds(150, 335, 90, 30);
		AcaoLogin.botaoAcessar(bAcessar, tCampoUsuario, tCampoSenha);

		bSair = new JButton("Sair");
		internalLogin.add(bSair);
		bSair.setBounds(262, 335, 90, 30);
		AcaoLogin.botaoCancelar(bSair);
		
		bCadastrar = new JButton("Cadastrar");
		internalLogin.add(bCadastrar);
		bCadastrar.setBounds(200, 400, 100, 30);
		AcaoLogin.botaoCadastrar(bCadastrar);

	}
}
