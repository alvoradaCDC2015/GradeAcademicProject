package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.gradeacademic.entidade.Estado;
import br.com.gradeacademic.entidade.Pais;
import br.com.gradeacademic.repositorio.RepositorioEstado;
import br.com.gradeacademic.repositorio.RepositorioPais;
import br.com.gradeacademic.visao.CadastraEstado;

public class AcaoCadastraEstado extends CadastraEstado {

	public static void botaoSalvar(JButton bSalvar) {
		bSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (tNomeEstado.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nome do estado é obrigatório!");

				} else if (cPaisPertencente == null) {
					JOptionPane.showMessageDialog(null, "Selecione um país!");

				} else {

					Estado estado = new Estado();
					estado.setNome(tNomeEstado.getText());

					List<Pais> paises = listarPaises();
					estado.setPais(paises.get(cPaisPertencente.getSelectedIndex()).getId());

					RepositorioEstado.salvar(estado);

					AcaoCadastraEstado.internalCadastro.dispose();
					// VisualizaEstado.visualizaEstado();

				}

			}
		});

	}

	public static List<Pais> listarPaises() {

		List<Pais> paises = RepositorioPais.listar();// vetor com os valores de
														// exemplo que quero
														// adicionar

		for (Pais pais : paises) {
			CadastraEstado.cPaisPertencente.addItem(pais.getNome());
		}

		return paises;
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
		return RepositorioPais.retornarUltimoId();
	}

}
