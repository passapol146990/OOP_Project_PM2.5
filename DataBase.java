import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataBase {
    public static void main(String[] args){
        // try{
        //     Scanner readFile = new Scanner(new File("./database/data.txt"));
        //     while (readFile.hasNext()) {
        //         for(String i:readFile.nextLine().split(",")){
        //             System.out.println(i);
        //         }
        //     }
        // }catch(Exception e){System.out.println(e);}
        Pattern p = Pattern.compile("peoplemin=(.*?),");
        Matcher m = p.matcher("peoplemin=0,peoplemax=100");
        System.out.println(m.matches());
        System.out.println(p.compile("peoplemin=0,peoplemax=100"));


    }
    int getMinPeople(){
        return 0;
    }
    int getMaxPeople(){
        return 0;
    }
    void setMinPeople(int x){}
    void setMaxPeople(int x){}
}
