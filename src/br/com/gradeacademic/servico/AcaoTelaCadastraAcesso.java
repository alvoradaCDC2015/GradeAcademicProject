package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.TelaCadastraAcesso;

public class AcaoTelaCadastraAcesso extends TelaCadastraAcesso {

	public static void botaoCancelar(JButton btnCancelar) {

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				internalCadastraAcesso.dispose();

			}

		});
	}

}
