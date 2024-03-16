import java.io.FileNotFoundException;

public class BlackList {


    static void bl(User user) throws FileNotFoundException {
        for (String blacklist : user.getBlackList()) {
            User person = Info.convert(blacklist);
            if (person.isActivity()) {
                System.out.println(blacklist);
            }
        }
    }

}


// unblock