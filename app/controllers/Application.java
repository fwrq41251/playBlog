package controllers;

import java.util.List;

import models.Article;
import play.mvc.Controller;
import play.mvc.Result;
import service.ArticleService;
import views.html.index;

public class Application extends Controller {
	
	/**
	 * render index page
	 * @return
	 */
    public static Result index() {    	
    	List<Article> articles = ArticleService.getAllArticles();
        return ok(index.render("winry", articles));
    }
    
}
