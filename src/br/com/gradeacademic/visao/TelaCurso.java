package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCurso extends TelaPrincipal {

	public static void cadastroCurso() {

		JInternalFrame internalCadastraCurso = new JInternalFrame();
		desktopPane.add(internalCadastraCurso);
		internalCadastraCurso.setVisible(true);
		internalCadastraCurso.setBounds(100, 51, 871, 619);
		internalCadastraCurso.setLayout(null);
		internalCadastraCurso.setClosable(true);

		JLabel lNomeCurso = new JLabel("Nome*");
		lNomeCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lNomeCurso.setBounds(-270, -10, 600, 50);
		lNomeCurso.setVisible(true);
		internalCadastraCurso.add(lNomeCurso);

		JTextField tCampoNomeCurso = new JTextField();
		tCampoNomeCurso.setSize(200, 20);
		tCampoNomeCurso.setLocation(10, 30);
		tCampoNomeCurso.setVisible(true);
		internalCadastraCurso.add(tCampoNomeCurso);

		JLabel lIDCurso = new JLabel("ID");
		lIDCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lIDCurso.setBounds(-50, -10, 600, 50);
		lIDCurso.setVisible(true);
		internalCadastraCurso.add(lIDCurso);

		JTextField tCampoIDCurso = new JTextField();
		tCampoIDCurso.setSize(30, 20);
		tCampoIDCurso.setLocation(235, 30);
		tCampoIDCurso.setVisible(true);
		internalCadastraCurso.add(tCampoIDCurso);

	}

	public static void visualizarCurso() {

	}

}
