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
		if(hasTweet(tweet)) {
			throw new IllegalArgumentException("Duplicate tweets cannot be added.");
		}
		
		tweets.add(tweet);
	}
	
	public LonelyTweetModel[] getTweets() {
		return tweets.toArray(new LonelyTweetModel[tweets.size()]);
	}
	
	public boolean hasTweet(LonelyTweetModel tweet) {
		for(LonelyTweetModel tweetInList : tweets) {
			if(tweet.equals(tweetInList)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void removeTweet(LonelyTweetModel tweet) {
		tweets.remove(tweet);
	}
}

