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

	public static int editando;

	public static void cadastrarSemestre() {

		internalCadastro = new JInternalFrame("Cadastrar Semestre");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setClosable(true);
		internalCadastro.getContentPane().setLayout(null);
		internalCadastro.setBounds(100, 51, 871, 400);

		JPanel infoSemestre = new JPanel();
		internalCadastro.add(infoSemestre);
		infoSemestre.setBorder(new TitledBorder(null, "Informações do Semestre", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(59, 59, 59)));
		infoSemestre.setBounds(36, 37, 789, 247);
		infoSemestre.setLayout(null);

		tID = new JTextField();
		internalCadastro.add(tID);
		tID.setBounds(100, 75, 50, 28);
		tID.setText(String.valueOf(AcaoCadastraSemestre.buscarUltimoId() + 1));
		tID.setVisible(false);

		JLabel lDescricao = new JLabel("Descrição do Semestre:");
		lDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		lDescricao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lDescricao.setBounds(100, 55, 175, 16);
		infoSemestre.add(lDescricao);

		tDescricao = new JTextField();
		tDescricao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tDescricao.setBounds(95, 83, 260, 28);
		tDescricao.setColumns(10);
		infoSemestre.add(tDescricao);

		JLabel lObservacao = new JLabel("Observação do Semestre:");
		lObservacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lObservacao.setBounds(388, 54, 180, 16);
		infoSemestre.add(lObservacao);
		lObservacao.setHorizontalAlignment(SwingConstants.LEFT);

		tObservacao = new JTextArea();
		tObservacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tObservacao.setBounds(383, 83, 330, 100);
		infoSemestre.add(tObservacao);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(556, 300, 147, 39);
		AcaoCadastraSemestre.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(715, 300, 103, 39);
		AcaoCadastraSemestre.botaoCancelar(bCancelar);

	}

}