package com.project1.questapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {

	@Id// varligin birincil anahtarini belirtir
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Veritabanına bu alan için otomatik olarak bir değer üretmesini bildirir
	/*  IDENTITY
	 *  bir veritabanı kimliği sütunu kullanarak varlık için birincil anahtarlar ataması gerektiğini belirtir.
	 */
	Long id;
	String userName;
	String password;
	int avatar;
	public Object getPassword() {
		return null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public int getAvatar() {
		return avatar;
	}
	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}
	public void setPassword(Object object) {
		this.password = (String) object;
	}
	
}
