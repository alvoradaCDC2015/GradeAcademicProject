package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.repositorio.RepositorioAcesso;
import br.com.gradeacademic.visao.Login;
import br.com.gradeacademic.visao.PreCadastro;

public class AcaoPreCadastro extends PreCadastro {

	private static void habilitarCampos() {
		Login.tCampoUsuario.setEnabled(true);
		Login.tCampoSenha.setEnabled(true);
		Login.bAcessar.setEnabled(true);
		Login.bSair.setEnabled(true);
		Login.bCadastrar.setEnabled(true);
	}

	public static void botaoVoltar(JButton bvoltar) {
		bvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				habilitarCampos();

				tela.dispose();

			}
		});
	}

	public static void fecharFrame() {

		tela.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				habilitarCampos();

			}

		});

	}

	public static void botaoConfirmar(JButton bConfirmar) {

		bConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Acesso acesso = new Acesso();
				acesso.setNome(tNome.getText());
				acesso.setUsuario(tUsuario.getText());
				acesso.setSenha(tSenha.getPassword().toString());

				RepositorioAcesso.salvar(acesso);

				habilitarCampos();

				tela.dispose();

			}
		});

	}

}
