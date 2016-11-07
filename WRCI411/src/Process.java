import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Process {
    private ArrayList<Integer> leftMotorList;
    private ArrayList<Integer> rightMotorList;
    private ArrayList<Integer> timeList;
    private ArrayList<Command> commandList;
    private ArrayList<TimedCommand> timedCommandList;

    public Process(ArrayList<Integer> leftMotorList, ArrayList<Integer> rightMotorList, ArrayList<Integer> timeList) {
        this.leftMotorList = leftMotorList;
        this.rightMotorList = rightMotorList;
        this.timeList = timeList;
        this.commandList = new ArrayList<>();
        this.timedCommandList = new ArrayList<>();
        processCommands();
        
    }
    
    private void processCommands(){
        int size = this.leftMotorList.size();
        for (int i = 0; i < size; i++) {
            Command command = new Command(leftMotorList.get(i),rightMotorList.get(i));
            commandList.add(command);
        }
        for (int i = 0; i < size; i++) {
            TimedCommand timedCommand = new TimedCommand(commandList.get(i),timeList.get(i));
            timedCommandList.add(timedCommand);
        }
    }

    public ArrayList<TimedCommand> getTimedCommandList() {
        return timedCommandList;
    }
}
