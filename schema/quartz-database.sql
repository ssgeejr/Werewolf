create database quartz2;
create user 'quartz2'@'localhost' identified by 'quartz2123';
grant all privileges on quartz2.* to 'quartz2'@'localhost';
flush privileges;
exit;

-- mysql -u quartz2 -p quartz2123 < /path/to/quartz-dist/docs/dbTables/tables_mysql.sql
-- for this project ... 
-- mysql -u quartz2 -p quartz2123 < schema/dbTables/tables_mysql_innodb.sql



