package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastraCurso extends TelaPrincipal {

	public static JInternalFrame internalCadastraCurso;

	public static void cadastroCurso() {

		internalCadastraCurso = new JInternalFrame("Cadastrar Curso");
		desktopPane.add(internalCadastraCurso);
		internalCadastraCurso.setVisible(true);
		internalCadastraCurso.setBounds(100, 51, 871, 619);
		internalCadastraCurso.setLayout(null);
		internalCadastraCurso.setClosable(true);

		JLabel lNomeCurso = new JLabel("Nome*");
		internalCadastraCurso.add(lNomeCurso);
		lNomeCurso.setBounds(-270, -10, 600, 50);
		lNomeCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tCampoNomeCurso = new JTextField();
		internalCadastraCurso.add(tCampoNomeCurso);
		tCampoNomeCurso.setSize(200, 20);
		tCampoNomeCurso.setLocation(10, 30);

		JLabel lIDCurso = new JLabel("ID");
		internalCadastraCurso.add(lIDCurso);
		lIDCurso.setBounds(-50, -10, 600, 50);
		lIDCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tCampoIDCurso = new JTextField();
		internalCadastraCurso.add(tCampoIDCurso);
		tCampoIDCurso.setSize(30, 20);
		tCampoIDCurso.setLocation(235, 30);

	}

}
