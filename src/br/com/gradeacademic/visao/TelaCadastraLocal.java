package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import br.com.gradeacademic.servico.AcaoTelaCadastraLocal;

import java.awt.Color;
import javax.swing.JComboBox;

public class TelaCadastraLocal extends TelaPrincipal {

	public static JInternalFrame internalCadastraLocal;
	public static JInternalFrame internalVizualizaLocal;

	public static JTextField tCampoPais;
	public static JTextField tCampoEstado;
	public static JTextField tCampoCidade;

	public static AcaoTelaCadastraLocal acao;

	public static void cadastrarLocal() {

		internalCadastraLocal = new JInternalFrame("Cadastrar Local");
		desktopPane.add(internalCadastraLocal);
		internalCadastraLocal.setVisible(true);
		internalCadastraLocal.setClosable(true);
		internalCadastraLocal.getContentPane().setLayout(null);
		internalCadastraLocal.setBounds(100, 51, 871, 619);

		pais();
		estado();
		cidade();

		JButton btnSalvar = new JButton("Salvar");
		internalCadastraLocal.add(btnSalvar);
		btnSalvar.setBounds(556, 510, 147, 39);
		AcaoTelaCadastraLocal.botaoSalvar(btnSalvar, tCampoCidade);

		JButton btnCancelar = new JButton("Cancelar");
		internalCadastraLocal.add(btnCancelar);
		btnCancelar.setBounds(715, 510, 103, 39);
		AcaoTelaCadastraLocal.botaoCancelar(btnCancelar);

	}

	private static void pais() {

		JPanel panelPais = new JPanel();
		internalCadastraLocal.add(panelPais);
		panelPais.setBorder(new TitledBorder(null, "Dados Pais", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panelPais.setBounds(36, 40, 789, 150);
		panelPais.setLayout(null);

		JLabel lIDPais = new JLabel("ID");
		panelPais.add(lIDPais);
		lIDPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDPais.setBounds(10, 23, 45, 16);

		JTextField campoIDPais = new JTextField();
		panelPais.add(campoIDPais);
		campoIDPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		campoIDPais.setBounds(10, 51, 45, 25);

		JLabel lNomePais = new JLabel("Nome*");
		panelPais.add(lNomePais);
		lNomePais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomePais.setBounds(65, 23, 175, 16);

		tCampoPais = new JTextField();
		panelPais.add(tCampoPais);
		tCampoPais.setBounds(65, 50, 260, 28);

	}

	private static void estado() {

		JPanel panelEstado = new JPanel();
		internalCadastraLocal.add(panelEstado);
		panelEstado.setBorder(new TitledBorder(null, "Dados Estado", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panelEstado.setBounds(36, 200, 789, 150);
		panelEstado.setLayout(null);

		JLabel lIDEstado = new JLabel("ID");
		lIDEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDEstado.setBounds(10, 23, 45, 16);
		panelEstado.add(lIDEstado);

		JTextField campoIDEstado = new JTextField();
		campoIDEstado.setEnabled(false);
		campoIDEstado.setEditable(false);
		campoIDEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		campoIDEstado.setColumns(10);
		campoIDEstado.setBounds(10, 51, 45, 25);
		panelEstado.add(campoIDEstado);

		JLabel lNomeEstado = new JLabel("Nome*");
		panelEstado.add(lNomeEstado);
		lNomeEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomeEstado.setBounds(65, 23, 175, 16);

		tCampoEstado = new JTextField();
		panelEstado.add(tCampoEstado);
		tCampoEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoEstado.setBounds(65, 50, 260, 28);

		JLabel lPaisPertencente = new JLabel("Pais*");
		panelEstado.add(lPaisPertencente);
		lPaisPertencente.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lPaisPertencente.setBounds(335, 23, 145, 16);

		JComboBox<String> cPaisPertencente = new JComboBox<String>();
		panelEstado.add(cPaisPertencente);
		cPaisPertencente.setBounds(335, 50, 87, 28);

	}

	private static void cidade() {

		JPanel panelCidade = new JPanel();
		internalCadastraLocal.add(panelCidade);
		panelCidade.setBorder(new TitledBorder(null, "Dados Cidade", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panelCidade.setBounds(36, 360, 789, 150);
		panelCidade.setLayout(null);

		JLabel lIDCidade = new JLabel("ID");
		panelCidade.add(lIDCidade);
		lIDCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDCidade.setBounds(10, 23, 45, 16);

		JTextField campoIDCidade = new JTextField();
		panelCidade.add(campoIDCidade);
		campoIDCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		campoIDCidade.setBounds(10, 51, 45, 25);

		JLabel lNomeCidade = new JLabel("Nome*");
		panelCidade.add(lNomeCidade);
		lNomeCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomeCidade.setBounds(65, 23, 175, 16);

		tCampoCidade = new JTextField();
		panelCidade.add(tCampoCidade);
		tCampoCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoCidade.setBounds(65, 50, 260, 28);

		JLabel lEstadoPertencente = new JLabel("Estado*");
		panelCidade.add(lEstadoPertencente);
		lEstadoPertencente.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lEstadoPertencente.setBounds(335, 23, 145, 16);

		JComboBox<String> cEstadoPertencente = new JComboBox<String>();
		panelCidade.add(cEstadoPertencente);
		cEstadoPertencente.setBounds(335, 50, 87, 28);

	}

}