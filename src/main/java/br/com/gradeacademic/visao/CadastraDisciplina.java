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
		internalCadastro.setBounds(100, 51, 871, 619);
		internalCadastro.setLayout(null);
		internalCadastro.setClosable(true);

		JLabel lIDCurso = new JLabel("ID");
		internalCadastro.add(lIDCurso);
		lIDCurso.setBounds(58, 55, 45, 16);
		lIDCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tCampoIDCurso = new JTextField();
		internalCadastro.add(tCampoIDCurso);
		tCampoIDCurso.setBounds(59, 83, 45, 28);

		JLabel lNomeCurso = new JLabel("Nome*");
		internalCadastro.add(lNomeCurso);
		lNomeCurso.setBounds(135, 55, 175, 16);
		lNomeCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tCampoNomeCurso = new JTextField();
		internalCadastro.add(tCampoNomeCurso);
		tCampoNomeCurso.setBounds(135, 83, 260, 28);

		JLabel lProfessor = new JLabel("Professor*");
		lProfessor.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lProfessor.setBounds(423, 54, 160, 16);
		internalCadastro.add(lProfessor);

		JTextField tCampoProfessor = new JTextField();
		internalCadastro.add(tCampoProfessor);
		tCampoProfessor.setBounds(423, 83, 200, 28);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(556, 510, 147, 39);
		AcaoCadastraDisciplina.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(715, 510, 103, 39);
		AcaoCadastraDisciplina.botaoCancelar(bCancelar);

	}

}
