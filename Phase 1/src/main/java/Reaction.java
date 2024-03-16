import java.io.FileNotFoundException;
import java.io.IOException;

public class Reaction {

    static void toDO(User you, Tweet tweet, int i) throws FileNotFoundException {
        System.out.println("toDo: ");
        System.out.println("1- Like/Dislike the tweet");
        System.out.println("2- Check comments");
        System.out.println("3- Retweet it!");
        System.out.println("4- Block the user");
        System.out.println("<- Check the previous tweet again. ");
        System.out.println(">- Go to the next tweet");
        System.out.println("5- goBack");
        System.out.println("6- add a new comment");
        String st = Sc.next1();
        if (st.equals("1")) {
            try {
                like(tweet, you);
            } catch (IOException e) {
                e.printStackTrace();
            }
            toDO(you, tweet, i);
        }
        if (st.equals("2")) {
            System.out.println(tweet.getTheComments());
            System.out.println("Enter a number from 0 to " + tweet.getTheComments().size() + " to see the comments below.");
            String sti = Sc.next1();
            int x = Integer.parseInt(sti);
            if (x > tweet.getTheComments().size() - 1 || x < 0) {
                System.out.println("Invalid number");
                toDO(you, tweet, i);
            } else {
                System.out.println(tweet.getTheComments().get(x).getTheComments());
                toDO(you, tweet.getTheComments().get(x), i);
            }
        }
        if (st.equals("3")) {
            Profile.reTweet(you, tweet);
        }
        if (st.equals("4")) {
            String name = tweet.getWriter();
            User person = Info.convert(name);
            Actions.block(you, person);
            i++;
            TimeLine.show(you, i);
        }
        if (st.equals("<")) {
            i--;
            TimeLine.show(you, i);
        }
        if (st.equals(">")) {
            i++;
            TimeLine.show(you, i);
        }
        if (st.equals("5")) {
            TheMenu.start(you);
        }
        if (st.equals("6")) {
            System.out.println("Write your comment:");
            String str = Sc.nLine();
            Tweet comment = new Tweet(you.getUsername(), str);
            tweet.getTheComments().add(comment);
            User person = Info.convert(tweet.getWriter());
            System.out.println("your cm was added.");
            try {
                Save.User(person);
            } catch (IOException e) {
                e.printStackTrace();
            }
            toDO(you, tweet, i);
        }

    }


    static void like(Tweet tweet, User person) throws IOException {
        if (tweet.getLikers().contains(person.getUsername())) {
            tweet.getLikers().remove(person.getUsername());
            int x = tweet.getLike();
            x--;
            tweet.setLike(x);
            System.out.println("You disliked the tweet.");
        } else {
            tweet.getLikers().add(person.getUsername());
            int x = tweet.getLike();
            x++;
            tweet.setLike(x);
            System.out.println("You liked the tweet.");
        }
        String writer = tweet.getWriter();
        User them = Info.convert(writer);
        Save.User(them);

    }


}
