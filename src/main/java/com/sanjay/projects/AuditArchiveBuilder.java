package com.sanjay.projects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AuditArchiveBuilder {

	private static final String AUTHOR = "{{author}}";
	private static final String CURRENT_DATE = "{{current_date}}";
	private static final String OLD_TABLE_DATA_AUDIT_ARCHIVE = "{{old_table_data_audit_archive}}";
	private static final String TABLE_DATA_AUDIT_ARCHIVE = "{{table_data_audit_archive}}";
	private static final String TABLE_DATA = "{{table_data}}";
	private static final String OWNER = "{{owner}}";
	private static final String TABLE_NAME = "{{table_name}}";
	private static final String HYPHEN = "-";
	private static final String UNDERSCORE = "_";
	private static final String OLD_PREFIX = "old.";
	

	public static void main(String[] args) throws IOException {
//		to get the all the column name from DB 

//		SELECT column_name, data_type
//		FROM information_schema.columns
//		WHERE table_schema = 'public' AND table_name = 'epro_plan_template';

		// Variables to replace in the template

//		current_date

//		author

		String SUFFIX_NUMBER_AUDIT = "00";
		String SUFFIX_NUMBER_TRIGGER = "01";
//		original_table_Script : original table script 
		String author = "Sanjay".toLowerCase(); // Sanjay
		String current_date = "2024-10-07"; // 2024-09-05

		String tableName = "epro_plan".toLowerCase(); // table name
		String owner = "admin"; // Owner name
		String originalTableScriptFilePath = "DB/table-script.txt"; // Script of the table

		String tableDataAuditArchive = "epro_plan_id,\r\n"
				+ "epro_plan_master_id,\r\n"
				+ "patient_id,\r\n"
				+ "case_id,\r\n"
				+ "encounter_type_id,\r\n"
				+ "cross_reference_id,\r\n"
				+ "cross_reference_type,\r\n"
				+ "schedule_date,\r\n"
				+ "assigned_to,\r\n"
				+ "status,\r\n"
				+ "status_change_reason,\r\n"
				+ "status_changed_on,\r\n"
				+ "status_changed_by,\r\n"
				+ "extension,\r\n"
				+ "created_on,\r\n"
				+ "created_by,\r\n"
				+ "last_modified_on,\r\n"
				+ "last_modified_by"; // Example

		// Convert StringBuilder back to String
		String oldTableDataAuditArchive = extracted(tableDataAuditArchive);

		// Paths to the template files
//		String auidtArchiveTemplatePath = "DB/Auidt-Archive-template.txt";
//		String triggerTemplatePath = "DB/Trigger-Template.txt";

		// liquibase
		String auidtArchiveTemplatePath = "DB/Liquibase-Auidt-Archive-template.txt";
		String triggerTemplatePath = "DB/Liquibase-Trigger-Template.txt";

		// Paths to the output files
		String auditArchiveOutputPath = "DB/output/" + SUFFIX_NUMBER_AUDIT + HYPHEN
				+ tableName.replace(UNDERSCORE, HYPHEN) + "-audit-archive-tables.sql";
		String triggerOutputPath = "DB/output/" + SUFFIX_NUMBER_TRIGGER + HYPHEN + tableName.replace(UNDERSCORE, HYPHEN)
				+ "-triggers.sql";

		// Perform the replacements and save the modified files
		replaceAndSaveTemplate(auidtArchiveTemplatePath, auditArchiveOutputPath, tableName, owner,
				originalTableScriptFilePath, tableDataAuditArchive, oldTableDataAuditArchive, author, current_date);
		replaceAndSaveTemplate(triggerTemplatePath, triggerOutputPath, tableName, owner, originalTableScriptFilePath,
				tableDataAuditArchive, oldTableDataAuditArchive, author, current_date);

	}

	private static String extracted(String tableDataAuditArchive) {
		// Split the string by comma
		String[] fields = tableDataAuditArchive.split(",\\r\\n");

		// Add "old_" prefix to each field
		StringBuilder modifiedFields = new StringBuilder();
		for (String field : fields) {
			modifiedFields.append(OLD_PREFIX).append(field).append(",\r\n");
		}
		return modifiedFields.toString();
	}

	private static void replaceAndSaveTemplate(String auditTemplatePath, String auditOutputPath, String tableName,
			String owner, String originalTableScriptFilePath, String tableDataAuditArchive,
			String oldTableDataAuditArchive, String author, String current_date) {
		try {
			// Read the template content
			String content = new String(Files.readAllBytes(Paths.get(auditTemplatePath)));
			String originalTableScript = new String(Files.readAllBytes(Paths.get(originalTableScriptFilePath)));

			// Replace placeholders with actual values
			content = content.replace(TABLE_NAME, tableName).replace(OWNER, owner)
					.replace(TABLE_DATA, originalTableScript).replace(TABLE_DATA_AUDIT_ARCHIVE, tableDataAuditArchive)
					.replace(OLD_TABLE_DATA_AUDIT_ARCHIVE, oldTableDataAuditArchive).replace(AUTHOR, author)
					.replace(CURRENT_DATE, current_date);

			// Save the modified content back to the file
			Files.write(Paths.get(auditOutputPath), content.getBytes());

			System.out.println("Successfully updated " + auditOutputPath);
		} catch (IOException e) {
			System.out.println("An error occurred while updating " + auditOutputPath);
			e.printStackTrace();
		}
	}
}
