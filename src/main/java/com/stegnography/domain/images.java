package com.stegnography.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "image_Table")
public class images {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
	
	@Transient
	private MultipartFile image;

	private String userid_password;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getUserid_password() {
		return userid_password;
	}

	public void setUserid_password(String userid_password) {
		this.userid_password = userid_password;
	}
}
