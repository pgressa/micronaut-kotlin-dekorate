package example.micronaut

import io.micronaut.runtime.Micronaut.*
import io.dekorate.kubernetes.annotation.KubernetesApplication
import io.dekorate.kubernetes.annotation.Label
import io.dekorate.kubernetes.annotation.Port
import io.dekorate.kubernetes.annotation.Probe

@KubernetesApplication(
    name = "foo",
    labels = [Label(key = "app", value = "foo")],
    ports = [Port(name = "http", containerPort = 8080)],
    livenessProbe = Probe(httpActionPath = "/health", initialDelaySeconds = 5, timeoutSeconds = 3, failureThreshold = 10),
    readinessProbe = Probe(httpActionPath = "/health", initialDelaySeconds = 5, timeoutSeconds = 3, failureThreshold = 10)
)
object Dekorate {
}
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("example.micronaut")
		.start()
}

