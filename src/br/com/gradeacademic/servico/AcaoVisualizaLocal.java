package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.gradeacademic.visao.CadastraCidade;
import br.com.gradeacademic.visao.CadastraEstado;
import br.com.gradeacademic.visao.CadastraPais;
import br.com.gradeacademic.visao.VisualizaLocal;

public class AcaoVisualizaLocal extends VisualizaLocal {

	public static void botaoNovoPais(JButton bNovoPais) {

		bNovoPais.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				CadastraPais.cadastrarPais();

			}
		});

	}

	public static void botaoNovoEstado(JButton bNovoEstado) {

		bNovoEstado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				CadastraEstado.cadastrarEstado();
				AcaoCadastraEstado.listarPaises();

			}
		});

	}

	public static void botaoNovaCidade(JButton bNovaCidade) {

		bNovaCidade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				CadastraCidade.cadastrarCidade();

			}
		});

	}

}
