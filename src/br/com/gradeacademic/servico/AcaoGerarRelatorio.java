package br.com.gradeacademic.servico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class AcaoGerarRelatorio {

	public static String sDestino = ("relatorios/relatorio.pdf"); // TROCAR

	public static void botaoGerar(JButton bGerar) throws IOException, DocumentException {
		bGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					criarDocumento();
				} catch (IOException | DocumentException e) {
					e.printStackTrace();
				}

			}
		});
	}

	public static void criarDocumento() throws IOException, DocumentException {

		File fArquivo = new File(sDestino);
		fArquivo.getParentFile().mkdirs();
		new AcaoGerarRelatorio();

		Document dRelatorio = new Document();
		PdfWriter writer = PdfWriter.getInstance(dRelatorio, new FileOutputStream(sDestino));

		dRelatorio.setPageSize(PageSize.LETTER.rotate());
		dRelatorio.open(); // ABRE O DOCUMENTO

		Font fFonte = new Font(FontFamily.TIMES_ROMAN, 20f);

		Paragraph pTitulo = new Paragraph("HORÁRIO ACADÊMICO \n \n", fFonte);

		pTitulo.setAlignment(Element.ALIGN_CENTER);
		dRelatorio.add(pTitulo);

		PdfPTable tTabela = new PdfPTable(new float[] { 0.4f, 0.6f, 0.6f, 0.6f, 0.6f, 0.6f }); // QUANTIDADE

		PdfTemplate template = writer.getDirectContent().createTemplate(1000, 80); // TAMANHO

		int a = 0; // NÃƒO APAGAR OS IF'S VAZIOS
		if (a == 0) {
			tTabela.addCell("     DIA");
		}
		if (a == 0) {
			tTabela.addCell("    HORÁRIO");
		}
		if (a == 0) {
			tTabela.addCell(" CC-1º / CC-2º");
		}
		if (a == 0) {
			tTabela.addCell(" CC-3º / CC-4º");
		}
		if (a == 0) {
			tTabela.addCell(" CC-5º / CC-6º");
		}
		if (a == 0) {
			tTabela.addCell(" CC-7º / CC-8º");
		}
		if (a == 0) {
			tTabela.addCell("SEGUNDA");
		}
		if (a == 0) {
			tTabela.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			tTabela.addCell(" EstatÃ­stica - Meibi Regina");
		}
		if (a == 0) {
			tTabela.addCell(" AnÃ¡lise Vetorial - Priscila Andujar");
		}
		if (a == 0) {
			tTabela.addCell(" ComputaÃ§Ã£o GrÃ¡fica - Marcio Marins");
		}
		if (a == 0) {
			tTabela.addCell(" Processamento de Imagens - AndrÃ© Oka");
		}
		if (a == 0) {
			tTabela.addCell("TERÃ‡A");
		}
		if (a == 0) {
			tTabela.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			tTabela.addCell(" ComunicaÃ§Ã£o de Dados e Redes I - Marcelo Weihmayr");
		}
		if (a == 0) {
			tTabela.addCell(" Estrutura de Dados I (Listas/Pilhas/Filas) - Altieres Matos");
		}
		if (a == 0) {
			tTabela.addCell(" Eletronica basica e Digital - Daniel Mantovani");
		}
		if (a == 0) {
			tTabela.addCell(" Lingua Brasileira de Sinais - Franciele Berloffa");
		}
		if (a == 0) {
			tTabela.addCell("QUARTA");
		}
		if (a == 0) {
			tTabela.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			tTabela.addCell(" Ingles TÃ©cnico e Instrumental - ???");
		}
		if (a == 0) {
			tTabela.addCell(" Sistemas Lineares de AutomaÃ§Ã£o e Controle - Daniel Mantovani");
		}
		if (a == 0) {
			tTabela.addCell(" Pesquisa Operacional - Alexandre Locci (tronco com ADM)");
		}
		if (a == 0) {
			tTabela.addCell(" Interface Homem e MÃ¡quina - Marcelo Weihmayr");
		}
		if (a == 0) {
			tTabela.addCell("QUINTA");
		}
		if (a == 0) {
			tTabela.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			tTabela.addCell(" Arquitetura de Computadore - AndrÃ© Oka");
		}
		if (a == 0) {
			tTabela.addCell(" Algoritimo e LÃ³gica de ProgramaÃ§Ã£o III (introduÃ§Ã£o a O.O.) - Alexandre Locci");
		}
		if (a == 0) {
			tTabela.addCell(" EstÃ©tica e Probabilidade - AngÃ©lica Sanches");
		}
		if (a == 0) {
			tTabela.addCell(" Economia e CenÃ¡rios Globalizados - Claudia Moura");
		}
		if (a == 0) {
			tTabela.addCell("SEXTA");
		}
		if (a == 0) {
			tTabela.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			tTabela.addCell(" Algoritimo e LÃ³gica de ProgramaÃ§Ã£o I - Alexandre Locci");
		}
		if (a == 0) {
			tTabela.addCell(" Engenharia de Software I - Marcelo Weihmayr");
		}
		if (a == 0) {
			tTabela.addCell(" Linguagens Formais, Automatos e Computabilidade - AndrÃ© Oka");
		}
		if (a == 0) {
			tTabela.addCell("");
		}
		if (a == 0) {
			tTabela.addCell("SÃ�BADO");
		}
		if (a == 0) {
			tTabela.addCell(" 08:10H / 09:40H");
		}
		if (a == 0) {
			tTabela.addCell("");
		}
		if (a == 0) {
			tTabela.addCell("");
		}
		if (a == 0) {
			tTabela.addCell("");
		}
		if (a == 0) {
			tTabela.addCell("");
		}
		tTabela.addCell(Image.getInstance(template)); // CRIA OS RETANGULOS
		dRelatorio.add(tTabela);
		dRelatorio.close();

	}

}
