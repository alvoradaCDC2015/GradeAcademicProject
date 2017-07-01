package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;

public class RepositorioProfessorDisponibilidade {

	public static boolean[] retornarDiasDisponiveis(String cpfProfessor) {
		/*
		 * Retorna num array os dias disponiveis ativos da um professor
		 */
		
		Connection conexao = ConectarBd.conectar();	
		boolean[] diasSemana = new boolean[7];
		
		try {
			Statement st = conexao.createStatement();
			
			ResultSet rs = st.executeQuery
					("SELECT pdi_dia_semana FROM pga_professor_disponibilidade d WHERE d.pdi_id_professor = "
							+ "(SELECT pro_id FROM pga_professor WHERE pro_cpf = '" + cpfProfessor + "' ) AND d.pdi_status = 1");
			
			while (rs.next()) {
				if (rs.getString(1).contains("segunda")) {
					diasSemana[0] = true;
				}
				if (rs.getString(1).contains("terça")) {
					diasSemana[1] = true;
				}
				if (rs.getString(1).contains("quarta")) {
					diasSemana[2] = true;
				}
				if (rs.getString(1).contains("quinta")) {
					diasSemana[3] = true;
				}
				if (rs.getString(1).contains("sexta")) {
					diasSemana[4] = true;
				}
				if (rs.getString(1).contains("sábado")) {
					diasSemana[5] = true;
				}
				if (rs.getString(1).contains("domingo")) {
					diasSemana[6] = true;
				}
			}
			rs.close();
			st.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao verificar disponibilidade.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
		
		return diasSemana;
	}
	
	public static void definirDiaDisponivel(String dia, String cpfProfessor) {
		Connection conexao = ConectarBd.conectar();
		
		try {
			Statement st = conexao.createStatement();
			
			ResultSet rs = st.executeQuery
					("SELECT pdi_status FROM pga_professor_disponibilidade d WHERE d.pdi_id_professor = "
							+ "(SELECT pro_id FROM pga_professor WHERE pro_cpf = '" + cpfProfessor + "' ) "
							+ "AND d.pdi_dia_semana = '" + dia + "'");
			if(rs.next()) {
				if(rs.getString(1).contains("0")) {
					st.execute("UPDATE pga_professor_disponibilidade d SET pdi_status = '1' WHERE d.pdi_id_professor = "
							+ "(SELECT pro_id FROM pga_professor WHERE pro_cpf = '" + cpfProfessor + "' ) "
							+ "AND d.pdi_dia_semana = '" + dia + "' ");
				} 
			} else {
				st.execute("INSERT INTO pga_professor_disponibilidade "
						+ "(pdi_id_professor, pdi_dia_semana, pdi_status) "
						+ "VALUES ((SELECT pro_id FROM pga_professor WHERE pro_cpf = '" + cpfProfessor + "' ), '" + dia + "', 1)");
			}	
			rs.close();
			st.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao definir dia disponivel.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}
	
	public static void removerDiaDisponivel(String dia, String cpfProfessor) {
		Connection conexao = ConectarBd.conectar();
		
		try {
			Statement st = conexao.createStatement();
			
			st.execute("UPDATE pga_professor_disponibilidade d SET pdi_status = '0' WHERE d.pdi_id_professor = "
					+ "(SELECT pro_id FROM pga_professor WHERE pro_cpf = '" + cpfProfessor + "' ) "
					+ "AND d.pdi_dia_semana = '" + dia + "' ");			
			st.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao remover dia disponivel.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

}
