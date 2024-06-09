package com.example.customization

import java.io.Serializable

//data class BpRecord(val sys: Int, val dia: Int, val hr: Int) : Serializable

data class Bprecords(
    val bprecords: List<bprecord>
)

data class bprecord(
    val datetime: String,
    val sys: Int,
    val dia: Int,
    val hr: Int
)