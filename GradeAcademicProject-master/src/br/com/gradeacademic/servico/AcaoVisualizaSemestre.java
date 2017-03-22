package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraSemestre;

public class AcaoVisualizaSemestre {

	public static void botaoNovo(JButton bNovo) {
		bNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraSemestre.cadastrarSemestre();
			}
		});
	}

}
