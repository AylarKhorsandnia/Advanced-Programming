import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TheMenu {

    static void start(User user) throws FileNotFoundException {
        System.out.println("Enter the num");
        System.out.println("Do you want to check your...");
        System.out.println("1- profile");
        System.out.println("2- timeline");
        System.out.println("3- explorer");
        System.out.println("4- messages");
        System.out.println("5- or log out?");

        String answer = Sc.next1();

        if (answer.equals("1")) {
            YourProfile.start(user);
        } else if (answer.equals("2")) {
            if (user.isActivity()) {
                try {
                    TimeLine.roll(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Your account is not active. First activate your page");
                start(user);
            }

        } else if (answer.equals("3")) {
            if (user.isActivity()) {
                System.out.println("1- search");
                System.out.println("2- explore");
                String javab = Sc.next1();
                if (javab.equals("goBack")) {
                    start(user);
                }
                if (javab.equals("1")) {
                    System.out.println("Enter the username");
                    String username = Sc.next1();
                    User person = Info.convert(username);
                    if (person != null) {
                        Explorer.search(user, person);
                    } else {
                        System.out.println("This username does not exist.");
                        start(user);
                    }
                }
                if (javab.equals("2")) {
                    System.out.println("ERROR...");
                    start(user);
                }

            } else {
                System.out.println("Your account is not active. First activate your page");
                start(user);
            }


        } else if (answer.equals("4")) {
            System.out.println("ERROR...");
            start(user);

        } else if (answer.equals("5")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            user.setLastOnline(dtf.format(now));
            try {
                Save.User(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
            FirstStep.start1();
        } else {
            System.out.println("Answer correctly!");
            start(user);
        }

    }


}
