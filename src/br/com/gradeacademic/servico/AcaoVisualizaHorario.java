package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.VisualizaHorario;

public class AcaoVisualizaHorario extends VisualizaHorario {

	public static void botaoSair(JButton bSair) {

		bSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				internalHorario.dispose();
			}
		});

	}

}
