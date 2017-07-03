package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.gradeacademic.servico.AcaoCadastraDisciplina;

public class CadastraDisciplina extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tID;
	public static JTextField tNome;
	public static JComboBox<String> tStatus;

	public static int editando;

	public static void cadastrarDisciplina() {

		internalCadastro = new JInternalFrame("Cadastrar Disciplina");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setBounds(100, 51, 350, 280);
		internalCadastro.setLayout(null);
		internalCadastro.setClosable(true);

		tID = new JTextField();
		internalCadastro.add(tID);
		tID.setBounds(59, 83, 45, 28);
		tID.setVisible(false);

		JLabel lNome = new JLabel("Nome*");
		internalCadastro.add(lNome);
		lNome.setBounds(35, 55, 175, 16);
		lNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		tNome = new JTextField();
		internalCadastro.add(tNome);
		tNome.setBounds(35, 83, 260, 28);

		JLabel lSituacao = new JLabel("Situação");
		lSituacao.setHorizontalAlignment(SwingConstants.LEFT);
		lSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSituacao.setBounds(35, 110, 95, 16);
		internalCadastro.add(lSituacao);

		tStatus = new JComboBox<String>();
		tStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "Inativo", "Ativo" }));
		tStatus.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tStatus.setBounds(35, 125, 110, 28);
		internalCadastro.add(tStatus);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(35, 165, 147, 39);
		AcaoCadastraDisciplina.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(195, 165, 103, 39);
		AcaoCadastraDisciplina.botaoCancelar(bCancelar);

	}

}
