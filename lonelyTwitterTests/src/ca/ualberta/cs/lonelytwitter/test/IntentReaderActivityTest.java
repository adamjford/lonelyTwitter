package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2<IntentReaderActivity> {
	
	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSendText() {
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		assertEquals("Is the activity getting my text?", text, activity.getText());
	}
	
	private IntentReaderActivity startWithText(String text, int transform_code) {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, transform_code);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}
}
