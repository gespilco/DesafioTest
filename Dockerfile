FROM openjdk:8
ADD target/exchange-rate.jar exchange-rate.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "exchange-rate.jar"]