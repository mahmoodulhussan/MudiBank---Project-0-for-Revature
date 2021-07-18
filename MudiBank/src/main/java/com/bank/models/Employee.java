package com.bank.models;



public class Employee {
	
	private int postId;
	private int authorId;
	private int wallUserId;
	private int postContent;
	
	public Employee() {
		
	}
	
	public Employee(int id, int authorId, int wallId, int content) {
		this.postId = id;
		this.authorId = authorId;
		this.wallUserId = wallId;
		this.postContent = content;
	}
	
	public Employee(int authorId, int wallId, int content) {
		this.authorId = authorId;
		this.wallUserId = wallId;
		this.postContent = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public int getWallUserId() {
		return wallUserId;
	}

	public void setWallUserId(int wallUserId) {
		this.wallUserId = wallUserId;
	}
	
	public int getPostContent() {
		return postContent;
	}
	
	public void setPostContent(int postContent) {
		this.postContent = postContent;
	}
	
	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", authorId=" + authorId + ", wallUserId=" + wallUserId + ", postContent="
				+ postContent + "]";	
		}


}
