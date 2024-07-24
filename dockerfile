FROM openjdk:17
WORKDIR /app
COPY ./target/alchemy-research-facility.jar /app
EXPOSE 8080:8080
CMD ["java","-jar","alchemy-research-facility.jar"]
