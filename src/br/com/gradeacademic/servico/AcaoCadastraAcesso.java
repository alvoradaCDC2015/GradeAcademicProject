package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
				acesso.setNivel(cNivel.getSelectedIndex());
				acesso.setStatus(cStatus.getSelectedIndex());

				boolean usuarioExiste = RepositorioAcesso.validarLoginExistente(acesso.getUsuario());

				if (!usuarioExiste) {

					boolean criou = RepositorioAcesso.salvar(acesso);

					String status = ValidarAcesso.validarStatus(acesso);
					String nivel = ValidarAcesso.validarNivelDeAcesso(acesso);

					if (criou) {

						if (VisualizaAcesso.tabela != null) {
							DefaultTableModel model = (DefaultTableModel) VisualizaAcesso.tabela.getModel();
							model.addRow(new Object[] { buscarUltimoId(), acesso.getNome(), acesso.getUsuario(),
									acesso.getSenha(), nivel, status });
						}

					} else {

						if (VisualizaAcesso.tabela != null && VisualizaAcesso.tabela.getSelectedRow() > 0) {
							VisualizaAcesso.tabela.setValueAt(acesso.getId(), VisualizaAcesso.tabela.getSelectedRow(),
									0);
							VisualizaAcesso.tabela.setValueAt(acesso.getNome(), VisualizaAcesso.tabela.getSelectedRow(),
									1);
							VisualizaAcesso.tabela.setValueAt(acesso.getUsuario(),
									VisualizaAcesso.tabela.getSelectedRow(), 2);
							VisualizaAcesso.tabela.setValueAt(acesso.getSenha(),
									VisualizaAcesso.tabela.getSelectedRow(), 3);
							VisualizaAcesso.tabela.setValueAt(nivel, VisualizaAcesso.tabela.getSelectedRow(), 4);
							VisualizaAcesso.tabela.setValueAt(status, VisualizaAcesso.tabela.getSelectedRow(), 5);
						}

					}

					AcaoCadastraAcesso.internalCadastro.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Usuário já existente.");
				}

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
		return RepositorioAcesso.retornarUltimoId();
	}

}
