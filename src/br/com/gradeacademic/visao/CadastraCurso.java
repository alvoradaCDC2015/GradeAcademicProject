package br.com.gradeacademic.visao;
import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.com.gradeacademic.servico.AcaoCadastraCurso;


public class CadastraCurso extends Principal {

	public static JInternalFrame internalCadastro;
	
	public static JTextField tIDCurso;
	public static JTextArea tObservacaoCurso;
	public static JTextField tNomeCurso;
	public static JTextField tDuracaoCurso;
	public static JComboBox<String> cCoordenadorPertencente;

	public static void cadastrarCurso() {

		internalCadastro = new JInternalFrame("Cadastrar Curso");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setBounds(100, 51, 871, 619);
		internalCadastro.setLayout(null);
		internalCadastro.setClosable(true);
		
		JPanel infoCurso = new JPanel();
		internalCadastro.add(infoCurso);
		infoCurso.setBorder(new TitledBorder(null, "Informações de Curso", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(59, 59, 59)));
		infoCurso.setBounds(36, 37, 789, 400);
		infoCurso.setLayout(null);
		
		
		JLabel lIDCurso = new JLabel("ID");
		internalCadastro.add(lIDCurso);
		lIDCurso.setBounds(58, 55, 45, 16);
		lIDCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDCurso.setVisible(false);
		infoCurso.add(lIDCurso);

		tIDCurso = new JTextField();
		internalCadastro.add(tIDCurso);
		tIDCurso.setBounds(59, 83, 45, 28);
		tIDCurso.setText(String.valueOf(AcaoCadastraCurso.buscarUltimoId() + 1));
		tIDCurso.setVisible(false);

		JLabel lNomeCurso = new JLabel("Descrição do Curso:*");
		internalCadastro.add(lNomeCurso);
		lNomeCurso.setBounds(140, 55, 175, 16);
		lNomeCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		infoCurso.add(lNomeCurso);
		
		tNomeCurso = new JTextField();
		internalCadastro.add(tNomeCurso);
		tNomeCurso.setBounds(135, 83, 260, 28);
		infoCurso.add(tNomeCurso);

		JLabel lObservacao = new JLabel("Observação do Curso:");
		lObservacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lObservacao.setBounds(428, 54, 180, 16);
		infoCurso.add(lObservacao);
		lObservacao.setHorizontalAlignment(SwingConstants.LEFT);

		tObservacaoCurso = new JTextArea();
		tObservacaoCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tObservacaoCurso.setBounds(423, 83, 300, 100);
		infoCurso.add(tObservacaoCurso);
		
		JLabel lCoordenador = new JLabel("Coordenador:*");
		lCoordenador.setHorizontalAlignment(SwingConstants.LEFT);
		lCoordenador.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lCoordenador.setBounds(140, 200, 175, 16);
		infoCurso.add(lCoordenador);

		cCoordenadorPertencente = new JComboBox<String>();
		infoCurso.add(cCoordenadorPertencente);
		cCoordenadorPertencente.setBounds(135, 229, 260, 28);
		
		JLabel lDuracao = new JLabel("Duração do Curso (em Anos):");
		lDuracao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lDuracao.setBounds(428, 200, 230, 16);
		infoCurso.add(lDuracao);
		lDuracao.setHorizontalAlignment(SwingConstants.LEFT);
		
		tDuracaoCurso = new JTextField();
		tDuracaoCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tDuracaoCurso.setBounds(423, 229, 50, 28);
		infoCurso.add(tDuracaoCurso);
		
		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(556, 510, 147, 39);
		AcaoCadastraCurso.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(715, 510, 103, 39);
		AcaoCadastraCurso.botaoCancelar(bCancelar);

	}

	public static void setarCampos(String id, String nome, String observacao, String duracao) {
		
		tIDCurso.setText(id);
		tNomeCurso.setText(nome);
		tObservacaoCurso.setText(observacao);
		tDuracaoCurso.setText(duracao);
		
		
	}

}
