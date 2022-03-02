package com.example.demo.soldier.repository

import com.example.demo.soldier.entity.Soldier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open interface SoldierRepository : JpaRepository<Soldier, String> {
    override fun findById(id: String): Optional<Soldier>
}