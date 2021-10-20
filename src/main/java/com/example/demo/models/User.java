package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
	@Table(name="User_Table")
	public class User 
	{
		

		private int age;
		@Id
		private String email;
		private String username;
		private String password;
		private String mobile;
		private String blood_group;
		private String location;
		private String gender;
		private String available;
		
		public User()
		{
			
		}
		
		

		public User( int age, String email, String username, String password, String mobile, String blood_group,
				String location, String gender, String available) {
			
			
			this.age = age;
			this.email = email;
			this.username = username;
			this.password = password;
			this.mobile = mobile;
			this.blood_group = blood_group;
			this.location = location;
			this.gender = gender;
			this.available = available;
		}




		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getBlood_group() {
			return blood_group;
		}

		public void setBlood_group(String blood_group) {
			this.blood_group = blood_group;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAvailable() {
			return available;
		}

		public void setAvailable(String available) {
			this.available = available;
		}



		@Override
		public String toString() {
			return "User [ age=" + age + ", email=" + email + ", username=" + username + ", password="
					+ password + ", mobile=" + mobile + ", blood_group=" + blood_group + ", location=" + location
					+ ", gender=" + gender + ", available=" + available + "]";
		}



		
}
