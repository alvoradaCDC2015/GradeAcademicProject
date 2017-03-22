package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;

public class TelaVisualizaCurso extends TelaPrincipal {

	public static JInternalFrame internalVisualizaCurso;

	public static void visualizarCurso() {

		internalVisualizaCurso = new JInternalFrame("Curso");
		desktopPane.add(internalVisualizaCurso);
		internalVisualizaCurso.setVisible(true);
		internalVisualizaCurso.setBounds(100, 51, 871, 619);
		internalVisualizaCurso.setLayout(null);
		internalVisualizaCurso.setClosable(true);

	}

}
