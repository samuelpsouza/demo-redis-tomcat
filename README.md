# POC Redis and Tomcat

The problem behind this POC was caused by a stateful application. The Struts application persisted much information on sessions such as quiz progress and timestamps. The problem was that the application did not persist the session in an external service, and when the container was restarted, all tomcat sessions were lost and consequently the user's information. The idea to solve the problem was to use Redis to persist session. When a container restarts, the user session is restored from Redis.
