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
			
			String status = validarStatus(semestre);

			tabela.addRow(new Object[] { semestre.getId(), semestre.getDescricao(), semestre.getObservacao(), status });
		}

	}

	private static String validarStatus(Semestre semestre) {
		String status = "Ativo";
		if (semestre.getStatus() == 0) {
			status = "Inativo";
		}
		return status;
	}

	public static void botaoNovo(JButton bNovo) {
		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AcaoVisualizaSemestre.internalVisualiza.dispose();
				CadastraSemestre.cadastrarSemestre();
			}
		});

	}

	public static void botaoEditar(JButton bEditar, JTable tabela) {

		bEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


									
				try{	
				String id = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0));
				String descricao = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 1));
				String observacao = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 2));
				
				
				CadastraSemestre.cadastrarSemestre();
				CadastraSemestre.setarCampos(id, descricao, observacao);
				AcaoVisualizaSemestre.internalVisualiza.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Selecione o cadastro que deseja editar!");
				}

			}
		});

	}
	public static void botaoRemover(JButton bRemover) {

		bRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int[] linhas = tabela.getSelectedRows();

				if (tabela.getSelectedRowCount() > 0) {

					int desejo = JOptionPane.showConfirmDialog(null, "Deseja realmente inativar semestre(s) selecionado(s)?",
							"Inativar Acesso", JOptionPane.YES_NO_OPTION);

					if (desejo == 0) {

						for (int i = 0; i < linhas.length; i++) {

							int ids = (int) tabela.getValueAt(linhas[i], 0);

							if (desejo == 0) {
								RepositorioSemestre.inativar(ids);
							}

						}

						for (int i = 0; i < linhas.length; i++) {
							DefaultTableModel model = (DefaultTableModel) tabela.getModel();
							model.setValueAt("Inativo", linhas[i], 3);
						}

					}

				} else {

					JOptionPane.showMessageDialog(null, "Selecione um Semestre.");

				}

			}
		});

	}

}
