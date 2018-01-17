import org.json.JSONObject;

public class Media extends Application {
    String type;


    public Media(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("price",price);
        jsonObject.put("type",type);
        return jsonObject;

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
