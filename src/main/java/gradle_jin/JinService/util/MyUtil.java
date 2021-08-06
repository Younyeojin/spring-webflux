package gradle_jin.JinService.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
    public String now(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}

/**
 * public String now(){
 *         Date date = new Date();
 *         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 *         String s = simpleDateFormat.format(date);
 *         return s;
 *     }*/
