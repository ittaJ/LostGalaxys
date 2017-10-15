package com.jatti.achievements.prize

import com.jatti.user.User
import org.bukkit.inventory.ItemStack

open class Prize {

    var items: List<ItemStack>? = ArrayList()
    var gold: Int = 0
    var exp: Double = 0.0
    var user: User? = null

    companion object {
        @JvmStatic
        fun builder(): PrizeBuilder {
            return PrizeBuilder()
        }
    }

}


class PrizeBuilder {

    private val p = Prize()

    fun withItems(items: List<ItemStack>): PrizeBuilder {
        p.items = items
        return this
    }

    fun withGold(gold: Int): PrizeBuilder {
        p.gold = gold
        return this
    }

    fun withExp(exp: Double): PrizeBuilder {
        p.exp = exp
        return this
    }

    fun forUser(user: User): PrizeBuilder {
        p.user = user
        return this
    }

    fun build(): Prize {

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