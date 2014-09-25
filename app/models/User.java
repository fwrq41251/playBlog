package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class User extends Model{

	private static final long serialVersionUID = -3472379595309714837L;

	@Id
	@Column(name = "username")
	public String userName;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "email")
	public String email;

	public User(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public static Finder<String,User> find = new Finder<String,User>(
			String.class, User.class
			); 
	
	public static User authenticate(String email, String password) {
		return find.where().eq("email", email)
				.eq("password", password).findUnique();
	}
}
