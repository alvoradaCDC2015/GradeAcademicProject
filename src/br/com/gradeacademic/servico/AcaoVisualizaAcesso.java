package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.repositorio.RepositorioAcesso;
import br.com.gradeacademic.visao.CadastraAcesso;
import br.com.gradeacademic.visao.VisualizaAcesso;

public class AcaoVisualizaAcesso extends VisualizaAcesso {

	public static void listarAcesso(DefaultTableModel tabela) {

		List<Acesso> acessos = RepositorioAcesso.listar();

		for (Acesso acesso : acessos) {

			String status = null;
			if (acesso.getStatus() == 0) {
				status = "Ativo";
			} else {
				status = "Inativo";
			}

			tabela.addRow(new Object[] { acesso.getId(), acesso.getNome(), acesso.getUsuario(), acesso.getSenha(),
					acesso.getNivel(), status });
		}

	}

	public static void botaoNovo(JButton bNovo) {

		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraAcesso.cadastrarAcesso();

			}

		});
	}

	public static void botaoEditar(JButton bEditar, JTable tabela) {

		bEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String id = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0));
				String nome = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 1));
				String usuario = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 2));
				String senha = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 3));
				String nivel = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 4));
				String status = String.valueOf((String) tabela.getValueAt(tabela.getSelectedRow(), 5));

				CadastraAcesso.cadastrarAcesso();
				CadastraAcesso.setarCampos(id, nome, usuario, senha, nivel, status);

			}
		});

	}

	public static void botaoRemover(JButton bRemover) {

		bRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int[] linhas = tabela.getSelectedRows();

				if (tabela.getSelectedRowCount() > 1) {

					int desejo = JOptionPane.showConfirmDialog(null, "Deseja excluir os acessos ?", null,
							JOptionPane.YES_NO_OPTION);

					if (desejo == 0) {

						for (int i = 0; i < linhas.length; i++) {

							int ids = (int) tabela.getValueAt(linhas[i], 0);

							if (desejo == 0) {
								RepositorioAcesso.deletar(ids);
							}

						}

					}

				} else {

					if (tabela.getSelectedRow() > -1) {

						int desejo = JOptionPane.showConfirmDialog(null,
								"Deseja excluir os acesso do(a) " + tabela.getValueAt(tabela.getSelectedRow(), 1) + "?",
								null, JOptionPane.YES_NO_OPTION);

						if (desejo == 0) {
							int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
							RepositorioAcesso.deletar(id);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Selecione um acesso.");
					}

				}

				for (int i = 0; i < linhas.length; i++) {
					DefaultTableModel model = (DefaultTableModel) tabela.getModel();
					model.removeRow(linhas[0]);
				}

			}
		});

	}
}
