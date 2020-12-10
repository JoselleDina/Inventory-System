package ac.za.cput.factory.equipment;

import ac.za.cput.entity.equipment.Device;

import ac.za.cput.util.GenericHelper;

public class DeviceFactory {

    public static Device createDevice(String deviceTypeId,String name){
        String deviceId = GenericHelper.generateId();
        Device device =new Device.Builder()
                .setDeviceId(deviceId)
                .setDeviceTypeId(deviceTypeId)
                .setName(name)
                .build();
        return device;


    }

    public static Device createDevice(String s) {
        return null;
    }
}