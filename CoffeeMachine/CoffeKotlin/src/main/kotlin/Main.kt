package machine
import kotlin.system.exitProcess
var water = 400
var milk = 540
var caffee = 120
var cups = 9
var coins = 550

val espWater = 250
val espCaffee = 16
val espCost = 4

val latWater = 350
val latCaffee = 20
val latMilk = 75
val latCost = 7

val capWater = 200
val capMilk = 100
val capCaffee = 12
val capCost = 6

public fun printCurrentState(){
    println("\nThe coffee machine has:\n" +
            "$water ml of water\n" +
            "$milk ml of milk\n" +
            "$caffee g of coffee beans\n" +
            "$cups disposable cups\n" +
            "$$coins of money\n")
}
fun actionMaker(): String {
    println("\nwrite action (buy, fill, take, remaining, exit):")
    val action = readln()
    return action
}
fun buyCaffeeChoice () {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val whatCaffee = readln()
    when (whatCaffee){
        "1" -> makeEspresso()
        "2" -> makeLatte()
        "3" -> makeCappuccino()
    }
}
fun makeEspresso() {
    if (water < espWater) println("Sorry, not enough water!")
    else if (caffee < espCaffee) println("Sorry, not enough caffee beans!")
    else if (cups < 1) println("Sorry, not enough disposable cups!")
    else {
        water = water - espWater
        caffee = caffee - espCaffee
        coins = coins + espCost
        cups = cups - 1
        println("I have enough resources, making you a coffee!")
    }
}
fun makeLatte() {
    if (water < latWater) println("Sorry, not enough water!")
    else if (caffee < latCaffee) println("Sorry, not enough caffee beans!")
    else if (cups < 1) println("Sorry, not enough disposable cups!")
    else {
        water = water - latWater
        milk = milk - latMilk
        caffee = caffee -latCaffee
        coins = coins + latCost
        cups = cups - 1
        println("I have enough resources, making you a coffee!")
    }
}
fun makeCappuccino() {
    if (water < capWater) println("Sorry, not enough water!")
    else if (caffee < capCaffee) println("Sorry, not enough caffee beans!")
    else if (cups < 1) println("Sorry, not enough disposable cups!")
    else {
        water = water - capWater
        milk = milk - capMilk
        caffee = caffee - capCaffee
        coins = coins + capCost
        cups = cups - 1
        println("I have enough resources, making you a coffee!")
    }
}
fun fillMachine(){
    println("Write how many ml of water you want to add:")
    water = water + readln().toInt()
    println("Write how many ml of milk you want to add:")
    milk = milk + readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    caffee = caffee + readln().toInt()
    println("Write how many disposable cups you want to add:")
    cups = cups + readln().toInt()
}
fun takeMoniez(){
    println("\nI gave you $$coins")
    coins = 0
}

fun main(args: Array<String>) {
    var action = " "
    while (action != null){
        action = actionMaker()
        when (action){
            "buy" -> buyCaffeeChoice()
            "fill" -> fillMachine()
            "take" -> takeMoniez()
            "back" -> actionMaker()
            "remaining" -> printCurrentState()
            "exit" -> exitProcess(0)
        }
    }
}