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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroProfessor extends TelaPrincipal {

	private static JTextField tCampoNome;
	private static JPanel panelInfoCliente;
	private static JFormattedTextField tCampoNascimento;
	private static JFormattedTextField tCampoCpf;
	private static JTextField CampoID;
	private static JTextField tCampoNaturalidade;
	private static JTextField tCampoEndereco;
	private static JTextField tCampoNumero;
	private static JTextField campoBairro;
	private static JFormattedTextField CampoCEP;
	private static JTextField campoCidade;
	private static JTextField campoEstado;
	static JButton btnCancelar = new JButton("Cancelar");
	static JButton btnSalvar = new JButton("Salvar");
	static JButton btnNovo = new JButton("Adicionar");
	static JButton btnBuscar = new JButton("Buscar ");
	private static JTextField tCampoNacionalidade;
	private static JTextField tCampoCoordenador;
	private static JComboBox<String> tCampoSituacao;
	private static JLabel lSituacao;

	public static void telaCadastroUsuario() {

		JInternalFrame internalCadProfessor = new JInternalFrame(
				"Cadastrar Professor");
		desktopPane.add(internalCadProfessor);
		internalCadProfessor.setVisible(true);
		internalCadProfessor.setBounds(100, 51, 871, 619);
		internalCadProfessor.setClosable(true);
		internalCadProfessor.setLayout(null);

		panelInfoCliente = new JPanel();
		panelInfoCliente.setBorder(new TitledBorder(null,
				"INFORMA\u00C7\u00D5ES DO CLIENTE", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelInfoCliente.setBounds(36, 37, 789, 247);
		internalCadProfessor.add(panelInfoCliente);
		panelInfoCliente.setLayout(null);

		tCampoNome = new JTextField();
		tCampoNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoNome.setBounds(135, 83, 260, 28);
		panelInfoCliente.add(tCampoNome);
		tCampoNome.setColumns(10);

		JLabel lnomeCompleto = new JLabel("Nome Completo*");
		lnomeCompleto.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lnomeCompleto.setBounds(135, 55, 175, 16);
		panelInfoCliente.add(lnomeCompleto);
		lnomeCompleto.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lNascimento = new JLabel("Data Nascimento*");
		lNascimento.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNascimento.setBounds(423, 54, 127, 16);
		panelInfoCliente.add(lNascimento);
		lNascimento.setHorizontalAlignment(SwingConstants.LEFT);

		try {
			tCampoNascimento = new JFormattedTextField(new MaskFormatter(
					"##/##/####"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tCampoNascimento.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoNascimento.setBounds(423, 83, 127, 28);
		panelInfoCliente.add(tCampoNascimento);

		try {
			tCampoCpf = new JFormattedTextField(new MaskFormatter(
					"###.###.###-##"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tCampoCpf.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoCpf.setBounds(573, 83, 106, 28);
		panelInfoCliente.add(tCampoCpf);

		CampoID = new JTextField();
		CampoID.setEnabled(false);
		CampoID.setEditable(false);
		CampoID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		CampoID.setColumns(10);
		CampoID.setBounds(59, 83, 45, 28);
		panelInfoCliente.add(CampoID);

		JLabel lId = new JLabel("ID");
		lId.setHorizontalAlignment(SwingConstants.LEFT);
		lId.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lId.setBounds(58, 55, 45, 16);
		panelInfoCliente.add(lId);

		JLabel cpf = new JLabel("CPF*");
		cpf.setHorizontalAlignment(SwingConstants.LEFT);
		cpf.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		cpf.setBounds(573, 55, 145, 16);
		panelInfoCliente.add(cpf);

		JLabel lNaturalidade = new JLabel("Naturalidade");
		lNaturalidade.setHorizontalAlignment(SwingConstants.LEFT);
		lNaturalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNaturalidade.setBounds(179, 127, 145, 16);
		panelInfoCliente.add(lNaturalidade);

		tCampoNaturalidade = new JTextField();
		tCampoNaturalidade
				.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoNaturalidade.setBounds(179, 155, 145, 28);
		panelInfoCliente.add(tCampoNaturalidade);

		JLabel lNacionalidade = new JLabel("Nacionalidade");
		lNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		lNacionalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNacionalidade.setBounds(349, 127, 145, 16);
		panelInfoCliente.add(lNacionalidade);

		tCampoNacionalidade = new JTextField();
		tCampoNacionalidade
				.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoNacionalidade.setBounds(349, 155, 145, 28);
		panelInfoCliente.add(tCampoNacionalidade);

		JLabel lCoordenador = new JLabel("Coordenador*");
		lCoordenador.setHorizontalAlignment(SwingConstants.LEFT);
		lCoordenador.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lCoordenador.setBounds(524, 127, 145, 16);
		panelInfoCliente.add(lCoordenador);

		tCampoCoordenador = new JTextField();
		tCampoCoordenador.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoCoordenador.setBounds(524, 155, 145, 28);
		panelInfoCliente.add(tCampoCoordenador);

		tCampoSituacao = new JComboBox<String>();
		tCampoSituacao.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Selecione...", "Ativo", "Inativo" }));
		tCampoSituacao.setToolTipText("");
		tCampoSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoSituacao.setBounds(59, 155, 95, 28);
		panelInfoCliente.add(tCampoSituacao);

		lSituacao = new JLabel("Situação");
		lSituacao.setHorizontalAlignment(SwingConstants.LEFT);
		lSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSituacao.setBounds(59, 127, 95, 16);
		panelInfoCliente.add(lSituacao);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tCampoNome != null
						&& tCampoNome.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null,
							"Nome é campo Obrigatório!");
				} else {

				}
			}
		});
		btnSalvar.setBounds(556, 510, 147, 39);
		internalCadProfessor.add(btnSalvar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});


		JPanel panelInfoEndereco = new JPanel();
		panelInfoEndereco.setBorder(new TitledBorder(null,
				"INFORMA\u00C7\u00D5ES DE ENDERE\u00C7O", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelInfoEndereco.setBounds(36, 301, 789, 197);
		internalCadProfessor.add(panelInfoEndereco);
		panelInfoEndereco.setLayout(null);

		tCampoEndereco = new JTextField();
		tCampoEndereco.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoEndereco.setColumns(10);
		tCampoEndereco.setBounds(56, 62, 260, 28);
		panelInfoEndereco.add(tCampoEndereco);

		JLabel lEndereco = new JLabel("Endereço*");
		lEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lEndereco.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lEndereco.setBounds(56, 34, 175, 16);
		panelInfoEndereco.add(lEndereco);

		JLabel lblN = new JLabel("N\u00BA");
		lblN.setHorizontalAlignment(SwingConstants.LEFT);
		lblN.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblN.setBounds(347, 34, 81, 16);
		panelInfoEndereco.add(lblN);

		tCampoNumero = new JTextField();
		tCampoNumero.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoNumero.setColumns(10);
		tCampoNumero.setBounds(347, 62, 81, 28);
		panelInfoEndereco.add(tCampoNumero);

		campoBairro = new JTextField();
		campoBairro.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		campoBairro.setColumns(10);
		campoBairro.setBounds(459, 62, 122, 28);
		panelInfoEndereco.add(campoBairro);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblBairro.setBounds(459, 34, 81, 16);
		panelInfoEndereco.add(lblBairro);

		JLabel lblCep = new JLabel("CEP*");
		lblCep.setHorizontalAlignment(SwingConstants.LEFT);
		lblCep.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblCep.setBounds(611, 34, 81, 16);
		panelInfoEndereco.add(lblCep);

		try {
			CampoCEP = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		CampoCEP.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		CampoCEP.setColumns(10);
		CampoCEP.setBounds(611, 62, 122, 28);
		panelInfoEndereco.add(CampoCEP);

		JLabel lblCidade = new JLabel("Cidade*");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblCidade.setBounds(203, 102, 175, 16);
		panelInfoEndereco.add(lblCidade);

		campoCidade = new JTextField();
		campoCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		campoCidade.setColumns(10);
		campoCidade.setBounds(203, 130, 162, 28);
		panelInfoEndereco.add(campoCidade);

		JLabel lblEstado = new JLabel("Estado*");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblEstado.setBounds(56, 102, 94, 16);
		panelInfoEndereco.add(lblEstado);

		campoEstado = new JTextField();
		campoEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		campoEstado.setBounds(56, 130, 114, 28);
		panelInfoEndereco.add(campoEstado);

		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		btnBuscar.setBounds(611, 96, 122, 28);
		panelInfoEndereco.add(btnBuscar);

	}

	public void limpaCampos() {

		tCampoNome.setText("");
		tCampoNascimento.setText("");
		tCampoSituacao.setSelectedIndex(0);
		tCampoCpf.setText("");
		tCampoEndereco.setText("");
		tCampoNumero.setText("");
		campoBairro.setText("");
		CampoCEP.setText("");
		campoEstado.setText("");
		campoCidade.setText("");

	}

	public static void camposDisabled() {

		tCampoNome.setEnabled(false);
		tCampoNascimento.setEnabled(false);
		tCampoSituacao.setEnabled(false);
		tCampoCpf.setEnabled(false);
		tCampoNaturalidade.setEnabled(false);
		tCampoCoordenador.setEnabled(false);
		tCampoNacionalidade.setEnabled(false);
		tCampoNaturalidade.setEnabled(false);
		tCampoEndereco.setEnabled(false);
		tCampoNumero.setEnabled(false);
		campoBairro.setEnabled(false);
		CampoCEP.setEnabled(false);
		campoEstado.setEnabled(false);
		campoCidade.setEnabled(false);
		btnSalvar.setEnabled(false);
		btnNovo.setEnabled(true);
		btnCancelar.setEnabled(false);
		btnBuscar.setEnabled(false);

	}

	public static void camposEnabled() {

		tCampoNome.setEnabled(true);
		tCampoNascimento.setEnabled(true);
		tCampoSituacao.setEnabled(true);
		tCampoCpf.setEnabled(true);
		tCampoNaturalidade.setEnabled(true);
		tCampoCoordenador.setEnabled(true);
		tCampoNacionalidade.setEnabled(true);
		tCampoEndereco.setEnabled(true);
		tCampoNumero.setEnabled(true);
		campoBairro.setEnabled(true);
		CampoCEP.setEnabled(true);
		campoEstado.setEnabled(true);
		campoCidade.setEnabled(true);
		btnSalvar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnNovo.setEnabled(false);
		btnBuscar.setEnabled(true);

	}
}
