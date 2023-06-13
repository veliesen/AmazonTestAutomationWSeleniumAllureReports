package InterfacePages;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class Variables {

   //Unique Product ID On Amazon
    public String ASIN="B0C46CZCFX";
    public String element="/html/body/div[1]/header/div/div[3]/div[2]/div[2]/div/div[1]/div/div/a";



    // Generates Random Text
    public String getGeneratedText() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedPassword = new String(array, Charset.forName("UTF-8"));
        return generatedPassword;
    }
    // Generates Random Number

    public int getGeneratedInteger(){

        int generatedInteger= (int) Math.floor(Math.random()*10000);

        return generatedInteger;
    }
    //Decrypt The Password
    public String getDecryptedPassword(){
        String encyrptedPassword="QXR3YTE5ODU";
        byte[] decryptedPasswordInBytes= Base64.getDecoder().decode(encyrptedPassword.getBytes(StandardCharsets.UTF_8));
        String decryptedPassword =new String((decryptedPasswordInBytes));
        return decryptedPassword;
    }
    //Decrypt The Email
    public String getDecryptedEmail(){
        String encyrptedEmail="bW1vdmVzZW4xQGdtYWlsLmNvbQ==";
        byte[] decryptedEmailInBytes=Base64.getDecoder().decode(encyrptedEmail.getBytes(StandardCharsets.UTF_8));
        String decryptedEmail =new String(decryptedEmailInBytes);
        return decryptedEmail;
    }



}
