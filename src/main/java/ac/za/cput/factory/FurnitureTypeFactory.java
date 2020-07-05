package ac.za.cput.factory;
//JodiSmit
import ac.za.cput.entity.FurnitureType;
import ac.za.cput.util.GenericHelper;



public class FurnitureTypeFactory {
    public static FurnitureType createFurnitureType(String furnitureDescription, double size, String color){

        String furnitureTypeId = GenericHelper.generateId();
        FurnitureType furnitureType = new FurnitureType.Builder()
                .setFurnitureTypeId(furnitureTypeId)
                .setFurnitureDescription( furnitureDescription)
                .setSize(size)
                .setColor(color)
                .build();

        return furnitureType;
    }
}
