package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Semestre;
import br.com.gradeacademic.repositorio.RepositorioSemestre;
import br.com.gradeacademic.visao.CadastraSemestre;
import br.com.gradeacademic.visao.VisualizaSemestre;

public class AcaoVisualizaSemestre extends VisualizaSemestre {

	public static void listarSemestre(DefaultTableModel tabela) {
		List<Semestre> semestres = RepositorioSemestre.listar();

		for (Semestre semestre : semestres) {

			tabela.addRow(new Object[] { semestre.getId(), semestre.getDescricao(), semestre.getObservacao() });
		}

	}

	public static void botaoNovo(JButton bNovo) {
		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraSemestre.editando = 0;
				AcaoVisualizaSemestre.internalVisualiza.dispose();
				CadastraSemestre.cadastrarSemestre();
			}
		});

	}

	public static void botaoEditar(JButton bEditar, JTable tabela) {

		bEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tabela.getSelectedRow() > -1) {

					CadastraSemestre.editando = 1;

					try {

						String id = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0));
						String descricao = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 1));
						String observacao = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 2));

						CadastraSemestre.cadastrarSemestre();

						CadastraSemestre.tID.setText(id);
						CadastraSemestre.tDescricao.setText(descricao);
						CadastraSemestre.tObservacao.setText(observacao);

						AcaoVisualizaSemestre.internalVisualiza.dispose();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Selecione o cadastro que deseja editar!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione o semestre que deseja editar!");
				}

			}
		});

	}

	public static void botaoExcluir(JButton bExcluir) {

		bExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tabela.getSelectedRow() > -1) {

					int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);

					RepositorioSemestre.excluir(id);

					DefaultTableModel tblRemove = (DefaultTableModel) tabela.getModel();
					int x = tblRemove.getRowCount();
					for (int a = 0; a < x; a++) {
						tblRemove.removeRow(0);
					}
					listarSemestre((DefaultTableModel) tabela.getModel());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione o semestre que deseja excluir!");
				}

			}
		});

	}

}
