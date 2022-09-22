package com.example.Project.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Club")
public class ClubEntity {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int club_id;
	
	@Column(nullable = false)
	private String club_name;
	
	@Column(nullable = false)
	private String category;
	
	@Column(nullable = false)
	private LocalDate date_of_creation;
	
	@Column(nullable = false)
	private boolean status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private UserEntity userentity;

	public ClubEntity(int club_id, String club_name, String category, LocalDate date_of_creation, boolean status,
			UserEntity userentity) {
		super();
		this.club_id = club_id;
		this.club_name = club_name;
		this.category = category;
		this.date_of_creation = date_of_creation;
		this.status = status;
		this.userentity = userentity;
	}

	public ClubEntity() {
		super();
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDate_of_creation() {
		return date_of_creation;
	}

	public void setDate_of_creation(LocalDate date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserEntity getUserentity() {
		return userentity;
	}

	public void setUserentity(UserEntity userentity) {
		this.userentity = userentity;
	}

	@Override
	public String toString() {
		return "ClubEntity [club_id=" + club_id + ", club_name=" + club_name + ", category=" + category
				+ ", date_of_creation=" + date_of_creation + ", status=" + status + ", userentity=" + userentity + "]";
	}
	
	
	

}
