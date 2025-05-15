### What was your approach (thought process) to tackling this project?
I started by carefully analyzing both functional and technical requirements to ensure I understood what we needed to build. The core task was to create an API that takes a model portfolio and amount, then returns the split orders with stock quantities based on allocation percentages. Since this is a prototype project, I made it modular enough for future expansion.

### What assumptions did you make?
* Client supports JSON format for request/response body
* currency will always be USD
* Total of model portfolio fractions will always be 1
* When allocating stock quantity I have to make sure the final value does not go above allocated portfolio value. It is okay if its slightly less. For example if stock value in portfolio is 200. but due to fractions cost ends up being 200.04, I should reduce stock quantity to lower it to 200 or less. 
* Decimal places and Default stock price are configured internally

### What challenges did you face when creating your solution?
* Figure out how much close to production code I can do in 2 hours.
* Data type for fractions.
* Handling fraction properly to round up stock
* Api request/response model


### If you were to migrate your code from its current standalone format to a fully functional production environment, what are some changes and controls you would put in place?
* Implement HTTPS enforcement and CORS policy 
* Configure build flavors and log levels with proper logging framework
* Implement stricter input validations
* Use authentication (OAuth or JWT or any existing auth architecture at Qapital)
* make Decimal places and Default stock price externally configurable
* Implement api rate-limiter per client or per user
* Implement health check and monitoring endpoints


