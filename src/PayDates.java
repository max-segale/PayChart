import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PayDates {

  ArrayList<PayDay> list = new ArrayList<PayDay>();
  Date first = null;
  Date last = null;

  PayDates(ArrayList<PayStub> stubList, int payInterval) {

    // Sort pay stubs by date
    stubList.sort((o1, o2) -> o1.date.compareTo(o2.date));

    // Get first and last pay stub date
    first = stubList.get(0).date;
    last = stubList.get(stubList.size() - 1).date;

    // Calculate how many intervals since start
    long msDiff = Math.abs(first.getTime() - last.getTime());
    long intervalCount = TimeUnit.DAYS.convert(msDiff, TimeUnit.MILLISECONDS) / payInterval;

    // Start calendar at first date
    Calendar cal = Calendar.getInstance();
    cal.setTime(first);

    // Loop through dates
    for (int i = 0; i < intervalCount + 1; i++) {

      // Get date from calendar
      Date payDate = cal.getTime();

      // Add pay day values
      list.add(new PayDay(payDate, stubList));
      
      // Iterate to next calendar date
      cal.add(Calendar.DATE, payInterval);
    }
  }
}
