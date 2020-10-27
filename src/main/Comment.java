package main;

public class Comment {
	private String comment;
	private String regDate;
	private String nickname;

	public Comment() {

	}

	private Comment(String comment, String regDate, String nickname) {
		this.comment = comment;
		this.regDate = regDate;
		this.nickname = nickname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
