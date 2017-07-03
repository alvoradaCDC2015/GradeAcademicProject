package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.entidade.Disciplina;
import br.com.gradeacademic.repositorio.RepositorioDisciplina;
import br.com.gradeacademic.visao.CadastraDisciplina;
import br.com.gradeacademic.visao.VisualizaDisciplina;

public class AcaoCadastraDisciplina extends CadastraDisciplina {

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (editando == 0) {
					salvar();
				} else if (editando == 1) {
					editar();
				}

				internalCadastro.dispose();
				VisualizaDisciplina.visualizarDisciplina();
				AcaoVisualizaDisciplina.listarDisciplinas();

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

	public static void salvar() {

		Disciplina disciplina = new Disciplina();
		disciplina.setNome(tNome.getText());
		disciplina.setStatus(tStatus.getSelectedIndex());

		RepositorioDisciplina.salvarDisciplina(disciplina);

	}

	public static void editar() {

		Disciplina disciplina = new Disciplina();
		disciplina.setId(Integer.parseInt(tID.getText()));
		disciplina.setNome(tNome.getText());
		disciplina.setStatus(tStatus.getSelectedIndex());

		RepositorioDisciplina.editar(disciplina);

	}

}
