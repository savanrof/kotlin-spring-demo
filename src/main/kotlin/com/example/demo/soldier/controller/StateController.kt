package com.example.demo.soldier.controller

import com.example.demo.soldier.dto.StateDTO
import com.example.demo.soldier.service.StateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/soldiers")
class StateController @Autowired constructor(
    private val stateService: StateService
) {
    @GetMapping("/{id}/state")
    fun getSateBySoliderId(@PathVariable id: String) : ResponseEntity<StateDTO> = ResponseEntity.ok(stateService.getBySoldier(id))

    @GetMapping("/state")
    fun getStateByState(@RequestParam state: String) : ResponseEntity<List<StateDTO>> = ResponseEntity.ok(stateService.getBySate(state))

    @PostMapping("/state")
    fun createState(@RequestBody payload: StateDTO) : ResponseEntity<StateDTO> = ResponseEntity(stateService.createState(payload), HttpStatus.CREATED)
}