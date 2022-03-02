package com.example.demo.soldier.mapper

import com.example.demo.soldier.dto.StateDTO
import com.example.demo.soldier.entity.State
import com.example.demo.soldier.repository.SoldierRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StateMapper @Autowired constructor(
    private val soldierRepository: SoldierRepository
) : Mapper<State, StateDTO> {
    override fun fromEntity(entity: State) = StateDTO (
        entity.id,
        entity.soldier.id!!,
        entity.state
        )

    override fun fromDTO(dto: StateDTO) = State (
        dto.id,
        soldierRepository.findById(dto.soldier).get(),
        dto.state
        )
}