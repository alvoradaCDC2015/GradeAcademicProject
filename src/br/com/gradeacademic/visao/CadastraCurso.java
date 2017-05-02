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

		JLabel lIDCurso = new JLabel("ID");
		internalCadastro.add(lIDCurso);
		lIDCurso.setBounds(58, 55, 45, 16);
		lIDCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tIDCurso = new JTextField();
		internalCadastro.add(tIDCurso);
		tIDCurso.setBounds(59, 83, 45, 28);

		JLabel lNomeCurso = new JLabel("Nome*");
		internalCadastro.add(lNomeCurso);
		lNomeCurso.setBounds(135, 55, 175, 16);
		lNomeCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		JTextField tNomeCurso = new JTextField();
		internalCadastro.add(tNomeCurso);
		tNomeCurso.setBounds(135, 83, 260, 28);

		JLabel lCoordenador = new JLabel("Coordenador*");
		lCoordenador.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lCoordenador.setBounds(423, 54, 160, 16);
		internalCadastro.add(lCoordenador);

		JTextField tCoordenador = new JTextField();
		internalCadastro.add(tCoordenador);
		tCoordenador.setBounds(423, 83, 200, 28);

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
