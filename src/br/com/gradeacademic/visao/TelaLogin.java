package br.com.gradeacademic.visao;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class TelaLogin extends JFrame {
	public TelaLogin() {
		Tela();
		getContentPane().setLayout(null);
	}



	public static void Tela() {

		ConfigTela();
		ComponentesTela();

	}

	public static void ConfigTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle("PGA_LOGIN");
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(1);
		tela.setSize(900, 700);
		tela.setVisible(true);
		tela.getContentPane().setLayout(null);

	

	}

	public static void ComponentesTela() {

	}
}
