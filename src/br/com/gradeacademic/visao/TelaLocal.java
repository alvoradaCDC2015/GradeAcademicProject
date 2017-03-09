package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.servico.AcaoTelaLocal;

import java.awt.Color;
import javax.swing.JComboBox;

public class TelaLocal extends TelaPrincipal {

	public static JInternalFrame internalCadastraLocal;

	public static JTextField tCampoPais;
	public static JTextField tCampoEstado;
	public static JTextField tCampoCidade;

	public static AcaoTelaLocal acao;

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
		btnSalvar.setBounds(556, 510, 147, 39);
		internalCadastraLocal.add(btnSalvar);
		btnSalvar.setFont(new Font("Roboto Condensed", Font.BOLD, 15));
		AcaoTelaLocal.botaoSalvar(btnSalvar, tCampoCidade);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(715, 510, 103, 39);
		internalCadastraLocal.add(btnCancelar);
		btnCancelar.setFont(new Font("Roboto Condensed", Font.BOLD, 15));
		AcaoTelaLocal.botaoCancelar(btnCancelar);

	}

	private static void pais() {

		JPanel panelPais = new JPanel();
		internalCadastraLocal.add(panelPais);
		panelPais.setBorder(new TitledBorder(null, "Dados Pais", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panelPais.setBounds(36, 40, 789, 150);
		panelPais.setLayout(null);

		tCampoPais = new JTextField();
		tCampoPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoPais.setBounds(65, 50, 260, 28);
		panelPais.add(tCampoPais);

		JLabel lNomePais = new JLabel("Nome*");
		lNomePais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomePais.setBounds(65, 23, 175, 16);
		panelPais.add(lNomePais);
		lNomePais.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lIDPais = new JLabel("ID");
		lIDPais.setHorizontalAlignment(SwingConstants.LEFT);
		lIDPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDPais.setBounds(10, 23, 45, 16);
		panelPais.add(lIDPais);

		JTextField campoIDPais = new JTextField();
		campoIDPais.setEnabled(false);
		campoIDPais.setEditable(false);
		campoIDPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		campoIDPais.setColumns(10);
		campoIDPais.setBounds(10, 51, 45, 25);
		panelPais.add(campoIDPais);

	}

	private static void estado() {

		JPanel panelEstado = new JPanel();
		internalCadastraLocal.add(panelEstado);
		panelEstado.setBorder(new TitledBorder(null, "Dados Estado", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panelEstado.setBounds(36, 200, 789, 150);
		panelEstado.setLayout(null);

		tCampoEstado = new JTextField();
		tCampoEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoEstado.setBounds(65, 50, 260, 28);
		panelEstado.add(tCampoEstado);

		JLabel lNomeEstado = new JLabel("Nome*");
		lNomeEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomeEstado.setBounds(65, 23, 175, 16);
		panelEstado.add(lNomeEstado);
		lNomeEstado.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lIDEstado = new JLabel("ID");
		lIDEstado.setHorizontalAlignment(SwingConstants.LEFT);
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

		JLabel lPaisPertencente = new JLabel("Pais*");
		lPaisPertencente.setHorizontalAlignment(SwingConstants.LEFT);
		lPaisPertencente.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lPaisPertencente.setBounds(335, 23, 145, 16);
		panelEstado.add(lPaisPertencente);

		JComboBox<String> cPaisPertencente = new JComboBox<String>();
		cPaisPertencente.setBounds(335, 50, 87, 28);
		panelEstado.add(cPaisPertencente);

	}

	private static void cidade() {

		JPanel panelCidade = new JPanel();
		internalCadastraLocal.add(panelCidade);
		panelCidade.setBorder(new TitledBorder(null, "Dados Cidade", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panelCidade.setBounds(36, 360, 789, 150);
		panelCidade.setLayout(null);

		tCampoCidade = new JTextField();
		tCampoCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoCidade.setBounds(65, 50, 260, 28);
		panelCidade.add(tCampoCidade);

		JLabel lNomeCidade = new JLabel("Nome*");
		lNomeCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNomeCidade.setBounds(65, 23, 175, 16);
		panelCidade.add(lNomeCidade);
		lNomeCidade.setHorizontalAlignment(SwingConstants.LEFT);

		JTextField campoIDCidade = new JTextField();
		campoIDCidade.setEnabled(false);
		campoIDCidade.setEditable(false);
		campoIDCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		campoIDCidade.setColumns(10);
		campoIDCidade.setBounds(10, 51, 45, 25);
		panelCidade.add(campoIDCidade);

		JLabel lIDCidade = new JLabel("ID");
		lIDCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lIDCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lIDCidade.setBounds(10, 23, 45, 16);
		panelCidade.add(lIDCidade);

		JLabel lEstadoPertencente = new JLabel("Estado*");
		lEstadoPertencente.setHorizontalAlignment(SwingConstants.LEFT);
		lEstadoPertencente.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lEstadoPertencente.setBounds(335, 23, 145, 16);
		panelCidade.add(lEstadoPertencente);

		JComboBox<String> cEstadoPertencente = new JComboBox<String>();
		cEstadoPertencente.setBounds(335, 50, 87, 28);
		panelCidade.add(cEstadoPertencente);

	}

	public static void visualizarLocal() {

		JInternalFrame internalVizualizaLocal = new JInternalFrame("Locais");
		internalVizualizaLocal.setClosable(true);
		internalVizualizaLocal.setLayout(null);
		desktopPane.add(internalVizualizaLocal);
		internalVizualizaLocal.setVisible(true);
		internalVizualizaLocal.setBounds(100, 51, 871, 619);

		tabelaAcessos(internalVizualizaLocal);

		JButton bNovoLocal = new JButton("Novo");
		internalVizualizaLocal.add(bNovoLocal);
		bNovoLocal.setBounds(30, 50, 147, 39);
		AcaoTelaLocal.botaoNovoLocal(bNovoLocal);

		JButton bEditarLocal = new JButton("Editar");
		internalVizualizaLocal.add(bEditarLocal);
		bEditarLocal.setBounds(180, 50, 147, 39);

		JButton bRemoverLocal = new JButton("Remover");
		internalVizualizaLocal.add(bRemoverLocal);
		bRemoverLocal.setBounds(330, 50, 147, 39);

		JTextField tBuscaLocal = new JTextField();
		internalVizualizaLocal.add(tBuscaLocal);
		tBuscaLocal.setBounds(607, 50, 147, 39);

		JButton bFiltraLocal = new JButton("F");
		internalVizualizaLocal.add(bFiltraLocal);
		bFiltraLocal.setBounds(751, 50, 39, 39);

		JButton bPesquisarLocal = new JButton("P");
		internalVizualizaLocal.add(bPesquisarLocal);
		bPesquisarLocal.setBounds(787, 50, 39, 39);

	}

	@SuppressWarnings("serial")
	private static void tabelaAcessos(JInternalFrame internalVizualizaAcesso) {

		JTable tabelaLocal = new JTable();
		tabelaLocal.setLayout(null);
		tabelaLocal.revalidate();
		tabelaLocal.setBounds(0, 0, 800, 500);
		tabelaLocal.setModel(new DefaultTableModel(new Object[] { "Pais", "Estado", "Cidade" }, 0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		});

		JScrollPane scrollLocal = new JScrollPane();
		scrollLocal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLocal.setBounds(0, 0, 800, 370);
		scrollLocal.setViewportView(tabelaLocal);

		JPanel panelTabelaLocal = new JPanel();
		internalVizualizaAcesso.add(panelTabelaLocal);
		panelTabelaLocal.add(scrollLocal);
		panelTabelaLocal.setLayout(null);
		panelTabelaLocal.setBounds(30, 150, 800, 370);

	}

}