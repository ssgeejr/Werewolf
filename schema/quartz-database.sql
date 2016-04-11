-- http://www.quartz-scheduler.org/documentation/quartz-2.x/tutorials/tutorial-lesson-09.html



-- http://saltnlight5.blogspot.com/2012/12/getting-started-with-quartz-scheduler.html

create database quartz2;
create user 'quartz2'@'localhost' identified by 'quartz2123';
grant all privileges on quartz2.* to 'quartz2'@'localhost';
flush privileges;
exit;

