import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFRead {

  ArrayList<PayStub> list = new ArrayList<PayStub>();

  public PDFRead(File[] docList) throws IOException, ParseException {

    // Loop through each document
    for (int p = 0; p < docList.length; p++) {

      // Get document text
      PDFText docText = new PDFText(docList[p]);

      String checkDate = "";
      String checkAmnt = "";
      String checkSrc = "";

      // Loop through document lines
      for (int l = 0; l < docText.lines.length; l++) {

        // Remove excess spaces
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(docText.lines[l]);
        String lnText = matcher.replaceAll(" ").trim();

        // Find important values
        if (lnText.startsWith("Week Begin")) {
          String[] dateLn = docText.lines[l + 1].trim().split(" ");
          checkDate = dateLn[1];
          checkSrc = dateLn[2];
        } else if (lnText.startsWith("Current:")) {
          checkAmnt = lnText.split(" ")[1].replace(",", "");
        }

        // Store payment values and move to next document
        if (checkDate != "" && checkAmnt != "" && checkSrc != "") {
          list.add(new PayStub(checkDate, checkAmnt, checkSrc));
          break;
        }
      }
    }
  }
}
