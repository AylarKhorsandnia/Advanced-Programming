import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Tweet implements Comparable<Tweet> {
    @Expose
    private String theTweet;
    @Expose
    private String writer;
    @Expose
    private int like = 0;
    @Expose
    private int comment = 0;
    @Expose
    private String time1;

    @Expose
    private LinkedList<String> Likers;

    @Expose
    private LinkedList<Tweet> theComments;

    @Expose
    private boolean retweet;

    @Expose
    private Tweet previousTweet , nextTweet;


//    @Expose
//    private TweetType type;

    public Tweet(String writer, String theTweet) {
        this.writer = writer;
        this.theTweet = theTweet;
        Likers = new LinkedList<>();
        theComments = new LinkedList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.setTime1(dtf.format(now));

    }

    public Tweet getPreviousTweet() {
        return previousTweet;
    }

    public void setPreviousTweet(Tweet previousTweet) {
        this.previousTweet = previousTweet;
    }

    public Tweet getNextTweet() {
        return nextTweet;
    }

    public void setNextTweet(Tweet nextTweet) {
        this.nextTweet = nextTweet;
    }

    public boolean isRetweet() {
        return retweet;
    }

    public void setRetweet(boolean retweet) {
        this.retweet = retweet;
    }

    public LinkedList<Tweet> getTheComments() {
        return theComments;
    }

    public void setTheComments(LinkedList<Tweet> theComments) {
        this.theComments = theComments;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTheTweet() {
        return theTweet;
    }

    public void setTheTweet(String theTweet) {
        this.theTweet = theTweet;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public LinkedList<String> getLikers() {
        return Likers;
    }

    public void setLikers(LinkedList<String> likers) {
        Likers = likers;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    @Override
    public int compareTo(Tweet o) {
        return this.getTime1().compareTo(o.getTime1());
    }


    @Override
    public String toString() {
        return "Tweet{" +
                "theTweet='" + theTweet + '\'' +
                ", writer='" + writer + '\'' +
                ", like=" + like +
                ", comment=" + comment +
                ", time1='" + time1 + '\'' +
                ", reTweet='" + retweet + '\'' +

                '}';
    }
}
