package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCidade extends TelaPrincipal {

	private static JPanel panelCadCidade;

	private static JTextField CampoID;
	private static JTextField tCampoCidade;
	private static JFormattedTextField tSiglaEstado;

	static JButton btnEditar = new JButton("EDITAR");
	static JButton btnSalvar = new JButton("SALVAR");
	static JButton btnAdicionar = new JButton("ADICIONAR");
	static JButton btnRemover = new JButton("REMOVER");
	static JButton btnPesquisar = new JButton("Buscar ");

	private static JTextField tCampoPesquisa;

	public static void cadastroCidade() {

		JInternalFrame internalCadastraCidade = new JInternalFrame("Cadastrar Cidade");
		desktopPane.add(internalCadastraCidade);
		internalCadastraCidade.setVisible(true);
		internalCadastraCidade.setClosable(true);
		internalCadastraCidade.setLayout(null);
		internalCadastraCidade.setBounds(100, 51, 871, 619);

		panelCadCidade = new JPanel();
		panelCadCidade.setBorder(new TitledBorder(null, "INFORMA\u00C7\u00D5ES DO CLIENTE", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelCadCidade.setBounds(36, 37, 789, 247);
		internalCadastraCidade.add(panelCadCidade);
		panelCadCidade.setLayout(null);

		tCampoCidade = new JTextField();
		tCampoCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoCidade.setBounds(135, 83, 260, 28);
		panelCadCidade.add(tCampoCidade);
		tCampoCidade.setColumns(10);

		JLabel lnomeCidade = new JLabel("Nome Cidade :");
		lnomeCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lnomeCidade.setBounds(135, 55, 175, 16);
		panelCadCidade.add(lnomeCidade);
		lnomeCidade.setHorizontalAlignment(SwingConstants.LEFT);

		try {
			tSiglaEstado = new JFormattedTextField(new MaskFormatter("##"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tSiglaEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tSiglaEstado.setBounds(573, 83, 106, 28);
		panelCadCidade.add(tSiglaEstado);

		CampoID = new JTextField();
		CampoID.setEnabled(false);
		CampoID.setEditable(false);
		CampoID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		CampoID.setColumns(10);
		CampoID.setBounds(59, 83, 45, 28);
		panelCadCidade.add(CampoID);

		JLabel lId = new JLabel("ID");
		lId.setHorizontalAlignment(SwingConstants.LEFT);
		lId.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lId.setBounds(58, 55, 45, 16);
		panelCadCidade.add(lId);

		JLabel lSiglaEstado = new JLabel("Estado:");
		lSiglaEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lSiglaEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSiglaEstado.setBounds(573, 55, 145, 16);
		panelCadCidade.add(lSiglaEstado);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tCampoCidade != null && tCampoCidade.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "Isira o nome da Cidade");
				} else {

				}
			}
		});
		btnSalvar.setBounds(715, 510, 103, 39);
		internalCadastraCidade.add(btnSalvar);
		btnSalvar.setFont(new Font("Roboto Condensed", Font.BOLD, 15));

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnEditar.setFont(new Font("Roboto Condensed", Font.BOLD, 15));
		btnEditar.setBounds(556, 510, 147, 39);
		internalCadastraCidade.add(btnEditar);

		JPanel panelPesquisaCidade = new JPanel();
		panelPesquisaCidade.setBorder(
				new TitledBorder(null, "PESQUISAR CIDADE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPesquisaCidade.setBounds(36, 301, 789, 197);
		internalCadastraCidade.add(panelPesquisaCidade);
		panelPesquisaCidade.setLayout(null);

		tCampoPesquisa = new JTextField();
		tCampoPesquisa.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoPesquisa.setColumns(10);
		tCampoPesquisa.setBounds(56, 62, 260, 28);
		panelPesquisaCidade.add(tCampoPesquisa);

		JLabel lPesquisarCidade = new JLabel("Pesquisar Cidade :");
		lPesquisarCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lPesquisarCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lPesquisarCidade.setBounds(56, 34, 175, 16);
		panelPesquisaCidade.add(lPesquisarCidade);

		btnPesquisar.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));

		btnPesquisar.setBounds(611, 96, 122, 28);
		panelPesquisaCidade.add(btnPesquisar);

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				camposEnabled();
			}
		});
		btnAdicionar.setFont(new Font("Roboto Condensed", Font.BOLD, 15));
		btnAdicionar.setBounds(420, 510, 124, 39);
		internalCadastraCidade.add(btnAdicionar);
	}

	public void limpaCampos() {

		tCampoCidade.setText("");
		tSiglaEstado.setText("");
		tCampoPesquisa.setText("");
	}

	public static void camposDisabled() {

		tCampoCidade.setEnabled(false);
		tSiglaEstado.setEnabled(false);
		tCampoPesquisa.setEnabled(false);
		btnSalvar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnPesquisar.setEnabled(false);

	}

	public static void camposEnabled() {

		tCampoCidade.setEnabled(true);
		tSiglaEstado.setEnabled(true);
		tCampoPesquisa.setEnabled(true);
		btnSalvar.setEnabled(true);
		btnEditar.setEnabled(true);
		btnAdicionar.setEnabled(false);
		btnPesquisar.setEnabled(true);

	}

}