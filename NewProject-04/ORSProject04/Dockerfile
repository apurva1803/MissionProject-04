FROM tomcat:11

RUN sed -i 's/port="8080"/port="8888"/g' /usr/local/tomcat/conf/server.xml

# Copy WAR file
COPY target/ORSProject04.war /usr/local/tomcat/webapps/ORSProject04.war

# Expose new port
EXPOSE 8888