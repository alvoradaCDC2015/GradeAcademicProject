package br.com.gradeacademic.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.gradeacademic.servico.AcaoCadastraPais;

public class CadastraPais extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tNomePais;

	public static void cadastrarPais() {

		internalCadastro = new JInternalFrame("Cadastrar País");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setClosable(true);
		internalCadastro.getContentPane().setLayout(null);
		internalCadastro.setBounds(100, 51, 530, 300);

		JPanel pPais = new JPanel();
		internalCadastro.add(pPais);
		pPais.setBorder(new TitledBorder(null, "Dados Pais", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		pPais.setBounds(36, 40, 450, 150);
		pPais.setLayout(null);

		JTextField tIDPais = new JTextField();
		tIDPais.setEnabled(false);
		tIDPais.setEditable(false);
		tIDPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tIDPais.setColumns(10);
		tIDPais.setBounds(10, 51, 45, 25);
		tIDPais.setVisible(false);

		JLabel lNomePais = new JLabel("Nome*");
		pPais.add(lNomePais);
		lNomePais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomePais.setBounds(65, 23, 175, 16);

		tNomePais = new JTextField();
		pPais.add(tNomePais);
		tNomePais.setBounds(65, 50, 260, 28);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(200, 200, 147, 39);
		AcaoCadastraPais.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(359, 200, 103, 39);
		AcaoCadastraPais.botaoCancelar(bCancelar);

	}

}
