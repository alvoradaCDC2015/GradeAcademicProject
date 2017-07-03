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

				if (editando == 0) {
					salvar();
				} else if (editando == 1) {
					editar();
					AcaoVisualizaProfessor.adicionaProfessoresNaTabela();
				}

				internalCadastro.dispose();

			}

		});
	}

	public static void salvar() {

		Professor professor = new Professor();
		professor.setStatus(tSituacao.getSelectedIndex());
		professor.setNivelAcesso(0);
		professor.setAdministrador(1);
		professor.setCoordenador(tCoordenador.getSelectedIndex());

		professor.setNome(tNome.getText());
		professor.setCpf(tCpf.getText());
		professor.setNaturalidade(tNaturalidade.getText());
		professor.setNacionalidade(tNacionalidade.getText());
		professor.setDataNascimento(tNascimento.getText());
		professor.setSenha(tSenha.getText());

		professor.setTelefoneResidencial(Long.parseLong(tTelefoneResidencial.getText()));
		professor.setCelular(Long.parseLong(tCelular.getText()));
		professor.setEmail(tEmail.getText());

		professor.setEndEndereco(tEndereco.getText());
		professor.setEndNumero(Integer.parseInt(tNumero.getText()));
		professor.setEndBairro(tBairro.getText());
		professor.setEndCep(tCEP.getText());
		professor.setEndCidade(tCidade.getText());

		RepositorioProfessor.salvarProfessor(professor);

	}

	public static void editar() {

		Professor professor = new Professor();
		professor.setId(Integer.parseInt(tID.getText()));
		professor.setStatus(tSituacao.getSelectedIndex());
		professor.setNivelAcesso(0);
		professor.setAdministrador(1);
		professor.setCoordenador(tCoordenador.getSelectedIndex());

		professor.setNome(tNome.getText());
		professor.setCpf(tCpf.getText());
		professor.setNaturalidade(tNaturalidade.getText());
		professor.setNacionalidade(tNacionalidade.getText());
		professor.setDataNascimento(tNascimento.getText());
		professor.setSenha(tSenha.getText());

		professor.setTelefoneResidencial(Long.parseLong(tTelefoneResidencial.getText()));
		professor.setCelular(Long.parseLong(tCelular.getText()));
		professor.setEmail(tEmail.getText());

		professor.setEndEndereco(tEndereco.getText());
		professor.setEndNumero(Integer.parseInt(tNumero.getText()));
		professor.setEndBairro(tBairro.getText());
		professor.setEndCep(tCEP.getText());
		professor.setEndCidade(tCidade.getText());

		RepositorioProfessor.atualizar(professor);

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
