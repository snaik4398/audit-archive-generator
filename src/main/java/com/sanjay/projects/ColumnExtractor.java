package com.sanjay.projects;

import java.util.ArrayList;
import java.util.List;

public class ColumnExtractor {

	public static void main(String[] args) {
		// Define the input table data as a string
		String tableData = "(\r\n" + "    appointment_doctor_id text COLLATE pg_catalog.\\\"default\\\" NOT NULL,\r\n"
				+ "    user_id text COLLATE pg_catalog.\\\"default\\\",\r\n"
				+ "    practitioner_id text COLLATE pg_catalog.\\\"default\\\",\r\n"
				+ "    appointment_id text COLLATE pg_catalog.\\\"default\\\",\r\n"
				+ "    created_by text COLLATE pg_catalog.\\\"default\\\",\r\n"
				+ "    created_on timestamp without time zone,\r\n"
				+ "    last_modified_by text COLLATE pg_catalog.\\\"default\\\",\r\n"
				+ "    last_modified_on timestamp without time zone,\r\n"
				+ "    CONSTRAINT {{table_name}}_pkey PRIMARY KEY ({{table_name}}_id)\r\n" + ")";

		// Call the function to extract column names
		List<String> extractedColumns = extractColumnNames(tableData);

		// Print the extracted column names
		System.out.println(extractedColumns);
	}

	public static List<String> extractColumnNames(String tableData) {
		// Split the input data by new lines to process each line
		String[] lines = tableData.split("\\r?\\n");
		List<String> columns = new ArrayList<>();

		// Loop through each line and extract the first word (column name)
		for (String line : lines) {
			// Skip the line if it contains the word "CONSTRAINT"
			if (line.trim().startsWith("CONSTRAINT")) {
				continue;
			}

			// Extract the first word before any space or comma
			String columnName = line.split("[\\s,]+")[0].trim();
			columns.add(columnName);
		}

		return columns;
	}
}
