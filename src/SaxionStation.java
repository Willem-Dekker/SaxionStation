import org.json.JSONArray;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SaxionStation {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Application> applications = new ArrayList<>();
    User willem = new User("willem",120.95);


    Media netflix = new Media("Netflix",9.99,"Video");

    public void run() {
        users.add(willem);
        willem.add_application(netflix);
        save_users("test.json");
    }


    public static void main(String[] args) {
        // write your code here
        new SaxionStation().run();
    }

    public void addBallToUser(String user,double bal){
        for (User u:users) {
            if (u.username.equals(user)){
                u.setBalance(u.balance + bal);
            }
        }
    }

    public void save_users(String filename){
        JSONArray jsonArray = new JSONArray();
        for (User u: users) {
            jsonArray.put(u.toJSONObject());
            u.saveLibary();
        }
        try {
            String jsonString = jsonArray.toString(2);
            Files.write(Paths.get(filename),jsonString.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
