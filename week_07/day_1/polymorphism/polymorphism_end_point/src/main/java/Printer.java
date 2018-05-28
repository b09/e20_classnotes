public class Printer implements INetworkable {

    public String print(String data){
        return "printing: " + data;
    }

    public String getStatus(){
        return "Ink Low";
    }

}
