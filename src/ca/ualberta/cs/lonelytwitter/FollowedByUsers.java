package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public interface FollowedByUsers {
	public ArrayList<User> getUsersFollowingThis();
	public void markAsFollowedBy(User follower);
}
