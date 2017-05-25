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

		informacoesCliente();

		informacoesEndereco();

		informacoesContato();
		
		JButton bDisponibilidade = new JButton("Disponibilidade");
		internalCadastro.add(bDisponibilidade);
		bDisponibilidade.setBounds(45, 510, 147, 39);
		AcaoCadastraProfessor.botaoDisponibilidade(bDisponibilidade);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(556, 510, 147, 39);
		AcaoCadastraProfessor.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(715, 510, 103, 39);
		AcaoCadastraProfessor.botaoCancelar(bCancelar);

	}

	private static void informacoesCliente() {

		JPanel panelInfoCliente = new JPanel();
		panelInfoCliente.setBorder(new TitledBorder(null, "INFORMAÇÕES DO CLIENTE", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelInfoCliente.setBounds(36, 17, 789, 200);
		internalCadastro.add(panelInfoCliente);
		panelInfoCliente.setLayout(null);

		tNome = new JTextField();
		tNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNome.setBounds(135, 63, 260, 28);
		panelInfoCliente.add(tNome);
		tNome.setColumns(10);

		JLabel lnomeCompleto = new JLabel("Nome Completo*");
		lnomeCompleto.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lnomeCompleto.setBounds(135, 35, 175, 16);
		panelInfoCliente.add(lnomeCompleto);
		lnomeCompleto.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lNascimento = new JLabel("Data Nascimento*");
		lNascimento.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNascimento.setBounds(423, 34, 127, 16);
		panelInfoCliente.add(lNascimento);
		lNascimento.setHorizontalAlignment(SwingConstants.LEFT);

		try {
			tNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tNascimento.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNascimento.setBounds(423, 63, 127, 28);
		panelInfoCliente.add(tNascimento);

		try {
			tCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tCpf.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCpf.setBounds(573, 63, 106, 28);
		panelInfoCliente.add(tCpf);

		tID = new JTextField();
		tID.setEnabled(false);
		tID.setEditable(false);
		tID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tID.setColumns(10);
		tID.setBounds(59, 63, 45, 28);
		panelInfoCliente.add(tID);

		JLabel lId = new JLabel("ID");
		lId.setHorizontalAlignment(SwingConstants.LEFT);
		lId.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lId.setBounds(58, 35, 45, 16);
		panelInfoCliente.add(lId);

		JLabel cpf = new JLabel("CPF*");
		cpf.setHorizontalAlignment(SwingConstants.LEFT);
		cpf.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		cpf.setBounds(573, 35, 145, 16);
		panelInfoCliente.add(cpf);

		JLabel lNaturalidade = new JLabel("Naturalidade");
		lNaturalidade.setHorizontalAlignment(SwingConstants.LEFT);
		lNaturalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNaturalidade.setBounds(179, 107, 145, 16);
		panelInfoCliente.add(lNaturalidade);

		tNaturalidade = new JTextField();
		tNaturalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNaturalidade.setBounds(179, 135, 145, 28);
		panelInfoCliente.add(tNaturalidade);

		JLabel lNacionalidade = new JLabel("Nacionalidade");
		lNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		lNacionalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNacionalidade.setBounds(349, 107, 145, 16);
		panelInfoCliente.add(lNacionalidade);

		tNacionalidade = new JTextField();
		tNacionalidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNacionalidade.setBounds(349, 135, 145, 28);
		panelInfoCliente.add(tNacionalidade);

		JLabel lCoordenador = new JLabel("Coordenador*");
		lCoordenador.setHorizontalAlignment(SwingConstants.LEFT);
		lCoordenador.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lCoordenador.setBounds(524, 107, 145, 16);
		panelInfoCliente.add(lCoordenador);

		tCoordenador = new JComboBox<>(new String[] { "Não", "Sim" });
		tCoordenador.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCoordenador.setBounds(524, 135, 100, 28);
		panelInfoCliente.add(tCoordenador);

		tSituacao = new JComboBox<String>();
		tSituacao.setModel(new DefaultComboBoxModel<String>(new String[] { "Ativo", "Inativo" }));
		tSituacao.setToolTipText("");
		tSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tSituacao.setBounds(59, 135, 110, 28);
		panelInfoCliente.add(tSituacao);

		JLabel lSituacao = new JLabel("Situação");
		lSituacao.setHorizontalAlignment(SwingConstants.LEFT);
		lSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSituacao.setBounds(59, 107, 95, 16);
		panelInfoCliente.add(lSituacao);
	}

	private static void informacoesEndereco() {

		JPanel panelInfoEndereco = new JPanel();
		panelInfoEndereco.setBorder(
				new TitledBorder(null, "INFORMAÇÕES DE ENDEREÇO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoEndereco.setBounds(36, 220, 789, 180);
		internalCadastro.add(panelInfoEndereco);
		panelInfoEndereco.setLayout(null);

		tEndereco = new JTextField();
		tEndereco.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tEndereco.setColumns(10);
		tEndereco.setBounds(56, 52, 260, 28);
		panelInfoEndereco.add(tEndereco);

		JLabel lEndereco = new JLabel("Endereço*");
		lEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lEndereco.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lEndereco.setBounds(56, 24, 175, 16);
		panelInfoEndereco.add(lEndereco);

		JLabel lblN = new JLabel("N\u00BA");
		lblN.setHorizontalAlignment(SwingConstants.LEFT);
		lblN.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblN.setBounds(347, 24, 81, 16);
		panelInfoEndereco.add(lblN);

		tNumero = new JTextField();
		tNumero.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tNumero.setColumns(10);
		tNumero.setBounds(347, 52, 81, 28);
		panelInfoEndereco.add(tNumero);

		tBairro = new JTextField();
		tBairro.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tBairro.setColumns(10);
		tBairro.setBounds(459, 52, 122, 28);
		panelInfoEndereco.add(tBairro);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblBairro.setBounds(459, 24, 81, 16);
		panelInfoEndereco.add(lblBairro);

		JLabel lblCep = new JLabel("CEP*");
		lblCep.setHorizontalAlignment(SwingConstants.LEFT);
		lblCep.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblCep.setBounds(611, 24, 81, 16);
		panelInfoEndereco.add(lblCep);

		try {
			tCEP = new JFormattedTextField(new MaskFormatter("##.###-###"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		tCEP.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCEP.setColumns(10);
		tCEP.setBounds(611, 52, 122, 28);
		panelInfoEndereco.add(tCEP);

		JLabel lblCidade = new JLabel("Cidade*");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblCidade.setBounds(203, 92, 175, 16);
		panelInfoEndereco.add(lblCidade);

		tCidade = new JTextField();
		tCidade.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCidade.setColumns(10);
		tCidade.setBounds(203, 120, 162, 28);
		panelInfoEndereco.add(tCidade);

		JLabel lblEstado = new JLabel("Estado*");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lblEstado.setBounds(56, 92, 94, 16);
		panelInfoEndereco.add(lblEstado);

		tEstado = new JTextField();
		tEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tEstado.setBounds(56, 120, 114, 28);
		panelInfoEndereco.add(tEstado);

		JButton btnBuscar = new JButton("Buscar ");
		btnBuscar.setBounds(611, 86, 122, 28);
		panelInfoEndereco.add(btnBuscar);
	}

	private static void informacoesContato() {

		JPanel panelInfoContato = new JPanel();
		panelInfoContato.setBorder(
				new TitledBorder(null, "INFORMAÇÕES DE CONTATO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoContato.setBounds(36, 405, 789, 100);
		internalCadastro.add(panelInfoContato);
		panelInfoContato.setLayout(null);

		JLabel lbTelefoneResidencial = new JLabel("Telefone Residencial");
		lbTelefoneResidencial.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lbTelefoneResidencial.setBounds(40, 25, 200, 20);
		panelInfoContato.add(lbTelefoneResidencial);
		
		JTextField tTelefoneResidencial = new JTextField();
		tTelefoneResidencial.setBounds(40, 50, 200, 28);
		panelInfoContato.add(tTelefoneResidencial);
		
		JLabel lbCelular = new JLabel("Celular");
		lbCelular.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lbCelular.setBounds(240, 25, 200, 20);
		panelInfoContato.add(lbCelular);
		
		JTextField tCelular = new JTextField();
		tCelular.setBounds(240, 50, 200, 28);
		panelInfoContato.add(tCelular);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lbEmail.setBounds(440, 25, 200, 20);
		panelInfoContato.add(lbEmail);
		
		JTextField tEmail = new JTextField();
		tEmail.setBounds(440, 50, 300, 28);
		panelInfoContato.add(tEmail);

		
	}

}
