<<<<<<< HEAD
package ac.za.cput.repository.equipment.Impl;
=======
package ac.za.cput.repository.equipment;
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.repository.IRepository;

import java.util.Set;

<<<<<<< HEAD
public interface DeviceRepository <D, S> extends IRepository<Device, String>
=======
public interface DeviceRepository extends IRepository<Device, String>
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df
{
    Set<Device> getAll();
}
