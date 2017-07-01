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

import br.com.gradeacademic.entidade.Pais;
import br.com.gradeacademic.servico.AcaoCadastraEstado;
import br.com.gradeacademic.servico.AcaoCadastraSemestre;

public class CadastraEstado extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tID;
	public static JTextField tNomeEstado;
	public static JComboBox<String> cPaisPertencente;

	public static void cadastrarEstado() {

		internalCadastro = new JInternalFrame("Cadastrar Estado");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setClosable(true);
		internalCadastro.getContentPane().setLayout(null);
		internalCadastro.setBounds(100, 51, 530, 300);

		JPanel pEstado = new JPanel();
		internalCadastro.add(pEstado);
		pEstado.setBorder(new TitledBorder(null, "Dados Estado", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		pEstado.setBounds(36, 40, 450, 150);
		pEstado.setLayout(null);

		tID = new JTextField();
		tID.setEnabled(false);
		tID.setEditable(false);
		tID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tID.setColumns(10);
		tID.setBounds(10, 51, 45, 25);
		tID.setText(String.valueOf(AcaoCadastraEstado.buscarUltimoId() + 1));
		tID.setVisible(false);
		pEstado.add(tID);

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

		cPaisPertencente = new JComboBox<String>();
		pEstado.add(cPaisPertencente);
		cPaisPertencente.setBounds(335, 50, 87, 28);
		AcaoCadastraEstado.listarPaises();

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(200, 200, 147, 39);
		AcaoCadastraEstado.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(359, 200, 103, 39);
		AcaoCadastraEstado.botaoCancelar(bCancelar);

	}

}
