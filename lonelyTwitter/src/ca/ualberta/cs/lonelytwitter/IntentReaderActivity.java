package ca.ualberta.cs.lonelytwitter;

import android.os.Bundle;
import android.widget.*;
import android.app.Activity;
import android.content.Intent;

public class IntentReaderActivity extends Activity {

	public static final String TEXT_KEY = "TEXT";
	public static final String TRANSFORM_KEY = "TRANSFORM";

	public static final int NORMAL = 1;
	public static final int REVERSE = 2;
	public static final int DOUBLE = 3;
	
	private String text;
	private int mode;
	private TextView textView;
	//private EditText textInput;
	//private Button saveButton;

	private void initializeControlReferences() {
		textView = (TextView) findViewById(R.id.intentText);
		//textInput = (EditText) findViewById(R.id.body);
		//saveButton = (Button) findViewById(R.id.save);
	}
	
	public String getText() {
		return text;
	}
	
	public TextView getTextView() {
		return textView;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_reader);
		
		initializeControlReferences();
		
		Intent intent = getIntent();
		mode = intent.getIntExtra(TRANSFORM_KEY, NORMAL);
		text = transformText(intent.getStringExtra(TEXT_KEY));
		textView.setText(text);
	}
	
	
	public String transformText(String text) {
		switch (mode) {
			case REVERSE:
				char[] string =  text.toCharArray();
				for (int i = 0; i < string.length / 2; i++) {
					char tmp = string[i];
					string[i] = string[string.length - i -1];
					string[string.length - i - 1] = tmp;
				}
				return new String(string);
			case DOUBLE:
				return text + text;
		}
		return text;
	}
}
