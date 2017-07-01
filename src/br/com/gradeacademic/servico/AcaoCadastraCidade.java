package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.entidade.Cidade;
import br.com.gradeacademic.entidade.Local;
import br.com.gradeacademic.repositorio.RepositorioAcesso;
import br.com.gradeacademic.repositorio.RepositorioCidade;
import br.com.gradeacademic.visao.CadastraCidade;
import br.com.gradeacademic.visao.VisualizaAcesso;
import br.com.gradeacademic.visao.VisualizaLocal;
import br.com.gradeacademic.repositorio.RepositorioCidade;
import br.com.gradeacademic.repositorio.RepositorioEstado;


public class AcaoCadastraCidade extends CadastraCidade {

	public static void botaoSalvar(JButton bSalvar) {
		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Cidade cidade = new Cidade();
				cidade.setNome(tNomeCidade.getText());
				

				boolean criou = RepositorioCidade.salvar(cidade);

				
				if (criou) {
					Connection conexao = ConectarBd.conectar();
					PreparedStatement parametro = null;
					ResultSet rs = null;

					parametro = conexao.prepareStatement("SELECT c.cid_id , c.cid_nome , e.est_nome,  p.pai_nome FROM pga_cidade c INNER JOIN pga_estado e "
							+ "ON e.est_id = c.cid_estado INNER JOIN pga_pais p ON p.pai_id = e.est_pais");
					
					if (VisualizaLocal.tabela != null) {
						DefaultTableModel model = (DefaultTableModel) VisualizaLocal.tabela.getModel();
						model.addRow(new Object[] {Cidade.getId(),Local.getNome_estado(),Local.getNome_pais()});
					}

				} else {

					if (VisualizaLocal.tabela != null && VisualizaLocal.tabela.getSelectedRow() > 0) {
						VisualizaLocal.tabela.setValueAt(Local.getNome_cidade(), VisualizaLocal.tabela.getSelectedRow(), 0);
						VisualizaLocal.tabela.setValueAt( RepositorioCidade.listar().get(0).getNome_cidade(), VisualizaLocal.tabela.getSelectedRow(), 1);
						
					}

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

}
