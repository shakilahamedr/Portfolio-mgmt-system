FROM public.ecr.aws/amazoncorretto/amazoncorretto:11
EXPOSE 8082
ADD target/DailySharePrice-0.0.1-SNAPSHOT.jar dailyshareprice.jar
CMD ["java","-jar","/dailyshareprice.jar"]