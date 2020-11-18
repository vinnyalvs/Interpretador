#!/bin/bash
#  Edson Lopes da Silva Júnior 201635023
#  Vinicius Alberto Alves da Silva 201665558C 

if [ -z "$1" ]; then antlr_jar="antlr-4.8-complete.jar" ; else antlr_jar=$1; fi

java -jar ./$antlr_jar -o ./parser/ -listener -visitor Lang.g4
javac -cp .:$antlr_jar ast/*.java parser/*.java  TypeCheck/*.java visitors/*.java LangCompiler.java -d .
java -classpath .:$antlr_jar LangCompiler -bs
find . -name "*.class" -delete
