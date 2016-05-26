println "Starting..."

["springboot", "spark", "vertx"].each {
	println "building $it ..."
	"mvn -f $it/pom.xml clean package -DskipTests".execute().waitFor()
}

new File("").absoluteFile.listFiles().each {
	if (it.name.endsWith(".csv")) {
		it.delete()
	}
}

(1..10).each {
	run(new File("RestServerStartupTest.groovy"), "springboot/target/springboot-0.0.1-SNAPSHOT.jar", "Spring")
}
(1..10).each {
	run(new File("RestServerStartupTest.groovy"), "spark/target/spark-0.0.1-SNAPSHOT.jar", "Spark")
}
(1..10).each {
	run(new File("RestServerStartupTest.groovy"), "vertx/target/vertx-0.0.1-SNAPSHOT-fat.jar", "Vertx")
}

println "...Finished"
