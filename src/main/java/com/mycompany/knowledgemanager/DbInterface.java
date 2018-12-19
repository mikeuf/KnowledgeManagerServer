package com.mycompany.knowledgemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 * DbInterface.java
 * 
 * This is used by the client to load and save articles to the database
 */
@WebService(serviceName = "DbInterface")
@Stateless()
public class DbInterface {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "phlogiston";
	private static final String PASSWORD = "pTbontb$2n";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/km?autoReconnect=true&useSSL=false";

	/**
	 * Loads an article from the database
	 * @param The ID of the article to be loaded
	 * @return The article, as a list of fields
	 */
	@WebMethod(operationName = "loadArticle")
	public List<String> loadArticle(int articleId) {

		List<String> list = new ArrayList();

		if (articleId < 1) {
			System.out.println("No article ID provided.");
			return list;
		}

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM `Article` WHERE `id` = (?)");
			stmt.setInt(1, articleId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				//	list.add(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4));
				list.add(Integer.toString(rs.getInt(1)));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return list;
	}

		/**
	 * Saves an article to the database
	 * @param The article as a list of fields
	 */
	@WebMethod(operationName = "saveArticle")
	public void saveArticle(List<String> list) {

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

			//	PreparedStatement stmt = con.prepareStatement("UPDATE Article SET title = ?, problem = ?, solution = ? WHERE id = ?");
			PreparedStatement stmt = con.prepareStatement(""
							+ "INSERT INTO Article (id, title, problem, solution)"
							+ "VALUES (?,?,?,?)"
							+ "ON DUPLICATE KEY UPDATE title=?, problem=?, solution=?");
			stmt.setInt(1, Integer.parseInt(list.get(0)));
			stmt.setString(2, list.get(1));
			stmt.setString(3, list.get(2));
			stmt.setString(4, list.get(3));
			stmt.setString(5, list.get(1));
			stmt.setString(6, list.get(2));
			stmt.setString(7, list.get(3));

			stmt.executeUpdate();

			con.commit();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	/**
	 * Starts a new article and clears the fields
	 * @return The highest current article ID
	 */
	@WebMethod(operationName = "newArticle")
	public int newArticle() {

		ResultSet rs = null;
		int lastArticle = 0;

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

			PreparedStatement stmt = con.prepareStatement("SELECT MAX(id) FROM Article");

			rs = stmt.executeQuery();
			rs.next();
			lastArticle = rs.getInt(1);
			if (lastArticle < 1) {
				return 1;
			}

			con.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return lastArticle;

	}

}
