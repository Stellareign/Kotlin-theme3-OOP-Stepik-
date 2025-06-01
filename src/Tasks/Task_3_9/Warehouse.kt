package Tasks.Task_3_9

class Warehouse {
    fun getPack(deliveryObject: DeliveryObject): Pack {
        return Pack(
            length = deliveryObject.length + 1,
            width = deliveryObject.width + 1,
            height = deliveryObject.height + 1,
            weight = 0.3
        );
    }
     fun packCargo(deliveryObject: DeliveryObject): Cargo {
         val pack = getPack(deliveryObject);
         return Cargo(
             length = pack.length,
             width = pack.width,
             height = pack.height,
             typePackaging = pack.type,
             netWeight = deliveryObject.weight,
             grossWeight = pack.weight + deliveryObject.weight
         );
     }
}