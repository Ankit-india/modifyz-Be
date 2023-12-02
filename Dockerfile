FROM openjdk:17-oracle
EXPOSE 7080
ADD target/modifyz-be-docker.jar modifyz-be-docker.jar
ENTRYPOINT ["java","-jar","/modifyz-be-docker.jar"]