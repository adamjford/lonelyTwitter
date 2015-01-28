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
}
