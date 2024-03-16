import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Info {


//    static User release(User user) throws FileNotFoundException {
//        Gson gson = new Gson();
//        User person = gson.fromJson(new FileReader("./src/main/resources/Users/" + user.getUsername() + ".json"), User.class);
//        return person;
//    }

//    static boolean existOrNot(User user) {
//        File f = new File("./src/main/resources/Users/" + user.getUsername() + ".json");
//        if (f.exists()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    static User convert(String username) throws FileNotFoundException {
        File f = new File("./src/main/resources/Users/" + username + ".json");

        if (f.exists()) {
            Gson gson = new Gson();
            User person = gson.fromJson(new FileReader(f), User.class);
            return person;
        }
        else{
            return null;
        }
    }


}
