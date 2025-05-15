### Prerequisites for compilation
* JDK version: 17

### Execution commands for Mac/Linux
* ./gradlew build
* java -jar build/libs/qapital-0.0.1-SNAPSHOT.jar

#### OR
* Just run ./gradlew bootRun

If you get error related to port, make sure the port 8080 is free.


### API Usage

* Endpoint: http://localhost:8080/v1/portfolio/split
* Request Method: POST
* Content-Type: application/json

Here is an example Json body for POST request

````json
{
    "amount": 1000.00,
    "orderType": "BUY",
    "portfolio": {
        "AAPL": 0.2,
        "MSFT": 0.2,
        "GOOG": 0.2,
        "AMZN": 0.2,
        "TSLA": 0.2
    },
    "marketPrices": {
        "AAPL": 75.50,
        "MSFT": 228.75,
        "GOOG": 42.30,
        "AMZN": 78.60,
        "TSLA": 145.30
    }
}