import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class User {
    String username;
    double balance;
    ArrayList<Game> games = new ArrayList<>();
    ArrayList<Media> media = new ArrayList<>();


    public User(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }


    public void add_application(Application app){
        if(balance >= app.getPrice()){
            if (app instanceof Game){
                games.add((Game)app);
            }else{
                media.add((Media)app);
            }
            balance -= app.price;
        }else{
            System.out.println("your to poor");
        }
    }

    public void setBalance(double balance) {
        if(balance > 0){
            this.balance = balance;
        }else{
            System.out.println("Balance can't be below 0");
        }

    }

    public void saveLibary(){
        JSONArray game = new JSONArray();
        JSONArray media = new JSONArray();
        for (Game g:games) {
            game.put(g.toJSONObject());
        }
        for (Media m: this.media
             ) {
            media.put(m.toJSONObject());
        }
        try {
            String jsonStringGames = game.toString(2);
            String jsonStringMedia = media.toString(2);
            Files.write(Paths.get(username+"_games.json"),jsonStringGames.getBytes());
            Files.write(Paths.get(username+"_media.json"),jsonStringMedia.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",username);
        jsonObject.put("ballance",balance);
        return jsonObject;
    }
    public ArrayList<Application> getApplications() {
        ArrayList<Application> applications = new ArrayList<>();
        for (Game g: games) {
            applications.add(g);
        }
        for (Media m: media
             ) {
            applications.add(m);
        }
        return applications;
    }
}
