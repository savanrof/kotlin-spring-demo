package com.example.demo.soldier.service.impl

import com.example.demo.soldier.dto.StateDTO
import com.example.demo.soldier.exception.SoldierException
import com.example.demo.soldier.mapper.StateMapper
import com.example.demo.soldier.repository.SoldierRepository
import com.example.demo.soldier.repository.StateRepository
import com.example.demo.soldier.service.StateService
import com.example.demo.soldier.util.SoldierUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class StateServiceImpl @Autowired constructor(
    private val stateRepository: StateRepository,
    private val soldierRepository: SoldierRepository,
    private val stateMapper: StateMapper,
    private val soldierUtils: SoldierUtils
) : StateService {

    override fun getBySoldier(soldierId: String): StateDTO {
        if (!with(soldierUtils)
            {soldierId.isSoldierExistsById()})
            throw SoldierException("Soldier with id $soldierId is not exists")
        val soldier = soldierRepository.findById(soldierId).get()
        return stateMapper.fromEntity(stateRepository.findBySoldier(soldier))
    }

    override fun getBySate(state: String): List<StateDTO> = stateRepository.findByState(state).map { stateMapper.fromEntity(it) }

    @Transactional
    override fun createState(payload: StateDTO): StateDTO {
        if (!with(soldierUtils)
            {payload.soldier!!.isSoldierExistsById()})
            throw SoldierException("Soldier with id ${payload.soldier} is not exists")
        return stateMapper.fromEntity(stateRepository.save(stateMapper.fromDTO(payload)))
    }

}