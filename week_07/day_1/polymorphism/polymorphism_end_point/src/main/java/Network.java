import java.util.*;

public class Network {
    private String name;
    private ArrayList<INetworkable> devices;


    public Network(String name){

        this.devices = new ArrayList<>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int deviceCount(){
        return devices.size();
    }


    public void connect(INetworkable device){
        devices.add(device);
    }


    public void disconnectAll(){
        devices.clear();
    }
}