package ca.ualberta.cs.lonelytwitter.tests;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	public LonelyTwitterActivityTest() {
		super(LonelyTwitterActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	//public void testFail() {
	//	fail();
	//}
	
	public void testPass() {
		assertEquals("Not equal.", 5, 5);
	}
	
}
