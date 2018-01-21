import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SaxionStation {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Application> applications = new ArrayList<>();
    //User willem = new User("willem",120.95);


    Media netflix = new Media("Netflix",9.99,"Video");

    public void run() {
        //users.add(willem);
        //willem.add_application(netflix);
        load_users("test.json");
        for (User u:users
             ) {
            System.out.println(u.toString());
        }
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
            //u.saveLibary();
        }
        try {
            String jsonString = jsonArray.toString(2);
            Files.write(Paths.get(filename),jsonString.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void load_users(String filename){
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(filename)));
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length() ; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                User u = new User(jsonObject);
                //u.toString();
                users.add(u);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
