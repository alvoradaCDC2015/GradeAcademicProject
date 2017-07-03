package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import br.com.gradeacademic.entidade.Horario;
import br.com.gradeacademic.repositorio.RepositorioHorario;
import br.com.gradeacademic.visao.VisualizaHorario;

public class AcaoBuscaHorario extends VisualizaHorario {

	public static void botaoBuscar(JButton bBuscar) {

		bBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (cComboProf.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Escolha um Professor.");

				} else if (cComboCurso.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Escolha um Curso.");

				} else if (cComboSemestre.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Escolha um Semestre.");

				} else if (cComboDiaSemana.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Escolha um dia da Semana.");

				} else if (cComboDisciplina.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Escolha uma Disciplina.");

				} else {

					tResultProfessor.setText(String.valueOf(cComboProf.getSelectedItem()));
					tResultCurso.setText(String.valueOf(cComboCurso.getSelectedItem()));
					tResultSemestre.setText(String.valueOf(cComboSemestre.getSelectedItem()));
					tResultDiaDaSemana.setText(String.valueOf(cComboDiaSemana.getSelectedItem()));
					tResultDisciplina.setText(String.valueOf(cComboDisciplina.getSelectedItem()));
				}
			}
		});

	}

	public static void botaoCancelar(JButton bCancelar) {

		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				internalHorario.dispose();

			}

		});
	}

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tResultProfessor != null && tResultProfessor.getText().equals("") == true && tResultCurso != null
						&& tResultCurso.getText().equals("") == true && tResultSemestre != null
						&& tResultSemestre.getText().equals("") == true && tResultDiaDaSemana != null
						&& tResultDiaDaSemana.getText().equals("") == true && tResultDisciplina != null
						&& tResultDisciplina.getText().equals("") == true) {

					JOptionPane.showMessageDialog(null, "Preencha primeiro os dados.");

				} else {

					Horario horario = new Horario();
					horario.setHorario_professor(tResultProfessor.getText());
					horario.setHorario_curso(tResultCurso.getText());
					horario.setHorario_semestre(tResultSemestre.getText());
					horario.setHorario_dia(tResultDiaDaSemana.getText());
					horario.setHorario_disciplina(tResultDisciplina.getText());

					RepositorioHorario.criar(horario);
					VisualizaHorario.limparCampos();
			

				}

			}

		});
	}

}
