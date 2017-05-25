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

		tela = new JFrame("Pré Cadastro");
		tela.setSize(371, 500);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setVisible(true);

		JLabel lNome = new JLabel("Nome");
		lNome.setBounds(10, 20, 140, 90);
		tela.add(lNome);

		tNome = new JTextField();
		tNome.setBounds(10, 80, 345, 30);
		tela.add(tNome);

		JLabel lUsuario = new JLabel("Usuário");
		lUsuario.setBounds(10, 100, 140, 90);
		tela.add(lUsuario);

		tUsuario = new JTextField();
		tUsuario.setBounds(10, 160, 345, 30);
		tela.add(tUsuario);

		JLabel lSenha = new JLabel("Senha");
		lSenha.setBounds(10, 190, 150, 90);
		tela.add(lSenha);

		tSenha = new JPasswordField();
		tSenha.setBounds(10, 250, 150, 30);
		tela.add(tSenha);

		JLabel lConfirmarSenha = new JLabel("Confirmar Senha");
		lConfirmarSenha.setBounds(200, 190, 150, 90);
		tela.add(lConfirmarSenha);

		tConfirmarSenha = new JPasswordField();
		tConfirmarSenha.setBounds(200, 250, 155, 30);
		tela.add(tConfirmarSenha);

		JButton bCadastrar = new JButton("Cadastrar");
		bCadastrar.setBounds(35, 370, 100, 30);
		AcaoPreCadastro.botaoCadastrar(bCadastrar);
		tela.add(bCadastrar);

		JButton bVoltar = new JButton("Voltar");
		bVoltar.setBounds(230, 370, 100, 30);
		AcaoPreCadastro.botaoVoltar(bVoltar);
		tela.add(bVoltar);

		AcaoPreCadastro.fecharFrame();
	}
}
