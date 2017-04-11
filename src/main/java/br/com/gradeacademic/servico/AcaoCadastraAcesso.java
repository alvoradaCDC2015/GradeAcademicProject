package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.repositorio.RepositorioAcesso;
import br.com.gradeacademic.visao.CadastraAcesso;

public class AcaoCadastraAcesso extends CadastraAcesso {

	public static void botaoSalvar(JButton bSalvar) {

		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Acesso acesso = new Acesso();
				acesso.setNome(tNome.getText());
				acesso.setUsuario(tUsuario.getText());
				acesso.setSenha(tSenha.getText());

				RepositorioAcesso.salvar(acesso);

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

	public static int buscarUltimoId() {

		return RepositorioAcesso.ultimoId;
	}

}
