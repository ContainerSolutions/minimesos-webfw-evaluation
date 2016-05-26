This repo evaluates 3 Java web frameworks for startup time and executable size. We are going for a lightweight framework because it will be launched with every test. Memory usage was only verified manually but correlates with the executable size.

* Spring Boot with Spring MVC
* Spark
* Vert.x

We build an executable jar file from each of them and measure the time required until they start up. Successful startup is determined by getting a successful response to an HTTP request. See the `RestServerStartupTest.groovy` script for the implementation of a single test run and BuildAndRun.groovy for building and running all 3 applications 10 times (building is only done once).

Use the command `groovy BuildAndRun.groovy` to do the full run.

Use the command `groovy RestServerStartupTest.groovy [path_to_jar] [framework_name]` to do a single test run. The framework name is only used to print results and name the result file. E.g: `groovy RestServerStartupTest.groovy spark/target/spark-0.0.1-SNAPSHOT.jar Spark`.

The result will be a csv file per framework with two columns: the size of the executable jar file and the time until startup. Of course the first column will be the same always but I didn't know any better place to put it.

## Results
These are the results from my machine.

### Spark
Executable size: 2289B

Startup times: min = 485ms, max = 637ms, avg = 520.7ms

### Spring
Executable size: 12657B

Startup times: min = 4183ms, max = 5203ms, avg = 4560.1ms

### Vert.x
Executable size: 4358B

Startup times: min = 647ms, max = 883ms, avg = 707.5ms
