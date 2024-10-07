package com.sanjay.projects;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

import lombok.extern.slf4j.Slf4j;

//copy and paste in the same project from where want to run 
@Slf4j
public class DBConnection {

	// JDBC URL, username, and password of PostgreSQL server
	private static final String URL = "jdbc:postgresql://34.93.229.66:5432/unified-search-db";
	private static final String USER = "admin";
	private static final String PASSWORD = "ynPRrPQPSQ79hesi";

	public static void main(String[] args) {
        Connection connection = null;

        try {
        	
        	 // Example timestamps
            Instant lastModifiedOn = Instant.parse("2023-08-07T12:00:00Z");
            Instant last_modified_on = Instant.parse("2024-08-07T12:00:00Z");

            // Compare timestamps
            if (last_modified_on.isAfter(lastModifiedOn)) {
                System.out.println("last_modified_on is after lastModifiedOn.");
            } else {
                System.out.println("last_modified_on is not after lastModifiedOn.");
            }
            // Register the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Execute a query
            String query = "select last_modified_on FROM public.job_failure where error_message != 'STALE_DATA' and retry_count > 3 order by last_modified_on desc limit 1";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();
//				log.info(resultSet.toString());
                // Process the result set
                while (resultSet.next()) {
                    // Assuming your_table_name has a column named "column_name"
                    String columnValue = resultSet.getString("last_modified_on");
                    System.out.println("Column Value: " + columnValue);
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}