import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Read {

    public static void main(String[] args) {
        ArrayList <Float> datas = new ArrayList<Float>();
        try {
            Scanner rf = new Scanner(new File("./pm2.5.txt"));
            while (rf.hasNext()) {
                // System.out.println(rf.nextLine().split("\t")[0]);
                for (String i:rf.nextLine().split("\t")) {
                    System.out.println(i);
                    float f=Float.parseFloat(i); 
                    datas.add(f);
                }
            }
                System.out.println(datas);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
