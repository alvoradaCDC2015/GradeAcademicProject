package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.entidade.Professor;
import br.com.gradeacademic.repositorio.RepositorioProfessor;
import br.com.gradeacademic.visao.CadastraHorario;
import br.com.gradeacademic.visao.CadastraProfessor;

public class AcaoCadastraProfessor extends CadastraProfessor {

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Professor professor = new Professor();
				professor.setNome(tNome.getText());
				professor.setDataNascimento(tNascimento.getText());
				professor.setCpf(tCpf.getText());
				professor.setNaturalidade(tNaturalidade.getText());
				professor.setNacionalidade(tNacionalidade.getText());
				professor.setTelefoneResidencial(Long.parseLong(tTelefoneResidencial.getText()));
				professor.setCelular(Long.parseLong(tCelular.getText()));
				professor.setEmail(tEmail.getText());
				professor.setSenha(tSenha.getText());
				professor.setNivelAcesso(0);
				professor.setStatus(tSituacao.getSelectedItem().toString());
				professor.setCoordenador(tCoordenador.getSelectedItem().toString());
				professor.setAdministrador(false);

				RepositorioProfessor.salvarProfessor(professor);

			}

		});
	}

	public static void botaoCancelar(JButton bCancelar) {

		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalCadastro.dispose();
			}
		});
	}

	public static void botaoDisponibilidade(JButton bDisponibilidade) {

		bDisponibilidade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CadastraHorario.cadastraHorario();

			}
		});

	}

}
