package br.com.gradeacademic.conectar;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConectarBd {

	public static void Conectar() {
		String url = "jdbc:postgresql://localhost:5432/gradeacademic";
		String usuario = "postgres";
		String senha = "123";

		try {
			Class.forName("org.postgresql.Driver");
			DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
