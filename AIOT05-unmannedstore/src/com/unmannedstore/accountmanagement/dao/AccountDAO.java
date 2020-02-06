package com.unmannedstore.accountmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unmannedstore.accountmanagement.model.Account;


/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class AccountDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/unmannedstore?useSSL=false&serverTimezone=CST";
	private String jdbcUsername = "root";
	private String jdbcPassword = "egg50611";

	private static final String INSERT_ACCOUNT_SQL = "INSERT INTO account" + "  (name, password, email, phone, birthday, memberimg, membercode, memberrank, memberpoints) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SELECT_ACCOUNT_BY_EMAIL = "select id,name,password,email,phone,birthday,memberimg, membercode, memberrank, memberpoints from account where email =?";
	private static final String SELECT_ALL_USERS = "select * from account";
	private static final String DELETE_USERS_SQL = "delete from account where id = ?;";
	private static final String UPDATE_ACCOUNT_SQL = "update account set password =?,email= ?  where name = ?;";
	private static final String UPDATE_PASSWORD_SQL = "update account set password =? where email = ?;";
	private static final String UPDATE_MEMBERPOINTS_BY_MEMBERCODE = "update account set memberpoints =? where membercode = ?;";
	private static final String SELECT_MEMBERPOINTS_BY_MEMBERCODE = "select memberpoints from account where membercode =?";
	
	//P.105-P107
	public AccountDAO() {
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

	public void insertAccount(Account account) throws SQLException {
		System.out.println(INSERT_ACCOUNT_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL)) {
			preparedStatement.setString(1, account.getName());
			preparedStatement.setString(2, account.getPassword());
			preparedStatement.setString(3, account.getEmail());
			preparedStatement.setString(4, account.getPhone());
			preparedStatement.setString(5, account.getBirthday());
			preparedStatement.setString(6, account.getMemberimg());
			preparedStatement.setString(7, account.getMembercode());
			preparedStatement.setInt(8, account.getMemberrank());
			preparedStatement.setInt(9, account.getMemberpoints());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public Boolean checkmembercode(String membercode) {
		Boolean checkmembercode=false;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Accountmembercode=rs.getString("email");
				if(membercode.equals(Accountmembercode)) {
					checkmembercode=true;
					break;
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return checkmembercode;
	}
	public Boolean checkAccountByEmail(String email) {
		Boolean checkEmail=false;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String AccountEmail=rs.getString("email");
				if(email.equals(AccountEmail)) {
					checkEmail=true;
					break;
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return checkEmail;
	}
	
	public int selectMemberpointsByMembercode(String membercode) {
		int memberpoints=0;
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEMBERPOINTS_BY_MEMBERCODE);) {
			preparedStatement.setString(1, membercode);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			memberpoints=rs.getInt("memberpoints");
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return memberpoints;
	}
	
	public Account selectAccountByEmail(String email) {
		Account account = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL);) {
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name=rs.getString("name");
				String password = rs.getString("password");
				String phone=rs.getString("phone");
				String birthday=rs.getString("birthday");
				String memberimg=rs.getString("memberimg");
				String membercode=rs.getString("membercode");
				int memberrank=rs.getInt("rank");
				int memberpoints=rs.getInt("memberpoints");
				account = new Account(id,name, password, email, phone, birthday, memberimg, membercode, memberrank, memberpoints);		
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return account;
	}
	
	public List<Account> selectAllAccount() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Account> account = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name=rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone=rs.getString("phone");
				String birthday=rs.getString("birthday");
				String memberimg=rs.getString("memberimg");
				String membercode=rs.getString("membercode");
				int memberrank=rs.getInt("memberrank");
				int memberpoints=rs.getInt("memberpoints");
				
				account.add(new Account(id,name, password, email, phone, birthday, memberimg, membercode, memberrank, memberpoints));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return account;
	}

	public boolean deleteAccount(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updatePassword(String email,String password) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PASSWORD_SQL);) {
			statement.setString(1,password);
			statement.setString(2,email);
			System.out.println(statement);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean updateMemberpoints(int memberpoints,String membercode ) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MEMBERPOINTS_BY_MEMBERCODE);) {
			statement.setInt(1,memberpoints);
			statement.setString(2,membercode);
			System.out.println(statement);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean updateAccount(Account account) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT_SQL);) {
			statement.setString(1, account.getPassword());
			statement.setString(2, account.getEmail());
			statement.setString(3, account.getName());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
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
