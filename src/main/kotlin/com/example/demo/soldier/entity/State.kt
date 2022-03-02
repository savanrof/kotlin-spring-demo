package com.example.demo.soldier.entity

import javax.persistence.*

@Entity
@Table(name = "STATE")
data class State(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @OneToOne
    @JoinColumn(name = "soldier", unique = true)
    val soldier: Soldier,

    @Column(name = "state")
    val state: String
)  {}
