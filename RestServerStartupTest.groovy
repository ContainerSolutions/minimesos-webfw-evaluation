def jarFile = args[0]
def fw = args[1]

println "Starting server"
def proc = new ProcessBuilder("java", "-jar", jarFile).redirectErrorStream(true).start()
proc.consumeProcessOutputStream(System.out as OutputStream)

def pollingThread = new Thread({
	def t0 = System.currentTimeMillis()
	def poll = {
		try {
			def body = new URL("http://localhost:8080/hello").text
			println "Got response: ${body}"
			return body.length() > 10
		} catch (IOException ex) {
			return false
		}
	}
	while (!poll()) {
		sleep(1)
	}
	def time = System.currentTimeMillis() - t0
	def size = (new File(jarFile).size() / 1024) as int
	println "StartupTime[$fw]=${time}ms"
	println "ExecutableSize[$fw]=${size}kb"

	new File("${fw}.result.csv") << "$size,$time\n"
})

try {
	pollingThread.start()
	pollingThread.join(10000)

} finally {
	proc.destroy()
}
