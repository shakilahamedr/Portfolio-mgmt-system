FROM public.ecr.aws/amazoncorretto/amazoncorretto:11
EXPOSE 8081
ADD target/Authorization-0.0.1-SNAPSHOT.jar authorization.jar
CMD ["java","-jar","/authorization.jar"]