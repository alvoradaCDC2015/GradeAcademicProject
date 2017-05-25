package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import br.com.gradeacademic.visao.CadastraAcesso;
import br.com.gradeacademic.visao.CadastraCidade;
import br.com.gradeacademic.visao.CadastraCurso;
import br.com.gradeacademic.visao.CadastraDisciplina;
import br.com.gradeacademic.visao.CadastraEstado;
import br.com.gradeacademic.visao.CadastraPais;
import br.com.gradeacademic.visao.CadastraProfessor;
import br.com.gradeacademic.visao.CadastraSemestre;
import br.com.gradeacademic.visao.VisualizaAcesso;
import br.com.gradeacademic.visao.VisualizaCurso;
import br.com.gradeacademic.visao.VisualizaDisciplina;
import br.com.gradeacademic.visao.VisualizaLocal;
import br.com.gradeacademic.visao.VisualizaProfessor;
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

	public static void visualizarLocal(JMenuItem visualizarLocal) {

		visualizarLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VisualizaLocal.visualizarLocal();

			}
		});
	}

	public static void criarAcesso(JMenuItem criarAcesso) {

		criarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastraAcesso.cadastrarAcesso();

			}
		});
	}

	public static void visualizarAcesso(JMenuItem visualizarAcesso) {

		visualizarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VisualizaAcesso.visualizarAcesso();
			}
		});
	}

	public static void visualizarCurso(JMenuItem visualizaCurso) {

		visualizaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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

	public static void visualizaDisciplina(JMenuItem visualizaDisciplina) {
		visualizaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VisualizaDisciplina.visualizarDisciplina();
			}
		});

	}

	public static void cadastrarSemestre(JMenuItem cadastrarSemestre) {

		cadastrarSemestre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraSemestre.cadastrarSemestre();
			}
		});

	}

	public static void visualizarSemestre(JMenuItem visualizaSemestre) {

		visualizaSemestre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisualizaSemestre.visualizarSemestre();
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

			}
		});
	}

	public static void criarPais(JMenuItem criarPais) {

		criarPais.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CadastraPais.cadastrarPais();
			}
		});

	}

	public static void criarEstado(JMenuItem criarEstado) {
		criarEstado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraEstado.cadastrarEstado();
			}
		});
	}

	public static void criarCidade(JMenuItem criarCidade) {
		criarCidade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastraCidade.cadastrarCidade();
			}
		});
	}

}
