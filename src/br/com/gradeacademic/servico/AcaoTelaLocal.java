package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.gradeacademic.visao.TelaLocal;

public class AcaoTelaLocal extends TelaLocal {

	public static void botaoSalvar(JButton btnSalvar, JTextField tCampoCidade) {

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tCampoCidade != null && tCampoCidade.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "Insira o nome da Cidade!");
				} else {

				}
			}
		});

	}

	public static void botaoCancelar(JButton btnCancelar) {

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				internalCadastraLocal.dispose();

			}
		});

	}

	public static void botaoNovoLocal(JButton bNovoLocal) {

		bNovoLocal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				TelaLocal.cadastrarLocal();

			}
		});

	}

}
