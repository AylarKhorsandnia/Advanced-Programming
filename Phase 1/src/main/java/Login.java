import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login {

    static void haveAccount() {
        System.out.println("Pls enter your username");
        String username = Sc.nLine();
        if(username.equals("goBack")){
            FirstStep.start2();
        }
        System.out.println("Enter your password");
        String password = Sc.nLine();
        if(password.equals("goBack")){
            haveAccount();
        }

        try {
            check(username , password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    static void check(String usrnm, String pass) throws FileNotFoundException {
        File f = new File("./src/main/resources/Users/" + usrnm + ".json");
      if(f.exists()){
          Gson gson = new Gson();
          User user = gson.fromJson(new FileReader("./src/main/resources/Users/" + usrnm + ".json") , User.class);

          if(pass.equals(user.getPassword())){
              user.setLastOnline("Online");
              try {
                  Save.User(user);
              } catch (IOException e) {
                  e.printStackTrace();
              }
              System.out.println("Welcome!");
              TheMenu.start(user);
          }
          else {
              System.out.println("Incorrect pass");
              haveAccount();
          }

      }
      else{
          System.out.println("This username does not exist.");
          haveAccount();
      }

    }
}
