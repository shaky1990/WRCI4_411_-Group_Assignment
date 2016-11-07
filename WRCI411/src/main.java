import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main {

    private static ArrayList<State> stateList;
    private static State initState;
    private static ArrayList<Integer> leftMotorList;
    private static ArrayList<Integer> rightMotorList;
    private static ArrayList<Integer> timeList;
    private static ArrayList<TimedCommand> timedCommandList;

    public static void main(String[] args) {
        //Create initial state of robot -> x,y position and the angle it faces
        initState = new State(0,0,0);

        //Initialize Reader class and pass through file to be read
        Reader reader = new Reader("C:\\Users\\mrads\\Documents\\GitHub\\WRCI4_411_-Group_Assignment\\WRCI411\\data\\example.csv");
        leftMotorList = reader.getLeftMotorList();
        rightMotorList = reader.getRightMotorList();
        timeList = reader.getTimeList();

        //Initialize Process class and pass through corresponding arraylists
        Process process = new Process(leftMotorList,rightMotorList,timeList);
        timedCommandList = process.getTimedCommandList();

        ///Initialize motion simulator
        MotionSimulator motionSimulator = new MotionSimulator();
        //Call getPath from motion simulator which takes in a initial state and a arraylist of timed commands
        //Returns a arraylist of states
        stateList = motionSimulator.getPath(initState,timedCommandList);

        //Starts visualFrame
        VisualFrame visualFrame = new VisualFrame(stateList);


    }
}
