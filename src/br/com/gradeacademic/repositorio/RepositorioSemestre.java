package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Semestre;
import br.com.gradeacademic.visao.CadastraSemestre;
//import br.com.gradeacademic.visao.VisualizaSemestre;


public class RepositorioSemestre {

	public static void salvar(Semestre semestre) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		ResultSet rs = null;

		try {
			
			
			parametro = conexao.prepareStatement("SELECT * FROM semestre WHERE id = ?");
			parametro.setInt(1, Integer.parseInt(CadastraSemestre.tID.getText()));
			rs = parametro.executeQuery();

			if (!rs.next()) {
				semestre.setId(retornarUltimoId());
				criar(semestre);

			//	if (VisualizaSemestre.tabela != null) {
		//			DefaultTableModel model = (DefaultTableModel) VisualizaSemestre.tabela.getModel();
		//			model.addRow(
		//					new Object[] { semestre.getId() + 1, semestre.getDescricao(), semestre.getObservacao() });
		//		}
		//		

			} else {
				semestre.setId(Integer.parseInt(CadastraSemestre.tID.getText()));
				atualizar(semestre);

			//	if (visualizaSemestre.tabela != null) {
			//		visualizaSemestre.tabela.setValueAt(semestre.getId() + 1, visualizarSemestre.tabela.getSelectedRow(), 0);
			//		visualizarSemestre.tabela.setValueAt(semestre.getDescricao(), visualizarSemestre.tabela.getSelectedRow(),
			//				1);
			//		visualizarSemestre.tabela.setValueAt(semestre.getObservacao(), visualizarSemestre.tabela.getSelectedRow(),
			//				2);
			//	}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}

	private static void criar(Semestre semestre) {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement("INSERT INTO acesso (Descricao, O) VALUES (?,?)");
			parametro.setString(1, semestre.getDescricao());
			parametro.setString(2, semestre.getObservacao());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Acesso " + retornarUltimoId() + " Criado!");
			//int ultimoId = retornarUltimoId();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

	}
		
	

	private static void atualizar(Semestre semestre) {


	}

	public static int retornarUltimoId() {

		Connection conexao = ConectarBd.conectar();

		PreparedStatement parametro = null;

		int id = 0;

		try {

			parametro = conexao.prepareStatement("SELECT MAX(id) FROM semestre");
			ResultSet rs = parametro.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage() + " - ao retornar ultimo ID.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return id;

	}
}
