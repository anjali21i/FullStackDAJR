package com.core.fullstack.security;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUserRecord implements Serializable {

	private static final long serialVersionUID = 416687071872452689L;

	private Long userId;
	private String loginId;
	private String password;
	private String userType;
	private String emailId;
	private String mobileCountry;
	private String mobile;
	private String firstName;
	private String username;
	private String accessToken;
	private String strQue;
	private String strAns;
	private String afterLoginPage;
	private Date lastlogintime;
}
