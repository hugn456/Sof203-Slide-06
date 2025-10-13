package com.poly.test;
import java.sql.*;
import com.poly.util.JdbcStatement;

public class TestStatement {
	public static void main(String[] args) {
		try {
			String sql = "SELECT * FROM Departments";
			ResultSet rs = JdbcStatement.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("Id") + " - " + rs.getString("Name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String insert = "INSERT INTO Departments VALUES('D01', N'HR', N'Human Resources')";
			int rows = JdbcStatement.executeUpdate(insert);
			System.out.println(rows + " row(s) inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}