package br.com.gradeacademic.visao;

import br.com.gradeacademic.servico.AcaoCadastraHorario;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class CadastraHorario extends Principal {

	public static JInternalFrame internalHorario;

	public static JToggleButton segunda = new JToggleButton();
	public static JToggleButton terca = new JToggleButton();
	public static JToggleButton quarta = new JToggleButton();
	public static JToggleButton quinta = new JToggleButton();
	public static JToggleButton sexta = new JToggleButton();
	public static JToggleButton sabado = new JToggleButton();

	public static void cadastraHorario() {

		internalHorario = new JInternalFrame("Horarios");
		internalHorario.setClosable(true);
		internalHorario.setLayout(null);
		desktopPane.add(internalHorario);
		internalHorario.setVisible(true);
		internalHorario.setBounds(125, 76, 721, 377);

		JButton btnSalvar = new JButton("Salvar");
		JButton btnCancelar = new JButton("Cancelar");

		btnSalvar.setBounds(571, 270, 120, 60);
		AcaoCadastraHorario.botaoSalvar(btnSalvar);
		btnCancelar.setBounds(441, 270, 120, 60);
		AcaoCadastraHorario.botaoCancelar(btnCancelar);

		JPanel panelNomeProfessor = new JPanel();
		panelNomeProfessor.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelNomeProfessor.setBounds(36, 37, 639, 50);
		panelNomeProfessor.setLayout(null);

		JLabel labelNomeProfessor = new JLabel("Meu teclado nao tem acentos");
		labelNomeProfessor.setBounds(10, 3, 600, 40);

		panelNomeProfessor.add(labelNomeProfessor);

		JPanel panelDiasSemana = new JPanel();
		panelDiasSemana.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelDiasSemana.setBounds(36, 97, 639, 157);
		panelDiasSemana.setLayout(null);

		segunda.setText("Segunda");
		terca.setText("Terça");
		quarta.setText("Quarta");
		quinta.setText("Quinta");
		sexta.setText("Sexta");
		sabado.setText("Sabado");

		JToggleButton[] diasSemana = new JToggleButton[6];

		diasSemana[0] = segunda;
		diasSemana[1] = terca;
		diasSemana[2] = quarta;
		diasSemana[3] = quinta;
		diasSemana[4] = sexta;
		diasSemana[5] = sabado;

		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				diasSemana[i].setBounds((200 * i) + 45, 30, 147, 39);
			} else {
				diasSemana[i].setBounds((200 * (i - 3)) + 45, 95, 147, 39);
			}
			panelDiasSemana.add(diasSemana[i]);
		}

		internalHorario.add(panelDiasSemana);
		internalHorario.add(panelNomeProfessor);
		internalHorario.add(btnSalvar);
		internalHorario.add(btnCancelar);

	}
}
