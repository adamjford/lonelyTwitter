package ca.ualberta.cs.lonelytwitter;

public class Author extends User implements UserLike {
	public Author(String string) {
		super(string);
	}
	
	@Override
	public void setName(String n) {
		this.name = n;
	}
}
