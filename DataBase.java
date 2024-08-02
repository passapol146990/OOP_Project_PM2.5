import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataBase {
    private int peoplemin=5000;
    private int peoplemax=5000;
    DataBase(){
        try{
            Scanner readFile = new Scanner(new File("./database/data.txt"));
            while (readFile.hasNext()) {
                String dataString = readFile.nextLine();
                Pattern p = Pattern.compile("peoplemin=(\\d+),peoplemax=(\\d+)");
                Matcher matcher = p.matcher(dataString);
                if (matcher.find()) {
                    this.peoplemin = Integer.parseInt(matcher.group(1));
                    this.peoplemax = Integer.parseInt(matcher.group(2));
                }
            }
        }catch(Exception e){System.out.println(e);}
    }
    public static void main(String[] args){
        DataBase data = new DataBase();
        System.out.println(data.getMaxPeople()+"\n"+data.getMinPeople());
    }
    int getMinPeople(){
        return this.peoplemin;
    }
    int getMaxPeople(){
        return this.peoplemax;
    }
    void setMinPeople(int x){
        this.peoplemin = x;
    }
    void setMaxPeople(int x){
        this.peoplemax = x;
    }
}
