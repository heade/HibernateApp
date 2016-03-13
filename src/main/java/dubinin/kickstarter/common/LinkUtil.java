package dubinin.kickstarter.common;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by daniel on 3/8/16.
 */
public class LinkUtil {
    public static String generateLink(HttpServletRequest req, String activationKey) throws MalformedURLException{
        String result = "";
        try{
            URL url = new URL(req.getRequestURL().toString());
            result += "http://";
            result += url.getHost() + ":";
            result += url.getPort();
        }catch (Exception e){
            e.printStackTrace();
        }
        result += "/activte/" + activationKey;
        return result;
    }
}
