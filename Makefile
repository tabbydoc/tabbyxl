.PHONY: assembly-single single jar install build compile clean all run

VERSION=0.1
JAR=target/tabbyxl.jar
SRC=$(shell find src -name "*.java")

all: assembly-single

jar: assembly-single

single: assembly-single

assembly-single: $(JAR)

$(JAR): $(SRC)
	mvn clean compile assembly:single

compile:
	mvn compile

build: install

install:
	mvn install

clean:
	mvn clean
	# Also remove "out" and everything under it.
	rm -rf out/

run: assembly-single
	./tabbyxl.sh