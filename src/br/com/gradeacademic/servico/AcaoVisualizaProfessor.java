package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import br.com.gradeacademic.entidade.Professor;
import br.com.gradeacademic.repositorio.RepositorioProfessor;
import br.com.gradeacademic.visao.CadastraProfessor;

public class AcaoVisualizaProfessor {

	public static void botaoNovo(JButton bNovo) {
		bNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraProfessor.cadastrarProfessor();
			}
		});
	}

	public static List<Professor> carregarProfessores() {

		return RepositorioProfessor.listar();

	}

}
