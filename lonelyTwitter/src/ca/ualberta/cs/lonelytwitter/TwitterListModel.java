package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TwitterListModel {
	private ArrayList<LonelyTweetModel> tweets;
	
	public TwitterListModel() {
		tweets = new ArrayList<LonelyTweetModel>();
	}
	
	public int getListLength() {
		return tweets.size();
	}
	
	public void addTweet(LonelyTweetModel tweet) throws IllegalArgumentException {
		tweets.add(tweet);
	}
	
	public LonelyTweetModel[] getTweets() {
		// NYI
		return null;
	}
	
	public boolean hasTweet(LonelyTweetModel tweet) {
		// NYI
		return false;
	}
	
	public void removeTweet(LonelyTweetModel tweet) {
		// NYI
	}
}

