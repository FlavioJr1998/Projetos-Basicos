package src;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import modelo.OS;

public class PDF {

    public PDF() {

    }

    public void gerarPDF(OS os) {
        File dest = new File("src/src/arquivos/OS_" + os.getCliente().getNome() + ".pdf");
        String str = "\n\tOrdem de Serviço";
        str += "\n\n\tDescrição: " + os.getDescricao() + "\n\tFuncionário: " + os.getFuncionario().getNome()
                + "\n\tCliente: " + os.getCliente().getNome() + "\n\tRua: " + os.getCliente().getEndereco().getRua()
                + "\tBairro: " + os.getCliente().getEndereco().getBairro() + "\tNúmero: " + os.getCliente().getEndereco().getNumero()
                + "\n\tCidade: " + os.getCliente().getEndereco().getCidade().getNome() + "\tEstado: " + os.getCliente().getEndereco().getCidade().getEstado()
                + "\tCEP: " + os.getCliente().getEndereco().getCep();

        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(str));
            document.close();
        } catch (Exception e) {
            System.out.println("DEU RUIM!");
        }
    }
}
