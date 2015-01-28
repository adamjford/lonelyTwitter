package ca.ualberta.cs.lonelytwitter.tests;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testEqual() {
		Date date = new Date(12313);
		NormalTweetModel normal = new NormalTweetModel("test tweet", date);
		NormalTweetModel other = new NormalTweetModel("test tweet", date);
		assertFalse("Different Tweets are not equal, yet Equal says they are.", normal.equals(other));
	}
}
