package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import br.com.gradeacademic.servico.AcaoCadastraProfessor;

import javax.swing.JButton;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class CadastraProfessor extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tID;
	public static JTextField tNome;
	public static JFormattedTextField tNascimento;
	public static JFormattedTextField tCpf;
	public static JComboBox<String> tSituacao;
	public static JTextField tNaturalidade;
	public static JTextField tNacionalidade;
	public static JComboBox<String> tCoordenador;
	public static JTextField tEndereco;
	public static JTextField tNumero;
	public static JTextField tBairro;
	public static JFormattedTextField tCEP;
	public static JTextField tCidade;
	public static JTextField tEstado;

	public static void cadastrarProfessor() {

		internalCadastro = new JInternalFrame("Cadastrar Professor");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setBounds(100, 51, 871, 619);
		internalCadastro.setClosable(true);
		internalCadastro.setLayout(null);

		informacoesCliente(internalCadastro);

		informacoesEndereco(internalCadastro);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(556, 510, 147, 39);
		AcaoCadastraProfessor.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(715, 510, 103, 39);
		AcaoCadastraProfessor.botaoCancelar(bCancelar);

	}

	private static void informacoesCliente(JInternalFrame internalCadProfessor) {
		
		JPanel panelInfoCliente = new JPanel();
		panelInfoCliente.setBorder(new TitledBorder(null, "INFORMA\u00C7\u00D5ES DO CLIENTE", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelInfoCliente.setBounds(36, 37, 789, 247);
		internalCadProfessor.add(panelInfoCliente);
		panelInfoCliente.setLayout(null);

		tNome = new JTextField();
		tNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNome.setBounds(135, 83, 260, 28);
		panelInfoCliente.add(tNome);
		tNome.setColumns(10);

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
			tNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tNascimento.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNascimento.setBounds(423, 83, 127, 28);
		panelInfoCliente.add(tNascimento);

		try {
			tCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tCpf.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCpf.setBounds(573, 83, 106, 28);
		panelInfoCliente.add(tCpf);

		tID = new JTextField();
		tID.setEnabled(false);
		tID.setEditable(false);
		tID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tID.setColumns(10);
		tID.setBounds(59, 83, 45, 28);
		panelInfoCliente.add(tID);

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

		tNaturalidade = new JTextField();
		tNaturalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNaturalidade.setBounds(179, 155, 145, 28);
		panelInfoCliente.add(tNaturalidade);

		JLabel lNacionalidade = new JLabel("Nacionalidade");
		lNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		lNacionalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNacionalidade.setBounds(349, 127, 145, 16);
		panelInfoCliente.add(lNacionalidade);

		tNacionalidade = new JTextField();
		tNacionalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNacionalidade.setBounds(349, 155, 145, 28);
		panelInfoCliente.add(tNacionalidade);

		JLabel lCoordenador = new JLabel("Coordenador*");
		lCoordenador.setHorizontalAlignment(SwingConstants.LEFT);
		lCoordenador.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lCoordenador.setBounds(524, 127, 145, 16);
		panelInfoCliente.add(lCoordenador);

		tCoordenador = new JComboBox<>(new String[] { "Não", "Sim" });
		tCoordenador.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCoordenador.setBounds(524, 155, 100, 28);
		panelInfoCliente.add(tCoordenador);

		tSituacao = new JComboBox<String>();
		tSituacao.setModel(new DefaultComboBoxModel<String>(new String[] { "Selecione...", "Ativo", "Inativo" }));
		tSituacao.setToolTipText("");
		tSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tSituacao.setBounds(59, 155, 110, 28);
		panelInfoCliente.add(tSituacao);

		JLabel lSituacao = new JLabel("Situação");
		lSituacao.setHorizontalAlignment(SwingConstants.LEFT);
		lSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSituacao.setBounds(59, 127, 95, 16);
		panelInfoCliente.add(lSituacao);
	}

	private static void informacoesEndereco(JInternalFrame internalCadProfessor) {
		
		JPanel panelInfoEndereco = new JPanel();
		panelInfoEndereco.setBorder(new TitledBorder(null, "INFORMA\u00C7\u00D5ES DE ENDERE\u00C7O",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoEndereco.setBounds(36, 301, 789, 197);
		internalCadProfessor.add(panelInfoEndereco);
		panelInfoEndereco.setLayout(null);

		tEndereco = new JTextField();
		tEndereco.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tEndereco.setColumns(10);
		tEndereco.setBounds(56, 62, 260, 28);
		panelInfoEndereco.add(tEndereco);

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

		tNumero = new JTextField();
		tNumero.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNumero.setColumns(10);
		tNumero.setBounds(347, 62, 81, 28);
		panelInfoEndereco.add(tNumero);

		tBairro = new JTextField();
		tBairro.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tBairro.setColumns(10);
		tBairro.setBounds(459, 62, 122, 28);
		panelInfoEndereco.add(tBairro);

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
			tCEP = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tCEP.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCEP.setColumns(10);
		tCEP.setBounds(611, 62, 122, 28);
		panelInfoEndereco.add(tCEP);

		JLabel lblCidade = new JLabel("Cidade*");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblCidade.setBounds(203, 102, 175, 16);
		panelInfoEndereco.add(lblCidade);

		tCidade = new JTextField();
		tCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCidade.setColumns(10);
		tCidade.setBounds(203, 130, 162, 28);
		panelInfoEndereco.add(tCidade);

		JLabel lblEstado = new JLabel("Estado*");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblEstado.setBounds(56, 102, 94, 16);
		panelInfoEndereco.add(lblEstado);

		tEstado = new JTextField();
		tEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tEstado.setBounds(56, 130, 114, 28);
		panelInfoEndereco.add(tEstado);

		JButton btnBuscar = new JButton("Buscar ");
		btnBuscar.setBounds(611, 96, 122, 28);
		panelInfoEndereco.add(btnBuscar);
	}

}
