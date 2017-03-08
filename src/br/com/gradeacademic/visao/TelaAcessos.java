package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaAcessos extends TelaPrincipal {

	public static void telaCadastraAcesso() {

		JInternalFrame internalCadastraAcesso = new JInternalFrame("Cadastrar Acesso");
		desktopPane.add(internalCadastraAcesso);
		internalCadastraAcesso.setVisible(true);
		internalCadastraAcesso.setClosable(true);
		internalCadastraAcesso.setLayout(null);
		internalCadastraAcesso.setBounds(100, 51, 871, 619);

		JLabel lNome = new JLabel("Nome");
		internalCadastraAcesso.add(lNome);
		lNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNome.setBounds(285, 140, 303, 28);

		JTextField tNome = new JTextField();
		internalCadastraAcesso.add(tNome);
		tNome.setBounds(285, 165, 303, 28);

		JLabel lUsuario = new JLabel("Usuário");
		internalCadastraAcesso.add(lUsuario);
		lUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lUsuario.setBounds(285, 205, 303, 28);

		JTextField tUsuario = new JTextField();
		internalCadastraAcesso.add(tUsuario);
		tUsuario.setBounds(285, 230, 303, 28);

		JLabel lSenha = new JLabel("Senha");
		internalCadastraAcesso.add(lSenha);
		lSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSenha.setBounds(285, 270, 303, 28);

		JTextField tSenha = new JTextField();
		internalCadastraAcesso.add(tSenha);
		tSenha.setBounds(285, 295, 303, 28);

		JButton bSalvar = new JButton("Salvar");
		internalCadastraAcesso.add(bSalvar);
		bSalvar.setBounds(285, 345, 147, 39);

		JButton bCancelar = new JButton("Cancelar");
		internalCadastraAcesso.add(bCancelar);
		bCancelar.setBounds(440, 345, 147, 39);

	}

	@SuppressWarnings("serial")
	public static void telaVisualizaAcesso() {

		JInternalFrame internalVizualizaAcesso = new JInternalFrame("Acessos");
		internalVizualizaAcesso.setClosable(true);
		internalVizualizaAcesso.setLayout(null);
		desktopPane.add(internalVizualizaAcesso);
		internalVizualizaAcesso.setVisible(true);
		internalVizualizaAcesso.setBounds(100, 51, 871, 619);

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

		JButton bNovoAcesso = new JButton("Novo");
		internalVizualizaAcesso.add(bNovoAcesso);
		bNovoAcesso.setBounds(30, 50, 147, 39);

		JButton bEditarAcesso = new JButton("Editar");
		internalVizualizaAcesso.add(bEditarAcesso);
		bEditarAcesso.setBounds(180, 50, 147, 39);

		JButton bRemoverAcesso = new JButton("Remover");
		internalVizualizaAcesso.add(bRemoverAcesso);
		bRemoverAcesso.setBounds(330, 50, 147, 39);

		JTextField tBuscaAcesso = new JTextField();
		internalVizualizaAcesso.add(tBuscaAcesso);
		tBuscaAcesso.setBounds(593, 50, 147, 39);

		JButton bFiltraAcesso = new JButton("F");
		internalVizualizaAcesso.add(bFiltraAcesso);
		bFiltraAcesso.setBounds(743, 50, 39, 39);

		JButton bPesquisarAcesso = new JButton("P");
		internalVizualizaAcesso.add(bPesquisarAcesso);
		bPesquisarAcesso.setBounds(787, 50, 39, 39);

	}

}
