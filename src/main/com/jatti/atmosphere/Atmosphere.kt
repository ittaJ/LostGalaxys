package com.jatti.atmosphere

class Atmosphere(var name: String){

    var gravity:Int = 0
    var temperature:Int = 0
    var lowTemperature:Int = 0
    var maxTemperature:Int = 0
    var isLife:Boolean = false
    var isChangable:Boolean = false
    var changeTime:Int = 0

    init{

        this.isLife = true
        this.isChangable = false
        this.changeTime = 0

        AtmosphereUtils.addAtmosphere(this)
    }

    companion object {

        operator fun get(name:String):Atmosphere{

            for(a in AtmosphereUtils.getAtmospheres()){

                if(a.name == name) return a

            }

            return Atmosphere(name)

        }

    }

}