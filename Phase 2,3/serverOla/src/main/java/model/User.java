package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "OLa")
public class User implements Serializable {

    @Id
    private String username;

    public User(String ID) {
        this.username = ID;
    }

    public User() {
    }

    @Column
    private String Password;
    @Column
    private String FullName = "";

    @Column
    private String Birthday;

    @Column
    private String Email = "";

    @Column
    private String PhoneNumber = "";

    @Column
    private String Biography = "";

    @Column
    private int TweetNumbers = 0;

    @ManyToMany()
    @Cascade({CascadeType.PERSIST})
    private List<User> Followers = new LinkedList<>();

    @ManyToMany(mappedBy = "Followers")
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<User> Followings = new LinkedList<>();

    @ManyToMany
    @Cascade(CascadeType.PERSIST)
    private List<User> Blocks = new LinkedList<>();

    @ManyToMany
    @Cascade(CascadeType.PERSIST)
    private List<User> Requests = new LinkedList<>();
    //    @Column
    private LocalDateTime LastOnline;
    @Column
    private boolean privacy = true;
    @Column
    private boolean Activity = true;
    @Column
    private boolean isOnline = false;

    public boolean isActivity() {
        return Activity;
    }

    public void setActivity(boolean activity) {
        Activity = activity;
    }


    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public List<User> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<User> followers) {
        Followers = followers;
    }

    public List<User> getFollowings() {
        return Followings;
    }

    public void setFollowings(List<User> followings) {
        Followings = followings;
    }

    public List<User> getBlocks() {
        return Blocks;
    }

    public void setBlocks(List<User> blocks) {
        Blocks = blocks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String ID) {
        this.username = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FullName;
    }

    public void setFirstName(String firstName) {
        FullName = firstName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    public int getTweetNumbers() {
        return TweetNumbers;
    }

    public void setTweetNumbers(int tweetNumbers) {
        TweetNumbers = tweetNumbers;
    }

    public LocalDateTime getLastOnline() {
        return LastOnline;
    }

    public void setLastOnline(LocalDateTime lastOnline) {
        LastOnline = lastOnline;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public List<User> getRequests() {
        return Requests;
    }

    public void setRequests(List<User> requests) {
        Requests = requests;
    }

    public static LocalDateTime LastOnline(User user1, User user2) {
        // ...
        return user1.getLastOnline();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}








