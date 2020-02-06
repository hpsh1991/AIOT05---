package com.unmannedstore.temperature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class temperatureDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/unmannedstore?useSSL=false&serverTimezone=CST";
	private String jdbcUsername = "root";
	private String jdbcPassword = "raspberry";

	private static final String INSERT_TEMP_SQL = "INSERT INTO temperature" + "  (indoor_temp, humidity, drink01_temp, drink02_temp, drink03_temp, drink04_temp, MQ_2) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_TEMP = "select * from temperature";
	
	public temperatureDAO() {	
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
	
	public void insertTemp(temperature temperature) throws SQLException {
		System.out.println(INSERT_TEMP_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEMP_SQL)) {
			preparedStatement.setDouble(1, temperature.getIndoor_temp());
			preparedStatement.setDouble(2, temperature.getHumidity());
			preparedStatement.setDouble(3, temperature.getDrink01_temp());
			preparedStatement.setDouble(4, temperature.getDrink02_temp());
			preparedStatement.setDouble(5, temperature.getDrink03_temp());
			preparedStatement.setDouble(6, temperature.getDrink04_temp());
			preparedStatement.setString(7, temperature.getMQ_2());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<temperature> selectAllTemp() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<temperature> temperatures = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEMP);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				int id = rs.getInt("id");
				double indoor_temp=rs.getDouble("indoor_temp");
				double humidity=rs.getDouble("humidity");
				double drink01_temp=rs.getDouble("drink01_temp");
				double drink02_temp=rs.getDouble("drink02_temp");
				double drink03_temp=rs.getDouble("drink03_temp");
				double drink04_temp=rs.getDouble("drink04_temp");
				String mQ_2=rs.getString("mQ_2");
				String record_time=rs.getString("record_time");
				
				temperatures.add(new temperature(id, indoor_temp, humidity, drink01_temp, drink02_temp, drink03_temp, drink04_temp, mQ_2, record_time));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return temperatures;
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
