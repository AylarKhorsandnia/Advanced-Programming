import java.io.FileNotFoundException;

public class Followings {


    static void fllwngs(User user) throws FileNotFoundException {
        for (String following : user.getFollowings()) {
            User person = Info.convert(following);
            if (person.isActivity()) {
                System.out.println(following);
            }
        }
    }

}
