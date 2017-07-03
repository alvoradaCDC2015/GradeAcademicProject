package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Professor;
import br.com.gradeacademic.repositorio.RepositorioProfessor;
import br.com.gradeacademic.visao.CadastraProfessor;
import br.com.gradeacademic.visao.VisualizaProfessor;

public class AcaoVisualizaProfessor extends VisualizaProfessor {

	public static void botaoNovo(JButton bNovo) {
		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraProfessor.editando = 0;
				CadastraProfessor.cadastrarProfessor();
			}
		});
	}

	public static List<Professor> carregarProfessores() {

		return RepositorioProfessor.listar();

	}

	public static void botaoEditar(JButton bEditar) {

		bEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tabela.getSelectedRow() > -1) {

					CadastraProfessor.editando = 1;

					int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);

					Professor professor = RepositorioProfessor.buscarPorId(id);

					CadastraProfessor.cadastrarProfessor();
					CadastraProfessor.tID.setText(String.valueOf(id));
					CadastraProfessor.tNome.setText(professor.getNome());
					CadastraProfessor.tNascimento.setText(professor.getDataNascimento());
					CadastraProfessor.tCpf.setText(professor.getCpf());
					CadastraProfessor.tSenha.setText(professor.getSenha());
					CadastraProfessor.tSituacao.setSelectedIndex(professor.getStatus());
					CadastraProfessor.tNaturalidade.setText(professor.getNaturalidade());
					CadastraProfessor.tNacionalidade.setText(professor.getNacionalidade());
					CadastraProfessor.tCoordenador.setSelectedIndex(professor.getCoordenador());
					CadastraProfessor.tEndereco.setText(professor.getEndEndereco());
					CadastraProfessor.tNumero.setText(String.valueOf(professor.getEndNumero()));
					CadastraProfessor.tBairro.setText(professor.getEndBairro());
					CadastraProfessor.tCEP.setText(professor.getEndCep());
					CadastraProfessor.tCidade.setText(professor.getEndCidade());
					CadastraProfessor.tTelefoneResidencial.setText(String.valueOf(professor.getTelefoneResidencial()));
					CadastraProfessor.tCelular.setText(String.valueOf(professor.getCelular()));
					CadastraProfessor.tEmail.setText(professor.getEmail());

				} else {
					JOptionPane.showMessageDialog(null, "Selecione o professor que deseja editar!");
				}

			}
		});

	}

	public static void adicionaProfessoresNaTabela() {

		DefaultTableModel tblRemove = (DefaultTableModel) tabela.getModel();
		int x = tblRemove.getRowCount();
		for (int a = 0; a < x; a++) {
			tblRemove.removeRow(0);
		}

		List<Professor> professores = AcaoVisualizaProfessor.carregarProfessores();
		for (Professor professor : professores) {

			((DefaultTableModel) tabela.getModel()).addRow(
					new Object[] { professor.getId(), professor.getNome(), professor.getCpf(), professor.getEmail() });

		}
	}

	public static void botaoExcluir(JButton bExcluir) {

		bExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tabela.getSelectedRow() > -1) {

					int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);

					RepositorioProfessor.excluir(id);

					adicionaProfessoresNaTabela();
				} else {
					JOptionPane.showMessageDialog(null, "Selecione o professor que deseja excluir!");
				}

			}
		});

	}
}
