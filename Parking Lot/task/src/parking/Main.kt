package parking

fun main() {
    val parkingLot = ParkingLot()

    while (true) {
        val command = readLine()!!.split(" ")
        val commandKey = command[0].lowercase()

        if (commandKey == "exit") break;

        if (parkingLot.size < 1 && commandKey != "create") {
            println("Sorry, a parking lot has not been created.")
            continue
        }

        when {
            commandKey == "create" -> parkingLot.reset(command[1].toInt())
            commandKey == "status" -> parkingLot.status()
            commandKey == "park" -> parkingLot.park(command[1], command[2])
            commandKey == "leave" -> parkingLot.leave(command[1].toInt())
            commandKey == "reg_by_color" -> parkingLot.getRegByColor(command[1])
            commandKey == "spot_by_color" -> parkingLot.getSpotByColor(command[1])
            commandKey == "spot_by_reg" -> parkingLot.getSpotByReg(command[1])
            else -> println("Unknown command")
        }
    }
}
