### TRANSFER API

To run the project run:

1) mvn clean install

2) cd api

3) mvn exec:java


##### ENDPOINTS
```sh
curl -X POST http://localhost:8080/transfer -H 'content-type: application/json' -d ' { "sourceAcount":"joe","destinationAccount":"bob","value":50}'
  ```
