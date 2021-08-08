# next_highest_number_with_same_digits
### Decription  
This repository contains the Java complied code for finding the next highest number with the same digits. This program works for both positive and negative integers. If the next highest number can be determined then the output will be printed on the console else ```No output``` will be printed. This program takes the input through command line arguments.

#### File description
- ```Main.java``` - This is the main file which contains the logic implementation
-   ```TestDigits.java``` - This file contains the all the test case for various scenarious
-   ```TestRunner.java``` - This is the JUnit test runner.

#### Commands to execute the project

##### To compile the source files, use the below command in the terminal or command prompt.

```javac Main.java TestDigits.java TestRunner.java```


##### To execute the test cases using test runner, use the below command in the terminal or command prompt.

```java TestRunner ```

##### To execute the main file, use the below command in the terminal or command prompt.

Program takes the input through command line arguments. Below are the few sample cases.

##### Sample case 1:
- Command: ```java Main 12345 ```

- Output: ```12354```

##### Sample case 2:
- Command: ```java Main 54321 ```

- Output: ```No output```

##### Sample case 3:
- Command: ```java Main -12345 ```

- Output: ```No output```

##### Sample case 4:
- Command: ```java Main -54321 ```

- Output: ```-54312```
