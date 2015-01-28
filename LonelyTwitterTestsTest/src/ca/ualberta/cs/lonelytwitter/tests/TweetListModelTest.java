package ca.ualberta.cs.lonelytwitter.tests;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.*;
import android.test.ActivityInstrumentationTestCase2;

public class TweetListModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testListCount() {
		TwitterListModel tweets = new TwitterListModel();
		tweets.addTweet(new NormalTweetModel("test"));
		
		assertEquals("Adding a tweet doesn't affect getListLength().", 1, tweets.getListLength());
	}
	
	public void testThatAddTweetThrowsAnExceptionIfADuplicateTweetIsAdded() {
		TwitterListModel tweets = new TwitterListModel();
		Date date = new Date(123);
		NormalTweetModel tweet1 = new NormalTweetModel("test", date);
		NormalTweetModel tweet2 = new NormalTweetModel("test", date);
		
		assertTrue("Expected tweets to be equal, but they were not.", tweet1.equals(tweet2));

		tweets.addTweet(tweet1);

		try {
			tweets.addTweet(tweet2);
			fail("No exception was thrown when a duplicate tweet was added.");
		} catch(IllegalArgumentException ex) {
			// success!
		} catch(Exception ex) {
			fail("An exception that was not IllegalArgumentException was thrown.");
		}
	}
	
	public void testThatGetTweetsReturnsTweetsInOrderTheyWereAdded() {
		TwitterListModel tweets = new TwitterListModel();
		NormalTweetModel tweet1 = new NormalTweetModel("test", new Date(3));
		NormalTweetModel tweet2 = new NormalTweetModel("test 2", new Date(2));
		NormalTweetModel tweet3 = new NormalTweetModel("test 3", new Date(1));
		
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		tweets.addTweet(tweet3);
		
		LonelyTweetModel[] array = tweets.getTweets();
		assertNotNull("Array returned from getTweets() is null.", array);
		assertTrue("Tweets are in incorrect order.", array[0].equals(tweet1));
		assertTrue("Tweets are in incorrect order.", array[1].equals(tweet2));
		assertTrue("Tweets are in incorrect order.", array[2].equals(tweet3));
	}
	
	public void testThatHasTweetReturnsTrueIfTweetExistsInList() {
		TwitterListModel tweets = new TwitterListModel();
		NormalTweetModel tweet1 = new NormalTweetModel("test", new Date(3));
		NormalTweetModel tweet2 = new NormalTweetModel("test 2", new Date(2));
		NormalTweetModel tweet3 = new NormalTweetModel("test 3", new Date(1));
		NormalTweetModel tweet4 = new NormalTweetModel("Not added.");
		
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		tweets.addTweet(tweet3);
		
		assertTrue("hasTweet() not returning true even though tweet was added.", tweets.hasTweet(tweet1));
		assertTrue("hasTweet() not returning true even though tweet was added.", tweets.hasTweet(tweet2));
		assertTrue("hasTweet() not returning true even though tweet was added.", tweets.hasTweet(tweet3));
		assertFalse("hasTweet() not returning false even though tweet was not added.", tweets.hasTweet(tweet4));
	}
	
	public void testThatRemoveTweetActuallyRemovesTheTweet() {
		TwitterListModel tweets = new TwitterListModel();
		NormalTweetModel tweet1 = new NormalTweetModel("test", new Date(3));
		NormalTweetModel tweet2 = new NormalTweetModel("test 2", new Date(2));
		NormalTweetModel tweet3 = new NormalTweetModel("test 3", new Date(1));
		
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		tweets.addTweet(tweet3);

		assertTrue("hasTweet() not returning true even though tweet was added.", tweets.hasTweet(tweet2));
		assertEquals("getListLength() not accurately returning count.", 3, tweets.getListLength());
		
		tweets.removeTweet(tweet2);

		assertFalse("hasTweet() not returning false even though tweet was removed.", tweets.hasTweet(tweet2));
		assertEquals("getListLength() not accurately returning count after tweet removed.", 2, tweets.getListLength());
	}
}
