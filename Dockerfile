FROM tomcat:alpine

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY ./target/demo-redis-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
COPY ./lib/ /usr/local/tomcat/lib/
COPY ./deploy/context.xml /usr/local/tomcat/config/context.xml
COPY ./deploy/redisson.conf /usr/local/tomcat/redisson.conf