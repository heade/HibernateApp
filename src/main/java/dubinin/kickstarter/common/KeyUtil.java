package dubinin.kickstarter.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by daniel on 3/6/16.
 */
public class KeyUtil {

    public static String generateKey(String email){
        try{
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha.digest(email.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (byte aDigest : digest){
                String hex = Integer.toHexString(0xff & aDigest);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "";
    }
}
