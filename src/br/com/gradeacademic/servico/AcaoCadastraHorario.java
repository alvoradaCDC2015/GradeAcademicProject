package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraHorario;

public class AcaoCadastraHorario extends CadastraHorario {

	public static void botaoCancelar(JButton bCancelar) {

		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalHorario.dispose();
			}
		});
	}
	
	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(segunda.isSelected()){
					javax.swing.JOptionPane.showMessageDialog(bSalvar, "OK, funfo legal");
					//Ponhar aqui perssistencia dos dados
				}
			}
		});
	}

}
