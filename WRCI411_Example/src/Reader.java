import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by mrads on 2016/11/07.
 */
public class Reader {

    private String filePath;
    private ArrayList<Integer> leftMotorList;
    private ArrayList<Integer> rightMotorList;
    private ArrayList<Integer> timeList;

    public Reader(String filePath) {
        this.filePath = filePath;
        leftMotorList = new ArrayList<>();
        rightMotorList = new ArrayList<>();
        timeList = new ArrayList<>();
        readData(this.filePath);
    }

    /**
     * Method used to read in CSV file
     * Each line is then split by "."
     * Each element is then added to corresponding list
     *
     * @param filePath
     */
    private void readData(String filePath){
        String line = "";
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null){
                String[] elements = line.split(",");
                leftMotorList.add(Integer.parseInt(elements[0]));
                rightMotorList.add(Integer.parseInt(elements[1]));
                timeList.add(Integer.parseInt(elements[2]));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getLeftMotorList() {
        return leftMotorList;
    }

    public ArrayList<Integer> getRightMotorList() {
        return rightMotorList;
    }

    public ArrayList<Integer> getTimeList() {
        return timeList;
    }

}
