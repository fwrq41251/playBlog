package service;

import java.util.List;

import models.Article;

public final class ArticleService {
	
	public static List<Article> getAllArticles() {
		List<Article> result = Article.findAll();
		return result;
	}
	
	public static boolean saveArticle(Article article) {
		article.save();
		return true;
	}

}
