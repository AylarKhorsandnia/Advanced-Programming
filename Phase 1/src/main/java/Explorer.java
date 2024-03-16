public class Explorer {

    static void search(User user1 , User user2){

        if(user2.getFollowers().contains(user1.getUsername())){
            Actions.showProfile1(user1 , user2);
        }

        else if(user2.getRequests().contains(user1.getUsername())){
            Actions.showProfile2(user1 , user2);
        }

        else{
            Actions.showProfile3(user1 , user2);
        }


    }

}
