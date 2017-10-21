package com.jatti.achievements.prize

import com.jatti.user.User
import org.bukkit.Sound
import org.bukkit.inventory.ItemStack

/**
 * Prize e.g for completing mission or getting achievement
 * @author Jatti
 * @version 1.0
 */
open class Prize {

    var items: List<ItemStack>? = ArrayList()
    var gold: Int = 0
    var exp: Double = 0.0
    var user: User? = null
    var sound: Sound? = null

    companion object {
        /**
         * Creates new builder to make Prize
         */
        @JvmStatic
        fun builder(): PrizeBuilder {
            return PrizeBuilder()
        }
    }

}

/**
 * Builder for Prize
 * @author Jatti
 * @version 1.0
 */
class PrizeBuilder {

    private val p = Prize()

    /**
     * Addes items to Prize
     * @param items list of item
     */
    fun withItems(items: List<ItemStack>): PrizeBuilder {
        p.items = items
        return this
    }

    /**
     * Addes gold to Prize
     * @param gold amount of gold
     */
    fun withGold(gold: Int): PrizeBuilder {
        p.gold = gold
        return this
    }

    /**
     * Addes exp to Prize
     * @param exp amount of exp
     */
    fun withExp(exp: Double): PrizeBuilder {
        p.exp = exp
        return this
    }

    fun withSound(sound: Sound): PrizeBuilder {
        p.sound = sound
        return this
    }
    /**
     * definies user which will get prize (MUST HAVE)
     * @param user user which will get prize
     */
    fun forUser(user: User): PrizeBuilder {
        p.user = user
        return this
    }

    /**
     * Creates Prize and gives it to user
     */
    fun build(): Prize {

        p.user!!.getPlayer().playSound(p.user!!.getPlayer().location, p.sound!!, 0F, 1F)

        if (p.items != null) {
            for (i in p.items!!) {
                p.user!!.getPlayer().inventory.addItem(i)
            }
        }

        p.user!!.addGold(p.gold)
        p.user!!.addExp(p.exp)

        return p

    }

}