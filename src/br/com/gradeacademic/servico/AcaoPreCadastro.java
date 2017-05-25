package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.com.gradeacademic.entidade.Acesso;
import br.com.gradeacademic.repositorio.RespositorioPreCadastro;
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

	public static void botaoCadastrar(JButton bCadastrar) {

		bCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String senha = new String(tSenha.getPassword());
				String confirmarSenha = new String(tConfirmarSenha.getPassword());

				boolean senhaOk = ValidarAcesso.validarConfirmarSenha(senha, confirmarSenha);

				if (senhaOk) {

					Acesso acesso = new Acesso();
					acesso.setNome(tNome.getText());
					acesso.setUsuario(tUsuario.getText());
					acesso.setSenha(senha);
					acesso.setNivel(0);
					acesso.setStatus(0);

					RespositorioPreCadastro.salvar(acesso);

					habilitarCampos();

					tela.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Senhas não estão iguais!");
				}
			}
		});

	}

}
