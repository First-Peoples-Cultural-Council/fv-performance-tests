#!/bin/sh
[ -d "./performance-tests/target/gatling" ] && rm -r ./performance-tests/target/gatling && echo "Removing old gatling results"
[ -f "./results.txt" ] && rm results.txt && echo "Removing old results.txt"
cd performance-tests
echo "Starting simulation tests..."
mvn -nsu gatling:test | tee ../results.txt
if grep -q  'KO=[1-9]' ../results.txt; then
    echo "Responses were dropped :("
else 
    echo "No responses were dropped :)"
fi
if grep -q "mean response time *[5-9][0-9][0-9][0-9]" ../results.txt; then
    echo "Mean response time was unacceptable"
elif grep -q "mean response time *[0-9]*[0-9][0-9][0-9][0-9][0-9]" ../results.txt; then
    echo "Mean response time was unacceptable"
else
    echo "Mean response time for all responses was acceptable"
fi

echo "Done!"
