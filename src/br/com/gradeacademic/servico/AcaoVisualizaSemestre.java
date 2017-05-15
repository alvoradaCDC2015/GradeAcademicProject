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

}
