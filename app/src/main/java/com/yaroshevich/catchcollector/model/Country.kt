package com.yaroshevich.catchcollector.model

class Country(var id: Int = 0, var name: String, var iconPath: String) {


    override fun hashCode(): Int = id

    override fun equals(other: Any?): Boolean {

        if (this === other) return true

        if (!(other is Country)) return false

        return name.equals(other.name)




    }
}
