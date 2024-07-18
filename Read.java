import java.io.File;
import java.util.*;


public class Read {
   static ArrayList <ArrayList> datas = new ArrayList<ArrayList>();
    public static void main(String[] args) {
        try {
            Scanner rf = new Scanner(new File("./pm2.5.txt"));
            while (rf.hasNext()) {
                ArrayList <Float> datas_row = new ArrayList<Float>();
                for (String i:rf.nextLine().split("\t")) {
                    float f=Float.parseFloat(i); 
                    datas_row.add(f);
                }
                datas.add(datas_row);
            }
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
        // 
        if (x-1>=0) {
            if (y-1>=0) {
                System.out.println(datas.get(x-1).get(y-1));
            }
            System.out.println(datas.get(x-1).get(y));
            if (y+1<=19) {
                System.out.println(datas.get(x-1).get(y+1));
            }
        }
        // 
        if(x+1<=19) {
            if (y-1>=0) {
                System.out.println(datas.get(x+1).get(y-1));
            }
            System.out.println(datas.get(x+1).get(y));
            if (y+1<=19) {
                System.out.println(datas.get(x+1).get(y+1));
            }
        }
        
    }
}

