package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;

import br.com.gradeacademic.visao.CadastraCurso;
import br.com.gradeacademic.visao.CadastraDisciplina;
import br.com.gradeacademic.visao.CadastraProfessor;
import br.com.gradeacademic.visao.CadastraSemestre;
import br.com.gradeacademic.visao.VisualizaCurso;
import br.com.gradeacademic.visao.VisualizaDisciplina;
import br.com.gradeacademic.visao.VisualizaHorario;
import br.com.gradeacademic.visao.VisualizaProfessor;
import br.com.gradeacademic.visao.VisualizaRelatorio;
import br.com.gradeacademic.visao.VisualizaSemestre;

public class AcaoPrincipal {

	public void sair(JMenuItem itemSair) {

		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
	}

	public static void cadastrarProfessor(JMenuItem itemCadastrar) {

		itemCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastraProfessor.cadastrarProfessor();

			}
		});
	}

	public static void cadastrarCurso(JMenuItem cadastrarCurso) {

		cadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastraCurso.cadastrarCurso();

			}
		});
	}

	public static void visualizarCurso(JMenuItem visualizaCurso) {

		visualizaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastraDisciplina.editando = 0;
				VisualizaCurso.visualizarCurso();
			}
		});

	}

	public static void cadastraDisciplina(JMenuItem cadastrarDisciplina) {
		cadastrarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastraDisciplina.cadastrarDisciplina();
			}
		});

	}

	public static void visualizaRelatorio(JMenuItem visualizaRelatorio) {
		visualizaRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					VisualizaRelatorio.visualizarRelatorio();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (DocumentException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public static void visualizaDisciplina(JMenuItem visualizaDisciplina) {
		visualizaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizaDisciplina.visualizarDisciplina();
				AcaoVisualizaDisciplina.listarDisciplinas();
			}
		});

	}

	public static void cadastrarSemestre(JMenuItem cadastrarSemestre) {

		cadastrarSemestre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraSemestre.editando = 0;
				CadastraSemestre.cadastrarSemestre();
			}
		});

	}

	public static void visualizarSemestre(JMenuItem visualizaSemestre) {

		visualizaSemestre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisualizaSemestre.visualizarSemestre();
				AcaoVisualizaSemestre.listarSemestre((DefaultTableModel) VisualizaSemestre.tabela.getModel());
			}
		});
	}

	public static void visualizarDisciplina(JMenuItem visualizaDisciplina) {

		visualizaDisciplina.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisualizaDisciplina.visualizarDisciplina();
			}
		});
	}

	public static void visualizarProfessor(JMenuItem visualizaProfessor) {
		visualizaProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisualizaProfessor.visualizarProfessor();
				AcaoVisualizaProfessor.adicionaProfessoresNaTabela();
			}
		});
	}

	public static void visualizaHorario(JMenuItem visualizaRelatorio) {
		visualizaRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VisualizaHorario.visualizaHorario();
			}
		});

	}

}
