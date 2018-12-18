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
		public List businessMethod(int articleId) {


		
		List list = new ArrayList();

				if (articleId < 1) {
			System.out.println("No article ID provided.");
			return list;
		}
		
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

		//	Statement stmt = con.createStatement();
		//	ResultSet rs = stmt.executeQuery("SELECT * FROM Article");
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM `Article` WHERE `id` = (?)");
			stmt.setInt(1, articleId);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				list.add(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4));
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
			list.add(ex.toString());
		}
		return list;
	}
}
	
	

