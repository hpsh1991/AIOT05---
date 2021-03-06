package com.unmannedstore.shoppingcart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class goodsDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/unmannedstore?useSSL=false&serverTimezone=CST";
	private String jdbcUsername = "root";
	private String jdbcPassword = "raspberry";
	
	private static final String SELECT_ALL_GOODS = "select * from goods";
	private static final String SELECT_GOODS_BY_ID = "select id, name, price, quantity, information, sales, img from goods where id =?";
	
	public goodsDAO() {
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public List<goods> selectAllgoods() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<goods> goods = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GOODS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price=rs.getInt("price");
				int quantity=rs.getInt("quantity");		
				String information = rs.getString("information");
				int sales=rs.getInt("sales");
				String img = rs.getString("img");
				goods.add(new goods(id, name, price, quantity, information, sales, img));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return goods;
	}
	
	public goods selectGoodsByID(int id) {
		goods goods=null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GOODS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				String information = rs.getString("information");
				int sales = rs.getInt("sales");
				String img = rs.getString("img");
				goods = new goods(id, name, price, quantity, information, sales, img);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return goods;
	}

	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
