package com.weiran.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GraphqlApplication

fun main(args: Array<String>) {
    runApplication<GraphqlApplication>(*args)
}
