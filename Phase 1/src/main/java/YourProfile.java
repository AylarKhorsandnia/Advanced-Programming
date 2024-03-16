import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class YourProfile {

    static void start(User user) {
        if (user.isActivity()) {
            System.out.println("1) Your personal info");
            System.out.println("2) Tweet");
            System.out.println("3) lists");
            System.out.println("4) goBack");

            String answer = Sc.next1();
            go(user, answer);
        } else {
            System.out.println("TO DO:");
            System.out.println("1) Check your personal info.");
            System.out.println("4) goBack");

            String answer = Sc.next1();
            go(user, answer);
        }


    }


    static void go(User user, String answer) {


        if (answer.equals("1")) {
            try {
                editProf(user);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (answer.equals("2")) {
            System.out.println("1) Write a new tweet.");
            System.out.println("2) Check all your tweets so far.");
            String st = Sc.nLine();
            if (st.equals("goBack")) {
                start(user);
            } else {
                if (st.equals("1")) {
                    System.out.println("New tweet:");
                    String twt = Sc.nLine();
                    if (twt.equals("goBack")) {
                        start(user);
                    } else {
                        Profile.newTweet(user, twt);
                    }
                }
                if (st.equals("2")) {
                    Profile.allYourTweets(user);
                    System.out.println("---------------");
                    start(user);
                }
            }
        }

        if (answer.equals("3")) {
            System.out.println("1) followers");
            System.out.println("2) followings");
            System.out.println("3) blacklist");
            System.out.println("4) your requests");
            System.out.println("5) your accepted following requests");
            System.out.println("6) your denied following requests");
            System.out.println("7) who started following you?");
            System.out.println("8) who stopped following you?");
            System.out.println("9) goBack");
            String st = Sc.nLine();

            if (st.equals("1")) {
                System.out.println("FOLLOWERS");
                try {
                    Followers.fllwrs(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("---------------");
                start(user);
            }
            if (st.equals("2")) {
                System.out.println("FOLLOWINGS");
                try {
                    Followings.fllwngs(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("---------------");
                start(user);
            }
            if (st.equals("3")) {
                System.out.println("BLACK LIST");
                try {
                    BlackList.bl(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("---------------");
                start(user);
            }
            if (st.equals("4")) {
                try {
                    Request.requests(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("---------------");
                start(user);
            }
            if (st.equals("5")) {
                try {
                    Request.acceptedRequests(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("---------------");
                start(user);
            }
            if (st.equals("6")) {
                System.out.println("");
                try {
                    Request.deniedRequests(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("---------------");
                start(user);
            }
            if (st.equals("7")) {
                System.out.println("STARTED FOLLOWING U");
                try {
                    Followers.startedFollowing(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("---------------");
                start(user);
            }
            if (st.equals("8")) {
                System.out.println("STOPPED FOLLOWING U");
                try {
                    Followers.stoppedFollowing(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("---------------");
                start(user);
            }
            if (answer.equals("9")) {
                try {
                    TheMenu.start(user);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        if(answer.equals("4")){
            try {
                TheMenu.start(user);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


    }


    static void nxtStep(User user) {
        System.out.println("Next step:");
        start(user);
    }


    static void lastSeen(User you, String num) {
        if (num.equals("1")) {
            you.getAllow().removeFirst();
            you.getAllow().add("everyone");
            try {
                Save.User(you);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (num.equals("2")) {
            you.getAllow().removeFirst();
            you.getAllow().add("followers");
            try {
                Save.User(you);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (num.equals("3")) {
            you.getAllow().removeFirst();
            you.getAllow().add("no one");
            try {
                Save.User(you);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    static void editProf(User user) throws FileNotFoundException {
        File f = new File("./src/main/resources/Users/" + user.getUsername() + ".json");
        Gson gson = new Gson();
        User person = gson.fromJson(new FileReader(f), User.class);
        System.out.println("Edit your...");
        System.out.println("1- password: " + person.getPassword());
        System.out.println("2- full name: " + person.getFullName());
        System.out.println("3- email: " + person.getEmail());
        System.out.println("4- phone number: " + person.getPhoneNum());
        System.out.println("5- birthday: " + person.getBirthday());
        System.out.println("6- bio: " + person.getBio());
        System.out.println("7- SETTING");

        String num = Sc.next1();
        if (num.equals("goBack")) {
            start(user);
        } else if (num.equals("1")) {
            System.out.println("Enter a new password");
            String nwpass = Sc.nLine();
            if (nwpass.equals("goBack")) {
                editProf(user);
            } else {
                EditProfile.password(user, nwpass);
                System.out.println("PASSWORD changed successfully.");
                nxtStep(user);
            }
        } else if (num.equals("2")) {
            System.out.println("Enter a full name");
            String nwfullName = Sc.nLine();
            if (nwfullName.equals("goBack")) {
                editProf(user);
            } else {
                EditProfile.fullName(user, nwfullName);
                System.out.println("FULLNAME changed successfully.");
                nxtStep(user);
            }
        } else if (num.equals("3")) {
            System.out.println("Enter an email");
            String email = Sc.nLine();
            if (email.equals("goBack")) {
                editProf(user);
            } else {
                EditProfile.email(user, email);
                System.out.println("EMAIL changed successfully.");
                nxtStep(user);
            }

        } else if (num.equals("4")) {
            System.out.println("Enter a phone number");
            String number = Sc.nLine();
            if (number.equals("goBack")) {
                editProf(user);
            } else {
                EditProfile.phoneNumber(user, number);
                System.out.println("PHONE NUMBER changed successfully.");
                nxtStep(user);
            }

        } else if (num.equals("5")) {
            System.out.println("Enter your birthday");
            System.out.println("year:");
            String year = Sc.next1();
            System.out.println("month:");
            String month = Sc.next1();
            System.out.println("day");
            String day = Sc.next1();
            String birth = SignUp.birthday(year, month, day);
            EditProfile.birthday(user, birth);
            System.out.println("BIRTHDAY changed successfully.");
            nxtStep(user);
        } else if (num.equals("6")) {
            System.out.println("Enter your new bio ");
            String bio = Sc.nLine();
            if (bio.equals("goBack")) {
                editProf(user);
            } else {
                EditProfile.bio(user, bio);
                System.out.println("YOUR BIO changed successfully.");
                nxtStep(user);
            }

        } else if (num.equals("7")) {
            System.out.println("1- Activity(your account is active) : " + person.isActivity());
            System.out.println("2- Privacy(your account is private): " + person.isPrivacy());
            System.out.println("3- Last Seen and online : " + person.getAllow());
            System.out.println("4- goBack");
            String answer = Sc.next1();
            Setting.stting(person, answer);

        } else {
            System.out.println("Invalid number.Try again.");
            editProf(user);
        }


    }


}
