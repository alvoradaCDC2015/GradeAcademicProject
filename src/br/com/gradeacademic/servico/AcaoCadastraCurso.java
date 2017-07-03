package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.com.gradeacademic.entidade.Curso;
import br.com.gradeacademic.entidade.Professor;
import br.com.gradeacademic.repositorio.RepositorioCurso;
import br.com.gradeacademic.repositorio.RepositorioProfessor;
import br.com.gradeacademic.visao.CadastraCurso;
import br.com.gradeacademic.visao.VisualizaCurso;

public class AcaoCadastraCurso extends CadastraCurso {


public static List<Professor> listarCoordenadores() {

		List<Professor> professores = RepositorioProfessor.listar();

		for (Professor professor : professores) {
			
			if(professor.getCoordenador() == 1){
			CadastraCurso.cCoordenadorPertencente.addItem(professor.getNome());
			}
		}

		return professores;
	}

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
				String coordenador = (String) cCoordenadorPertencente.getSelectedItem();
				Curso curso = new Curso();
				curso.setNome(tNomeCurso.getText());
				curso.setObservacao(tObservacaoCurso.getText());
				curso.setDuracao(Integer.parseInt(tDuracaoCurso.getText()));

				@SuppressWarnings("unused")
				List<Professor> cursos = RepositorioProfessor.listar();
				
				curso.setCoordenador(coordenador);

				RepositorioCurso.salvar(curso);

				AcaoCadastraCurso.internalCadastro.dispose();
				VisualizaCurso.visualizarCurso();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Preencher todos os Campos solicitados!");
				}

			}
		});

	}

	public static void botaoCancelar(JButton bCancelar) {
		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				internalCadastro.dispose();
			}
		});
	}

	public static int buscarUltimoId() {
		return RepositorioCurso.retornarUltimoId();
	}

}
