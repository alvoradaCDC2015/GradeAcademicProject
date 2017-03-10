package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import br.com.gradeacademic.visao.TelaCadastraAcesso;
import br.com.gradeacademic.visao.TelaCadastraCurso;
import br.com.gradeacademic.visao.TelaCadastraLocal;
import br.com.gradeacademic.visao.TelaCadastraProfessor;
import br.com.gradeacademic.visao.TelaVisualizaAcesso;
import br.com.gradeacademic.visao.TelaVisualizaCurso;
import br.com.gradeacademic.visao.TelaVisualizaLocal;

public class AcaoTelaPrincipal {

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

				TelaCadastraProfessor.telaCadastroUsuario();

			}
		});
	}

	public static void cadastrarCurso(JMenuItem cadastrarCurso) {

		cadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastraCurso.cadastroCurso();

			}
		});
	}

	public static void criarLocal(JMenuItem criarLocal) {

		criarLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastraLocal.cadastrarLocal();

			}
		});
	}

	public static void visualizarLocal(JMenuItem visualizarLocal) {

		visualizarLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaVisualizaLocal.visualizarLocal();

			}
		});
	}

	public static void criarAcesso(JMenuItem criarAcesso) {

		criarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastraAcesso.cadastrarAcesso();

			}
		});
	}

	public static void visualizarAcesso(JMenuItem visualizarAcesso) {

		visualizarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaVisualizaAcesso.visualizarAcesso();
			}
		});
	}

	public static void visualizarCurso(JMenuItem visualizaCurso) {

		visualizaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaVisualizaCurso.visualizarCurso();
			}
		});

	}

}
