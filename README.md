# Project Title

BANK ACCOUT MANAGEMENT REST WEB SERVICE

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
Java 8
Linux OS
Mysql5.5 database
php5
```

```

### Installing
----preparing environment-----
Set your java home to point to your java8 folder location
i.e 
Open /etc/environment in any text editor like nano or gedit and add the following line:
JAVA_HOME="path to your java8 location"
type 'source /etc/environment' on terminal
Then check the variable, by running this command:
echo $JAVA_HOME
```
Clone or download the project

```

## Running the project

while inside the project folder, change directory to 'target'
on terminal, type java -jar BankWeb3-0.0.1-SNAPSHOT.jar
The service will start

### Testing the service

A test php file is located inside the project folder 'BankWebTest.php'

You can open by and make changes by uncommenting and commenting the url varaibles depending on the tests you want to carry out
Execute the command 'php BankWebTest.php' and the response will be printed on your terminal

```



## Built With

* [Spring](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management




## Author

* *Tim Mayabi** - *Initial work* - [BankWebService](https://github.com/timayabi2020/BankWebSpring)


