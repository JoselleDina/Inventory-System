<<<<<<< HEAD
package ac.za.cput.repository.equipment.Impl;
=======
package ac.za.cput.repository.equipment;
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.IRepository;

import java.util.Set;

<<<<<<< HEAD
public interface FurnitureRepository <F, S> extends IRepository<Furniture, String>
=======
public interface FurnitureRepository extends IRepository<Furniture, String>
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df
{
    Set<Furniture> getAll();
}
