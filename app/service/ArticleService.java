package service;

import models.Article;

import com.avaje.ebean.Page;

public final class ArticleService {
	
	public static Page<Article> getAllArticles(int page) {
		Page<Article> result = Article.findByPage(page);
		return result;
	}
	
	public static boolean saveArticle(Article article) {
		article.save();
		return true;
	}

}
