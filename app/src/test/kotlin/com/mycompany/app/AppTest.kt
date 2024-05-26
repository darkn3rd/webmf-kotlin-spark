package com.mycompany.app

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import kotlin.test.Test
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.*
import spark.Spark.*

class AppTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun setup() {
            initializeServer()
            awaitInitialization()
        }

        @AfterAll
        @JvmStatic
        fun cleanup() {
            stop()
        }
    }

    @Test
    fun testRootRoute() = runBlocking {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("http://localhost:4567/")
        val responseBody = response.bodyAsText()
        assertEquals(200, response.status.value)
        assertEquals("Hello World!\n", responseBody)
        client.close()
    }

    @Test
    fun testHelloRoute() = runBlocking {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("http://localhost:4567/hello")
        val responseBody = response.bodyAsText()
        assertEquals(200, response.status.value)
        assertEquals("Hello World!\n", responseBody)
        client.close()
    }

    @Test
    fun testHelloSlashRoute() = runBlocking {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("http://localhost:4567/hello/")
        val responseBody = response.bodyAsText()
        assertEquals(200, response.status.value)
        assertEquals("Hello World!\n", responseBody)
        client.close()
    }

    @Test
    fun testHelloNameRoute() = runBlocking {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("http://localhost:4567/hello/John")
        val responseBody = response.bodyAsText()
        assertEquals(200, response.status.value)
        assertEquals("Why, Hello John!\n", responseBody)
        client.close()
    }
}
