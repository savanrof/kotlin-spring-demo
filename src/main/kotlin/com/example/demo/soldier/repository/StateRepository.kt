package com.example.demo.soldier.repository

import com.example.demo.soldier.entity.Soldier
import com.example.demo.soldier.entity.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StateRepository : JpaRepository<State, Int>{
    fun findBySoldier(soldier: Soldier) : State

    fun findByState(state: String) : List<State>
}