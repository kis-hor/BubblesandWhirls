package model;

import java.io.File;

import javax.servlet.http.Part;

import util.StringUtils;

public class RegisterModel {
		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private String username;
		private String password;
		private String role;
		private String imageUrlFromPart;
		
		public RegisterModel(String firstName, String lastName, String email, String phoneNumber, String username,String password, String role, Part imagePart) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.username = username;
			this.password = password;
			this.role = role;
			this.setImageUrlFromPart(getImageUrl(imagePart));
		}
		
		public RegisterModel() {
			
		}
		
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
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
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}


		
		
		private String getImageUrl(Part part) {
			String savePath = StringUtils.IMAGE_DIR_SAVE_PATH;
			File fileSaveDir = new File(savePath);
			String imageUrlFromPart = null;
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdirs();
			}
			String contentDisp = part.getHeader("content-disposition");
			String[] items = contentDisp.split(";");
			for (String s : items) {
				if (s.trim().startsWith("filename")) {
					imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
				}
			}
			if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
				imageUrlFromPart = "download.jpg";
			}
			return imageUrlFromPart;
		}

		public String getImageUrlFromPart() {
			return imageUrlFromPart;
		}

		public void setImageUrlFromPart(String imageUrlFromPart) {
			this.imageUrlFromPart = imageUrlFromPart;
		}

}
		

