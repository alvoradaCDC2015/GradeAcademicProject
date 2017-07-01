package br.com.gradeacademic.visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.gradeacademic.servico.AcaoPreCadastroProfessor;

public class PreCadastroProfessor {

	public static JFrame tela;

	public static JTextField tNome;
	public static JTextField tEmail;
	public static JTextField tCpf;
	public static JPasswordField tSenha;

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

		JLabel lEmail = new JLabel("Email");
		lEmail.setBounds(10, 100, 140, 90);
		tela.add(lEmail);

		tEmail = new JTextField();
		tEmail.setBounds(10, 160, 345, 30);
		tela.add(tEmail);

		JLabel lCpf = new JLabel("CPF");
		lCpf.setBounds(10, 190, 150, 90);
		tela.add(lCpf);

		tCpf = new JTextField();
		tCpf.setBounds(10, 250, 150, 30);
		tela.add(tCpf);

		JLabel lSenha = new JLabel("Senha");
		lSenha.setBounds(200, 190, 150, 90);
		tela.add(lSenha);

		tSenha = new JPasswordField();
		tSenha.setBounds(200, 250, 155, 30);
		tela.add(tSenha);

		JButton bCadastrar = new JButton("Cadastrar");
		bCadastrar.setBounds(35, 370, 100, 30);
		AcaoPreCadastroProfessor.botaoCadastrar(bCadastrar);
		tela.add(bCadastrar);

		JButton bVoltar = new JButton("Voltar");
		bVoltar.setBounds(230, 370, 100, 30);
		AcaoPreCadastroProfessor.botaoVoltar(bVoltar);
		tela.add(bVoltar);

		AcaoPreCadastroProfessor.fecharFrame();
	}
}
