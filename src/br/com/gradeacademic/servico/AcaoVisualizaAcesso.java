package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.repositorio.RepositorioAcesso;
import br.com.gradeacademic.visao.CadastraAcesso;
import br.com.gradeacademic.visao.VisualizaAcesso;

public class AcaoVisualizaAcesso extends VisualizaAcesso {

	public static void listarAcesso(DefaultTableModel tabela) {

		List<Acesso> acessos = RepositorioAcesso.listar();

		for (Acesso acesso : acessos) {
			tabela.addRow(new Object[] { acesso.getId(), acesso.getNome(), acesso.getUsuario(), acesso.getSenha() });
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

}
