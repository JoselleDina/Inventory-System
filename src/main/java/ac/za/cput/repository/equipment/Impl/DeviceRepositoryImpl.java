package ac.za.cput.repository.equipment.Impl;

import ac.za.cput.entity.equipment.Device;
<<<<<<< HEAD

import java.util.HashSet;
import java.util.Set;

public class DeviceRepositoryImpl implements ac.za.cput.repository.equipment.Impl.DeviceRepository <Device, String>
{
    private Set<Device> deviceDB;

    public DeviceRepositoryImpl()
    {
=======
import ac.za.cput.repository.equipment.DeviceRepository;
import java.util.HashSet;
import java.util.Set;

public class DeviceRepositoryImpl implements DeviceRepository
{
    private static DeviceRepository deviceRepository = null;
    private Set<Device> deviceDB;

    private DeviceRepositoryImpl(){
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df

        this.deviceDB = new HashSet<>();

    }

<<<<<<< HEAD
=======
    public static DeviceRepository getDeviceRepository(){

        if(deviceRepository == null){

            deviceRepository = new DeviceRepositoryImpl();
        }
        return deviceRepository;

    }

>>>>>>> ea9ea980a8f164536665761b728a23875a6585df

    @Override
    public Set<Device> getAll() {
        return this.deviceDB;
    }

    @Override
    public Device create(Device device) {
        this.deviceDB.add(device);
        return device;
    }

    @Override
    public Device read(String deviceId) {
        Device device = this.deviceDB.stream()
                .filter(l -> l.getDeviceId().equalsIgnoreCase(deviceId))
                .findAny()
                .orElse(null);
        return device;
    }

    @Override
    public Device update(Device device) {
<<<<<<< HEAD
        Device device1 =read(device.getDeviceId());
        if(device1 != null){
            this.deviceDB.remove(device);
=======
        Device oldDevice =read(device.getDeviceId());
        if(oldDevice != null){
            this.deviceDB.remove(oldDevice);
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df
            this.deviceDB.add(device);
        }
        return device;
    }

    @Override
    public void delete(String deviceId) {

        Device device = read(deviceId);
        if (device != null) this.deviceDB.remove(device);

    }
}
