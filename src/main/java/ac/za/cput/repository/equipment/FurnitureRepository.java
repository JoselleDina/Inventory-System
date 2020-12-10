/*
 *@author @Emile Lubangi kitenge 216012465
 *
 */
package ac.za.cput.repository.equipment;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FurnitureRepository extends JpaRepository <Furniture, String> {



}