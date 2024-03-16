import java.io.FileNotFoundException;

public class Followers {


    static void fllwrs(User user) throws FileNotFoundException {
        for (String follower : user.getFollowers()) {
            User person = Info.convert(follower);
            if (person.isActivity()) {
                System.out.println(follower);
            }
        }
    }



    static void stoppedFollowing(User you) throws FileNotFoundException {
        for (String them : you.getStopF()) {
            User person = Info.convert(them);
            if (person.isActivity()) {
                System.out.println(them);
            }
        }
    }
    static void startedFollowing(User you) throws FileNotFoundException {
        for (String them : you.getStartF()) {
            User person = Info.convert(them);
            if (person.isActivity()) {
                System.out.println(them);
            }
        }
    }



}
