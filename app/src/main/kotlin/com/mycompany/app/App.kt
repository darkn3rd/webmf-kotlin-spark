package com.mycompany.app
import spark.kotlin.*

fun initializeServer() {
    port(4567) // Set the port before defining routes
    
    get("/hello") { "Hello World!\n" }
    get("/") { "Hello World!\n" }
    get("/hello/") { "Hello World!\n" }
    get("/hello/:name") { "Why, Hello " + params(":name") + "!\n" }
}

fun main() {
    initializeServer()
}
