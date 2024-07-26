FROM openjdk:17
WORKDIR /app
COPY ./target/alchemy-research-facility-3.3.2.jar /app
CMD ["java","-jar","alchemy-research-facility-3.3.2.jar"]
