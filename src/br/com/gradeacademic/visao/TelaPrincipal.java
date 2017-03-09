package br.com.gradeacademic.visao;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.com.gradeacademic.servico.AcaoTelaPrincipal;

import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;

public class TelaPrincipal {

	static JDesktopPane desktopPane = new JDesktopPane();

	protected static Container DesktopPane;
	static JFrame tela = new JFrame();
	static JMenuBar menuBar = new JMenuBar();

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

		tela.add(menuBar);
		menuBar.setBounds(0, 0, 2021, 33);

		TelaLogin.login();

	}

	public static void MenuBar() {

		JMenu mArquivo = new JMenu("Arquivo");
		menuBar.add(mArquivo);
		mArquivo.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mArquivo.setIcon(new ImageIcon("door_out.png"));

		JMenuItem itemSair = new JMenuItem("Sair");
		mArquivo.add(itemSair);
		itemSair.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JMenu mProfessor = new JMenu("Professor");
		menuBar.add(mProfessor);
		mProfessor.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mProfessor.setIcon(new ImageIcon("user.png"));

		JMenuItem cadastrarProfessor = new JMenuItem("Cadastrar");
		mProfessor.add(cadastrarProfessor);
		cadastrarProfessor.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoTelaPrincipal.cadastrarProfessor(cadastrarProfessor);

		JMenu mCurso = new JMenu("Curso");
		menuBar.add(mCurso);
		mCurso.setIcon(new ImageIcon("page.png"));
		mCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JMenuItem cadastrarCurso = new JMenuItem("Cadastrar");
		mCurso.add(cadastrarCurso);
		cadastrarCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoTelaPrincipal.cadastrarCurso(cadastrarCurso);

		JMenu mDisciplina = new JMenu("Disciplina");
		menuBar.add(mDisciplina);
		mDisciplina.setIcon(new ImageIcon("page.png"));
		mDisciplina.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JMenuItem cadastrarDisciplina = new JMenuItem("Cadastrar");
		mDisciplina.add(cadastrarDisciplina);
		cadastrarDisciplina.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JMenu mRelatorio = new JMenu("Relatorio");
		menuBar.add(mRelatorio);
		mRelatorio.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mRelatorio.setIcon(new ImageIcon("report.png"));

		JMenu mLocais = new JMenu("Locais");
		menuBar.add(mLocais);
		mLocais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mLocais.setIcon(new ImageIcon("report.png"));

		JMenuItem criarLocal = new JMenuItem("Criar");
		mLocais.add(criarLocal);
		criarLocal.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoTelaPrincipal.criarLocal(criarLocal);

		JMenuItem visualizarLocal = new JMenuItem("Visualizar");
		mLocais.add(visualizarLocal);
		visualizarLocal.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoTelaPrincipal.visualizarLocal(visualizarLocal);

		JMenu mAcesso = new JMenu("Acessos");
		menuBar.add(mAcesso);
		mAcesso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mAcesso.setIcon(new ImageIcon("report.png"));

		JMenuItem criarAcesso = new JMenuItem("Criar");
		mAcesso.add(criarAcesso);
		criarAcesso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoTelaPrincipal.criarAcesso(criarAcesso);

		JMenuItem visualizarAcesso = new JMenuItem("Visualizar");
		mAcesso.add(visualizarAcesso);
		visualizarAcesso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		AcaoTelaPrincipal.visualizarAcesso(visualizarAcesso);

		JMenu mSobre = new JMenu("Sobre");
		menuBar.add(mSobre);
		mSobre.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mSobre.setIcon(new ImageIcon("information.png"));

	}
}
