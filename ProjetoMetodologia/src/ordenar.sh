#! /bin/bash

algoritmo=$1
input=$2
output=$3

javac main/Main.java

java -cp . main.Main $algoritmo $input $output
