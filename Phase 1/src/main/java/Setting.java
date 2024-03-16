public class Setting {


    static void stting(User user, String answer) {
        if (answer.equals("1")) {
            System.out.println("1- Activity(your account is active) : " + user.isActivity());
            System.out.println("1) Active OR 2) Deactive ");
            String activity = Sc.next1();
            if (activity.equals("1")) {
                EditProfile.activityON(user);
                System.out.println("You are active now.");
                YourProfile.nxtStep(user);
            }
            if (activity.equals("2")) {
                EditProfile.activityOFF(user);
                System.out.println("You arent active now.");
                YourProfile.nxtStep(user);
            }
        }

        if (answer.equals("2")) {
            System.out.println("2- Privacy(your account is private): " + user.isPrivacy());
            System.out.println("1) Public OR 2) Private ");
            String privacy = Sc.next1();
            if (privacy.equals("1")) {
                EditProfile.privacyOFF(user);
                System.out.println("Your page is public now");
                YourProfile.nxtStep(user);
            }
            if ((privacy.equals("2"))) {
                EditProfile.privacyON(user);
                System.out.println("Your page is private now");
                YourProfile.nxtStep(user);
            }
        }
        if (answer.equals("3")) {
            System.out.println("3- Last Seen : " + user.getAllow());
            System.out.println("Who could see your last seen?: ");
            System.out.println("1) everyone 2) followers 3) on one");
            String st = Sc.nLine();
            YourProfile.lastSeen(user, st);
            YourProfile.nxtStep(user);
        }
        if (answer.equals("4")) {
            YourProfile.nxtStep(user);
        }
    }

}
