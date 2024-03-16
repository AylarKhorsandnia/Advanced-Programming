import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SignUp {


    static void userName() {
        System.out.println("*Pls enter your username:");
        String username = Sc.nLine();
        if (username.equals("goBack")) {
            FirstStep.start2();
        } else {
            User user = new User(username);
            File f = new File("./src/main/resources/Users/" + user.getUsername() + ".json");
            if (!f.exists()) {
                fullName(user);
            } else {
                System.out.println("This username already exists.Try another one.");
                userName();
            }
        }
    }


    static void fullName(User user) {
        System.out.println("*What's your full name?");
        String name = Sc.nLine();
        if (name.equals("goBack")) {
            userName();
        } else {
            user.setFullName(name);
            password1(user);
        }
    }


    static void password1(User user) {
        System.out.println("*Enter your password:");
        String pass1 = Sc.nLine();
        if (pass1.equals("goBack")) {
            fullName(user);
        } else {
            user.setPassword(pass1);
            password2(user);
        }
    }

    static void password2(User user) {
        System.out.println("*Confirm your password:");
        String pass2 = Sc.nLine();
        if (pass2.equals("goBack")) {
            password1(user);
        } else if (pass2.equals(user.getPassword())) {
            email(user);
        } else {
            System.out.println("The passwords don't match. pls try again.");
            password1(user);
        }

    }

    static void email(User user) {
        System.out.println("*Your email is:");
        String email = Sc.nLine();
        if (email.equals("goBack")) {
            password2(user);
        } else {
            try {
                Save.checkEmail(user, email);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            user.setEmail(email);
            phonenum(user);
        }
    }

    static void phonenum(User user) {
        System.out.println("And your phone number:");
        String phoneNum = Sc.nLine();
        if (phoneNum.equals("goBack")) {
            email(user);
        } else {
            try {
                Save.checkPhone(user, phoneNum);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            user.setPhoneNum(phoneNum);
            birth(user);
        }
    }

    static void birth(User user) {
        System.out.println("When is your birthday?");
        System.out.println("year:");
        String year = Sc.nLine();
        System.out.println("month:");
        String month = Sc.nLine();
        System.out.println("day:");
        String day = Sc.nLine();
        user.setBirthday(birthday(year, month, day));
        bio(user);

    }

    static void bio(User user) {
        System.out.println("Your bio:");
        String bio = Sc.nLine();
        if (bio.equals("goBack")) {
            birth(user);
        } else if (bio.equals("-")) {
            active(user);
        } else {
            user.setBio(bio);
            active(user);
        }
    }

    static void active(User user) {
        user.setActivity(true);
        privacy(user);
    }

    static void privacy(User user) {
        System.out.println("*privacy of account:");
        System.out.println("1- private     2- public");
        String st = Sc.next1();
        if (st.equals("1")) {
            user.setPrivacy(true);
            register(user);
        }
        if (st.equals("2")) {
            user.setPrivacy(false);
            register(user);
        }
    }

    static void register(User user) {
        try {
            user.setLastOnline("never");
            user.getAllow().add("no one");
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("You signed up successfully!");
        System.out.println("let's start");
        Login.haveAccount();
    }


    static String birthday(String year, String month, String day) {
        return year + "/" + month + "/" + day;
    }


}
