package br.com.gradeacademic.visao;

import javax.swing.JInternalFrame;
import br.com.gradeacademic.servico.AcaoGerarRelatorio;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VisualizaRelatorio extends Principal {

	public static JInternalFrame internalRelatorio;

	/**
	 * @throws DocumentException 
	 * @throws IOException 
	 * @wbp.parser.entryPoint
	 */
	public static void visualizarRelatorio() {

		internalRelatorio = new JInternalFrame("Relatorio");
		desktopPane.add(internalRelatorio);
		internalRelatorio.setVisible(true);
		internalRelatorio.setBounds(100, 51, 871, 619);
		internalRelatorio.setClosable(true);
		internalRelatorio.getContentPane().setLayout(null);
		
		table(internalRelatorio);

		JButton bGerar = new JButton("Gerar Relatorio");
		internalRelatorio.getContentPane().add(bGerar);
		bGerar.setBounds(633, 81, 147, 39);
		AcaoGerarRelatorio.botaoGerar(bGerar);
		
		@SuppressWarnings("rawtypes")
		JComboBox cComboCurso = new JComboBox();
		cComboCurso.setBounds(79, 87, 195, 26);
		internalRelatorio.getContentPane().add(cComboCurso);
		
		@SuppressWarnings("rawtypes")
		JComboBox cComboSemestre = new JComboBox();
		cComboSemestre.setBounds(298, 87, 160, 26);
		internalRelatorio.getContentPane().add(cComboSemestre);
		
		JLabel lCurso = new JLabel("Curso *");
		lCurso.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lCurso.setBounds(79, 57, 160, 28);
		internalRelatorio.getContentPane().add(lCurso);
		
		JLabel lSemestre = new JLabel("Semestre *");
		lSemestre.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSemestre.setBounds(298, 57, 160, 28);
		internalRelatorio.getContentPane().add(lSemestre);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(633, 501, 147, 39);
		internalRelatorio.getContentPane().add(btnImprimir);

	}
	
	
	private static void table(JInternalFrame internalRelatorio) {
		JTable tTableRelatorio = new JTable();
		tTableRelatorio.setLayout(null);
		tTableRelatorio.revalidate();
		tTableRelatorio.setBounds(0, 0, 800, 500);
		tTableRelatorio.setRowHeight(1, 90);
		tTableRelatorio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "SEGUNDA", "TER\u00C7A", "QUARTA", "QUINTA", "SEXTA"
			}
		));
		
		tTableRelatorio.getColumnModel().getColumn(0).setResizable(false);
		tTableRelatorio.getColumnModel().getColumn(0).setPreferredWidth(45);
		tTableRelatorio.getColumnModel().getColumn(1).setResizable(false);
		tTableRelatorio.getColumnModel().getColumn(1).setPreferredWidth(104);
		tTableRelatorio.getColumnModel().getColumn(2).setResizable(false);
		tTableRelatorio.getColumnModel().getColumn(2).setPreferredWidth(112);
		tTableRelatorio.getColumnModel().getColumn(3).setResizable(false);
		tTableRelatorio.getColumnModel().getColumn(3).setPreferredWidth(114);
		tTableRelatorio.getColumnModel().getColumn(3).setMinWidth(36);
		tTableRelatorio.getColumnModel().getColumn(4).setResizable(false);
		tTableRelatorio.getColumnModel().getColumn(4).setPreferredWidth(101);
		tTableRelatorio.getColumnModel().getColumn(5).setResizable(false);
		tTableRelatorio.getColumnModel().getColumn(5).setPreferredWidth(97);
		

		JScrollPane sScrollRelatorio = new JScrollPane();
		sScrollRelatorio.setBounds(0, 0, 704, 287);
		sScrollRelatorio.setViewportView(tTableRelatorio);

		JPanel pPanelRelatorio = new JPanel();
		internalRelatorio.getContentPane().add(pPanelRelatorio);
		pPanelRelatorio.add(sScrollRelatorio);
		pPanelRelatorio.setLayout(null);
		pPanelRelatorio.setBounds(76, 172, 704, 287);
	}
}
