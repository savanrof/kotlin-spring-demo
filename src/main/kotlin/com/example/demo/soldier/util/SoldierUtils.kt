package com.example.demo.soldier.util

import com.example.demo.soldier.repository.SoldierRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SoldierUtils @Autowired constructor(
    private val soldierRepository: SoldierRepository
) {
    fun String.isSoldierExistsById() : Boolean = soldierRepository.existsById(this)
}