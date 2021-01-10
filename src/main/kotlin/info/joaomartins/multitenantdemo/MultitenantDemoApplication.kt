package info.joaomartins.multitenantdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultitenantDemoApplication

fun main(args: Array<String>) {
    runApplication<MultitenantDemoApplication>(*args)
}
