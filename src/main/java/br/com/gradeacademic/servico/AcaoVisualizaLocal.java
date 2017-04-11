package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraLocal;
import br.com.gradeacademic.visao.VisualizaLocal;

public class AcaoVisualizaLocal extends VisualizaLocal {

	public static void botaoNovo(JButton bNovo) {

		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				CadastraLocal.cadastrarLocal();

			}
		});

	}

}
