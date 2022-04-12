package ru.newmcpe.magicstone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MagicstoneServerApplication

fun main(args: Array<String>) {
    runApplication<MagicstoneServerApplication>(*args)
}
