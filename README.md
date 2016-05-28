This repo evaluates 3 Java web frameworks for startup time and executable size. We are going for a lightweight framework because it will be launched with every test.

* Spring Boot with Spring MVC
* Spark
* Vert.x

We build an executable jar file from each of them and measure the time required until they start up. Successful startup is determined by getting a successful response to an HTTP request. See the `RestServerStartupTest.groovy` script for the implementation of a single test run and BuildAndRun.groovy for building and running all 3 applications 10 times (building is only done once).

Use the command `groovy BuildAndRun.groovy` to do the full run.

Use the command `groovy RestServerStartupTest.groovy [path_to_jar] [framework_name]` to do a single test run. The framework name is only used to print results and name the result file. E.g: `groovy RestServerStartupTest.groovy spark/target/spark-0.0.1-SNAPSHOT.jar Spark`.

The result will be a csv file per framework with 3 columns: the size of the executable jar file, the memory usage as reported by the app and the time until startup. Of course the first column will be the same always but I didn't know any better place to put it. Memory usage is measured by the following piece of code and returned in the JSON response from the app:

``` Java
Runtime runtime = Runtime.getRuntime();
runtime.gc();
long usedMemory = runtime.totalMemory() - runtime.freeMemory();
```

## Results
These are the results from my machine. Feel free to reproduce them on yours and suggest ways to improve the measurements.

### Spark
Executable size: 2.3 MB

Memory usage (avg): 3.5 MB

Startup time (avg): 0.5 s

### Spring
Executable size: 12.6 MB

Memory usage (avg): 14.3 MB

Startup time (avg): 4.5 s

### Vert.x
Executable size: 4.3 MB

Memory usage (avg): 5.2 MB

Startup time (avg): 0.7 s
