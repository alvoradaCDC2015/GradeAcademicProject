package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Curso;
import br.com.gradeacademic.repositorio.RepositorioCurso;
import br.com.gradeacademic.visao.CadastraCurso;
import br.com.gradeacademic.visao.VisualizaCurso;

public class AcaoVisualizaCurso {
	
	protected static Object internalVisualiza;

	public static void listarCurso(DefaultTableModel tabela) {
		List<Curso> cursos = RepositorioCurso.listar();

		for (Curso curso : cursos) {

			tabela.addRow(new Object[] { curso.getId(), curso.getNome(), curso.getCoordenador(), curso.getDuracao()});
		}

	}

	public static void botaoNovo(JButton bNovo) {

		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraCurso.cadastrarCurso();
				AcaoCadastraCurso.listarCoordenadores();
				VisualizaCurso.internalVisualiza.dispose();

			}
		});
	}

	public static void botaoEditar(JButton bEditar, JTable tabela) {

		bEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


									
				try{	
				String id = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0));
				String nome = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 1));
				String observacao = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 2));
				String duracao = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 3 ));
				
				
				CadastraCurso.cadastrarCurso();
				CadastraCurso.setarCampos(id, nome, observacao, duracao);
				AcaoCadastraCurso.listarCoordenadores();
				VisualizaCurso.internalVisualiza.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Selecione o cadastro que deseja editar!");
				}

			}
		});

	}

}