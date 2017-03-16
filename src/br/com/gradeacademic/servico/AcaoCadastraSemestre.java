package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraSemestre;

public class AcaoCadastraSemestre extends CadastraSemestre {

	public static void botaoSalvar(JButton bSalvar) {

	}

	public static void botaoCancelar(JButton bCancelar) {

		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalCadastro.dispose();
			}
		});
	}

}
