import java.io.File;
import java.util.Scanner;

class WorkFile {
    private String enterFile;
    public void listFile(final File folder) {
        for(final File fileEnter : folder.listFiles()) {
            if(fileEnter.isDirectory()) {
                listFile(fileEnter);
            }
            else {
                System.out.println(fileEnter.getName());
            }
        }
    }
    public void listFile(String name) {
        final File folder =  new File(name);
        for(final File fileEnter : folder.listFiles()) {
            if(fileEnter.isDirectory()) {
                listFile(fileEnter);
            }
            else {
                System.out.println(fileEnter.getName());
            }
        }
    }
    public void listFile() {
        System.out.println("Enter path: ");
        Scanner input = new Scanner(System.in);
        enterFile = input.nextLine();
        final File folder =  new File(enterFile);
        for(final File fileEnter : folder.listFiles()) {
            if(fileEnter.isDirectory()) {
                listFile(fileEnter);
            }
            else {
                System.out.println(fileEnter.getName());
            }
        }
    }
}

public class FileManager {
    public static void main(String[] args) {
        System.out.println("Hello World");
//        WorkFile wf = new WorkFile();
//        //Fist exmple
//        final File folder = new File("/Users/lado/Documents");
//        wf.listFile(folder);
//
//        //Second example
//        wf.listFile("/Users/lado/Documents");
//
//        //Third example
//        wf.listFile();
        MyFileManager mfm = new MyFileManager();
        mfm.Manger();
    }
}
