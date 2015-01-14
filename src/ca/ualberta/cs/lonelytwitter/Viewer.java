package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Viewer extends User {
	@Override
	public void setName(String n) throws IOException {
		if(n.length() > 8) {
			throw new IOException("Too long!");
		}
		
		name = n;
	}
}
