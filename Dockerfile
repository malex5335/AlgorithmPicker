FROM gradle:alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build

FROM openjdk:17-alpine

COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar
COPY --from=build /home/gradle/src/src/main/resources/* /src/main/resources/

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]