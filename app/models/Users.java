package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="users")
public class Users extends Model{

	private static final long serialVersionUID = -3472379595309714837L;

	@Id
	@Column(name = "username")
	public String userName;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "email")
	public String email;

	public Users(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public static Finder<String,Users> find = new Finder<String,Users>(
			String.class, Users.class
			); 
	
	public static Users authenticate(String email, String password) {
		return find.where().eq("email", email)
				.eq("password", password).findUnique();
	}
}
