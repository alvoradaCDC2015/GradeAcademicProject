package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.gradeacademic.servico.AcaoTelaCadastraAcesso;

public class TelaCadastraAcesso extends TelaPrincipal {

	public static JInternalFrame internalCadastraAcesso;

	public static JTextField tNome;
	public static JTextField tUsuario;
	public static JTextField tSenha;

	public static void cadastrarAcesso() {

		internalCadastraAcesso = new JInternalFrame("Cadastrar Acesso");
		desktopPane.add(internalCadastraAcesso);
		internalCadastraAcesso.setVisible(true);
		internalCadastraAcesso.setClosable(true);
		internalCadastraAcesso.setLayout(null);
		internalCadastraAcesso.setBounds(100, 51, 520, 528);

		int yBound = 100;

		JLabel lNome = new JLabel("Nome*");
		internalCadastraAcesso.add(lNome);
		lNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNome.setBounds(yBound, 120, 303, 28);

		tNome = new JTextField();
		internalCadastraAcesso.add(tNome);
		tNome.setBounds(yBound, 145, 303, 28);

		JLabel lUsuario = new JLabel("Usuário*");
		internalCadastraAcesso.add(lUsuario);
		lUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lUsuario.setBounds(yBound, 185, 303, 28);

		tUsuario = new JTextField();
		internalCadastraAcesso.add(tUsuario);
		tUsuario.setBounds(yBound, 210, 303, 28);

		JLabel lSenha = new JLabel("Senha*");
		internalCadastraAcesso.add(lSenha);
		lSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSenha.setBounds(yBound, 250, 303, 28);

		tSenha = new JTextField();
		internalCadastraAcesso.add(tSenha);
		tSenha.setBounds(yBound, 275, 303, 28);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(yBound, 345, 147, 39);
		internalCadastraAcesso.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(yBound + 150, 345, 147, 39);
		internalCadastraAcesso.add(btnCancelar);
		AcaoTelaCadastraAcesso.botaoCancelar(btnCancelar);

	}

}
