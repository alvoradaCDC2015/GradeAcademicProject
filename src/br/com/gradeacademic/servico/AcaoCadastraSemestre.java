package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

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

				if (editando == 0) {
					RepositorioSemestre.criar(semestre);
					System.out.println("criou");
				} else if (editando == 1) {
					semestre.setId(Integer.parseInt(tID.getText()));
					RepositorioSemestre.atualizar(semestre);
					System.out.println("atualizou");
				}

				AcaoCadastraSemestre.internalCadastro.dispose();
				VisualizaSemestre.visualizarSemestre();
				AcaoVisualizaSemestre.listarSemestre((DefaultTableModel) VisualizaSemestre.tabela.getModel());

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
