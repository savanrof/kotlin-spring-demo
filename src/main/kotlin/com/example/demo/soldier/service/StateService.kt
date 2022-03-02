package com.example.demo.soldier.service

import com.example.demo.soldier.dto.SoldierDTO
import com.example.demo.soldier.dto.StateDTO
import org.springframework.stereotype.Service

@Service
interface StateService {
    fun getBySoldier(soldierId: String) : StateDTO

    fun getBySate(state: String) : List<StateDTO>

    fun createState(payload: StateDTO) : StateDTO
}