package ca.ualberta.cs.lonelytwitter.tests;

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
}
