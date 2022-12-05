package dei.info3.uebung2philippgureth1.network;

import com.google.gson.annotations.SerializedName;

public class ServingLine {

    @SerializedName("number")
    private String number;

    @SerializedName("name")
    private String name;

    @SerializedName("direction")
    private String direction;


    public String getDirection() {return direction;}

    public void setDirection(String direction) {this.direction = direction;}

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

}
