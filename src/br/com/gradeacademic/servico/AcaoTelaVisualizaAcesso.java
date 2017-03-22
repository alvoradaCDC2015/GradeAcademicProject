package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.TelaCadastraAcesso;
import br.com.gradeacademic.visao.TelaVisualizaAcesso;

public class AcaoTelaVisualizaAcesso extends TelaVisualizaAcesso {

	public static void botaoNovoAcesso(JButton bNovoAcesso) {

		bNovoAcesso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastraAcesso.cadastrarAcesso();

			}

		});
	}

}
