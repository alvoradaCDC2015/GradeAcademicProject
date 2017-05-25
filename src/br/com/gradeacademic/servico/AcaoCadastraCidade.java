package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraCidade;

public class AcaoCadastraCidade extends CadastraCidade {

	public static void botaoSalvar(JButton bSalvar) {
		// TODO Auto-generated method stub
		
	}

	public static void botaoCancelar(JButton bCancelar) {
		bCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				internalCadastro.dispose();
			}
		});
	}

}
