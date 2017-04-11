package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraCurso;

public class AcaoCadastraCurso extends CadastraCurso {

	public static void botaoSalvar(JButton bSalvar) {

	}

	public static void botaoCancelar(JButton bCancelar) {
		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				internalCadastro.dispose();
			}
		});
	}

}
