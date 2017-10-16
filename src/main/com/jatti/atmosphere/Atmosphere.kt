package com.jatti.atmosphere

/**
 * Atmosphere for planets, it defines everything which is important on planet (expect mobs) like gravity or temperature
 * @author Jatti
 * @version 1.0
 *
 * @param name Atmosphere's name
 *
 * gravity - gravity on planet
 * temperature - temperature on planet right now
 * lowTemperature - the lowest temperature planet with this atmosphere can reach
 * maxTemperature - the highest temperature planet with this atmosphere can reach
 * isLife - can mobs spawn on it?
 * isChangable - can player change it?
 * changeTime - time to change atmosphere on planet
 */
class Atmosphere(var name: String) {

    var gravity: Int = 0
    var temperature: Int = 0
    var lowTemperature: Int = 0
    var maxTemperature: Int = 0
    var isLife: Boolean = false
    var isChangable: Boolean = false
    var changeTime: Int = 0

    init {

        this.isLife = true
        this.isChangable = false
        this.changeTime = 0

        AtmosphereUtils.addAtmosphere(this)
    }

    companion object {

        /**
         * Gets atmosphere with defined name from all atmospheres
         *
         * @param name atmosphere's name
         */
        @JvmStatic
        fun get(name: String): Atmosphere {

            AtmosphereUtils.getAtmospheres()
                    .filter { it.name == name }
                    .forEach { return it }

            return Atmosphere(name)

        }

    }

}