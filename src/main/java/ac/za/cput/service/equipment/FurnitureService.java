/*
 *@author @Emile Lubangi kitenge 216012465
 *
 */
package ac.za.cput.service.equipment;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.service.IService;

import java.util.Set;

public interface FurnitureService extends IService<Furniture, String>
{
    Set<Furniture> getAll();
}
