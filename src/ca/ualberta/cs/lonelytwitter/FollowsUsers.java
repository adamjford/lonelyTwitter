package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public interface FollowsUsers {
	public void followUser(User u);
	public void unfollowUser(User u);
	public ArrayList<User> getFollowedUsers();
}
