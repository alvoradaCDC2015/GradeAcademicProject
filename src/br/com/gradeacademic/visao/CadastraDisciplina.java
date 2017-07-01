package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.gradeacademic.servico.AcaoCadastraDisciplina;

public class CadastraDisciplina extends Principal {

	public static JInternalFrame internalCadastro;

	public static void cadastrarDisciplina() {

		internalCadastro = new JInternalFrame("Cadastrar Disciplina");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setBounds(100, 51, 350, 280);
		internalCadastro.setLayout(null);
		internalCadastro.setClosable(true);

		JTextField tCampoIDCurso = new JTextField();
		internalCadastro.add(tCampoIDCurso);
		tCampoIDCurso.setBounds(59, 83, 45, 28);
		tCampoIDCurso.setVisible(false);

		JLabel lNomeCurso = new JLabel("Nome*");
		internalCadastro.add(lNomeCurso);
		lNomeCurso.setBounds(35, 55, 175, 16);
		lNomeCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tCampoNomeCurso = new JTextField();
		internalCadastro.add(tCampoNomeCurso);
		tCampoNomeCurso.setBounds(35, 83, 260, 28);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(35, 150, 147, 39);
		AcaoCadastraDisciplina.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(195, 150, 103, 39);
		AcaoCadastraDisciplina.botaoCancelar(bCancelar);

	}

}
