# Task
- Merge Overlapping Intervals with test.
- - 1) Intervals it is tuple;
- - 2) For example: 
          at the input of your function an unordered array of tuples 
          [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)],
          then at the output you should get an ordered array [(0, 1), (3, 8), (9, 12)].
          
## hOW tO rUn
```
$ git clone https://github.com/ArSiu/AlgoLabs.git
$ cd AlgoLabs
$ git checkout lab3
$ java Calendar.java (0,1),(3,5),(4,8),(10,12),(9,10)
```

## hOW tO rUn test
download junit.jar(https://sourceforge.net/projects/junit/)
```
$java -cp C:\Users\ars\Desktop\JUNIT\junit-4.10.jar org.junit.runner.JUnitCore CalendarTest.java
```
## Output
```
Input Ranges: 
 (0,1)  (3,5)  (4,8)  (10,12)  (9,10) 
Merge Ranges: 
 (0,1)  (3,8)  (9,12) 
```

## Pre-requirements
java 14.0.1 or above

<details>
<summary>How do I install JUnit?</summary>
1.First, download the latest version of JUnit, referred to below as junit.zip.</br>
2.Then install JUnit on your platform of choice:  </br>
<h2>Windows</h2></br>
To install JUnit on Windows, follow these steps:</br>

1. Unzip the junit.zip distribution file to a directory referred to as %JUNIT_HOME%.</br></br>

2. Add JUnit to the classpath:</br>
```
set CLASSPATH=%CLASSPATH%;%JUNIT_HOME%\junit.jar</br>
```

<h2>Unix (bash)</h2></br>
To install JUnit on Unix, follow these steps:</br>

1. Unzip the junit.zip distribution file to a directory referred to as $JUNIT_HOME.</br>

2. Add JUnit to the classpath:</br>

```
export CLASSPATH=$CLASSPATH:$JUNIT_HOME/junit.jar</br>
```


<h2>(Optional) Unzip the $JUNIT_HOME/src.jar file.</h2></br>
4.Test the installation by running the sample tests distributed with JUnit. </br>
Note that the sample tests are located in the installation directory directly, not the junit.jar file. </br>
Therefore, make sure that the JUnit installation directory is on your CLASSPATH. </br></br>

Then simply type:</br> 
```
java org.junit.runner.JUnitCore org.junit.tests.AllTests
```

All the tests should pass with an "OK" message.</br>

If the tests don't pass, verify that junit.jar is in the CLASSPATH.</br>
</details> </br>

<details>
<summary>༼ つ ಥ_ಥ ༽つ</summary>
<p>
(https://youtu.be/fEiNQuzyfa4)
  
```java
БОШЕНТУНМАЙ
```
</p>
</details> 
