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
	
	public void addTweet(LonelyTweetModel tweet) {
		tweets.add(tweet);
	}
}
