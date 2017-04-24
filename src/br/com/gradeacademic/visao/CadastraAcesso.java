package br.com.gradeacademic.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	public static JComboBox<String> cNivel;
	public static JComboBox<String> cStatus;

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
		lNome.setBounds(xBound, 80, 303, 28);

		tNome = new JTextField();
		internalCadastro.add(tNome);
		tNome.setBounds(xBound, 105, 303, 28);

		JLabel lUsuario = new JLabel("Usuário*");
		internalCadastro.add(lUsuario);
		lUsuario.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lUsuario.setBounds(xBound, 145, 303, 28);

		tUsuario = new JTextField();
		internalCadastro.add(tUsuario);
		tUsuario.setBounds(xBound, 170, 303, 28);

		JLabel lSenha = new JLabel("Senha*");
		internalCadastro.add(lSenha);
		lSenha.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lSenha.setBounds(xBound, 210, 303, 28);

		tSenha = new JTextField();
		internalCadastro.add(tSenha);
		tSenha.setBounds(xBound, 235, 303, 28);
		
		JLabel lNivel = new JLabel("Nível de acesso*");
		internalCadastro.add(lNivel);
		lNivel.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lNivel.setBounds(xBound, 275, 303, 28);
		
		cNivel = new JComboBox<>();
		internalCadastro.add(cNivel);
		cNivel.setBounds(xBound, 305, 150, 28);
		cNivel.addItem("Professor");
		cNivel.addItem("Coordenador");
		cNivel.addItem("Administrador");
		
		JLabel lStatus = new JLabel("Status*");
		internalCadastro.add(lStatus);
		lStatus.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		lStatus.setBounds(xBound + 160, 275, 303, 28);
		
		cStatus = new JComboBox<>();
		internalCadastro.add(cStatus);
		cStatus.setBounds(xBound + 160, 305, 150, 28);
		cStatus.addItem("Ativo");
		cStatus.addItem("Invativo");

		JButton bSalvar = new JButton("Salvar");
		bSalvar.setBounds(xBound, 355, 147, 39);
		internalCadastro.add(bSalvar);
		AcaoCadastraAcesso.botaoSalvar(bSalvar);

		JButton bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(xBound + 150, 355, 147, 39);
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
