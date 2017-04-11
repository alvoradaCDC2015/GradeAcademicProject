package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.com.gradeacademic.visao.CadastraProfessor;

public class AcaoCadastraProfessor extends CadastraProfessor {

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tNome != null && tNome.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "Nome é campo Obrigatório!");
				}

			}
		});
	}

	public static void botaoCancelar(JButton bCancelar) {

		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalCadastro.dispose();
			}
		});
	}

}
