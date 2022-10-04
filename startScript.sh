docker-compose build && docker-compose up -d
sleep 10
mvn test -Dtest=TestSandbox

