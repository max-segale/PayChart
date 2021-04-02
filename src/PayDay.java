import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PayDay {

  Date date = null;
  Double amount = 0.0;
  HashMap<String, Double> sources = new HashMap<String, Double>();
  
  public PayDay(Date payDate, ArrayList<PayStub> stubList) {

    date = payDate;

    // Find pay stubs on this date
    for (int s = 0; s < stubList.size(); s++) {

      PayStub stubItem = stubList.get(s);

      if (stubItem.date.compareTo(payDate) == 0) {

        // Add payment amounts
        amount += stubItem.amount;

        // Add company names
        sources.put(stubItem.source, stubItem.amount);

      }
    }
  }
}
