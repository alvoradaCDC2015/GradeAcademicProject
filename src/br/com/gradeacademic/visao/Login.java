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

	public static void visualizarLogin() {

		internalLogin = new JInternalFrame("Login");
		desktopPane.add(internalLogin);
		internalLogin.setVisible(true);
		internalLogin.setClosable(true);
		internalLogin.setLayout(null);
		internalLogin.setBounds(100, 51, 520, 528);

		AcaoLogin.fecharAplicacao(internalLogin);

		JMenuBar mMenuBarLogin = new JMenuBar();
		mMenuBarLogin.setBounds(0, 0, 514, 23);
		internalLogin.add(mMenuBarLogin);

		JMenu mMenuAjuda = new JMenu("Ajuda");
		mMenuBarLogin.add(mMenuAjuda);

		JTextField tLogo = new JTextField();
		internalLogin.add(tLogo);
		tLogo.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tLogo.setBounds(143, 82, 218, 71);
		tLogo.setEnabled(false);
		tLogo.setHorizontalAlignment(SwingConstants.CENTER);
		tLogo.setText("LOGO");
		tLogo.setColumns(10);

		JLabel lUsuario = new JLabel("Usuário");
		internalLogin.add(lUsuario);
		lUsuario.setBounds(143, 191, 218, 17);
		lUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tUsuario = new JTextField();
		internalLogin.add(tUsuario);
		tUsuario.setBounds(143, 211, 218, 29);
		tUsuario.requestFocus();

		JLabel lSenha = new JLabel("Senha");
		internalLogin.add(lSenha);
		lSenha.setBounds(143, 263, 218, 17);
		lSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JPasswordField tSenha = new JPasswordField();
		internalLogin.add(tSenha);
		tSenha.setBounds(143, 282, 218, 29);
		AcaoLogin.campoSenha(tUsuario, tSenha);

		JButton bAcessar = new JButton("Acessar");
		internalLogin.add(bAcessar);
		bAcessar.setBounds(143, 335, 119, 43);
		AcaoLogin.botaoAcessar(bAcessar, tUsuario, tSenha);

		JButton bCancelar = new JButton("Cancelar");
		internalLogin.add(bCancelar);
		bCancelar.setBounds(272, 335, 88, 43);
		AcaoLogin.botaoCancelar(bCancelar);

	}
}
