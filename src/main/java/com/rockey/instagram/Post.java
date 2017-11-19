package com.rockey.instagram;

import java.util.List;



public class Post {
	
	private int numberoftags;
	private List<String> tagslist;
	private likes likes;
	
	

	public likes getLikes() {
		return likes;
	}

	public void setLikes(likes likes) {
		this.likes = likes;
	}

	public List<String> getTagslist() {
		return tagslist;
	}

	public void setTagslist(List<String> tagslist) {
		this.tagslist = tagslist;
	}

	public int getNumberoftags() {
		return numberoftags;
	}

	public void setNumberoftags(int numberoftags) {
		this.numberoftags = numberoftags;
	}
	

}
