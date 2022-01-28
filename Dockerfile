FROM openjdk:11
ARG JAR_FILE=build/libs/TourGuidepricer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} TourGuidepricer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/TourGuidepricer-0.0.1-SNAPSHOT.jar"]
EXPOSE 9008