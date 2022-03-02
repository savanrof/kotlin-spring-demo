package com.example.demo.soldier.controller

import com.example.demo.soldier.dto.SoldierDTO
import com.example.demo.soldier.entity.Soldier
import com.example.demo.soldier.service.SoldierService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/soldiers")
class SoldierController @Autowired constructor(
    val soldierService: SoldierService
) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<SoldierDTO> = ResponseEntity.ok(soldierService.getSoldierById(id))

    @GetMapping
    fun getAll() : ResponseEntity<List<SoldierDTO>> = ResponseEntity.ok(soldierService.getAllSoldiers())

    @PutMapping
    fun updateSoldier(@RequestBody soldierDTO: SoldierDTO) : ResponseEntity<SoldierDTO> = ResponseEntity.ok(soldierService.updateSoldier(soldierDTO))

    @DeleteMapping("/{id}")
    fun deleteSoldier(@PathVariable id: String) : ResponseEntity<Unit> = ResponseEntity(soldierService.deleteSoldier(id), HttpStatus.NO_CONTENT)

    @PostMapping
    fun createSoldier(@RequestBody soldierDTO: SoldierDTO) : ResponseEntity<SoldierDTO> = ResponseEntity(soldierService.createSoldier(soldierDTO), HttpStatus.CREATED)
}