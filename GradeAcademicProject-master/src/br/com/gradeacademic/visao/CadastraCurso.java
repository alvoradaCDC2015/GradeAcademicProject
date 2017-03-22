package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.gradeacademic.servico.AcaoCadastraCurso;

public class CadastraCurso extends Principal {

	public static JInternalFrame internalCadastro;

	public static void cadastrarCurso() {

		internalCadastro = new JInternalFrame("Cadastrar Curso");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setBounds(100, 51, 871, 619);
		internalCadastro.setLayout(null);
		internalCadastro.setClosable(true);

		JLabel lID = new JLabel("ID");
		internalCadastro.add(lID);
		lID.setBounds(58, 55, 45, 16);
		lID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tID = new JTextField();
		internalCadastro.add(tID);
		tID.setBounds(59, 83, 45, 28);

		JLabel lNome = new JLabel("Nome*");
		internalCadastro.add(lNome);
		lNome.setBounds(135, 55, 175, 16);
		lNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tNome = new JTextField();
		internalCadastro.add(tNome);
		tNome.setBounds(135, 83, 260, 28);

		JLabel lProfessor = new JLabel("Professor/Coordenador*");
		lProfessor.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lProfessor.setBounds(423, 54, 160, 16);
		internalCadastro.add(lProfessor);

		JTextField tProfessor = new JTextField();
		internalCadastro.add(tProfessor);
		tProfessor.setBounds(423, 83, 200, 28);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(556, 510, 147, 39);
		AcaoCadastraCurso.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(715, 510, 103, 39);
		AcaoCadastraCurso.botaoCancelar(bCancelar);

	}

}
