package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Horario;
import br.com.gradeacademic.visao.VisualizaHorario;

public class RepositorioHorario extends VisualizaHorario {

	public static void criar(Horario horario) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao.prepareStatement(
					"INSERT INTO pga_horario (hor_professor, hor_curso, hor_semestre, hor_dia, hor_disciplina) VALUES (?,?,?,?,?)");
			parametro.setString(1, horario.getHorario_professor());
			parametro.setString(2, horario.getHorario_curso());
			parametro.setString(3, horario.getHorario_semestre());
			parametro.setString(4, horario.getHorario_dia());
			parametro.setString(5, horario.getHorario_disciplina());

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Semestre Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	@SuppressWarnings("unchecked")
	public static void ComboSemestre() {

		String sql = "SELECT * FROM pga_semestre";
		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement(sql);
			rs = parametro.executeQuery();

			while (rs.next()) {

				cComboSemestre.addItem(rs.getString("sem_descricao"));

			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unchecked")
	public static void ComboProfessor() {

		String sql = "SELECT * FROM pga_professor";
		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement(sql);
			rs = parametro.executeQuery();

			while (rs.next()) {

				cComboProf.addItem(rs.getString("pro_nome"));

			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unchecked")
	public static void ComboCurso() {

		String sql = "SELECT * FROM pga_curso";
		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement(sql);
			rs = parametro.executeQuery();

			while (rs.next()) {

				cComboCurso.addItem(rs.getString("cur_nome"));

			}

		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unchecked")
	public static void ComboDisciplina() {

		String sql = "SELECT * FROM pga_disciplina";
		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement(sql);
			rs = parametro.executeQuery();

			while (rs.next()) {

				cComboDisciplina.addItem(rs.getString("dis_nome"));

			}

		} catch (Exception e) {

		}
	}
}
