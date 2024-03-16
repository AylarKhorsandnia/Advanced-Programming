import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Save {


    static void User(User user) throws IOException {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        FileWriter filewriter = new FileWriter("./src/main/resources/Users/" + user.getUsername() + ".json");
        gson.toJson(user , filewriter);

        filewriter.flush();

    }


    static void checkEmail(User person ,String Email) throws FileNotFoundException {
        File[] f = new File("./src/main/resources/Users/").listFiles();
        for (File file: f) {
            Gson gson = new Gson();
            User user = gson.fromJson(new FileReader(file) , User.class);
            if(user.getEmail().equals(Email)){
                System.out.println("This email already exists. Try another one.");
                SignUp.email(person);
                break;
            }
        }
    }
    static void checkPhone(User person ,String phone) throws FileNotFoundException {
        File[] f = new File("./src/main/resources/Users/").listFiles();
        for (File file: f) {
            Gson gson = new Gson();
            User user = gson.fromJson(new FileReader(file) , User.class);
            if(user.getPhoneNum().equals(phone) && !user.getPhoneNum().equals("-")){
                System.out.println("This phone number already exists. Try another one.");
                SignUp.phonenum(person);
                break;
            }
        }
    }



}
