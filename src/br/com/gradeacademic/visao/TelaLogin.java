package br.com.gradeacademic.visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame {

	private JTextField tCampoUsuario;
	private JPasswordField tCampoSenha;
	private JTextField tLogoProvisoria;

	public static void main(String[] args) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {

		}

		new TelaLogin();
	}

	public TelaLogin() {
		Janela();
	}

	public void Janela() {

		// Configurações da Janela

		setVisible(true);
		setSize(520, 528);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setLayout(null);

		JMenuBar mMenuBarLogin = new JMenuBar();
		mMenuBarLogin.setBounds(0, 0, 514, 23);
		getContentPane().add(mMenuBarLogin);

		JMenu mMenuAjuda = new JMenu("Ajuda");
		mMenuBarLogin.add(mMenuAjuda);

		tLogoProvisoria = new JTextField();
		tLogoProvisoria.setFont(new Font("Dialog", Font.PLAIN, 12));
		tLogoProvisoria.setBounds(148, 82, 218, 71);
		getContentPane().add(tLogoProvisoria);
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
		getContentPane().add(bCancelar);
		bCancelar.setFont(new Font("Dialog", Font.PLAIN, 14));

		JButton bAcessar = new JButton("Acessar");
		bAcessar.setBounds(148, 335, 119, 43);
		getContentPane().add(bAcessar);
		bAcessar.setFont(new Font("Dialog", Font.PLAIN, 14));
		bAcessar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String admin = "admin";
				String senhaAdmin = "admin";

				String usuario = tCampoUsuario.getText();
				String senha = new String(tCampoSenha.getPassword());

				if (usuario.equals(admin) && senha.equals(senhaAdmin)) {

					JOptionPane.showMessageDialog(null, "Logado com Sucesso!");

					TelaPrincipal.Principal();
					dispose();

				} else {

					JOptionPane.showMessageDialog(null, "Usuario ou senha incorreta.");
					tCampoUsuario.setText("");
					tCampoSenha.setText("");
					tCampoUsuario.requestFocus();
				}
			}

		});

		tCampoUsuario = new JTextField();
		tCampoUsuario.setBounds(148, 211, 218, 29);
		getContentPane().add(tCampoUsuario);
		tCampoUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoUsuario.setColumns(10);
		tCampoUsuario.requestFocus();

		tCampoSenha = new JPasswordField();
		tCampoSenha.setBounds(148, 282, 218, 29);
		getContentPane().add(tCampoSenha);
		tCampoSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoSenha.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					String admin = "admin";
					String senhaAdmin = "admin";

					String usuario = tCampoUsuario.getText();
					String senha = new String(tCampoSenha.getPassword());

					if (usuario.equals(admin) && senha.equals(senhaAdmin)) {

						JOptionPane.showMessageDialog(null, "Logado com Sucesso!");

						TelaPrincipal.Principal();
						dispose();

					} else {

						JOptionPane.showMessageDialog(null, "Usuario ou senha incorreta.");
						tCampoUsuario.setText("");
						tCampoSenha.setText("");
						tCampoUsuario.requestFocus();

					}

				}

			}
		}

		);

		JLabel lUsuario = new JLabel("Usu\u00E1rio");
		lUsuario.setBounds(148, 182, 218, 17);

		getContentPane().add(lUsuario);
		lUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));

		JLabel lSenha = new JLabel("Senha");
		lSenha.setBounds(148, 252, 218, 17);
		getContentPane().add(lSenha);
		lSenha.setFont(new Font("Dialog", Font.PLAIN, 14));

	}
}
