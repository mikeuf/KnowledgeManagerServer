/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.knowledgemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author cyclops
 */
@WebService(serviceName = "DbInterface")
@Stateless()
public class DbInterface {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "phlogiston";
	private static final String PASSWORD = "pTbontb$2n";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/km?autoReconnect=true&useSSL=false";

	/**
	 * This is a sample web service operation
	 */
	@WebMethod(operationName = "hello")
	public String hello(@WebParam(name = "name") String txt) {
		return "Hello " + txt + " !";
	}

	@WebMethod(operationName = "businessMethod")
	public List<String> businessMethod(int articleId) {

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
			list.add(ex.toString());
		}
		return list;
	}

	@WebMethod(operationName = "saveArticle")
	public boolean saveArticle(List<String> list) {

		//	List<String> list = new ArrayList();

		/*		if (articleId < 1) {
			System.out.println("No article ID provided.");
			return list;
		}*/
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

			System.out.println("Hello from saveArticle");

			PreparedStatement stmt = con.prepareStatement("UPDATE Article SET title = ?, problem = ?, solution = ? WHERE id = ?");
			stmt.setString(1, list.get(1));
			stmt.setString(2, list.get(2));
			stmt.setString(3, list.get(3));
			stmt.setInt(4, Integer.parseInt(list.get(0)));

			stmt.executeUpdate();

			con.commit();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
			list.add(ex.toString());
			return false;
		}
		return true;
	}

	@WebMethod(operationName = "newArticle")
	public int newArticle() {

		ResultSet rs = null;
		int lastArticle = 0;

		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

			System.out.println("Hello from saveArticle");

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
