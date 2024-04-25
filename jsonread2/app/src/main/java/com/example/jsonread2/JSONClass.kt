package com.example.jsonread2

data class kpop(
    val singers: List<Singer>
)

data class Singer(
    val agency: String,
    val name: String,
    val year_of_debut: Int
)