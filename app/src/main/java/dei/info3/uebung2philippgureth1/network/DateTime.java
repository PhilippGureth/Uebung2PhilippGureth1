package dei.info3.uebung2philippgureth1.network;

import com.google.gson.annotations.SerializedName;

public class DateTime {

    @SerializedName("hour")
    private String hour;

    @SerializedName("minute")
    private String minute;


    public String getHour() {return hour;}

    public void setHour(String hour) {this.hour = hour;}

    public String getMinute() {return minute;}

    public void setMinute(String minute) {this.minute = minute;}

}
