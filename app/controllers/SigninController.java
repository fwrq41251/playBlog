package controllers;


import global.Consts;
import models.Users;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class SigninController extends Controller{
	
	/**
	 * render the signIn page
	 * @return
	 */
	public static Result signin() {
    	return ok(views.html.signin.signin.render(Form.form(Signin.class)));
    }

	/**
	 * authenticate signIn info
	 * @return
	 */
	public static Result authenticate() {
	    Form<Signin> loginForm = Form.form(Signin.class).bindFromRequest();
	    if (loginForm.hasErrors()) {
	        return badRequest(views.html.signin.signin.render(loginForm));
	    } else {
	        session().clear();
	        session("email", loginForm.get().email);
	        session("authenticated", Consts.TRUE);
	        return redirect(
	            routes.PostController.render()
	        );
	    }
	}
	
	public static class Signin {

	    public String email;
	    public String password;
	    
	    public String validate() {
		    if (Users.authenticate(email, password) == null) {
		      return "Invalid user or password";
		    }
		    return null;
		}

	}
}
