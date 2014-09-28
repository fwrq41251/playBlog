package models;

import global.Consts;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;

@Entity
@Table(name="article")
public class Article extends Model{

	private static final long serialVersionUID = 5883982129768725148L;

	@Id
	public Long id;

	@Column(name = "title")
	public String title;

	@Column(name = "content")
	public String content;

	@Column(name = "date")
	public Date date;

	//	public List<String> tags;
	//	
	//	@Column(name = "status")
	//	public EArticleStatus status;
	//	
	//	@Column(name = "permission")
	//	public EPermission permission;

	@Column(name = "username")
	public String userName;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
	@JoinColumn(name = "username", insertable = false, updatable = false)
	public Users author;

	public Article(String titile, String content, String userName, Date date) {
		this.title = titile;
		this.content = content;
		this.userName = userName;
		this.date = date;
	}

	public static Finder<Long,Article> find = new Finder<Long, Article>(Long.class, Article.class);

	/**
	 * get All articles
	 * @return
	 */
	public static List<Article> findAll() {
		return find.all();
	}

	/**
	 * find articles by email
	 * @param user
	 * @return
	 */
	public static List<Article> findInvolving(String user) {
		return find.where()
				.eq("author.email", user)
				.findList();
	}

	/**
	 * a mock article
	 * @return
	 */
	public static Article mockArticle() {
		String title = "hello world";
		String content = "this is the first article.";
		String userName = "winry";
		Article article = new Article(title, content, userName, new Date());
		return article;
	}

	/**
	 * find articles by id
	 * @param page
	 * @return
	 */
	public static Page<Article> findByPage(int page) {
		PagingList<Article> pagingList =   
				 find.orderBy("date desc").findPagingList(Consts.PageSize);  

		// get the row count in the background...  
		// ... otherwise it is fetched on demand  
		// ... when getTotalRowCount() or getTotalPageCount()   
		// ... is called  
		pagingList.getFutureRowCount();  

		Page<Article> result = pagingList.getPage(page);  
		return result;
	}
	
	public static Article findById(long id) {
		Article article = find.byId(id);
		return article;
	}
}
