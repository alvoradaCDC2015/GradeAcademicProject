package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import br.com.gradeacademic.repositorio.RepositorioHorario;
import br.com.gradeacademic.servico.AcaoBuscaHorario;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class VisualizaHorario extends Principal {
	public static JInternalFrame internalHorario;

	/**
	 * @wbp.parser.entryPoint
	 */

	@SuppressWarnings("rawtypes")
	protected static JComboBox cComboSemestre = new JComboBox();
	@SuppressWarnings("rawtypes")
	protected static JComboBox cComboProf = new JComboBox();
	@SuppressWarnings("rawtypes")
	protected static JComboBox cComboCurso = new JComboBox();
	@SuppressWarnings("rawtypes")
	protected static JComboBox cComboDiaSemana = new JComboBox();
	@SuppressWarnings("rawtypes")
	protected static JComboBox cComboDisciplina = new JComboBox();

	public static JTextField tResultProfessor;
	public static JTextField tResultCurso;
	public static JTextField tResultSemestre;
	public static JTextField tResultDiaDaSemana;
	public static JTextField tResultDisciplina;

	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		cComboProf.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));

		cComboProf.setBounds(80, 128, 204, 26);
		internalHorario.getContentPane().add(cComboProf);
		RepositorioHorario.ComboProfessor();
		cComboCurso.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));

		cComboCurso.setBounds(313, 129, 183, 26);
		internalHorario.getContentPane().add(cComboCurso);
		RepositorioHorario.ComboCurso();

		JLabel lCurso = new JLabel("Curso:");
		lCurso.setBounds(313, 101, 161, 16);
		internalHorario.getContentPane().add(lCurso);

		JLabel lSemestre = new JLabel("Semestre:");
		lSemestre.setBounds(532, 101, 87, 16);
		internalHorario.getContentPane().add(lSemestre);
		cComboSemestre.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));

		cComboSemestre.setBounds(532, 129, 161, 26);
		internalHorario.getContentPane().add(cComboSemestre);
		RepositorioHorario.ComboSemestre();

		JLabel lDiasSemana = new JLabel("Dia da semana:");
		lDiasSemana.setBounds(85, 166, 128, 16);
		internalHorario.getContentPane().add(lDiasSemana);
		cComboDiaSemana.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "Segunda-Feira", "Terça-Feira",
				"Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado" }));

		cComboDiaSemana.setBounds(80, 194, 204, 26);
		internalHorario.getContentPane().add(cComboDiaSemana);

		JLabel lDisciplina = new JLabel("Disciplina:");
		lDisciplina.setBounds(313, 167, 128, 16);
		internalHorario.getContentPane().add(lDisciplina);
		cComboDisciplina.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));

		cComboDisciplina.setBounds(313, 195, 183, 26);
		internalHorario.getContentPane().add(cComboDisciplina);
		RepositorioHorario.ComboDisciplina();

		JButton bSalvar = new JButton("Salvar");
		bSalvar.setBounds(448, 502, 147, 39);
		internalHorario.getContentPane().add(bSalvar);
		AcaoBuscaHorario.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(621, 502, 147, 39);
		internalHorario.getContentPane().add(bCancelar);

		AcaoBuscaHorario.botaoCancelar(bCancelar);

		JButton bBuscar = new JButton("Buscar");
		bBuscar.setBounds(532, 188, 186, 39);
		internalHorario.getContentPane().add(bBuscar);

		AcaoBuscaHorario.botaoBuscar(bBuscar);

	}

	public static void limparCampos() {

		tResultCurso.setText("");
		tResultDiaDaSemana.setText("");
		tResultDisciplina.setText("");
		tResultProfessor.setText("");
		tResultSemestre.setText("");

	}

	private static void table(JInternalFrame internalHorario) {

		JPanel pPanelHorario = new JPanel();
		pPanelHorario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		internalHorario.getContentPane().add(pPanelHorario);
		pPanelHorario.setLayout(null);
		pPanelHorario.setBounds(58, 261, 751, 186);

		tResultProfessor = new JTextField();
		tResultProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		tResultProfessor.setFont(new Font("SansSerif", Font.BOLD, 13));
		tResultProfessor.setEditable(false);
		tResultProfessor.setBounds(53, 40, 210, 38);
		pPanelHorario.add(tResultProfessor);
		tResultProfessor.setColumns(10);

		tResultCurso = new JTextField();
		tResultCurso.setHorizontalAlignment(SwingConstants.CENTER);
		tResultCurso.setFont(new Font("SansSerif", Font.BOLD, 13));
		tResultCurso.setEditable(false);
		tResultCurso.setColumns(10);
		tResultCurso.setBounds(285, 40, 210, 38);
		pPanelHorario.add(tResultCurso);

		tResultSemestre = new JTextField();
		tResultSemestre.setHorizontalAlignment(SwingConstants.CENTER);
		tResultSemestre.setFont(new Font("SansSerif", Font.BOLD, 13));
		tResultSemestre.setEditable(false);
		tResultSemestre.setColumns(10);
		tResultSemestre.setBounds(518, 40, 186, 38);
		pPanelHorario.add(tResultSemestre);

		tResultDiaDaSemana = new JTextField();
		tResultDiaDaSemana.setHorizontalAlignment(SwingConstants.CENTER);
		tResultDiaDaSemana.setFont(new Font("SansSerif", Font.BOLD, 13));
		tResultDiaDaSemana.setEditable(false);
		tResultDiaDaSemana.setColumns(10);
		tResultDiaDaSemana.setBounds(53, 108, 210, 38);
		pPanelHorario.add(tResultDiaDaSemana);

		tResultDisciplina = new JTextField();
		tResultDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		tResultDisciplina.setFont(new Font("SansSerif", Font.BOLD, 13));
		tResultDisciplina.setEditable(false);
		tResultDisciplina.setColumns(10);
		tResultDisciplina.setBounds(285, 108, 210, 38);
		pPanelHorario.add(tResultDisciplina);
	}
}
