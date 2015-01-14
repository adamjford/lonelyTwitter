package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Author extends User implements UserLike {
	public Author(String string) {
		super(string);
	}
	
	@Override
	public void setName(String n) throws IOException {
		this.name = n;
	}
}
