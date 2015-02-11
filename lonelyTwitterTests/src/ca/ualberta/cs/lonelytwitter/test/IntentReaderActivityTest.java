package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;

public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2<IntentReaderActivity> {
	
	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testDefaultText() {
		IntentReaderActivity activity = startWithText(null, IntentReaderActivity.NORMAL);
		TextView textView = activity.getTextView();
		assertEquals("Is getText() returning the default text incorrectly?", null, activity.getText());
		assertEquals("Is the TextView not being properly populated?", IntentReaderActivity.DEFAULT_TEXT, textView.getText().toString());
		
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), textView);
	}
	
	public void testSendText() {
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		assertEquals("Is the activity getting my text?", text, activity.getText());
	}

	public void testDoubleText() {
		String text = "Hi";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.DOUBLE);
		assertEquals("Is the activity getting my doubled text?", text+text, activity.getText());
	}
	
	public void testReverseText() {
		String text = "Greetings";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.REVERSE);
		assertEquals("Is the activity getting my reversed text?", "sgniteerG", activity.getText());
	}
	
	public void testDisplayText() {
		String text = "This text should be displayed.";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		TextView textView = activity.getTextView();
		assertEquals("Is the activity displaying the text?", text, textView.getText());
	}
	
	private IntentReaderActivity startWithText(String text, int transform_code) {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, transform_code);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}
}
