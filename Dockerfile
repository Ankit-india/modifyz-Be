FROM openjdk:17-oracle
EXPOSE 7080
ADD target/modifyz-merchant-be-docker.jar modifyz-merchant-be-docker.jar
ENTRYPOINT ["java","-jar","/modifyz-merchant-be-docker.jar"]