package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Disciplina;
import br.com.gradeacademic.repositorio.RepositorioDisciplina;
import br.com.gradeacademic.visao.CadastraDisciplina;
import br.com.gradeacademic.visao.VisualizaDisciplina;

public class AcaoVisualizaDisciplina extends VisualizaDisciplina {

	public static void botaoNovo(JButton bNovo) {

		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraDisciplina.cadastrarDisciplina();
			}
		});
	}

	public static void botaoEditar(JButton bEditar) {

		bEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CadastraDisciplina.editando = 1;

				int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);

				Disciplina disciplina = RepositorioDisciplina.buscarPorId(id);

				CadastraDisciplina.cadastrarDisciplina();

				CadastraDisciplina.tID.setText(String.valueOf(disciplina.getId()));
				CadastraDisciplina.tNome.setText(disciplina.getNome());
				CadastraDisciplina.tStatus.setSelectedIndex(disciplina.getStatus());

			}
		});

	}

	public static void botaoExcluir(JButton bRemover) {

		bRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);

				RepositorioDisciplina.excluir(id);

				AcaoVisualizaDisciplina.listarDisciplinas();

			}
		});

	}

	public static void listarDisciplinas() {

		DefaultTableModel tblRemove = (DefaultTableModel) tabela.getModel();
		int x = tblRemove.getRowCount();
		for (int a = 0; a < x; a++) {
			tblRemove.removeRow(0);
		}

		List<Disciplina> disciplinas = RepositorioDisciplina.listar();
		for (Disciplina disciplina : disciplinas) {

			((DefaultTableModel) tabela.getModel()).addRow(new Object[] { disciplina.getId(), disciplina.getNome() });

		}
	}

}
