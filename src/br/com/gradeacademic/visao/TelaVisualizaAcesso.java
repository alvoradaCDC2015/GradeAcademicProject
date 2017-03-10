package br.com.gradeacademic.visao;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.servico.AcaoTelaVisualizaAcesso;

public class TelaVisualizaAcesso extends TelaPrincipal {

	public static JInternalFrame internalVizualizaAcesso;

	public static void visualizarAcesso() {

		internalVizualizaAcesso = new JInternalFrame("Acessos");
		internalVizualizaAcesso.setClosable(true);
		internalVizualizaAcesso.setLayout(null);
		desktopPane.add(internalVizualizaAcesso);
		internalVizualizaAcesso.setVisible(true);
		internalVizualizaAcesso.setBounds(100, 51, 871, 619);

		tabelaAcessos(internalVizualizaAcesso);

		JButton bNovoLocal = new JButton("Novo");
		internalVizualizaAcesso.add(bNovoLocal);
		bNovoLocal.setBounds(30, 50, 147, 39);
		AcaoTelaVisualizaAcesso.botaoNovoAcesso(bNovoLocal);

		JButton bEditarLocal = new JButton("Editar");
		internalVizualizaAcesso.add(bEditarLocal);
		bEditarLocal.setBounds(180, 50, 147, 39);

		JButton bRemoverLocal = new JButton("Remover");
		internalVizualizaAcesso.add(bRemoverLocal);
		bRemoverLocal.setBounds(330, 50, 147, 39);

		JTextField tBuscaLocal = new JTextField();
		internalVizualizaAcesso.add(tBuscaLocal);
		tBuscaLocal.setBounds(607, 50, 147, 39);

		JButton bFiltraLocal = new JButton("F");
		internalVizualizaAcesso.add(bFiltraLocal);
		bFiltraLocal.setBounds(751, 50, 39, 39);

		JButton bPesquisarLocal = new JButton("P");
		internalVizualizaAcesso.add(bPesquisarLocal);
		bPesquisarLocal.setBounds(787, 50, 39, 39);

	}

	@SuppressWarnings("serial")
	private static void tabelaAcessos(JInternalFrame internalVizualizaAcesso) {
		JTable tabelaAcessos = new JTable();
		tabelaAcessos.setLayout(null);
		tabelaAcessos.revalidate();
		tabelaAcessos.setBounds(0, 0, 800, 500);
		tabelaAcessos.setModel(new DefaultTableModel(new Object[] { "ID", "Nome", "Usuário", "Senha" }, 0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		});

		JScrollPane scrollAcessos = new JScrollPane();
		scrollAcessos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollAcessos.setBounds(0, 0, 800, 370);
		scrollAcessos.setViewportView(tabelaAcessos);

		JPanel panelTabelaAcessos = new JPanel();
		internalVizualizaAcesso.add(panelTabelaAcessos);
		panelTabelaAcessos.add(scrollAcessos);
		panelTabelaAcessos.setLayout(null);
		panelTabelaAcessos.setBounds(30, 150, 800, 370);
	}

}
