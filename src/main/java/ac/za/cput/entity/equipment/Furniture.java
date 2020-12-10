package ac.za.cput.entity.equipment;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Furniture {

    @Id
    private String furnitureId;
    private String name;
    private String furnitureTypeId;

    protected Furniture() {
    }

    public Furniture(Builder builder){
        this.furnitureId = builder.furnitureId;
        this.furnitureTypeId = builder.furnitureTypeId;
        this.name = builder.name;
    }

    public static class Builder {
        private String furnitureId;
        private String name;
        private String furnitureTypeId;


        public Builder setFurnitureId(String furnitureId) {
            this.furnitureId = furnitureId;
            return this;
        }// Setter
        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setFurnitureTypeId(String furnitureTypeId) {
            this.furnitureTypeId = furnitureTypeId;
            return this;
        } // Setter

        public Builder copy(Furniture furniture) {
            this.furnitureId = furniture.furnitureId;

            this.furnitureTypeId = furniture.furnitureTypeId;
            return this;
        }

        public Furniture build() {
            return new Furniture(this);

        }
    }
    public String getFurnitureId() {
        return furnitureId;
    }

    public String getName() {
        return name;
    }

    public String getFurnitureTypeId() {
        return furnitureTypeId;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "furnitureId=" + furnitureId +
                ", furnitureTypeId=" + furnitureTypeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return furnitureId.equals(furniture.furnitureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(furnitureId);
    }
} // Main