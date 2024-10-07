package com.sanjay.projects;

import java.util.List;

public class testing {

	public static void main(String[] args) {

		String tableDataAuditArchive = "epro_plan_template_id,\r\n" + "epro_plan_master_id,\r\n"
				+ "epro_questionnaire_master_id,\r\n" + "epro_plan_template_name,\r\n" + "occurence_interval,\r\n"
				+ "order_number,\r\n" + "recurrence,\r\n" + "occurence_interval_unit,\r\n" + "created_on,\r\n"
				+ "created_by,\r\n" + "last_modified_on,\r\n" + "last_modified_by";
		// Split the string by comma
		String[] fields = tableDataAuditArchive.split(",\\r\\n");

		// Add "old_" prefix to each field
		StringBuilder modifiedFields = new StringBuilder();
		
		for (String field : fields) {
			System.out.println(field.toString());
			modifiedFields.append("old_").append(field).append(",\r\n");
		}

		// Convert StringBuilder back to String
		String modifiedTableDataAuditArchive = modifiedFields.toString();
		System.out.println("======================================");
		System.out.println(tableDataAuditArchive);
		System.out.println("======================================");
		System.out.println(modifiedTableDataAuditArchive);
	}
	

	public static String extractColumns(String sqlCreateTable) {
		// Initialize the output StringBuilder
		StringBuilder columnsBuilder = new StringBuilder();

		// Find the start and end of the column definitions
		int startIndex = sqlCreateTable.indexOf('(') + 1;
		int endIndex = sqlCreateTable.indexOf(')');

		// Extract the columns section
		String columnsSection = sqlCreateTable.substring(startIndex, endIndex).trim();

		// Split by new lines to process each line individually
		String[] lines = columnsSection.split("\n");

		for (String line : lines) {
			// Trim whitespace and skip empty lines
			line = line.trim();
			if (line.isEmpty() || line.startsWith("CONSTRAINT")) {
				continue;
			}

			// Add each column definition to the output
			columnsBuilder.append(line).append("\n");
		}

		return columnsBuilder.toString().trim();
	}
}
