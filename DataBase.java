import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataBase {
    private float[][] datas;
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
                    this.peoplemin = (this.peoplemin <= 0)? 1 : this.peoplemin;
                    this.peoplemax = (this.peoplemax <= 0)? 1 : this.peoplemax;
                }
            }
        }catch(Exception e){
            System.out.println("Not have /database/data.txt");
            try {
                File myObj = new File("./database/data.txt");
                myObj.createNewFile();
            } catch (IOException err) {
                System.out.println("An error occurred.");
                err.printStackTrace();
            }
        }
    }
    int getRandomPeople(){
        return (int)((Math.random()*this.peoplemax) + this.peoplemin);
    }
    int getMinPeople(){
        return this.peoplemin;
    }
    int getMaxPeople(){
        return this.peoplemax;
    }
    void setMinPeople(int x){
        this.peoplemin = x;
        try{
            FileWriter fw = new FileWriter("./database/data.txt");
            fw.write("peoplemin="+this.peoplemin+",peoplemax="+this.peoplemax);
            fw.close();
        }catch(Exception e){}
    }
    void setMaxPeople(int x){
        this.peoplemax = x;
        this.peoplemin = x;
        try{
            FileWriter fw = new FileWriter("./database/data.txt");
            fw.write("peoplemin="+this.peoplemin+",peoplemax="+this.peoplemax);
            fw.close();
        }catch(Exception e){}
    }
    float[][] getDatas(){
        return this.datas;
    }
    void readFile(String path){
        try {
            Scanner readFile = new Scanner(new File(path));
            this.datas = null;
            ArrayList<float[]> tempData = new ArrayList<>();
            while (readFile.hasNext()) {
                String[] line = readFile.nextLine().split("\t");
                float[] datas_row = new float[line.length];
                for (int i = 0; i < line.length; i++) {
                    datas_row[i] = Float.parseFloat(line[i]);
                }
                tempData.add(datas_row);
            }
            this.datas = tempData.toArray(new float[tempData.size()][]);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
