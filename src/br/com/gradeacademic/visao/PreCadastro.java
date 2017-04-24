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

		JLabel lnome = new JLabel("Nome");
		lnome.setBounds(10, 0, 140, 90);
		tela.add(lnome);

		JTextField cnome = new JTextField();
		cnome.setBounds(10, 60, 345, 30);
		tela.add(cnome);

		JLabel lsobrenome = new JLabel("Sobrenome");
		lsobrenome.setBounds(10, 80, 140, 90);
		tela.add(lsobrenome);

		JTextField csobrenome = new JTextField();
		csobrenome.setBounds(10, 140, 345, 30);
		tela.add(csobrenome);

		JLabel llogin = new JLabel("Login");
		llogin.setBounds(10, 160, 140, 90);
		tela.add(llogin);

		JTextField clogin = new JTextField();
		clogin.setBounds(10, 220, 345, 30);
		tela.add(clogin);

		JLabel lsenha = new JLabel("Senha");
		lsenha.setBounds(10, 240, 150, 90);
		tela.add(lsenha);

		JPasswordField csenha = new JPasswordField();
		csenha.setBounds(10, 300, 150, 30);
		tela.add(csenha);

		JLabel lconfirmarsenha = new JLabel("Confirmar Senha");
		lconfirmarsenha.setBounds(200, 240, 150, 90);
		tela.add(lconfirmarsenha);

		JPasswordField cconfirmarsenha = new JPasswordField();
		cconfirmarsenha.setBounds(200, 300, 155, 30);
		tela.add(cconfirmarsenha);

		JButton bconfirmar = new JButton("Confirmar");
		bconfirmar.setBounds(35, 400, 100, 30);
		tela.add(bconfirmar);

		JButton bvoltar = new JButton("Voltar");
		bvoltar.setBounds(230, 400, 100, 30);
		AcaoPreCadastro.botaoVoltar(bvoltar);
		tela.add(bvoltar);
		
		AcaoPreCadastro.fecharFrame();
	}
}
