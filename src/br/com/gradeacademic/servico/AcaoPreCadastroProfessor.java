package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.com.gradeacademic.entidade.Professor;
import br.com.gradeacademic.repositorio.RepositorioPreCadastroProfessor;
import br.com.gradeacademic.visao.Login;
import br.com.gradeacademic.visao.PreCadastroProfessor;

public class AcaoPreCadastroProfessor extends PreCadastroProfessor {

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

				if (!tNome.getText().isEmpty() && !tEmail.getText().isEmpty() && !tCpf.getText().isEmpty()
						&& !senha.isEmpty()) {

					Professor professor = new Professor();
					professor.setNome(tNome.getText());
					professor.setEmail(tEmail.getText());
					professor.setCpf(tCpf.getText());
					professor.setSenha(senha);
					professor.setNivelAcesso(0);
					professor.setAdministrador(false);
					professor.setCoordenador("Não");
					professor.setStatus("Ativo");

					RepositorioPreCadastroProfessor.salvar(professor);

					habilitarCampos();
					tela.dispose();

				}

				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

			}
		});

	}

}
