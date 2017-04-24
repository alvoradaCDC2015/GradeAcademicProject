package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import br.com.gradeacademic.visao.Login;
import br.com.gradeacademic.visao.PreCadastro;

public class AcaoPreCadastro extends PreCadastro {

	public static void botaoVoltar(JButton bvoltar) {
		bvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Login.tCampoUsuario.setEnabled(true);
				Login.tCampoSenha.setEnabled(true);
				Login.bAcessar.setEnabled(true);
				Login.bSair.setEnabled(true);
				Login.bCadastrar.setEnabled(true);

				tela.dispose();

			}
		});
	}

	public static void fecharFrame() {

		tela.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				Login.tCampoUsuario.setEnabled(true);
				Login.tCampoSenha.setEnabled(true);
				Login.bAcessar.setEnabled(true);
				Login.bSair.setEnabled(true);
				Login.bCadastrar.setEnabled(true);

			}
		});

	}

}
