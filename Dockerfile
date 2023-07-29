FROM openjdk:17-oracle
EXPOSE 8080
ADD target/modifyz-merchant-be-docker.jar modifyz-merchant-be-docker.jar
ENTRYPOINT ["java","-jar","/modifyz-merchant-be-docker.jar"]