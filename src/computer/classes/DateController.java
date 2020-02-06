package computer.classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateController {

    private Date oday = new Date();

    public DateController() {

    }

    public String getTimes(){
        String patternTimes = "hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(patternTimes);
        return sdf.format(oday);
    }
    public String getTimesEn(){
        String patternTimes = "hh:mm:ss a";
        SimpleDateFormat sdf = new SimpleDateFormat(patternTimes);
        return sdf.format(oday);
    }

    public String getShortDate(){
        String patternShortDate = "yyyy/dd/MM";
        SimpleDateFormat sdf = new SimpleDateFormat(patternShortDate);
        return sdf.format(oday);
    }

    public String getShortDateTimes(){
        String patternShortDateTimes = "yyyy/MM/dd hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(patternShortDateTimes);
        return sdf.format(oday);
    }

    public String getFullDateHour(){
        String patternFullDate = "EEEE, dd MMMM yyyy hh:mm:ss a";
        SimpleDateFormat sdf = new SimpleDateFormat(patternFullDate, new Locale("EN", "en"));
        return sdf.format(oday);
    }
    public String getFullDate(){
        String patternFullDate = "EEEE, dd MMMM yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(patternFullDate, new Locale("EN", "en"));
        return sdf.format(oday);
    }
}
