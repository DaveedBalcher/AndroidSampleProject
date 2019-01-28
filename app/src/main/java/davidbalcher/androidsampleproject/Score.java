package davidbalcher.androidsampleproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Score {


    String name;
    String value;
    Date date;
    private String gender;

    public Score(String name, int value, long timestamp, String gender) {
        this.name = name;
        this.value = String.valueOf(value) + "%";

        this.date  = new java.util.Date(timestamp);

        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("E, d MMM yyyy hh:mm:ss", Locale.US);
        return sdf.format(date);
    }

    public Date getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }

}
