import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class Profile {


    static void newTweet(User user, String st) {
        Tweet twit = new Tweet(user.getUsername(), st);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        twit.setTime1(dtf.format(now));
        user.getTwiits().add(twit);

        try {
            Save.User(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        YourProfile.nxtStep(user);
    }

    static void reTweet(User you , Tweet tweet){
        String st = tweet.getWriter() + tweet.getTheTweet() ;
        Tweet twit = new Tweet(you.getUsername(), st);
        twit.setRetweet(true);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        twit.setTime1(dtf.format(now));
        you.getTwiits().add(twit);
        try {
            Save.User(you);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    static void allYourTweets(User user) {
        List<Tweet> twitha = user.getTwiits();
        int counter = twitha.size();
        if (counter != 0) {
            twitha.sort(Comparator.reverseOrder());
            for (Tweet twit : twitha) {
                System.out.println("Tweet number " + counter + ":");
                System.out.println(twit.getTheTweet());
                System.out.println("Time:");
                System.out.println(twit.getTime1());
                System.out.println("Likes:");
                System.out.println(twit.getLike());
                System.out.println("Comments:");
                System.out.println(twit.getTheComments());
                System.out.println("**************************");
                counter--;
            }
        } else {
            System.out.println("No tweets have been written so far.");
        }
        YourProfile.nxtStep(user);
    }


}

