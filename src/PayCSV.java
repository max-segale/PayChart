import com.opencsv.CSVWriter;
 
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PayCSV {
  PayCSV(ArrayList<PayDay> payDayList) throws IOException {

    CSVWriter csvWriter = new CSVWriter(new FileWriter("/Users/maxwell/Documents/paystubs/pay-days.csv"));

    // Write column names
    csvWriter.writeNext(new String[]{"Date", "Amount", "Total"});

    // Set data formats
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    NumberFormat dollarFormat = NumberFormat.getCurrencyInstance();

    // Set initial dollar amount 
    Double totalPay = 0.0;

    // Loop through pay days
    for (int w = 0; w < payDayList.size(); w++) {

      PayDay payItem = payDayList.get(w);

      // Add to total dollar amount
      totalPay += payItem.amount;

      // Format data to strings
      String weekDate = dateFormat.format(payItem.date);
      String dollarAmount = dollarFormat.format(payItem.amount);
      String totalAmount = dollarFormat.format(totalPay);

      // Write CSV line
      csvWriter.writeNext(new String[]{weekDate, dollarAmount, totalAmount});
    }

    csvWriter.close();

  }
}
