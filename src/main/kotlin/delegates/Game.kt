package delegates

fun main() {

    val zombie = Zombie("Nick")
    val human = Human("Max")

    zombie.move()
    zombie.fight()

    human.move()
    human.fight()

    val premiumHuman = PremiumPlayer(human)
    premiumHuman.fight()
    premiumHuman.move()
    premiumHuman.callForHelp()

    val flyingZombie = FlyingPlayer(zombie)
    flyingZombie.fight()
    flyingZombie.move()
    flyingZombie.flight()

}

interface Player {
    fun fight()
    fun move()
}

data class Human(val name: String) : Player {
    override fun fight() {
        println("fighting with gun")
    }

    override fun move() {
        println("running very fast")
    }
}

data class Zombie(val name: String) : Player {
    override fun fight() {
        println("eating human")
    }

    override fun move() {
        println("walking very slowly")
    }
}

data class FlyingPlayer(val player: Player) : Player by player {
    fun flight() {
        println("flighting")
    }
}

data class PremiumPlayer(val player: Player) : Player by player {
    fun callForHelp() {
        println("Help me!!!")
    }
}