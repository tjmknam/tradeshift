# tradeshift
This project includes three docker images and it uses POSTGRES DB with the default port 5432. Use sample/sample123 to test this application.


# Build with the following command
mvn clean install

# Flow
.war file will be generated and it can be deployed to any server web container like tomcat


# Deploy with Docker
'docker-compose up' will start 3 docker containers. One with tomcat, one with PostgreSQL, and one with database data
