package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCadastroCurso extends TelaPrincipal {

	static JLabel jlNome;
	static JLabel jlCod;
	static JTextField jtCampoNome;
	static JTextField jtCampoCod;

	public static void cadastroCurso() {

		JInternalFrame InternalCadDisciplina = new JInternalFrame();
		desktopPane.add(InternalCadDisciplina);
		InternalCadDisciplina.setVisible(true);
		InternalCadDisciplina.setBounds(100, 51, 300, 200);
		InternalCadDisciplina.setLayout(null);

		jlNome = new JLabel("Curso: *");
		jlNome.setHorizontalAlignment(SwingConstants.CENTER);
		jlNome.setBounds(-270, -10, 600, 50);
		jlNome.setVisible(true);
		InternalCadDisciplina.add(jlNome);

		jtCampoNome = new JTextField();
		jtCampoNome.setSize(200, 20);
		jtCampoNome.setLocation(10, 30);
		jtCampoNome.setVisible(true);
		InternalCadDisciplina.add(jtCampoNome);

		jlCod = new JLabel("Cod: ");
		jlCod.setHorizontalAlignment(SwingConstants.CENTER);
		jlCod.setBounds(-50, -10, 600, 50);
		jlCod.setVisible(true);
		InternalCadDisciplina.add(jlNome);

		jtCampoCod = new JTextField();
		jtCampoCod.setSize(30, 20);
		jtCampoCod.setLocation(235, 30);
		jtCampoCod.setVisible(true);
		InternalCadDisciplina.add(jtCampoCod);

	}

}
