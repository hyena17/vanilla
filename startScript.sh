docker-compose build && docker-compose up -d
sleep 5
mvn test -Dtest=TestSandbox

