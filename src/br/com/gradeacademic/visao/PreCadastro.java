package br.com.gradeacademic.visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.gradeacademic.servico.AcaoPreCadastro;

public class PreCadastro {

	public static JFrame tela;

	public static JTextField tNome;
	public static JTextField tUsuario;
	public static JTextField tLogin;
	public static JPasswordField tSenha;
	public static JPasswordField tConfirmarSenha;

	public static void JanelaPreCadastro() {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		tela = new JFrame("Tela");

		tela.setTitle("Pré Cadastro");
		tela.setSize(371, 528);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);

		tela.setLayout(null);
		tela.setVisible(true);

		JLabel lNome = new JLabel("Nome");
		lNome.setBounds(10, 0, 140, 90);
		tela.add(lNome);

		tNome = new JTextField();
		tNome.setBounds(10, 60, 345, 30);
		tela.add(tNome);

		JLabel lUsuario = new JLabel("Usuário");
		lUsuario.setBounds(10, 80, 140, 90);
		tela.add(lUsuario);

		tUsuario = new JTextField();
		tUsuario.setBounds(10, 140, 345, 30);
		tela.add(tUsuario);

		JLabel lLogin = new JLabel("Login");
		lLogin.setBounds(10, 160, 140, 90);
		tela.add(lLogin);

		tLogin = new JTextField();
		tLogin.setBounds(10, 220, 345, 30);
		tela.add(tLogin);

		JLabel lSenha = new JLabel("Senha");
		lSenha.setBounds(10, 240, 150, 90);
		tela.add(lSenha);

		tSenha = new JPasswordField();
		tSenha.setBounds(10, 300, 150, 30);
		tela.add(tSenha);

		JLabel lConfirmarSenha = new JLabel("Confirmar Senha");
		lConfirmarSenha.setBounds(200, 240, 150, 90);
		tela.add(lConfirmarSenha);

		tConfirmarSenha = new JPasswordField();
		tConfirmarSenha.setBounds(200, 300, 155, 30);
		tela.add(tConfirmarSenha);

		JButton bConfirmar = new JButton("Confirmar");
		bConfirmar.setBounds(35, 400, 100, 30);
		AcaoPreCadastro.botaoConfirmar(bConfirmar);
		tela.add(bConfirmar);

		JButton bVoltar = new JButton("Voltar");
		bVoltar.setBounds(230, 400, 100, 30);
		AcaoPreCadastro.botaoVoltar(bVoltar);
		tela.add(bVoltar);

		AcaoPreCadastro.fecharFrame();
	}
}
