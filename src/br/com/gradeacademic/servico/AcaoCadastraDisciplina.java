package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraDisciplina;

public class AcaoCadastraDisciplina extends CadastraDisciplina {

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
