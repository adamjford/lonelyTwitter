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
		if(duplicateTweetAlreadyExists(tweet)) {
			throw new IllegalArgumentException("Duplicate tweets cannot be added.");
		}
		
		tweets.add(tweet);
	}
	
	private boolean duplicateTweetAlreadyExists(LonelyTweetModel newTweet) {
		for(LonelyTweetModel tweet : tweets) {
			if(tweet.equals(newTweet)) {
				return true;
			}
		}
		
		return false;
	}
	
	public LonelyTweetModel[] getTweets() {
		return tweets.toArray(new LonelyTweetModel[tweets.size()]);
	}
	
	public boolean hasTweet(LonelyTweetModel tweet) {
		// NYI
		return false;
	}
	
	public void removeTweet(LonelyTweetModel tweet) {
		// NYI
	}
}

