package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.com.gradeacademic.visao.TelaCadastraProfessor;

public class AcaoTelaCadastraProfessor extends TelaCadastraProfessor {

	public static void botaoSalvar(JButton btnSalvar) {

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tCampoNome != null && tCampoNome.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "Nome é campo Obrigatório!");
				} else {

				}
			}
		});
	}

	public static void botaoCancelar(JButton btnCancelar) {

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalCadProfessor.dispose();
			}
		});
	}

}
