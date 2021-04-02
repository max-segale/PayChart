public class App {
  public static void main(String[] args) throws Exception {

    // Get paystub PDF files
    Files pdfStubs = new Files("/Users/maxwell/Documents/paystubs", "pdf");

    // Compile paystub values
    PDFRead stubData = new PDFRead(pdfStubs.list);

    // Count pay per week
    PayDates weeklyPay = new PayDates(stubData.list, 7);

    // Write data to CSV
    new PayCSV(weeklyPay.list);
  }
}
