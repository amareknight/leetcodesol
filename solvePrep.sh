#!/bin/bash
problemStr=$1
result="${problemStr// /}"
mkdir "src/$result"
echo "package ${result};" > "src/${result}/Solution.java"
mkdir "test/$result"
echo "package ${result};\nimport org.junit.Test;\nimport org.junit.Assert.*;\n" > "test/${result}/SolutionTest.java"
