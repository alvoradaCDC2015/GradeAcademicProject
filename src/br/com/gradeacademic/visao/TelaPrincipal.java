package br.com.gradeacademic.visao;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

		Principal();
	}

	public static void Principal() {

		Janela();
	}

	public static void Janela() {

		MenuBar();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension tamTela = kit.getScreenSize();
		int larg = tamTela.width;
		int alt = tamTela.height;
		int minhaLargura = larg;
		int minhaAltura = alt;

		desktopPane.setBackground(SystemColor.inactiveCaption);
		desktopPane.setBounds(0, 32, minhaLargura, minhaAltura);
		tela.getContentPane().add(desktopPane);

		tela.setSize(minhaLargura, minhaAltura);
		tela.setDefaultCloseOperation(1);
		tela.setLocationRelativeTo(null);
		tela.setTitle("PROJECT GRADE ACADEMIC - ADMINISTRADOR");
		tela.getContentPane().setLayout(null);
		tela.setVisible(true);

		menuBar.setBounds(0, 0, 2021, 33);
		tela.getContentPane().add(menuBar);

	}

	public static void MenuBar() {

		JMenu mArquivo = new JMenu("Arquivo");
		mArquivo.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mArquivo.setIcon(new ImageIcon("door_out.png"));
		menuBar.add(mArquivo);

		JMenuItem ItemSair = new JMenuItem("Sair");
		ItemSair.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		ItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		mArquivo.add(ItemSair);

		JMenu mProfessor = new JMenu("Professor");
		mProfessor.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mProfessor.setIcon(new ImageIcon("user.png"));
		menuBar.add(mProfessor);

		JMenuItem ItemCadastrar = new JMenuItem("Cadastrar");
		ItemCadastrar.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		ItemCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroProfessor.telaCadastroUsuario();

			}
		});
		mProfessor.add(ItemCadastrar);

		JMenu mCurso = new JMenu("Curso");
		mCurso.setIcon(new ImageIcon("page.png"));
		mCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		menuBar.add(mCurso);

		JMenuItem menuItem = new JMenuItem("Cadastrar");
		menuItem.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroCurso.cadastroCurso();

			}
		});
		mCurso.add(menuItem);

		JMenu mDisciplina = new JMenu("Disciplina");
		mDisciplina.setIcon(new ImageIcon("page.png"));
		mDisciplina.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		menuBar.add(mDisciplina);

		JMenuItem menuItem_1 = new JMenuItem("Cadastrar");
		menuItem_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mDisciplina.add(menuItem_1);

		JMenu mRelatorio = new JMenu("Relatorio");
		mRelatorio.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mRelatorio.setIcon(new ImageIcon("report.png"));
		menuBar.add(mRelatorio);

		JMenu mLocais = new JMenu("Locais");
		mLocais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mLocais.setIcon(new ImageIcon("report.png"));
		menuBar.add(mLocais);

		JMenuItem iCriarEstado = new JMenuItem("Criar Estado");
		iCriarEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		iCriarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroEstado.cadastroEstado();

			}
		});
		mLocais.add(iCriarEstado);

		JMenuItem iCriarCidade = new JMenuItem("Criar Cidade");
		iCriarCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		iCriarCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroCidade.cadastroCidade();

			}
		});
		mLocais.add(iCriarCidade);

		JMenu mUsuario = new JMenu("Usuário");
		mUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mUsuario.setIcon(new ImageIcon("report.png"));
		menuBar.add(mUsuario);

		JMenuItem iCriarAcesso = new JMenuItem("Criar");
		iCriarAcesso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		iCriarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaAcessos.telaCadastraAcesso();

			}
		});
		mUsuario.add(iCriarAcesso);

		JMenuItem iListarAcesso = new JMenuItem("Visualizar");
		iListarAcesso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		iListarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaAcessos.telaVisualizaAcesso();
			}
		});
		mUsuario.add(iListarAcesso);

		JMenu mSobre = new JMenu("Sobre");
		mSobre.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		mSobre.setIcon(new ImageIcon("information.png"));
		menuBar.add(mSobre);

	}
}
