import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class EditProfile {

    static void password(User user , String nwPassword)  {

        // Set a new password. Rewrite a new file.

        user.setPassword(nwPassword);
//        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//
//        FileWriter filewriter = null;
//        try {
//            filewriter = new FileWriter("./src/main/resources/Users/" + user.getUsername() + ".json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        gson.toJson(user , filewriter);
//
//        try {
//            filewriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    static void fullName(User user , String nwfullName)  {

        // Do the say thing for other objects.

        user.setFullName(nwfullName);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void email(User user , String email)  {

        user.setEmail(email);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void phoneNumber(User user , String number)  {

        user.setPhoneNum(number);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void birthday(User user , String birth)  {

        user.setBirthday(birth);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void bio(User user , String bio)  {

        user.setBio(bio);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void privacyON(User user ){
        user.setPrivacy(true);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void privacyOFF(User user){
        user.setPrivacy(false);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void activityON(User user){
        user.setActivity(true);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void activityOFF(User user){
        user.setActivity(false);
        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








}
