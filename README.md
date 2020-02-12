# fv-performance-tests
Repo to store Gatling and other performance tests

To use, run `./performanceTests.sh`. 

## Tests

All of the tests are run on preprod.firstvoices.com

### AlphabetTest
Loads the entire Dene Alphabet page (chosen for its public availabilty and large alphabet size of 70 characters).

Should be able to handle a reduced test load (30 users over 10 seconds) without dropping a single response.

### DocEnrichQueryTest
Performs a Document Enriched Query over the set of FVCharacters.

Should be able to handle a standard test load (100 users over 10 seconds) with the mean response time under 6000 ms without dropping a single response.

### GalleryTest
Loads a Gallery Image from the Homalco Dialect (chosen for its public availability).

Should be able to handle a reduced test load (30 users over 10 seconds) without dropping a single response.

### StaticResourceTest
Fetches a static resource (logo-fpcc-white.png).

Should be able to handle a standard test load (100 users over 10 seconds) with all responses under 1200 ms and without dropping a single response.

### WordPhraseSearchTest
Loads the Word page and Phrase page for Dene and searches for 'den'.

Should be able to handle a reduced test load (30 users over 10 seconds) without dropping a single response.