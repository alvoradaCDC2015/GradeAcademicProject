package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraHorario;
import br.com.gradeacademic.repositorio.RepositorioProfessorDisponibilidade;

public class AcaoCadastraHorario extends CadastraHorario {
	private static String usuarioLogado = br.com.gradeacademic.visao.Login.tCampoUsuario.getText();

	public static void botaoCancelar(JButton bCancelar) {

		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalHorario.dispose();
			}
		});
	}

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(segunda.isSelected()){
					RepositorioProfessorDisponibilidade.definirDiaDisponivel("segunda", usuarioLogado);
				} else {
					RepositorioProfessorDisponibilidade.removerDiaDisponivel("segunda", usuarioLogado);
				}
				if(terca.isSelected()){
					RepositorioProfessorDisponibilidade.definirDiaDisponivel("terça", usuarioLogado);
				} else {
					RepositorioProfessorDisponibilidade.removerDiaDisponivel("terça", usuarioLogado);
				}
				if(quarta.isSelected()){
					RepositorioProfessorDisponibilidade.definirDiaDisponivel("quarta", usuarioLogado);
				} else {
					RepositorioProfessorDisponibilidade.removerDiaDisponivel("quarta", usuarioLogado);
				}
				if(quinta.isSelected()){
					RepositorioProfessorDisponibilidade.definirDiaDisponivel("quinta", usuarioLogado);
				} else {
					RepositorioProfessorDisponibilidade.removerDiaDisponivel("quinta", usuarioLogado);
				}
				if(sexta.isSelected()){
					RepositorioProfessorDisponibilidade.definirDiaDisponivel("sexta", usuarioLogado);
				} else {
					RepositorioProfessorDisponibilidade.removerDiaDisponivel("sexta", usuarioLogado);
				}
				if(sabado.isSelected()){
					RepositorioProfessorDisponibilidade.definirDiaDisponivel("sábado", usuarioLogado);
				} else {
					RepositorioProfessorDisponibilidade.removerDiaDisponivel("sábado", usuarioLogado);
				}
				internalHorario.dispose();
			}
		});
	}

}
