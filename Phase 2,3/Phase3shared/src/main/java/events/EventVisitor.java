package events;

import responses.Response;

public interface EventVisitor {
    Response changeFrame(String frame);
    Response login(String username, String password);
    Response newTweet(String content, String authToken);
    Response setNameLabel(String authToken);
    Response signUp(String username, String password, String fullName, String email, String phone, String birthday);
    Response getUserModel(String authToken);
//    Response exit();
//
    // ...
}
