package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.entidade.Semestre;
import br.com.gradeacademic.repositorio.RepositorioSemestre;
import br.com.gradeacademic.visao.CadastraSemestre;
import br.com.gradeacademic.visao.VisualizaSemestre;

public class AcaoCadastraSemestre extends CadastraSemestre {

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Semestre semestre = new Semestre();
				semestre.setDescricao(tDescricao.getText());
				semestre.setObservacao(tObservacao.getText());

				RepositorioSemestre.salvar(semestre);

				AcaoCadastraSemestre.internalCadastro.dispose();
				VisualizaSemestre.visualizarSemestre();

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
		return RepositorioSemestre.retornarUltimoId();
	}

}
