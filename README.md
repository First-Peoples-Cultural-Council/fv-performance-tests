# fv-performance-tests
Repo to store Gatling and other performance tests

To use, enter performance-tests and run  mvn -nsu gatling:test

## Tests

### StaticResourceTest
Fetches a static resource (logo-fpcc-white.png).

Should be able to handle a standard test load (100 users over 10 seconds) with all response under 1200 ms.

### DocenrichQueryTest
Performs a Document Enriched Query over the set of FVCharacters.

Should be able to handle a standard test load (100 users over 10 seconds) without dropping a single respomse.