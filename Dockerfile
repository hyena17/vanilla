FROM adoptopenjdk/maven-openjdk11
COPY . .
CMD mvn test -Dtest=TestSandbox
