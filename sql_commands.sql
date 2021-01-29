-- SHOW DATABASES
SELECT name, database_id, create_date FROM sys.databases;
GO
-- SHOW TABLES
SELECT * FROM INFORMATION_SCHEMA.TABLES;
-- execute script from terminal
-- sqlcmd -S localhost -i -U SA -P 'Qwer!234' path_to_script