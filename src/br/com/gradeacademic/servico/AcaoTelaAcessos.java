package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.TelaAcessos;

public class AcaoTelaAcessos extends TelaAcessos {

	public void botaoNovoAcesso(JButton bNovoAcesso) {
		bNovoAcesso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarAcesso();

			}

		});
	}

	public void botaoCancelar(JButton bCancelar) {
		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				internalCadastraAcesso.dispose();

			}

		});
	}

}
