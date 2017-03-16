package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.gradeacademic.servico.AcaoCadastraAcesso;

public class CadastraAcesso extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tNome;
	public static JTextField tUsuario;
	public static JTextField tSenha;

	public static void cadastrarAcesso() {

		internalCadastro = new JInternalFrame("Cadastrar Acesso");
		desktopPane.add(internalCadastro);
		internalCadastro.setVisible(true);
		internalCadastro.setClosable(true);
		internalCadastro.setLayout(null);
		internalCadastro.setBounds(100, 51, 520, 528);

		int yBound = 100;

		JLabel lNome = new JLabel("Nome*");
		internalCadastro.add(lNome);
		lNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNome.setBounds(yBound, 120, 303, 28);

		tNome = new JTextField();
		internalCadastro.add(tNome);
		tNome.setBounds(yBound, 145, 303, 28);

		JLabel lUsuario = new JLabel("Usuário*");
		internalCadastro.add(lUsuario);
		lUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lUsuario.setBounds(yBound, 185, 303, 28);

		tUsuario = new JTextField();
		internalCadastro.add(tUsuario);
		tUsuario.setBounds(yBound, 210, 303, 28);

		JLabel lSenha = new JLabel("Senha*");
		internalCadastro.add(lSenha);
		lSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSenha.setBounds(yBound, 250, 303, 28);

		tSenha = new JTextField();
		internalCadastro.add(tSenha);
		tSenha.setBounds(yBound, 275, 303, 28);

		JButton bSalvar = new JButton("Salvar");
		bSalvar.setBounds(yBound, 345, 147, 39);
		internalCadastro.add(bSalvar);
		AcaoCadastraAcesso.botaoSalvar(bSalvar, tNome, tUsuario, tSenha);

		JButton bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(yBound + 150, 345, 147, 39);
		internalCadastro.add(bCancelar);
		AcaoCadastraAcesso.botaoCancelar(bCancelar);

	}

}
