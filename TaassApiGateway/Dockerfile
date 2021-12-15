FROM openjdk:11
#VOLUME ["/app"]
EXPOSE 8081
ARG DEPENDENCY=target
ADD ${DEPENDENCY}/*.jar TaassApiGateway.jar
ENTRYPOINT ["java","-jar","TaassApiGateway.jar"]