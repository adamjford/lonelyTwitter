package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;

public abstract class User implements FollowsUsers, FollowedByUsers {
	protected String name;
	private ArrayList<User> followedUsers;
	private ArrayList<User> usersFollowingThis;

	public String getName() {
		return name;
	}
	
	public abstract void setName(String name) throws IOException;
	
	public User(String n) {
		super();
		name = n;
		followedUsers = new ArrayList<User>();
		usersFollowingThis = new ArrayList<User>();
	}
	
	public User() {
		this("Anonymous");
	}
	
	public void followUser(User u) {
		// NYI
	}

	public void unfollowUser(User u) {
		// NYI
	}

	public ArrayList<User> getFollowedUsers() {
		return followedUsers;
	}

	public ArrayList<User> getUsersFollowingThis() {
		return usersFollowingThis;
	}

	public void markAsFollowedBy(User follower) {
		// NYI
	}
}
