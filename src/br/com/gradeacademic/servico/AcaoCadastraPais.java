package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.entidade.Pais;
import br.com.gradeacademic.repositorio.RepositorioPais;
import br.com.gradeacademic.visao.CadastraPais;


public class AcaoCadastraPais extends CadastraPais {

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Pais pais = new Pais();
				pais.setNome(tNome.getText());

				RepositorioPais.salvar(pais);

				AcaoCadastraPais.internalCadastro.dispose();
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

	public static int buscarUltimoId() {
		return RepositorioPais.retornarUltimoId();
	}

}
