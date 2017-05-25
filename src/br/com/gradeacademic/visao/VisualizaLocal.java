package br.com.gradeacademic.visao;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.servico.AcaoVisualizaLocal;

public class VisualizaLocal extends Principal {

	public static JInternalFrame internalVisualiza;

	public static void visualizarLocal() {

		internalVisualiza = new JInternalFrame("Locais");
		internalVisualiza.setClosable(true);
		internalVisualiza.setLayout(null);
		desktopPane.add(internalVisualiza);
		internalVisualiza.setVisible(true);
		internalVisualiza.setBounds(100, 51, 871, 619);

		tabela(internalVisualiza);

		JButton bNovoPais = new JButton("Novo País");
		internalVisualiza.add(bNovoPais);
		bNovoPais.setBounds(30, 50, 100, 39);
		AcaoVisualizaLocal.botaoNovoPais(bNovoPais);

		JButton bNovoEstado = new JButton("Novo Estado");
		internalVisualiza.add(bNovoEstado);
		bNovoEstado.setBounds(130, 50, 100, 39);
		AcaoVisualizaLocal.botaoNovoEstado(bNovoEstado);

		JButton bNovoCidade = new JButton("Nova Cidade");
		internalVisualiza.add(bNovoCidade);
		bNovoCidade.setBounds(230, 50, 100, 39);
		AcaoVisualizaLocal.botaoNovaCidade(bNovoCidade);

		JButton bEditar = new JButton("Editar");
		internalVisualiza.add(bEditar);
		bEditar.setBounds(340, 50, 130, 39);

		JButton bRemover = new JButton("Remover");
		internalVisualiza.add(bRemover);
		bRemover.setBounds(470, 50, 130, 39);

		JTextField tBusca = new JTextField();
		internalVisualiza.add(tBusca);
		tBusca.setBounds(607, 50, 147, 39);

		JButton bFiltra = new JButton("F");
		internalVisualiza.add(bFiltra);
		bFiltra.setBounds(751, 50, 39, 39);

		JButton bPesquisar = new JButton("P");
		internalVisualiza.add(bPesquisar);
		bPesquisar.setBounds(787, 50, 39, 39);

	}

	@SuppressWarnings("serial")
	private static void tabela(JInternalFrame internalVizualiza) {
		JTable tabela = new JTable();
		tabela.setLayout(null);
		tabela.revalidate();
		tabela.setBounds(0, 0, 800, 500);
		tabela.setModel(new DefaultTableModel(new Object[] { "ID", "Pais", "ID", "Estado", "ID", "Cidade" }, 0) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		});

		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(0, 0, 800, 370);
		scroll.setViewportView(tabela);

		JPanel panelTabela = new JPanel();
		internalVizualiza.add(panelTabela);
		panelTabela.add(scroll);
		panelTabela.setLayout(null);
		panelTabela.setBounds(30, 150, 800, 370);
	}

}