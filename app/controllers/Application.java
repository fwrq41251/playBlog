package controllers;

import global.Consts;

import java.util.List;

import com.avaje.ebean.Page;

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
    public static Result index(int page) {    	
    	Page<Article> result = ArticleService.getAllArticles(page);
    	List<Article> articles = result.getList();
    	int totalRows = result.getTotalRowCount();  
        return ok(index.render("winry", articles, totalRows/Consts.PageSize+1, page+1));
    }
    
}
