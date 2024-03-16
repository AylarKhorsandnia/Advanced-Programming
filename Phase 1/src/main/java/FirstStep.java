public class FirstStep {

    static void start1() {
        System.out.println("Welcome to hola!");
        System.out.println("you must login with your account or create a new one.");
        start2();
    }

    static void start2() {
        System.out.println("Do you have any account?");
        System.out.println("Type yes / no");
        String answer = Sc.next1();
        // login
        if (answer.equals("yes")) {
            Login.haveAccount();
        }
        // sign up
        else if (answer.equals("no")) {
            System.out.println("NOTICE: Whenever you type (goBack) in this social media, you go one step backward.");
            System.out.println("You MUST answer the Q with * ");
            System.out.println("Other Qs could be filled with (-) if you don't want to answer them.");
            SignUp.userName();
        } else {
            System.out.println("Pay more attention to your answer!");
            start2();
        }

    }
}
