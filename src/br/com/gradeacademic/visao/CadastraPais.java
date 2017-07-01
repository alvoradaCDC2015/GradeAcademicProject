package br.com.gradeacademic.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.gradeacademic.servico.AcaoCadastraPais;
import br.com.gradeacademic.servico.AcaoCadastraSemestre;

public class CadastraPais extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tID;
	public static JTextField tNome;

	public static void cadastrarPais() {

		internalCadastro = new JInternalFrame("Cadastrar País");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setClosable(true);
		internalCadastro.getContentPane().setLayout(null);
		internalCadastro.setBounds(100, 51, 530, 300);

		JPanel infoPais = new JPanel();
		internalCadastro.add(infoPais);
		infoPais.setBorder(new TitledBorder(null, "Dados Pais", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		infoPais.setBounds(36, 40, 450, 150);
		infoPais.setLayout(null);

		tID = new JTextField();
		tID.setEnabled(false);
		tID.setEditable(false);
		tID.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		tID.setColumns(10);
		tID.setBounds(10, 51, 45, 25);
		tID.setText(String.valueOf(AcaoCadastraSemestre.buscarUltimoId() + 1));
		tID.setVisible(false);

		JLabel lNome = new JLabel("Nome*");
		infoPais.add(lNome);
		lNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNome.setBounds(65, 23, 175, 16);

		tNome = new JTextField();
		infoPais.add(tNome);
		tNome.setBounds(65, 50, 260, 28);

		JButton bSalvar = new JButton("Salvar");
		internalCadastro.add(bSalvar);
		bSalvar.setBounds(200, 200, 147, 39);
		AcaoCadastraPais.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastro.add(bCancelar);
		bCancelar.setBounds(359, 200, 103, 39);
		AcaoCadastraPais.botaoCancelar(bCancelar);

	}

}
