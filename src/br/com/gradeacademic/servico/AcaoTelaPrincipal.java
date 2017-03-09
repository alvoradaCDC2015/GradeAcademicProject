package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import br.com.gradeacademic.visao.TelaAcessos;
import br.com.gradeacademic.visao.TelaCadastroProfessor;
import br.com.gradeacademic.visao.TelaCurso;
import br.com.gradeacademic.visao.TelaLocal;

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

				TelaCadastroProfessor.telaCadastroUsuario();

			}
		});
	}

	public static void cadastrarCurso(JMenuItem cadastrarCurso) {

		cadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCurso.cadastroCurso();

			}
		});
	}

	public static void criarLocal(JMenuItem criarLocal) {

		criarLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaLocal.cadastrarLocal();

			}
		});
	}

	public static void visualizarLocal(JMenuItem visualizarLocal) {

		visualizarLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaLocal.visualizarLocal();

			}
		});
	}

	public static void criarAcesso(JMenuItem criarAcesso) {

		criarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaAcessos.cadastrarAcesso();

			}
		});
	}

	public static void visualizarAcesso(JMenuItem visualizarAcesso) {

		visualizarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaAcessos.visualizarAcesso();
			}
		});
	}

}
