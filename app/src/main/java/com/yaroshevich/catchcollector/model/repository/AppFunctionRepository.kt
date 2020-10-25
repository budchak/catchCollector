package com.yaroshevich.catchcollector.model.repository

import com.yaroshevich.catchcollector.model.Function

class AppFunctionRepository {

    val function = mutableListOf<Function>()

    init {

        function.apply {
            add(Function("Рыбалки"))
            add(Function("Снаряжение"))
            add(Function("Рыбы"))
            add(Function("Трофеи"))
            add(Function("Погода"))
            add(Function("Карты"))
        }
    }

    fun getFunctionList(): List<Function>{
        return function
    }
}