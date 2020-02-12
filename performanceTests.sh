#!/bin/sh
[ -d "./performance-tests/target/gatling" ] && rm -r ./performance-tests/target/gatling && echo "Removing old gatling results"
[ -f "./results.txt" ] && rm results.txt && echo "Removing old results.txt"
cd performance-tests
echo "Starting simulation tests..."
mvn -nsu gatling:test > ../results.txt
if grep -q  'KO=[1-9]' ../results.txt; then
    echo "Responses were dropped :("
else 
    echo "No responses were dropped :)"
fi
echo "Done!"
