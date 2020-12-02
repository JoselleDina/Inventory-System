package ac.za.cput.entity.equipment;

import javax.management.relation.Role;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity

public class Device {
    @Id
    private String deviceId;
    private String deviceTypeId;
    private String name;


    protected Device() {
    }


    public Device(Builder builder) {
        this.deviceId = builder.deviceId;
        this.deviceTypeId = builder.deviceTypeId;
        this.name = builder.name;

    }

    public static class Builder {
        private String deviceId;
        private String deviceTypeId;
        private String name;

        public Builder setDeviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }// Setter

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDeviceTypeId(String deviceTypeId) {
            this.deviceTypeId = deviceTypeId;
            return this;
        } // Setter

        public Builder copy(Device device) {
            this.deviceId = device.deviceId;
            this.deviceTypeId = device.deviceTypeId;
            return this;
        }

        public Device build() {
            return new Device(this);

        }
    }

    public String getName() {
        return name;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "device_id=" + deviceId +
                ", device_type_id=" + deviceTypeId +


                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return deviceId.equals(device.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId);
    }
} // Main
