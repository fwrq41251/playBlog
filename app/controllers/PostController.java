package controllers;

import global.Consts;

import java.util.Date;

import models.Article;

import org.apache.commons.lang3.StringUtils;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import service.ArticleService;

public class PostController extends Controller {

	/**
	 * render the post page
	 * 
	 * @return
	 */
	public static Result render() {
		if (!StringUtils.equals(session("authenticated"), Consts.TRUE)) {
			return redirect(routes.SigninController.signin());
		}
		return ok(views.html.post.post.render(Form.form(Post.class)));
	}

	/**
	 * persist the article
	 * 
	 * @return
	 */
	public static Result post() {
		Form<Post> article = Form.form(Post.class).bindFromRequest();
		if (article.hasErrors()) {
			return badRequest(views.html.post.post.render(article));
		} else {
			Post post = article.get();
			Article articlePo = new Article(post.title, post.content, "winry",
					new Date());
			articlePo.status = "p";
			ArticleService.saveArticle(articlePo);
			return redirect(routes.Application.index(0));
		}
	}

	/**
	 * render the edit page
	 * 
	 * @return
	 */
	public static Result renderEdit(long id) {
		Article article = Article.findById(id);
		return ok(views.html.post.edit.render(Form.form(Post.class), article));
	}

	/**
	 * save the change to article
	 * 
	 * @return
	 */
	public static Result saveChange() {
		Form<Post> article = Form.form(Post.class).bindFromRequest();
		if (article.hasErrors()) {
			return badRequest(views.html.post.post.render(article));
		} else {
			Post post = article.get();
			Article articlePo = Article.findById(post.id);
			articlePo.title = post.title;
			articlePo.content = post.content;
			ArticleService.updateArticle(articlePo);
			return redirect(routes.Application.index(0));
		}
	}

	public static class Post {

		public long id;
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
