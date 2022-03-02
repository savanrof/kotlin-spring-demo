package com.example.demo.soldier.mapper

interface Mapper<E, D> {
    fun fromEntity(entity: E): D
    fun fromDTO(dto: D): E
}