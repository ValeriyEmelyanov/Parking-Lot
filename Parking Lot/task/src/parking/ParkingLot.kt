package parking

class ParkingLot {
    val lots = mutableMapOf<Int, Car>()
    var size = 0

    fun reset(_size: Int) {
        if (_size <= 0) {
            println("The size of the parking lot must be positive.")
            return
        }
        size = _size
        lots.clear()
        println("Created a parking lot with $size spots.")
    }

    fun status() {
        if (lots.isEmpty()) {
            println("Parking lot is empty.")
            return
        }

        lots.keys.sorted().forEach {
            val car = lots.get(it)
            println("$it ${car?.registrationNumber} ${car?.color}")
        }
    }

    fun park(registrationNumber: String, color: String) {
        if (lots.size >= size) {
            println("Sorry, the parking lot is full.")
            return
        }
        val car = Car(registrationNumber, color)
        for (i in 1..size) {
            if (!lots.containsKey(i)) {
                lots.put(i, car)
                println("${car.color} car parked in spot $i.")
                break
            }
        }
    }

    fun leave(lot: Int) {
        lots.remove(lot)
        println("Spot ${lot} is free.")
    }

    fun getRegByColor(color: String) {
        val upperColor = color.uppercase()
        val regs = lots
            .filter { entry -> upperColor == entry.value.color.uppercase() }
            .keys
            .sorted()
            .map { lots.get(it)?.registrationNumber }
            .toList()

        if (regs.size == 0) {
            println("No cars with color $color were found.")
            return
        }

        println(regs.joinToString())
    }

    fun getSpotByColor(color: String) {
        val upperColor = color.uppercase()
        val spots = lots
            .filter { entry -> upperColor == entry.value.color.uppercase() }
            .keys
            .sorted()
            .toList()

        if (spots.size == 0) {
            println("No cars with color $color were found.")
            return
        }

        println(spots.joinToString())
    }

    fun getSpotByReg(registrationNumber: String) {
        val spots = lots
            .filter { entry -> registrationNumber == entry.value.registrationNumber }
            .keys

        if (spots.size == 0) {
            println("No cars with registration number $registrationNumber were found.")
            return
        }

        println(spots.joinToString())
    }
}