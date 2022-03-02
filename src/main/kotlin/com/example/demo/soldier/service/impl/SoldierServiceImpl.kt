package com.example.demo.soldier.service.impl

import com.example.demo.soldier.dto.SoldierDTO
import com.example.demo.soldier.exception.SoldierException
import com.example.demo.soldier.mapper.SoldierMapper
import com.example.demo.soldier.repository.SoldierRepository
import com.example.demo.soldier.service.SoldierService
import com.example.demo.soldier.util.SoldierUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class SoldierServiceImpl @Autowired constructor(
    private val soldierRepository: SoldierRepository,
    private val mapper: SoldierMapper,
    private val soldierUtils: SoldierUtils
) : SoldierService {

    override fun getSoldierById(id: String) : SoldierDTO = mapper.fromEntity(soldierRepository.findById(id).get())

    override fun getAllSoldiers(): List<SoldierDTO> = soldierRepository.findAll().map { mapper.fromEntity(it) }

    @Transactional
    override fun createSoldier(payload: SoldierDTO): SoldierDTO {
        if (payload.militaryType == null || payload.rank == null || payload.salary == null)
            throw SoldierException("Please complete soldier information")
        return mapper.fromEntity(soldierRepository.save(mapper.fromDTO(payload)))
    }

    @Transactional
    override fun updateSoldier(payload: SoldierDTO): SoldierDTO {
        if (!with(soldierUtils)
            {payload.id!!.isSoldierExistsById()})
            throw SoldierException("Soldier with id ${payload.id} is not exists")
        soldierRepository.save(mapper.fromDTO(payload))
        return payload
    }

    @Transactional
    override fun deleteSoldier(id: String) : Unit{
        if (!with(soldierUtils)
            {id.isSoldierExistsById()})
            throw SoldierException("Soldier with id $id is not exists")
        soldierRepository.deleteById(id)
    }
}