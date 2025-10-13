package com.poly.test;

import java.sql.*;

import com.poly.util.JdbcPrepared;

public class TestPrepared {
	public static void main(String[] args) {
		// ví dụ SELECT
		try {
			String sql = "SELECT * FROM Departments WHERE Id = ?";
			Object[] values = { "D01" };
			ResultSet resultSet = JdbcPrepared.executeQuery(sql, values);
			while (resultSet.next()) {
				String value = resultSet.getString("Name");
				System.out.println(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ví dụ INSERT
		try {
			String sql = "INSERT INTO Departments (Id, Name, Description) VALUES (?, ?, ?)";
			Object[] values = { "D04", "Marketing", "Marketing Department" };
			int rows = JdbcPrepared.executeUpdate(sql, values);
			System.out.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ví dụ INSERT UPDATE
		try {
			String sql = "UPDATE Departments SET Name = ?, Description = ? WHERE Id = ?";
			Object[] values = { "Sales", "Sales and Customer Relations", "D04" };
			int rows = JdbcPrepared.executeUpdate(sql, values);
			System.out.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ví dụ DELETE
		try {
			String sql = "DELETE FROM Departments WHERE Id = ?";
			Object[] values = { "D04" };
			int rows = JdbcPrepared.executeUpdate(sql, values);
			System.out.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}