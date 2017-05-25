package br.com.gradeacademic.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.gradeacademic.servico.AcaoCadastraCidade;

public class CadastraCidade extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tNomeCidade;

	public static void cadastrarCidade() {

		internalCadastro = new JInternalFrame("Cadastrar Cidade");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setClosable(true);
		internalCadastro.getContentPane().setLayout(null);
		internalCadastro.setBounds(100, 51, 530, 300);

		JPanel pCidade = new JPanel();
		internalCadastro.add(pCidade);
		pCidade.setBorder(new TitledBorder(null, "Dados Cidade", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		pCidade.setBounds(36, 40, 450, 150);
		pCidade.setLayout(null);

		JTextField tIDCidade = new JTextField();
		tIDCidade.setEnabled(false);
		tIDCidade.setEditable(false);
		tIDCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tIDCidade.setColumns(10);
		tIDCidade.setBounds(10, 51, 45, 25);
		tIDCidade.setVisible(false);

		JLabel lNomeCidade = new JLabel("Nome*");
		pCidade.add(lNomeCidade);
		lNomeCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomeCidade.setBounds(65, 23, 175, 16);

		tNomeCidade = new JTextField();
		pCidade.add(tNomeCidade);
		tNomeCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNomeCidade.setBounds(65, 50, 260, 28);

		JLabel lEstadoPertencente = new JLabel("Estado*");
		pCidade.add(lEstadoPertencente);
		lEstadoPertencente.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lEstadoPertencente.setBounds(335, 23, 145, 16);

		JComboBox<String> cEstadoPertencente = new JComboBox<String>();
		pCidade.add(cEstadoPertencente);
		cEstadoPertencente.setBounds(335, 50, 87, 28);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(200, 200, 147, 39);
		AcaoCadastraCidade.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(359, 200, 103, 39);
		AcaoCadastraCidade.botaoCancelar(bCancelar);

	}

}
