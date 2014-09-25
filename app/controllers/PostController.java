package controllers;


import global.Consts;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import models.Article;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import service.ArticleService;

public class PostController extends Controller{
	
	/**
	 * render the post page
	 * @return
	 */
	public static Result render() {
		if(!StringUtils.equals(session("authenticated"), Consts.TRUE)) {
			return redirect(
		            routes.SigninController.signin()
		        );
		}
    	return ok(views.html.post.post.render(Form.form(Post.class)));
    }
	
	/**
	 * persist the article
	 * @return
	 */
	public static Result post() {
		Form<Post> article = Form.form(Post.class).bindFromRequest();
	    if (article.hasErrors()) {
	        return badRequest(views.html.post.post.render(article));
	    } else {
	    	Post post = article.get();
	    	Article articlePo = new Article(post.title, post.content, "winry", new Date());
	    	ArticleService.saveArticle(articlePo);
	        return redirect(
	            routes.Application.index()
	        );
	    }
	}
	
	public static class Post {

	    public String title;
	    public String content;
	    
	    public String validate() {
		    if (null == title) {
		      return "title can not be empty";
		    }
		    return null;
		}

	}
	
}
