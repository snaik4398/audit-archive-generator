This repo is used to create the audit archive script of the table according to liquibase.

<liquibase-version>4.6.2</liquibase-version>

			<!-- Liquibase -->
			<dependency>
				<groupId>org.liquibase</groupId>
				<artifactId>liquibase-core</artifactId>
				<version>${liquibase-version}</version>
			</dependency>
   =======================================================
template folder : 
DB/Liquibase-Auidt-Archive-template.txt
DB/Liquibase-Trigger-Template.txt

generate output will be on output table.


inside the "table-script.txt" need to add the  script of the table content with out the constrain 

