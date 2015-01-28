package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TwitterListModel {
	private ArrayList<LonelyTweetModel> tweets;
	private int count;
	
	public TwitterListModel() {
		count = 0;
		tweets = new ArrayList<LonelyTweetModel>();
	}
	
	public int getListLength() {
		return count;
	}
	
	public void addTweet(LonelyTweetModel tweet) {
		tweets.add(tweet);
	}
}
