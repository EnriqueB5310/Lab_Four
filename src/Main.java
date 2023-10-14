import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args) throws IOException {

        try {
            File myFile = new File("WebData.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            }
        } catch (IOException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }

        String url = null;
        try {
            Scanner link = new Scanner(System.in);
            System.out.println("Enter a link to get the info of");
            url = link.nextLine();

            if (url == null) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
        ;

        var pageLocation = URI.create(url).toURL();


        
        System.out.println("Saving data to file...");
        System.out.println(pageLocation.getProtocol());
        System.out.println(pageLocation.getHost());
        System.out.println(pageLocation.getFile());


        FileWriter myWriter = new FileWriter("WebData.txt");
        myWriter.write("Protocol: " + pageLocation.getProtocol() + "\n");
        myWriter.write("Host: " + pageLocation.getHost() + "\n");
        myWriter.write("File name: " + pageLocation.getFile() + "\n");
        myWriter.close();

    }
}