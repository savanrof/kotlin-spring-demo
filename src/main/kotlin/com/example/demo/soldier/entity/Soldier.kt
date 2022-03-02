package com.example.demo.soldier.entity

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "SOLDIER")
data class Soldier(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    val id: String? = UUID.randomUUID().toString(),

    @Column(name = "type")
    val militaryType: String,

    @Column(name = "soldier_rank")
    val rank: String,

    @Column(name = "salary")
    val salary: Double
    ) {

}
