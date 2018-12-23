package Project.application.function;

public class Holiday {

    String date;
    String holiday;

    public Holiday(String date, String holiday){
        this.date = date;
        this.holiday = holiday;
    }

    public String getDate(){ return date;}
    public String getHoliday(){ return holiday;}
}
