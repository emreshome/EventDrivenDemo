

## Usage

Clone the repository, run `mvn clean package -DskipTests` , then `run docker-compose up --build`

Some services may restart on failure during docker-compose step, they will eventually start successfully when other services are successfully started.

Here list of services will be deployed. Only Producer service has port forwarding, which is 8080 in order to consume API.

    - Consumer Service
    - Producer Service
    - Apache Kafka
    - Zookeper
    - Cassandra

8080 port consumes only Http POST method with query parameters name, lastname and followers(All required).

```
POST http://localhost:8080?name=emre&lastname=eren&followers=some_id_1,some_id_2
```

Producer service will create new entry in the user table and then send message to consumer service.
When consumer service receives message it will create new entry in **user_follower** table.