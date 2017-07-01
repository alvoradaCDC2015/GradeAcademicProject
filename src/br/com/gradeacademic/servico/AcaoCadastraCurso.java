package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.entidade.Curso;
import br.com.gradeacademic.repositorio.RepositorioCurso;
import br.com.gradeacademic.visao.CadastraCurso;
import br.com.gradeacademic.visao.VisualizaCurso;

public class AcaoCadastraCurso extends CadastraCurso {

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Curso curso = new Curso();
				curso.setNome(tNomeCurso.getText());
				curso.setObservacao(tObservacaoCurso.getText());
			 	curso.setCoordenador(cCoordenadorPertencente.getToolTipText()); //VERIFICAR
				curso.setDuracao(Integer.parseInt(tDuracaoCurso.getText()));

				RepositorioCurso.salvar(curso);

				AcaoCadastraCurso.internalCadastro.dispose();
				VisualizaCurso.visualizarCurso();

			}
		});

	}

	public static void botaoCancelar(JButton bCancelar) {
		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				internalCadastro.dispose();
			}
		});
	}

	public static int buscarUltimoId() {
		return RepositorioCurso.retornarUltimoId();
	}

}
