# Pull base image

FROM tomcat:8-jre8

ADD tomcat-users.xml C:/Program Files/Apache Software Foundation/Tomcat 8.0
ADD context.xml C:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/manager/META-INF/context.xml
ADD build/libs/ProjectManagerServiceBoot.war C:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps

CMD ["catalina.sh", "run"]

EXPOSE 8080