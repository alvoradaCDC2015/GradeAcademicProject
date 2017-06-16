package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Pais;
import br.com.gradeacademic.repositorio.RepositorioPais;
import br.com.gradeacademic.visao.CadastraPais;
import br.com.gradeacademic.visao.VisualizaPais;

public class AcaoVisualizaPais extends VisualizaPais {

	public static void listarPais(DefaultTableModel tabela) {
		List<Pais> paises = RepositorioPais.listar();

		for (Pais pais : paises) {

			tabela.addRow(new Object[] { pais.getId(), pais.getNome() });
		}

	}

	public static void botaoNovo(JButton bNovo) {
		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AcaoVisualizaPais.internalVisualiza.dispose();
				CadastraPais.cadastrarPais();
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
				
				
				CadastraPais.cadastrarPais();
				CadastraPais.setarCampos(id,nome);
				AcaoVisualizaPais.internalVisualiza.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Selecione o cadastro que deseja editar!");
				}

			}
		});

	}

}
