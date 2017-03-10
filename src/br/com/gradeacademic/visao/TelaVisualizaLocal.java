package br.com.gradeacademic.visao;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.servico.AcaoTelaVisualizaLocal;

public class TelaVisualizaLocal extends TelaPrincipal {

	public static JInternalFrame internalVizualizaLocal;

	public static void visualizarLocal() {

		internalVizualizaLocal = new JInternalFrame("Locais");
		internalVizualizaLocal.setClosable(true);
		internalVizualizaLocal.setLayout(null);
		desktopPane.add(internalVizualizaLocal);
		internalVizualizaLocal.setVisible(true);
		internalVizualizaLocal.setBounds(100, 51, 871, 619);

		tabelaAcessos(internalVizualizaLocal);

		JButton bNovoLocal = new JButton("Novo");
		internalVizualizaLocal.add(bNovoLocal);
		bNovoLocal.setBounds(30, 50, 147, 39);
		AcaoTelaVisualizaLocal.botaoNovoLocal(bNovoLocal);

		JButton bEditarLocal = new JButton("Editar");
		internalVizualizaLocal.add(bEditarLocal);
		bEditarLocal.setBounds(180, 50, 147, 39);

		JButton bRemoverLocal = new JButton("Remover");
		internalVizualizaLocal.add(bRemoverLocal);
		bRemoverLocal.setBounds(330, 50, 147, 39);

		JTextField tBuscaLocal = new JTextField();
		internalVizualizaLocal.add(tBuscaLocal);
		tBuscaLocal.setBounds(607, 50, 147, 39);

		JButton bFiltraLocal = new JButton("F");
		internalVizualizaLocal.add(bFiltraLocal);
		bFiltraLocal.setBounds(751, 50, 39, 39);

		JButton bPesquisarLocal = new JButton("P");
		internalVizualizaLocal.add(bPesquisarLocal);
		bPesquisarLocal.setBounds(787, 50, 39, 39);

	}

	@SuppressWarnings("serial")
	private static void tabelaAcessos(JInternalFrame internalVizualizaAcesso) {

		JTable tabelaLocal = new JTable();
		tabelaLocal.setLayout(null);
		tabelaLocal.revalidate();
		tabelaLocal.setBounds(0, 0, 800, 500);
		tabelaLocal.setModel(new DefaultTableModel(new Object[] { "Pais", "Estado", "Cidade" }, 0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		});

		JScrollPane scrollLocal = new JScrollPane();
		scrollLocal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLocal.setBounds(0, 0, 800, 370);
		scrollLocal.setViewportView(tabelaLocal);

		JPanel panelTabelaLocal = new JPanel();
		internalVizualizaAcesso.add(panelTabelaLocal);
		panelTabelaLocal.add(scrollLocal);
		panelTabelaLocal.setLayout(null);
		panelTabelaLocal.setBounds(30, 150, 800, 370);

	}

}