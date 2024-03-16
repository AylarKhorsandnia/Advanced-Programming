package responses;

public class SignUpResponse extends Response{
    private final String response;

    public SignUpResponse(String response) {
        this.response = response;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.signUpResponse(response);
    }
}
