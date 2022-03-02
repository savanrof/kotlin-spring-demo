package com.example.demo.soldier.mapper

import com.example.demo.soldier.dto.SoldierDTO
import com.example.demo.soldier.entity.Soldier
import org.springframework.stereotype.Service

@Service
class SoldierMapper : Mapper<Soldier, SoldierDTO> {
    override fun fromEntity(entity: Soldier): SoldierDTO = SoldierDTO(
        entity.id,
        entity.militaryType,
        entity.rank,
        entity.salary
    )

    override fun fromDTO(dto: SoldierDTO): Soldier = Soldier(
        dto.id,
        dto.militaryType,
        dto.rank,
        dto.salary
    )
}