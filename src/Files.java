import java.io.File;
import java.io.FilenameFilter;

public class Files {

  File[] list;

  public Files(String dir, String type) {

    // Get all the files in directory
    File paystubs = new File(dir);

    // Filter files by extension
    FilenameFilter filter = new FilenameFilter() {
      public boolean accept(File f, String name) {
        return name.toLowerCase().endsWith("." + type);
      }
    };

    // Create file list
    list = paystubs.listFiles(filter);
  }
}
