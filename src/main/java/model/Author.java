package model;

import java.sql.Date;
import java.util.Objects;

// tác giả
public class Author {
	private String 	authorCode;
	private String 	authorName;
	private Date	dateOfBirth;
	private String	biography;
	
	public Author() {
	}

	public Author(String authorCode, String authorName, Date dateOfBirth, String biography) {
		this.authorCode = authorCode;
		this.authorName = authorName;
		this.dateOfBirth = dateOfBirth;
		this.biography = biography;
	}

	public String getAuthorCode() {
		return authorCode;
	}

	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorCode, authorName, biography, dateOfBirth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorCode, other.authorCode);
	}

	@Override
	public String toString() {
		return "Author [authorCode=" + authorCode + ", authorName=" + authorName + ", dateOfBirth=" + dateOfBirth
				+ ", biography=" + biography + "]";
	}
	
	
}
