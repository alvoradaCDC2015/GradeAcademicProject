package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.TelaCadastraLocal;
import br.com.gradeacademic.visao.TelaVisualizaLocal;

public class AcaoTelaVisualizaLocal extends TelaVisualizaLocal {

	public static void botaoNovoLocal(JButton bNovoLocal) {

		bNovoLocal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				TelaCadastraLocal.cadastrarLocal();

			}
		});

	}

	public static void botaoEditarLocal(JButton bEditarLocal) {
		bEditarLocal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				TelaCadastraLocal.cadastrarLocal();

			}
		});
	}

}
