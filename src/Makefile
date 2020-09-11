# THIS IS A MAKEFILE FOR PLANE - EMPLOYEE APP
JFLAGS=-g
JC=javac
JVM=java

.SUFFIXES:.java.class

.java.class:
	$(JC)$(JFLAGS)$*.java


CLASSES = Main.java

MAIN= Main

default:classes

classes:$(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN)

clean:
	$(RM) main/*.class
	$(RM) planes/*.class
	$(RM) employees/*.class
	$(RM) counter/*.class
