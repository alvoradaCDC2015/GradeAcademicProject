package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroEstado extends TelaPrincipal {

	private static JTextField tCampoNome;
	private static JPanel panelInfoCliente;
	private static JTextField CampoID;
	private static JComboBox<String> tCampoPais;
	static JButton btnCancelar = new JButton("CANCELAR");
	static JButton btnSalvar = new JButton("SALVAR");
	static JButton btnNovo = new JButton("ADICIONAR");
	static JButton btnBuscar = new JButton("Buscar ");
	private static JComboBox<String> tCampoSituacao;
	private static JLabel lSituacao;

	public static void cadastroEstado() {

		JInternalFrame internalCadastraEstado = new JInternalFrame("Cadastrar Estado");
		desktopPane.add(internalCadastraEstado);
		internalCadastraEstado.setVisible(true);
		internalCadastraEstado.setClosable(true);
		internalCadastraEstado.setLayout(null);
		internalCadastraEstado.setBounds(100, 51, 871, 619);

		panelInfoCliente = new JPanel();
		panelInfoCliente.setBorder(new TitledBorder(null, "INFORMA\u00C7\u00D5ES DO ESTADO", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelInfoCliente.setBounds(36, 37, 789, 247);
		internalCadastraEstado.add(panelInfoCliente);
		panelInfoCliente.setLayout(null);

		tCampoNome = new JTextField();
		tCampoNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoNome.setBounds(135, 83, 260, 28);
		panelInfoCliente.add(tCampoNome);
		tCampoNome.setColumns(10);

		JLabel lnomeCompleto = new JLabel("Nome * :");
		lnomeCompleto.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lnomeCompleto.setBounds(135, 55, 175, 16);
		panelInfoCliente.add(lnomeCompleto);
		lnomeCompleto.setHorizontalAlignment(SwingConstants.LEFT);

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

		JLabel lPais = new JLabel("Pais * :");
		lPais.setHorizontalAlignment(SwingConstants.LEFT);
		lPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lPais.setBounds(179, 127, 145, 16);
		panelInfoCliente.add(lPais);

		tCampoPais = new JComboBox<String>();
		tCampoPais.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoPais.setModel(new DefaultComboBoxModel<String>(new String[] { "Brasil", "Lituania", "Bahamas" }));
		tCampoPais.setToolTipText("");
		tCampoPais.setBounds(179, 155, 145, 28);
		panelInfoCliente.add(tCampoPais);

		tCampoSituacao = new JComboBox<String>();
		tCampoSituacao.setModel(new DefaultComboBoxModel<String>(new String[] { "Ativo", "Inativo" }));
		tCampoSituacao.setToolTipText("");
		tCampoSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tCampoSituacao.setBounds(59, 155, 95, 28);
		panelInfoCliente.add(tCampoSituacao);

		lSituacao = new JLabel("Situa\u00E7\u00E3o :");
		lSituacao.setHorizontalAlignment(SwingConstants.LEFT);
		lSituacao.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSituacao.setBounds(59, 127, 95, 16);
		panelInfoCliente.add(lSituacao);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tCampoNome != null && tCampoNome.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "Nome do estado é obrigatório");
				} else {

				}
			}
		});
		btnSalvar.setBounds(556, 510, 147, 39);
		internalCadastraEstado.add(btnSalvar);
		btnSalvar.setFont(new Font("Roboto Condensed", Font.BOLD, 15));

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCancelar.setFont(new Font("Roboto Condensed", Font.BOLD, 15));
		btnCancelar.setBounds(715, 510, 103, 39);
		internalCadastraEstado.add(btnCancelar);

		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				camposEnabled();
			}
		});
		btnNovo.setFont(new Font("Roboto Condensed", Font.BOLD, 15));
		btnNovo.setBounds(420, 510, 124, 39);
		internalCadastraEstado.add(btnNovo);

	}

	public void limpaCampos() {

		tCampoNome.setText("");
		tCampoSituacao.setSelectedIndex(0);

	}

	public static void camposDisabled() {

		tCampoNome.setEnabled(false);

		tCampoSituacao.setEnabled(false);
		tCampoPais.setEnabled(false);

		tCampoPais.setEnabled(false);
		btnSalvar.setEnabled(false);
		btnNovo.setEnabled(true);
		btnCancelar.setEnabled(false);
		btnBuscar.setEnabled(false);

	}

	public static void camposEnabled() {

		tCampoNome.setEnabled(true);
		tCampoSituacao.setEnabled(true);
		tCampoPais.setEnabled(true);
		btnSalvar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnNovo.setEnabled(false);
		btnBuscar.setEnabled(true);

	}
}