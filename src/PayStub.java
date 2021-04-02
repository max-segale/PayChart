import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayStub {
  
  Date date = null;
  Double amount = 0.0;
  String source = "";

  public PayStub(String newDate, String newAmnt, String newSrc) throws ParseException {

    // Convert string to date
    date = new SimpleDateFormat("dd-MMM-yyyy").parse(newDate);
    
    // Convert string to dollar amount
    amount = Double.parseDouble(newAmnt);

    // Correct pay source value
    switch (source) {
      case "Cure": source = "FCBCure";
        break;
      default: source = newSrc;
        break;
    }
  }
}
