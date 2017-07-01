package br.com.gradeacademic.visao;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.com.gradeacademic.servico.AcaoPrincipal;

import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;

public class Principal {

	static JDesktopPane desktopPane = new JDesktopPane();

	protected static Container DesktopPane;
	static JFrame tela = new JFrame();
	static JMenuBar mBarraDeFerramentas = new JMenuBar();

	public static void main(String[] args) {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension tamTela = kit.getScreenSize();
		int larg = tamTela.width;
		int alt = tamTela.height;
		int minhaLargura = larg;
		int minhaAltura = alt;

		desktopPane.setBackground(SystemColor.inactiveCaption);
		desktopPane.setBounds(0, 32, 2000, 2000);
		tela.add(desktopPane);

		tela.setSize(minhaLargura, minhaAltura);
		tela.setDefaultCloseOperation(1);
		tela.setLocationRelativeTo(null);
		tela.setTitle("PROJECT GRADE ACADEMIC - ADMINISTRADOR");
		tela.setLayout(null);
		tela.setVisible(true);
		tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tela.add(mBarraDeFerramentas);
		mBarraDeFerramentas.setBounds(0, 0, 2021, 33);

		Login.visualizarLogin();

	}

	public static void MenuBar() {

		JMenu mArquivo = new JMenu("Arquivo");
		mBarraDeFerramentas.add(mArquivo);
		mArquivo.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mArquivo.setIcon(new ImageIcon("door_out.png"));

		itensArquivo(mArquivo);

		JMenu mProfessor = new JMenu("Professor");
		mBarraDeFerramentas.add(mProfessor);
		mProfessor.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mProfessor.setIcon(new ImageIcon("user.png"));

		itensProfessor(mProfessor);

		JMenu mCurso = new JMenu("Curso");
		mBarraDeFerramentas.add(mCurso);
		mCurso.setIcon(new ImageIcon("page.png"));
		mCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		itensCurso(mCurso);

		JMenu mSemestre = new JMenu("Semestre");
		mBarraDeFerramentas.add(mSemestre);
		mSemestre.setIcon(new ImageIcon("page.png"));
		mSemestre.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		itensSemestre(mSemestre);

		JMenu mDisciplina = new JMenu("Disciplina");
		mBarraDeFerramentas.add(mDisciplina);
		mDisciplina.setIcon(new ImageIcon("page.png"));
		mDisciplina.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		itensDisciplina(mDisciplina);

		JMenu mRelatorio = new JMenu("Relatorio");
		mBarraDeFerramentas.add(mRelatorio);
		mRelatorio.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mRelatorio.setIcon(new ImageIcon("report.png"));

		itensRelatorio(mRelatorio);

		JMenu mLocal = new JMenu("Locais");
		mBarraDeFerramentas.add(mLocal);
		mLocal.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mLocal.setIcon(new ImageIcon("report.png"));

		itensLocal(mLocal);

		JMenu mSobre = new JMenu("Sobre");
		mBarraDeFerramentas.add(mSobre);
		mSobre.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mSobre.setIcon(new ImageIcon("information.png"));

	}

	private static void itensArquivo(JMenu mArquivo) {
		JMenuItem itemSair = new JMenuItem("Sair");
		mArquivo.add(itemSair);
		itemSair.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
	}

	private static void itensProfessor(JMenu mProfessor) {
		JMenuItem cadastrarProfessor = new JMenuItem("Cadastrar");
		mProfessor.add(cadastrarProfessor);
		cadastrarProfessor.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.cadastrarProfessor(cadastrarProfessor);

		JMenuItem visualizaProfessor = new JMenuItem("Visualizar");
		mProfessor.add(visualizaProfessor);
		visualizaProfessor.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.visualizarProfessor(visualizaProfessor);
	}

	private static void itensCurso(JMenu mCurso) {
		JMenuItem cadastrarCurso = new JMenuItem("Cadastrar");
		mCurso.add(cadastrarCurso);
		cadastrarCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.cadastrarCurso(cadastrarCurso);

		JMenuItem visualizaCurso = new JMenuItem("Visualizar");
		mCurso.add(visualizaCurso);
		visualizaCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.visualizarCurso(visualizaCurso);
	}

	private static void itensSemestre(JMenu mSemestre) {
		JMenuItem cadastrarSemestre = new JMenuItem("Cadastrar");
		mSemestre.add(cadastrarSemestre);
		cadastrarSemestre.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.cadastrarSemestre(cadastrarSemestre);

		JMenuItem visualizaSemestre = new JMenuItem("Visualizar");
		mSemestre.add(visualizaSemestre);
		visualizaSemestre.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.visualizarSemestre(visualizaSemestre);
	}

	private static void itensDisciplina(JMenu mDisciplina) {
		JMenuItem cadastrarDisciplina = new JMenuItem("Cadastrar");
		mDisciplina.add(cadastrarDisciplina);
		cadastrarDisciplina.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.cadastraDisciplina(cadastrarDisciplina);

		JMenuItem visualizaDisciplina = new JMenuItem("Visualizar");
		mDisciplina.add(visualizaDisciplina);
		visualizaDisciplina.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.visualizarDisciplina(visualizaDisciplina);

	}

	private static void itensRelatorio(JMenu mRelatorio) {
		JMenuItem visualizarRelatorio = new JMenuItem("Visualizar");
		mRelatorio.add(visualizarRelatorio);
		visualizarRelatorio.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.visualizaRelatorio(visualizarRelatorio);

		JMenuItem visualizarHorario = new JMenuItem("Horários");
		mRelatorio.add(visualizarHorario);
		visualizarHorario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.visualizaHorario(visualizarHorario);

	}

	private static void itensLocal(JMenu mLocais) {

		JMenuItem criarPais = new JMenuItem("Criar País");
		mLocais.add(criarPais);
		criarPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.criarPais(criarPais);

		JMenuItem criarEstado = new JMenuItem("Criar Estado");
		mLocais.add(criarEstado);
		criarEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.criarEstado(criarEstado);

		JMenuItem criarCidade = new JMenuItem("Criar Cidade");
		mLocais.add(criarCidade);
		criarCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.criarCidade(criarCidade);

		JMenuItem visualizarLocal = new JMenuItem("Visualizar");
		mLocais.add(visualizarLocal);
		visualizarLocal.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoPrincipal.visualizarLocal(visualizarLocal);
	}
}
