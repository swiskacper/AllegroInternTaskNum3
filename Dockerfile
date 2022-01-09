FROM openjdk:11
ADD target/appSpr-0.0.1-SNAPSHOT.jar .
EXPOSE 9090
CMD java -jar appSpr-0.0.1-SNAPSHOT.jar