import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
public class control {
    public static final String filePath= "./data/";
    public static String[] load(String name){
        File file = new File(filePath+name+".txt");
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()){
                    String user = scanner.nextLine();
                    String password = scanner.nextLine();
                    String[] output = {user,password};
                    return output;
            }
        }catch(FileNotFoundException e){
            System.out.println("Not such file");
            String[] output = {null,null};
            return output;
        }
        String[] output = {null,null};
        return output;
    }
    public static void delete(String name){
        File file = new File(filePath+name+".txt");
        if(file.exists())
            file.delete();
    }
    public static void update(String name,String user,String password){
        File file = new File(filePath+name+".txt");
        if(!file.exists()) {
            {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("Already exists");
                }
            }
        }
        try(PrintWriter writer = new PrintWriter(file)){
            writer.println(user);
            writer.println(password);
        }catch(FileNotFoundException e){
            System.out.println("Not such file");
        }
    }
}
