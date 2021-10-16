# java

runner for java applications
in java-command
> javac JavaCommand.java
> java JavaCommand

# cmd line arguments
arguments for program

in cmd-line-arguments-command
> javac CommandLineArguments.java
> java CommandLineArguments 10 20 30

# javadoc
api docs generator javadoc [options] [packagenames] [sourcefiles] [@files]

in javadoc-command
> javac JavaDocumentation.java
> javadoc -d ./javadoc JavaDocumentation.java 

run javadoc in gradle / maven  Windows: For example, if you want to document com.mypackage, whose source files reside in the directory \user\src\com\mypackage, and if this package relies on a library in \user\lib, then you would use the following command:

javadoc -sourcepath \user\lib -classpath \user\src com.mypackage

Similar to other tools, if you don't specify -classpath, then the javadoc command uses the CLASSPATH environment variable when it's set. If both aren't set, then the javadoc command searches for classes from the current directory.

# jar
create and manages jar

- create a jar file

in jar-command
create file CreateAJarFile.java

> javac CreateAJarFile.java
> jar -cvf MyJarFile.jar CreateAJarFile.class
> cd ..
> java -cp ./jar-command/MyJarFile.jar CreateAJarFile 

# display content of jar

> jar -tvf MyJarFile.jar jar -xvf SampleWebApp.war


# visual vm
download visualvm https://visualvm.github.io/index.html
install visualvm intellij plugin
configure visualvm intellij plugin