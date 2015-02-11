package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.R;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	LonelyTwitterActivity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(R.id.body));
	}
	
	public void testSettingText() {
		instrumentation.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				textInput.setText("Text");
			}
		});
		
		instrumentation.waitForIdleSync();
		assertEquals("Text?", "Text", textInput.getText().toString());
	}
	
	public void testCreatingATweet() {
		ListView listView = (ListView) activity.findViewById(R.id.oldTweetsList);
		ListAdapter adapter = listView.getAdapter();
		int oldCount = adapter.getCount();

		final String tweetText = "New Tweet!";
		instrumentation.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				makeTweet(tweetText);
			}
		});
		
		instrumentation.waitForIdleSync();
		
		int newCount = adapter.getCount();
		
		assertEquals("Adapter did not get a new item.", oldCount+1, newCount);
		
		Object newItem = adapter.getItem(newCount-1);
		
		assertTrue("New item is not a NormalTweetModel", newItem instanceof NormalTweetModel);
		
		assertEquals("New item does not have correct test.", tweetText, ((NormalTweetModel)newItem).getText());
	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
}
