import org.json.JSONObject;

public class Game extends Application {
    int number_of_players, age_restriction, rating;

    public Game(String name, double price, int number_of_players, int age_restriction, int rating) {
        super(name, price);
        this.number_of_players = number_of_players;
        this.age_restriction = age_restriction;
        this.rating = rating;
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("price",price);
        jsonObject.put("number_of_players",number_of_players);
        jsonObject.put("age_restriction",age_restriction);
        jsonObject.put("rating",rating);
        return jsonObject;

    }


    public int getNumber_of_players() {
        return number_of_players;
    }

    public void setNumber_of_players(int number_of_players) {
        this.number_of_players = number_of_players;
    }

    public int getAge_restriction() {
        return age_restriction;
    }

    public void setAge_restriction(int age_restriction) {
        this.age_restriction = age_restriction;
    }
}
