package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import br.com.gradeacademic.servico.AcaoCadastraLocal;

import java.awt.Color;
import javax.swing.JComboBox;

public class CadastraLocal extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tNomePais;
	public static JTextField tNomeEstado;
	public static JTextField tNomeCidade;

	public static AcaoCadastraLocal acao;

	public static void cadastrarLocal() {

		internalCadastro = new JInternalFrame("Cadastrar Local");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setClosable(true);
		internalCadastro.getContentPane().setLayout(null);
		internalCadastro.setBounds(100, 51, 871, 619);

		pais();
		estado();
		cidade();

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(556, 510, 147, 39);
		AcaoCadastraLocal.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(715, 510, 103, 39);
		AcaoCadastraLocal.botaoCancelar(bCancelar);

	}

	private static void pais() {

		JPanel pPais = new JPanel();
		internalCadastro.add(pPais);
		pPais.setBorder(new TitledBorder(null, "Dados Pais", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		pPais.setBounds(36, 40, 789, 150);
		pPais.setLayout(null);

		JLabel lIDPais = new JLabel("ID");
		pPais.add(lIDPais);
		lIDPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDPais.setBounds(10, 23, 45, 16);

		JTextField tIDPais = new JTextField();
		pPais.add(tIDPais);
		tIDPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tIDPais.setBounds(10, 51, 45, 25);

		JLabel lNomePais = new JLabel("Nome*");
		pPais.add(lNomePais);
		lNomePais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomePais.setBounds(65, 23, 175, 16);

		tNomePais = new JTextField();
		pPais.add(tNomePais);
		tNomePais.setBounds(65, 50, 260, 28);

	}

	private static void estado() {

		JPanel pEstado = new JPanel();
		internalCadastro.add(pEstado);
		pEstado.setBorder(new TitledBorder(null, "Dados Estado", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		pEstado.setBounds(36, 200, 789, 150);
		pEstado.setLayout(null);

		JLabel lIDEstado = new JLabel("ID");
		lIDEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDEstado.setBounds(10, 23, 45, 16);
		pEstado.add(lIDEstado);

		JTextField tIDEstado = new JTextField();
		tIDEstado.setEnabled(false);
		tIDEstado.setEditable(false);
		tIDEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tIDEstado.setColumns(10);
		tIDEstado.setBounds(10, 51, 45, 25);
		pEstado.add(tIDEstado);

		JLabel lNomeEstado = new JLabel("Nome*");
		pEstado.add(lNomeEstado);
		lNomeEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomeEstado.setBounds(65, 23, 175, 16);

		tNomeEstado = new JTextField();
		pEstado.add(tNomeEstado);
		tNomeEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNomeEstado.setBounds(65, 50, 260, 28);

		JLabel lPaisPertencente = new JLabel("Pais*");
		pEstado.add(lPaisPertencente);
		lPaisPertencente.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lPaisPertencente.setBounds(335, 23, 145, 16);

		JComboBox<String> cPaisPertencente = new JComboBox<String>();
		pEstado.add(cPaisPertencente);
		cPaisPertencente.setBounds(335, 50, 87, 28);

	}

	private static void cidade() {

		JPanel pCidade = new JPanel();
		internalCadastro.add(pCidade);
		pCidade.setBorder(new TitledBorder(null, "Dados Cidade", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		pCidade.setBounds(36, 360, 789, 150);
		pCidade.setLayout(null);

		JLabel lIDCidade = new JLabel("ID");
		pCidade.add(lIDCidade);
		lIDCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDCidade.setBounds(10, 23, 45, 16);

		JTextField tIDCidade = new JTextField();
		pCidade.add(tIDCidade);
		tIDCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tIDCidade.setBounds(10, 51, 45, 25);

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

	}

}