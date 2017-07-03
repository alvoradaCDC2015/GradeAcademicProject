package br.com.gradeacademic.visao;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Disciplina;
import br.com.gradeacademic.entidade.Professor;
import br.com.gradeacademic.entidade.Semestre;
import br.com.gradeacademic.repositorio.RepositorioDisciplina;
import br.com.gradeacademic.repositorio.RepositorioProfessor;
import br.com.gradeacademic.repositorio.RepositorioSemestre;
import br.com.gradeacademic.servico.AcaoVisualizaHorario;

public class VisualizaHorario extends Principal {
	public static JInternalFrame internalHorario;

	static JComboBox<String> cComboProf = new JComboBox<>();
	static JComboBox<String> cComboCurso = new JComboBox<>();
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
		List<Professor> professors = RepositorioProfessor.listar();
		for (Professor professor : professors) {
			cComboProf.addItem(professor.getNome());
		}

		cComboCurso.setBounds(299, 128, 161, 26);
		internalHorario.getContentPane().add(cComboCurso);

		lCurso.setBounds(299, 100, 161, 16);
		internalHorario.getContentPane().add(lCurso);

		JLabel lSemestre = new JLabel("Semestre:");
		lSemestre.setBounds(510, 100, 87, 16);
		internalHorario.getContentPane().add(lSemestre);

		JComboBox<String> cComboSemestre = new JComboBox<>();
		cComboSemestre.setBounds(510, 128, 161, 26);
		internalHorario.getContentPane().add(cComboSemestre);
		List<Semestre> semestres = RepositorioSemestre.listar();
		for (Semestre semestre : semestres) {
			cComboSemestre.addItem(semestre.getDescricao());
		}

		JLabel lDiasSemana = new JLabel("Dia da semana:");
		lDiasSemana.setBounds(85, 166, 128, 16);
		internalHorario.getContentPane().add(lDiasSemana);

		JComboBox<String> cComboDiaSemana = new JComboBox<>();
		cComboDiaSemana.setBounds(80, 194, 168, 26);
		internalHorario.getContentPane().add(cComboDiaSemana);

		JLabel lDisciplina = new JLabel("Disciplina:");
		lDisciplina.setBounds(299, 166, 128, 16);
		internalHorario.getContentPane().add(lDisciplina);

		JComboBox<String> cComboDisciplina = new JComboBox<>();
		cComboDisciplina.setBounds(299, 194, 168, 26);
		internalHorario.getContentPane().add(cComboDisciplina);
		List<Disciplina> disciplinas = RepositorioDisciplina.listar();
		for (Disciplina disciplina : disciplinas) {
			cComboDisciplina.addItem(disciplina.getNome());
		}

		JButton bSair = new JButton("Sair");
		bSair.setBounds(621, 502, 147, 39);
		internalHorario.getContentPane().add(bSair);
		AcaoVisualizaHorario.botaoSair(bSair);

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
		tTableHorario.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "#", "Professor", "Curso", "Semestre", "Dia da Semana", "Disciplina" }));

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
