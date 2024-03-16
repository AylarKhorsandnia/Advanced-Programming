package events;

import responses.Response;

public class SignUpEvent extends Event {
    private final String username, password, fullName, email, phone, birthday;

    public SignUpEvent(String username, String password, String fullName, String email, String phone, String birthday) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.signUp(username, password, fullName, email, phone, birthday);
    }
}
