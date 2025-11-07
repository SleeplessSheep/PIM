#!/bin/bash
# PIM Build and Run Script for Linux/Mac

# Clean build directory
echo "Cleaning build directory..."
rm -rf build/*

# Create build directory structure
mkdir -p build

# Compile Model classes
echo "Compiling Model classes..."
javac -d build src/Model/*.java

# Compile View classes
echo "Compiling View classes..."
javac -cp build -d build src/View/*.java

# Compile Controller classes
echo "Compiling Controller classes..."
javac -cp build -d build src/Controller/*.java

# Compile Main class
echo "Compiling Main class..."
javac -cp build -d build src/*.java

# Run the application
echo "Starting PIM application..."
echo "======================================"
java -cp build Main
