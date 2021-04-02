import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFText {

  String lines[];
  
  public PDFText(File pdfDoc) throws IOException {

    // Get text from PDF document
    PDFTextStripper stripper = new PDFTextStripper();
    String lineSep = stripper.getLineSeparator();
    PDDocument document = PDDocument.load(pdfDoc);
    String pdfText = stripper.getText(document).toString();
    document.close();
    
    // Split text into lines
    lines = pdfText.split(lineSep);
  }
}
