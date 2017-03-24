package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.repositorio.RepositorioAcesso;
import br.com.gradeacademic.visao.CadastraAcesso;
import br.com.gradeacademic.visao.VisualizaAcesso;

public class AcaoCadastraAcesso extends CadastraAcesso {

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Acesso acesso = new Acesso();
				acesso.setNome(tNome.getText());
				acesso.setUsuario(tUsuario.getText());
				acesso.setSenha(tSenha.getText());

				RepositorioAcesso.salvar(acesso);

				if (VisualizaAcesso.tabela != null) {
					DefaultTableModel model = (DefaultTableModel) VisualizaAcesso.tabela
							.getModel();
					model.addRow(new Object[] { acesso.getId() + 1,
							acesso.getNome(), acesso.getUsuario(),
							acesso.getSenha() });
				}

				AcaoCadastraAcesso.internalCadastro.dispose();

			}
		});

	}

	public static void botaoCancelar(JButton bCancelar) {

		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				internalCadastro.dispose();

			}

		});
	}

	public static int buscarUltimoId() {

		return RepositorioAcesso.ultimoId;
	}

}
