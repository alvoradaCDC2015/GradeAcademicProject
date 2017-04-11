package br.com.gradeacademic.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.com.gradeacademic.servico.AcaoCadastraSemestre;

public class CadastraSemestre extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tID;
	public static JTextField tDescricao;
	public static JTextArea tObservacao;

	public static void cadastrarSemestre() {

		internalCadastro = new JInternalFrame("Cadastrar Semestre");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setClosable(true);
		internalCadastro.getContentPane().setLayout(null);
		internalCadastro.setBounds(100, 51, 871, 619);

		JPanel infoSemestre = new JPanel();
		internalCadastro.add(infoSemestre);
		infoSemestre.setBorder(new TitledBorder(null, "Informa��es do Semestre", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(59, 59, 59)));
		infoSemestre.setBounds(36, 37, 789, 247);
		infoSemestre.setLayout(null);

		JLabel lID = new JLabel("ID");
		lID.setHorizontalAlignment(SwingConstants.LEFT);
		lID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lID.setBounds(63, 55, 45, 16);
		infoSemestre.add(lID);

		tID = new JTextField();
		tID.setEnabled(false);
		tID.setEditable(false);
		tID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tID.setColumns(10);
		tID.setBounds(59, 83, 45, 28);
		infoSemestre.add(tID);

		JLabel lDescricao = new JLabel("Descri��o do Semestre:");
		lDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		lDescricao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lDescricao.setBounds(140, 55, 175, 16);
		infoSemestre.add(lDescricao);

		tDescricao = new JTextField();
		tDescricao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tDescricao.setBounds(135, 83, 260, 28);
		tDescricao.setColumns(10);
		infoSemestre.add(tDescricao);

		JLabel lObservacao = new JLabel("Observa��o do Semestre:");
		lObservacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lObservacao.setBounds(428, 54, 180, 16);
		infoSemestre.add(lObservacao);
		lObservacao.setHorizontalAlignment(SwingConstants.LEFT);

		tObservacao = new JTextArea();
		tObservacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tObservacao.setBounds(423, 83, 300, 100);
		infoSemestre.add(tObservacao);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(556, 510, 147, 39);
		AcaoCadastraSemestre.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(715, 510, 103, 39);
		AcaoCadastraSemestre.botaoCancelar(bCancelar);

	}

}
