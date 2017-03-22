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

import br.com.gradeacademic.servico.AcaoTelaCadastraSemestre;

public class TelaCadastraSemestre extends TelaPrincipal {

	public static JInternalFrame internalCadastraSemestre;

	public static JTextField CampoID;
	public static JTextField tCampoDescricao;
	public static JTextArea tCampoObservacao;

	public static void cadastrarSemestre() {

		internalCadastraSemestre = new JInternalFrame("Cadastrar Semestre");
		desktopPane.add(internalCadastraSemestre);
		internalCadastraSemestre.setVisible(true);
		internalCadastraSemestre.setClosable(true);
		internalCadastraSemestre.getContentPane().setLayout(null);
		internalCadastraSemestre.setBounds(100, 51, 871, 619);

		JPanel panelInfoSemestre = new JPanel();
		internalCadastraSemestre.add(panelInfoSemestre);
		panelInfoSemestre.setBorder(new TitledBorder(null,
				"INFORMAÇÕES SEMESTRE", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(59, 59, 59)));
		panelInfoSemestre.setBounds(36, 37, 789, 247);
		panelInfoSemestre.setLayout(null);

		JLabel lId = new JLabel("ID");
		lId.setHorizontalAlignment(SwingConstants.LEFT);
		lId.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lId.setBounds(63, 55, 45, 16);
		panelInfoSemestre.add(lId);
		
		CampoID = new JTextField();
		CampoID.setEnabled(false);
		CampoID.setEditable(false);
		CampoID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		CampoID.setColumns(10);
		CampoID.setBounds(59, 83, 45, 28);
		panelInfoSemestre.add(CampoID);

		JLabel lDescSemestre = new JLabel("Descrição do Semestre:");
		lDescSemestre.setHorizontalAlignment(SwingConstants.LEFT);
		lDescSemestre.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lDescSemestre.setBounds(140, 55, 175, 16);
		panelInfoSemestre.add(lDescSemestre);
		
		tCampoDescricao = new JTextField();
		tCampoDescricao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoDescricao.setBounds(135, 83, 260, 28);
		tCampoDescricao.setColumns(10);
		panelInfoSemestre.add(tCampoDescricao);

		JLabel lObservacao = new JLabel("Observação do Semestre:");
		lObservacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lObservacao.setBounds(428, 54, 180, 16);
		panelInfoSemestre.add(lObservacao);
		lObservacao.setHorizontalAlignment(SwingConstants.LEFT);
		
		tCampoObservacao = new JTextArea();
		tCampoObservacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoObservacao.setBounds(423, 83, 300, 100);
		panelInfoSemestre.add(tCampoObservacao);

		JButton btnSalvar = new JButton("Salvar");
		internalCadastraSemestre.add(btnSalvar);
		btnSalvar.setBounds(556, 510, 147, 39);
		AcaoTelaCadastraSemestre.botaoSalvar(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		internalCadastraSemestre.add(btnCancelar);
		btnCancelar.setBounds(715, 510, 103, 39);
		AcaoTelaCadastraSemestre.botaoCancelar(btnCancelar);

	}

}
