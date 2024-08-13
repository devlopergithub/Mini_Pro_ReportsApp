FROM openjdk:17

COPY target/Reports_App.war /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java", "-jar", "Reports_App.war"]
