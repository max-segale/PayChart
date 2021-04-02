import com.opencsv.CSVWriter;
 
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PayCSV {
  PayCSV(ArrayList<PayDay> payDayList) throws IOException {

    CSVWriter csvWriter = new CSVWriter(new FileWriter("/Users/maxwell/Documents/paystubs/pay-days.csv"));

    csvWriter.writeNext(new String[]{"Date", "Amount", "Total"});

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    Double totalPay = 0.0;

    for (int w = 0; w < payDayList.size(); w++) {

      PayDay payItem = payDayList.get(w);

      totalPay += payItem.amount;

      String weekDate = dateFormat.format(payItem.date);
      String dollarAmount = formatter.format(payItem.amount);
      String totalAmount = formatter.format(totalPay);

      // Write data line
      csvWriter.writeNext(new String[]{weekDate, dollarAmount, totalAmount});
    }

    csvWriter.close();

  }
}
