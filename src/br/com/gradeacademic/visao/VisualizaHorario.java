package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VisualizaHorario extends Principal {
	public static JInternalFrame internalHorario;
	
	static JComboBox cComboProf = new JComboBox();
	static JComboBox cComboCurso = new JComboBox();
	static JLabel lCurso = new JLabel("Curso:");

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void visualizaHorario() {

		internalHorario = new JInternalFrame("Horários");
		desktopPane.add(internalHorario);

		internalHorario.setVisible(true);
		internalHorario.setBounds(100, 51, 871, 619);
		internalHorario.setClosable(true);
		internalHorario.getContentPane().setLayout(null);

		table(internalHorario);

		JLabel lProf = new JLabel("Professor (a):");
		lProf.setBounds(85, 96, 87, 16);
		internalHorario.getContentPane().add(lProf);

		JLabel lGerenciamentoDeHorarios = new JLabel("Gerenciamento de Horarios:");
		lGerenciamentoDeHorarios.setFont(new Font("SansSerif", Font.BOLD, 14));
		lGerenciamentoDeHorarios.setBounds(85, 50, 435, 26);
		internalHorario.getContentPane().add(lGerenciamentoDeHorarios);

		
		cComboProf.setBounds(80, 128, 168, 26);
		internalHorario.getContentPane().add(cComboProf);

		
		cComboCurso.setBounds(299, 128, 161, 26);
		internalHorario.getContentPane().add(cComboCurso);

		
		lCurso.setBounds(299, 100, 161, 16);
		internalHorario.getContentPane().add(lCurso);

		JLabel lSemestre = new JLabel("Semestre:");
		lSemestre.setBounds(510, 100, 87, 16);
		internalHorario.getContentPane().add(lSemestre);

		JComboBox cComboSemestre = new JComboBox();
		cComboSemestre.setBounds(510, 128, 161, 26);
		internalHorario.getContentPane().add(cComboSemestre);

		JLabel lDiasSemana = new JLabel("Dia da semana:");
		lDiasSemana.setBounds(85, 166, 128, 16);
		internalHorario.getContentPane().add(lDiasSemana);

		JComboBox cComboDiaSemana = new JComboBox();
		cComboDiaSemana.setBounds(80, 194, 168, 26);
		internalHorario.getContentPane().add(cComboDiaSemana);
		
		JLabel lDisciplina = new JLabel("Disciplina:");
		lDisciplina.setBounds(299, 166, 128, 16);
		internalHorario.getContentPane().add(lDisciplina);
		
		JComboBox cComboDisciplina = new JComboBox();
		cComboDisciplina.setBounds(299, 194, 168, 26);
		internalHorario.getContentPane().add(cComboDisciplina);
		
		JButton bSalvar = new JButton("Salvar");
		bSalvar.setBounds(448, 502, 147, 39);
		internalHorario.getContentPane().add(bSalvar);
		
		JButton bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(621, 502, 147, 39);
		internalHorario.getContentPane().add(bCancelar);
		
		JButton bBuscar = new JButton("Buscar");
		bBuscar.setBounds(510, 188, 75, 39);
		internalHorario.getContentPane().add(bBuscar);

	}

	private static void table(JInternalFrame internalHorario) {
		JTable tTableHorario = new JTable();
		tTableHorario.setLayout(null);
		tTableHorario.revalidate();
		tTableHorario.setBounds(0, 0, 800, 500);
		tTableHorario.setRowHeight(1, 90);
		tTableHorario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "Professor", "Curso", "Semestre", "Dia da Semana", "Disciplina"
			}
		));

		JScrollPane sScrollHorario = new JScrollPane();
		sScrollHorario.setBounds(26, 6, 692, 209);
		sScrollHorario.setViewportView(tTableHorario);

		JPanel pPanelHorario = new JPanel();
		internalHorario.getContentPane().add(pPanelHorario);
		pPanelHorario.add(sScrollHorario);
		pPanelHorario.setLayout(null);
		pPanelHorario.setBounds(56, 261, 724, 229);
	}
}
