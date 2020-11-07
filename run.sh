#!/bin/bash
#  Edson Lopes da Silva Júnior 201635023
#  Vinicius Alberto Alves da Silva 201665558C 

if [ -z "$1" ]; then antlr_jar="antlr-4.8-complete.jar" ; else antlr_jar=$1; fi

java -jar ./$antlr_jar -o ./parser/ Lang.g4
javac -cp .:$antlr_jar ast/*.java parser/*.java LangCompiler.java -d .
java -classpath .:$antlr_jar lang.LangCompiler -bs