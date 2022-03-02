package com.example.demo.soldier.service

import com.example.demo.soldier.dto.SoldierDTO
import com.example.demo.soldier.entity.Soldier
import org.springframework.stereotype.Service

@Service
open interface SoldierService {
    fun getSoldierById(id: String) : SoldierDTO

    fun getAllSoldiers(): List<SoldierDTO>

    fun createSoldier(payload: SoldierDTO) : SoldierDTO

    fun updateSoldier(payload: SoldierDTO) : SoldierDTO

    fun deleteSoldier(id: String) : Unit
}