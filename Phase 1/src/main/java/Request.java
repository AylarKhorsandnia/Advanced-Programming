import java.io.FileNotFoundException;
import java.io.IOException;

public class Request {
    static void requests(User you) throws FileNotFoundException {
        System.out.println("They requested to follow you");
        System.out.println(" ");
        for (String person : you.getRequests()) {
            User them = Info.convert(person);
            if (them.isActivity()) {
                System.out.println(person + ": 1)Accept  2)Deny and let them know   3)Deny without telling them ");
                String st = Sc.next1();
                if (st.equals("1")) {
                    you.getStartF().add(them.getUsername());
                    try {
                        accept(you, Info.convert(person));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if ((st.equals("2"))) {
                    deny1(you, Info.convert(person));
                }
                if(st.equals("3")){
                    deny2(you , Info.convert(person));
                }
            }
        }
        YourProfile.start(you);
    }


    static void accept(User you, User person) {
        you.getFollowers().add(person.getUsername());
        you.getRequests().remove(person.getUsername());
        try {
            Save.User(you);
        } catch (IOException e) {
            e.printStackTrace();
        }

        person.getFollowings().add(you.getUsername());
        person.getAcceptedRequests().add(you.getUsername());
        try {
            Save.User(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deny1(User you, User person) {
        you.getRequests().remove(person);
        try {
            Save.User(you);
        } catch (IOException e) {
            e.printStackTrace();
        }
        person.getDeniedRequests().add(you.getUsername());
        try {
            Save.User(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void deny2(User you, User person) {
        you.getRequests().remove(person);
        try {
            Save.User(you);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    static void acceptedRequests(User you) throws FileNotFoundException {
        System.out.println("They accepted your requests:");

        for (String them : you.getAcceptedRequests()) {
            User person = Info.convert(them);
            if (person.isActivity()) {
                System.out.println(them);
            }
        }

    }

    static void deniedRequests(User you) throws FileNotFoundException {
        System.out.println("They denied your requests:");

        for (String them : you.getDeniedRequests()) {
            User person = Info.convert(them);
            if (person.isActivity()) {
                System.out.println(them);
            }
        }

    }


}
