package com.sis.expt.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Setter
@Getter
public class UserRequest {

	@NotNull(message = "User name should not be blank")
	private String name;
	@Email(message = "Email can be empty")
	private String email;
	private String gender;
	@Pattern(regexp = "^\\d{10}$", message = "Mobile number is not valid")
	private String mobile;
	@Min(18)
	@Max(60 )
	private Integer age;
	@NotBlank(message = "Nationality should not be blank")
	private String nationality;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
}
