package com.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_notes")
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "title should not be blank.")
	@NotEmpty(message = "title should not be Empty.")
	@NotNull(message = "title should not be Null.")
	@Column(name = "notes_title", length = 2000)
	private String title;

	@NotBlank(message = "description should not be blank.")
	@NotEmpty(message = "description should not be Empty.")
	@NotNull(message = "description should not be Null.")
	@Column(name = "notes_description", length = 10000)
	private String description;

	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@ManyToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Notes [id=" + id + ", title=" + title + ", description=" + description + ", user=" + user + "]";
	}
}
