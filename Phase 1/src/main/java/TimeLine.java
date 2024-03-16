import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class TimeLine {

    static void roll(User you) throws IOException {
        for (String user : you.getFollowings()) {
            User person = Info.convert(user);
            for (Tweet tweet : person.getTwiits()) {
                you.getTimeline().add(tweet);
            }
        }
        you.getTimeline().sort(Comparator.reverseOrder());
        Save.User(you);
        show(you, 0);
    }

    static void show(User you, int i) throws FileNotFoundException {

        if (you.getTimeline().isEmpty()) {
            System.out.println("No tweets so far.");
            TheMenu.start(you);
        } else if (i < you.getTimeline().size() && i >= 0) {
            Tweet tweet = you.getTimeline().get(i);
            if (!tweet.isRetweet()) {
                System.out.println(tweet.getWriter() + ":");
                System.out.println(tweet.getTheTweet());
                System.out.println("Time:");
                System.out.println(tweet.getTime1());
                System.out.println(tweet.getLike() + "like(s)");
                Reaction.toDO(you, tweet, i);
            } else {
                System.out.println(tweet.getWriter() + " retweeted:");

                System.out.println(tweet.getTheTweet());
                System.out.println("Time:");
                System.out.println(tweet.getTime1());
                System.out.println(tweet.getLike() + "like(s)");
                Reaction.toDO(you, tweet, i);

            }

        } else {
            System.out.println("No more tweets.");
            TheMenu.start(you);
        }
    }


}
