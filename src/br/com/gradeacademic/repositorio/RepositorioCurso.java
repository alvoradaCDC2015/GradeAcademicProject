package br.com.gradeacademic.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gradeacademic.conectar.ConectarBd;
import br.com.gradeacademic.entidade.Curso;
import br.com.gradeacademic.visao.CadastraCurso;



public class RepositorioCurso {


		
	public static boolean salvar(Curso curso) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet rs = null;

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_CURSO WHERE cur_id = ?");
			parametro.setInt(1, Integer.parseInt(CadastraCurso.tIDCurso.getText()));
			rs = parametro.executeQuery();

			if (!rs.next()) {

				curso.setId(retornarUltimoId());
				criar(curso);
				return true;

			} else {

				curso.setId(Integer.parseInt(CadastraCurso.tIDCurso.getText()));
				atualizar(curso);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao salvar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return false;
	}

	public static void criar(Curso curso) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao
					.prepareStatement("INSERT INTO PGA_CURSO (cur_nome, cur_observacao, cur_duracao_anos, cur_coordenador, cur_status) VALUES (?, ?, ?, ?, ?)");
			parametro.setString(1, curso.getNome());
			parametro.setString(2, curso.getObservacao());
			parametro.setInt(3, curso.getDuracao());
			parametro.setString(4, curso.getCoordenador());
			parametro.setInt(5, 1);
			

			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Curso " + retornarUltimoId() + " Salvo!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e + " - ao criar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static void atualizar(Curso curso) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;

		try {

			parametro = conexao
					.prepareStatement("UPDATE PGA_CURSO SET cur_nome = ?, cur_observacao = ?, cur_duracao_anos = ?, cur_coordenador = ? WHERE cur_id= ?");
			parametro.setString(1, curso.getNome());
			parametro.setString(2, curso.getObservacao());
			parametro.setInt(3, curso.getDuracao());
			parametro.setString(4, curso.getCoordenador());
			parametro.setInt(5, curso.getId());
			parametro.executeUpdate();

			JOptionPane.showMessageDialog(null, "Curso " + curso.getId() + " Atualizado!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao atualizar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static List<Curso> listar() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		ResultSet resultCurso = null;
		List<Curso> cursos = new ArrayList<>();

		try {

			parametro = conexao.prepareStatement("SELECT * FROM PGA_CURSO ORDER BY cur_id");
			resultCurso = parametro.executeQuery();
			
			
			
			while (resultCurso.next()) {

				Curso curso = new Curso();
				curso.setId(resultCurso.getInt("cur_id"));
				curso.setNome(resultCurso.getString("cur_nome"));
				curso.setObservacao(resultCurso.getString("cur_observacao"));
				curso.setCoordenador(resultCurso.getString("cur_coordenador"));
				curso.setDuracao(resultCurso.getInt("cur_duracao_anos"));
				curso.setStatus(Integer.parseInt(resultCurso.getString("cur_status")));
				
				cursos.add(curso);

			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao listar.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return cursos;
	}

	public static void inativar(int id) {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int statusInativo = 0;

		try {

			parametro = conexao.prepareStatement("UPDATE PGA_CURSO SET cur_status = ? WHERE cur_id = ?");
			parametro.setInt(1, statusInativo);
			parametro.setInt(2, id);
			parametro.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao remover Curso.");
		} finally {
			ConectarBd.desconectar(conexao);
		}
	}

	public static int retornarUltimoId() {

		Connection conexao = ConectarBd.conectar();
		PreparedStatement parametro = null;
		int id = 0;

		try {

			parametro = conexao.prepareStatement("SELECT MAX(cur_id) FROM PGA_CURSO");
			ResultSet rs = parametro.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + " - ao retornar ultimo ID.");
		} finally {
			ConectarBd.desconectar(conexao);
		}

		return id;
	}

}
