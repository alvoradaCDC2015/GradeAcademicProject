package br.com.gradeacademic.servico;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDF {

	public static final String DEST = ("C:/Users/aluno/Desktop/permissao/relatorio.pdf"); // TROCAR
																							// O
																							// CAMINHO

	public static void main(String[] args) throws IOException, DocumentException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new PDF().createPdf(DEST);
	}

	public void createPdf(String dest) throws IOException, DocumentException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));

		document.setPageSize(PageSize.LETTER.rotate());
		document.open(); // ABRE O DOCUMENTO

		Font f = new Font(FontFamily.TIMES_ROMAN, 20f);

		Paragraph p = new Paragraph("HORÁRIO ACADÊMICO \n \n", f);

		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);

		PdfPTable table = new PdfPTable(new float[] { 0.4f, 0.6f, 0.6f, 0.6f, 0.6f, 0.6f }); // QUANTIDADE
																								// DE
																								// COLUNAS
																								// E
																								// TAMANHO

		PdfTemplate template = writer.getDirectContent().createTemplate(1000, 80); // TAMANHO

		int a = 0; // NÃO APAGAR OS IF'S VAZIOS
		if (a == 0) {
			table.addCell("     DIA");
		}
		if (a == 0) {
			table.addCell("    HORÁRIO");
		}
		if (a == 0) {
			table.addCell(" CC-1° / CC-2°");
		}
		if (a == 0) {
			table.addCell(" CC-3° / CC-4°");
		}
		if (a == 0) {
			table.addCell(" CC-5° / CC-6°");
		}
		if (a == 0) {
			table.addCell(" CC-7° / CC-8°");
		}
		if (a == 0) {
			table.addCell("SEGUNDA");
		}
		if (a == 0) {
			table.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			table.addCell(" Estatísca - Meibi Regina");
		}
		if (a == 0) {
			table.addCell(" Análise Vetorial - Priscila Andujar");
		}
		if (a == 0) {
			table.addCell(" Computação Gráfica - Marcio Marins");
		}
		if (a == 0) {
			table.addCell(" Processamento de Imagens - André Oka");
		}
		if (a == 0) {
			table.addCell("TERÇA");
		}
		if (a == 0) {
			table.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			table.addCell(" Comunicação de Dados e Redes I - Marcelo Weihmayr");
		}
		if (a == 0) {
			table.addCell(" Estrutura de Dados I (Listas/Pilhas/Filas) - Altieres Matos");
		}
		if (a == 0) {
			table.addCell(" Eletronica basica e Digital - Daniel Mantovani");
		}
		if (a == 0) {
			table.addCell(" Lingua Brasileira de Sinais - Franciele Berloffa");
		}
		if (a == 0) {
			table.addCell("QUARTA");
		}
		if (a == 0) {
			table.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			table.addCell(" Ingles Técnico e Instrumental - ???");
		}
		if (a == 0) {
			table.addCell(" Sistemas Lineares de Automação e Controle - Daniel Mantovani");
		}
		if (a == 0) {
			table.addCell(" Pesquisa Operacional - Alexandre Locci (tronco com ADM)");
		}
		if (a == 0) {
			table.addCell(" Interface Homem e Máquina - Marcelo Weihmayr");
		}
		if (a == 0) {
			table.addCell("QUINTA");
		}
		if (a == 0) {
			table.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			table.addCell(" Arquitetura de Computadore - André Oka");
		}
		if (a == 0) {
			table.addCell(" Algoritimo e Lógica de Programação III (introdução a O.O.) - Alexandre Locci");
		}
		if (a == 0) {
			table.addCell(" Estética e Probabilidade - Angélica Sanches");
		}
		if (a == 0) {
			table.addCell(" Economia e Cenários Globalizados - Claudia Moura");
		}
		if (a == 0) {
			table.addCell("SEXTA");
		}
		if (a == 0) {
			table.addCell(" 19:15H / 22:00H");
		}
		if (a == 0) {
			table.addCell(" Algoritimo e Lógica de Programação I - Alexandre Locci");
		}
		if (a == 0) {
			table.addCell(" Engenharia de Software I - Marcelo Weihmayr");
		}
		if (a == 0) {
			table.addCell(" Linguagens Formais, Automatos e Computabilidade - André Oka");
		}
		if (a == 0) {
			table.addCell("");
		}
		if (a == 0) {
			table.addCell("SÁBADO");
		}
		if (a == 0) {
			table.addCell(" 08:10H / 09:40H");
		}
		if (a == 0) {
			table.addCell("");
		}
		if (a == 0) {
			table.addCell("");
		}
		if (a == 0) {
			table.addCell("");
		}
		if (a == 0) {
			table.addCell("");
		}
		table.addCell(Image.getInstance(template)); // CRIA OS RETANGULOS
		document.add(table);
		document.close();

	}
}