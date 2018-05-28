import java.util.*;

public class Network {
    private String name;
    private ArrayList<Computer> computers;

    public Network(String name){
        this.computers = new ArrayList<Computer>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int deviceCount(){
        return computers.size();
    }

    public void connect(Computer computer){
        computers.add(computer);
    }

    public void disconnectAll(){
        computers.clear();
    }
}