package ru.nsu.mmikhalev.task2.utils

import com.github.javafaker.Faker

object RandomGeneratorUtils {
    private val faker: Faker = Faker.instance()

    fun getFaker(): Faker = faker
}