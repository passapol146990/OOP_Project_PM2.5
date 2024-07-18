import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Read {
   static ArrayList <ArrayList> datas = new ArrayList<ArrayList>();
    public static void main(String[] args) {
        
        try {
            Scanner rf = new Scanner(new File("./pm2.5.txt"));
            while (rf.hasNext()) {
                ArrayList <Float> datas_row = new ArrayList<Float>();
                // System.out.println(rf.nextLine().split("\t")[0]);
                for (String i:rf.nextLine().split("\t")) {
                    // System.out.println(i);
                    float f=Float.parseFloat(i); 
                    datas_row.add(f);
                }
                datas.add(datas_row);
            }
            // for (ArrayList i : datas) {
                // System.out.println(i);               
            // }
            // for (int i = 0; i < datas.size(); i++) {
                
                // for (int j = 0; j < datas.get(i).size(); j++) {
                    // System.out.printf("%d-%d\n",i,j);
                // }
            // }
            // System.out.println(datas);     
                
            } catch (Exception e) {
                System.out.println(e);
            }
        add_score(1,18);
        }
    static void add_score(int x,int y)
    {
        if (y-1>=0) {
            System.out.println(datas.get(x).get(y-1));
        }
        System.out.println(datas.get(x).get(y));
        if (y+1<=19) {
            System.out.println(datas.get(x).get(y+1));
        }

        if (x-1>=0) {
            if (y-1>=0) {
                System.out.println(datas.get(x-1).get(y-1));
            }
            System.out.println(datas.get(x-1).get(y));
            if (y+1<=19) {
                System.out.println(datas.get(x-1).get(y+1));
            }
        }

        // System.out.println(datas.get(x+1).get(y));
        // System.out.println(datas.get(x+1).get(z));
        // System.out.println(datas.get(x+1).get(c));
        
    }
}

