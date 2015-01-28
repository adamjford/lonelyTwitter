package ca.ualberta.cs.lonelytwitter.tests;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.*;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testThatNormalTweetsWithSameTextAndDatesAreEqual() {
		Date date = new Date(12313);
		NormalTweetModel normal = new NormalTweetModel("test tweet", date);
		NormalTweetModel other = new NormalTweetModel("test tweet", date);
		assertTrue("Equals says two identical tweets are not.", normal.equals(other));
	}

	public void testThatNormalTweetsWithSameTextButDifferentDatesAreNotEqual() {
		NormalTweetModel normal = new NormalTweetModel("test tweet", new Date(12313));
		NormalTweetModel other = new NormalTweetModel("test tweet", new Date(34242));
		assertFalse("Tweets have different dates, but are being considered as equal.", normal.equals(other));
	}

	public void testThatNormalTweetsWithSameDatesButDifferentTextAreEqual() {
		Date date = new Date(12313);
		NormalTweetModel normal = new NormalTweetModel("test tweet", date);
		NormalTweetModel other = new NormalTweetModel("test tweet 2", date);
		assertFalse("Tweets have different text, but are being considered as equal.", normal.equals(other));
	}

	public void testThatNormalTweetsWithDifferentTextAndDatesAreEqual() {
		NormalTweetModel normal = new NormalTweetModel("test tweet", new Date(12313));
		NormalTweetModel other = new NormalTweetModel("test tweet 2", new Date(34242));
		assertFalse("Tweets have different text and dates, but are being considered as equal.", normal.equals(other));
	}
	
	public void testThatNormalDoesNotTreatImportantTweetsWithSameTextAndDateAsEqual() {
		Date date = new Date(12313);
		NormalTweetModel normal = new NormalTweetModel("test tweet", date);
		ImportantTweetModel important = new ImportantTweetModel("test tweet", date);
		assertFalse("A Normal tweet and an Important tweet are saying they're equal, but they're not.", normal.equals(important));
	}

	public void testThatImportantDoesNotTreatNormalTweetsWithSameTextAndDateAsEqual() {
		Date date = new Date(12313);
		NormalTweetModel normal = new NormalTweetModel("test tweet", date);
		ImportantTweetModel important = new ImportantTweetModel("test tweet", date);
		assertFalse("A Normal tweet and an Important tweet are saying they're equal, but they're not.", important.equals(normal));
	}
}
