package domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private String id;
	private String name;
	private String password;
	private String phone;
	private String address;
	private String sex;
	private String email;
	private String nickName;
	private Date birthday;
	private String code;
	private int state;
	
}
