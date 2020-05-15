package scripts.bbuu20_api.extensions

import org.tribot.api2007.Objects
import org.tribot.api2007.types.RSObject
import scripts.bbuu20_api.enums.Rock

fun Objects.findNearest(distance: Int, rocksList: List<Rock>): Array<RSObject> {
    var arraySize = 0
    for (rocks in rocksList) {
        for (id in rocks.ids) {
            arraySize++
        }
    }
    val ids = IntArray(arraySize)
    var index = 0
    for (rocks in rocksList) {
        for (id in rocks.ids) {
            ids[index] = id
            index++
        }
    }
    return Objects.findNearest(distance, *ids)
}