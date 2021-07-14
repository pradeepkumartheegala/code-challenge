# ECommerce Code Challenge API

**Problem :**
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

**NOTES**
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

**EXAMPLES:**
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes

### Prerequisites

- JDk 1.8 or higher
- Eclipse or any IDE 
- Postman to test APIs

### Tech Stack

- Java
- Maven
- SpringBoot
- Swagger

### Running

if you run application as Java Application or SpringBoot App, its going to deployed on default port 8080 in embeded tomcat server

You can change the port number by configuring the value for server.port in application.properties file.

Once started , you can see that Only one API are created with  following requests and responses
 /codeRanges method type of Post.
 
### Example

```
Swagger Url:
http://localhost:8080/swagger-ui.html#!/code45ranges45controller/getMinimumNumbersRangeUsingPOST
```
 
Request: [[94133,94133], [94200,94299], [94600,94699]]

Response:
[
  [
    94133,
    94133
  ],
  [
    94200,
    94299
  ],
  [
    94600,
    94699
  ]
]

To Run test cases you can use mvn test command or right click and run as Junit in eclipse
