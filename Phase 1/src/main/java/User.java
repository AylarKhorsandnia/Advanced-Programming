import com.google.gson.annotations.Expose;
import java.util.LinkedList;

public class User {
    static int lastId = 0;
    @Expose
    private String Username;
    @Expose
    private String FullName;
    @Expose
    private String Password;
    @Expose
    private String Email;
    @Expose
    private String PhoneNum;
    @Expose
    private String Birthday;
    @Expose
    private String bio;
    @Expose
    private final int id;
    @Expose
    private boolean activity;

    @Expose
    private LinkedList<Tweet> twiits;

    @Expose
    private LinkedList<String> followers;
    @Expose
    private LinkedList<String> followings;
    @Expose
    private LinkedList<String> blackList;

    @Expose
    private boolean privacy;
    @Expose
    private LinkedList<String> requests;
    @Expose
    private LinkedList<Tweet> timeline;
    @Expose
    private String lastOnline;
    @Expose
    private LinkedList<String> allow;
    @Expose
    private LinkedList<String> startF;
    @Expose
    private LinkedList<String> stopF;
    @Expose
    private LinkedList<String> acceptedRequests;
    @Expose
    private LinkedList<String> deniedRequests;

    // constructor
    public User(String username) {
        Username = username;
        lastId++;
        this.id = lastId;
        twiits = new LinkedList<>();
        followers = new LinkedList<>();
        followings = new LinkedList<>();
        blackList = new LinkedList<>();
        requests = new LinkedList<>();
        timeline = new LinkedList<>();
        allow = new LinkedList<>();
        startF = new LinkedList<>();
        stopF = new LinkedList<>();
        acceptedRequests = new LinkedList<>();
        deniedRequests = new LinkedList<>();
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public LinkedList<String> getFollowers() {
        return followers;
    }

    public void setFollowers(LinkedList<String> followers) {
        this.followers = followers;
    }

    public LinkedList<String> getFollowings() {
        return followings;
    }

    public void setFollowings(LinkedList<String> followings) {
        this.followings = followings;
    }

    public LinkedList<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(LinkedList<String> blackList) {
        this.blackList = blackList;
    }

    public LinkedList<Tweet> getTwiits() {
        return twiits;
    }

    public void setTwiits(LinkedList<Tweet> twiits) {
        this.twiits = twiits;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public LinkedList<String> getRequests() {
        return requests;
    }

    public void setRequests(LinkedList<String> requests) {
        this.requests = requests;
    }

    public LinkedList<Tweet> getTimeline() {
        return timeline;
    }

    public void setTimeline(LinkedList<Tweet> timeline) {
        this.timeline = timeline;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public String getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(String lastOnline) {
        this.lastOnline = lastOnline;
    }

    public LinkedList<String> getAllow() {
        return allow;
    }

    public void setAllow(LinkedList<String> allow) {
        this.allow = allow;
    }

    public LinkedList<String> getStartF() {
        return startF;
    }

    public void setStartF(LinkedList<String> startF) {
        this.startF = startF;
    }

    public LinkedList<String> getStopF() {
        return stopF;
    }

    public void setStopF(LinkedList<String> stopF) {
        this.stopF = stopF;
    }

    public LinkedList<String> getAcceptedRequests() {
        return acceptedRequests;
    }

    public void setAcceptedRequests(LinkedList<String> acceptedRequests) {
        this.acceptedRequests = acceptedRequests;
    }

    public LinkedList<String> getDeniedRequests() {
        return deniedRequests;
    }

    public void setDeniedRequests(LinkedList<String> deniedRequests) {
        this.deniedRequests = deniedRequests;
    }
}