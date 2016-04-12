# Werewolf
Notification engine based on Quartz and Twillio

Tomcat Examples: http://stackoverflow.com/questions/19573457/simple-example-for-quartz-2-2-and-tomcat-7


Download the quartz distro from here: http://www.quartz-scheduler.org/downloads/
explode it and find the database schema files

Install, Config, Build examples: 

http://teknosrc.com/how-setup-quartz-scheduler-server-with-mysql-database/

https://www.javacodegeeks.com/2014/05/how-to-quartz-scheduler-with-clustering-in-jee-application-with-mysql.html

https://dzone.com/articles/getting-started-quartz



Project Tree: 

|   pom.xml
|
\---src
    \---main
        +---java
        |   \---com
        |       \---ioexcept
        |               \---werewolf
        |                       *.java
        |
        +---resources
        |       log4j.dtd
        |       log4j.xml
        |       quartz.properties
        |       quartz_data.xml
        |
        \---webapp
            |   index.jsp
            |
            \---WEB-INF
                    web.xml