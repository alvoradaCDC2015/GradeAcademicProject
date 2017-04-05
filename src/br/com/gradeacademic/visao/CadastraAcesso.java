package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.gradeacademic.servico.AcaoCadastraAcesso;

public class CadastraAcesso extends Principal {

	public static JInternalFrame internalCadastro;

	public static JTextField tID;
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

		int xBound = 100;

		tID = new JTextField();
		internalCadastro.add(tID);
		tID.setBounds(100, 75, 50, 28);
		tID.setText(String.valueOf(AcaoCadastraAcesso.buscarUltimoId() + 1));
		tID.setVisible(false);

		JLabel lNome = new JLabel("Nome*");
		internalCadastro.add(lNome);
		lNome.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNome.setBounds(xBound, 120, 303, 28);

		tNome = new JTextField();
		internalCadastro.add(tNome);
		tNome.setBounds(xBound, 145, 303, 28);

		JLabel lUsuario = new JLabel("Usuário*");
		internalCadastro.add(lUsuario);
		lUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lUsuario.setBounds(xBound, 185, 303, 28);

		tUsuario = new JTextField();
		internalCadastro.add(tUsuario);
		tUsuario.setBounds(xBound, 210, 303, 28);

		JLabel lSenha = new JLabel("Senha*");
		internalCadastro.add(lSenha);
		lSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSenha.setBounds(xBound, 250, 303, 28);

		tSenha = new JTextField();
		internalCadastro.add(tSenha);
		tSenha.setBounds(xBound, 275, 303, 28);

		JButton bSalvar = new JButton("Salvar");
		bSalvar.setBounds(xBound, 345, 147, 39);
		internalCadastro.add(bSalvar);
		AcaoCadastraAcesso.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(xBound + 150, 345, 147, 39);
		internalCadastro.add(bCancelar);
		AcaoCadastraAcesso.botaoCancelar(bCancelar);

	}

	public static void setarCampos(String id, String nome, String usuario, String senha) {

		tID.setText(id);
		tNome.setText(nome);
		tUsuario.setText(usuario);
		tSenha.setText(senha);

	}

}
