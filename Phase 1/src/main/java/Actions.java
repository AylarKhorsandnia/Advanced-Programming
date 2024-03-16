import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Actions {

    static void showProfile1(User you, User user) {
        System.out.println("FOLLOWED BY U");
        System.out.println(" name: " + user.getFullName());
        System.out.println(" user name: " + user.getUsername());
        System.out.println(" bio: " + user.getBio());
        if (user.getAllow().contains("followers") || user.getAllow().contains("everyone")) {
            System.out.println(" last seen: " + user.getLastOnline());
        } else {
            System.out.println(" last seen: recently");
        }
        showTweet(user);
        toDo(you, user);

    }


    static void showProfile2(User you, User user) {
        System.out.println("REQUESTED BY U");
        System.out.println(" name: " + user.getFullName());
        System.out.println(" user name: " + user.getUsername());
        if (user.getAllow().contains("everyone")) {
            System.out.println(" last seen: " + user.getLastOnline());
        } else {
            System.out.println(" last seen: recently");
        }
        toDo(you, user);
    }

    static void showProfile3(User you, User user) {
        System.out.println("NOT FOLLOWED BY U");
        System.out.println(" user name: " + user.getUsername());
        if (user.getAllow().contains("everyone")) {
            System.out.println(" last seen: " + user.getLastOnline());
        } else {
            System.out.println(" last seen: recently");
        }
        toDo(you, user);
    }


    static void toDo(User you, User user) {
        System.out.println(" ");
        System.out.println("To do:");
        System.out.println("1- follow/unfollow");
        System.out.println("2- block/unblock");
        System.out.println("3- goBack");
        String st = Sc.next1();
        //FOLLOWING
        if (st.equals("1")) {
            follow(you, user);
        }

        //BLOCKING
        if (st.equals("2")) {
            block(you, user);

        }

        //goBack
        if (st.equals("3")) {
            try {
                TheMenu.start(you);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


    static void follow(User you, User person) {
        //unfollow
        if (person.getFollowers().contains(you.getUsername())) {
            person.getFollowers().remove(you.getUsername());
            person.getStopF().add(you.getUsername());
            try {
                Save.User(person);
            } catch (IOException e) {
                e.printStackTrace();
            }
            you.getFollowings().remove(person.getUsername());
            try {
                Save.User(you);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("you unfollowed them.");
            toDo(you, person);
        }

        //have been blocked before
        else if (you.getBlackList().contains(person.getUsername())) {
            System.out.println("You have blocked them. You should unblock them first!");
            toDo(you, person);
        }

        //first follow request
        else if (!person.getBlackList().contains(you.getUsername())) {
            if (!person.getRequests().contains(you.getUsername())) {
                // request to follow (privacy on)
                if (person.isPrivacy()) {
                    person.getRequests().add(you.getUsername());
                    try {
                        Save.User(person);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("you requested to follow them.");
                } else {
                    // follow (privacy off)
                    person.getFollowers().add(you.getUsername());
                    person.getStartF().add(you.getUsername());
                    try {
                        Save.User(person);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    you.getFollowings().add(person.getUsername());
                    try {
                        Save.User(you);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("you start following them.");
                }
                toDo(you, person);
            }

            // have been on request list
            else {
                person.getRequests().remove(you.getUsername());
                try {
                    Save.User(person);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("you deleted your follow request.");
            toDo(you, person);

        } else if (person.getBlackList().contains(you.getUsername())) {
            System.out.println("they have blocked you. you cant follow them.");
            toDo(you, person);
        }
    }


    static void block(User you, User person) {
        //unblock
        if (you.getBlackList().contains(person.getUsername())) {
            you.getBlackList().remove(person.getUsername());
            try {
                Save.User(you);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("you unblocked them.");
        }
        //block
        else {
            you.getBlackList().add(person.getUsername());
            if (you.getFollowings().contains(person.getUsername())) {
                you.getFollowings().remove(person.getUsername());
                person.getFollowers().remove(you.getUsername());
                person.getStopF().add(you.getUsername());
                try {
                    Save.User(person);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Save.User(you);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (person.getFollowings().contains(you)) {
                person.getFollowings().remove(you.getUsername());
                you.getFollowers().remove(person.getUsername());
                try {
                    Save.User(you);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Save.User(person);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("you blocked them.");
        }
        toDo(you, person);

    }

    static void showTweet(User person) {
        List<Tweet> tweets = person.getTwiits();
        int counter = tweets.size();

        if (counter != 0) {
            tweets.sort(Comparator.reverseOrder());
            for (Tweet tweet : person.getTwiits()) {
                System.out.println(counter + ") " + tweet.getTheTweet());
                System.out.println("Time:");
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd hh:mm:ss");
//                String zaman = dtf.format(tweet.getTime());
                System.out.println(tweet.getTime1());
                System.out.println("Likes: " + tweet.getLike());
                System.out.println("Comments: " + tweet.getTheComments());
                System.out.println(".......................");
                counter--;
            }

        } else {
            System.out.println("NO TWEETS YET.");

        }
        try {
            TheMenu.start(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}





