package ac.za.cput.entity;

public class FurnitureType {

    private final int furnitureTypeId;
    private final String furnitureDescription;
    private final double size;
    private final String color;


    private FurnitureType(Builder builder){

        this.furnitureTypeId = builder.furnitureTypeId;
        this.furnitureDescription = builder.furnitureDescription;
        this.size = builder.size;
        this.color = builder.color;


    }

    public int getFurnitureTypeId(){

        return furnitureTypeId;

    }

    public String getFurnitureDescription(){

        return furnitureDescription;

    }

    public double getSize(){

        return size;

    }

    public String getColor(){


        return color;

    }

    public static class Builder{

        private int furnitureTypeId;
        private String furnitureDescription;
        private double size;
        private String color;

        public Builder setFurnitureTypeId( final int furnitureTypeId){

            this.furnitureTypeId = furnitureTypeId;
            return this;
        }

        public Builder setFurnitureDescription( final String furnitureDescription){

            this.furnitureDescription = furnitureDescription;
            return this;
        }

        public Builder setSize(final double size){

            this.size =size;
            return this;

        }


        public Builder setColor(final String color){

            this.color = color;
            return this;

        }


        public Builder type(FurnitureType furnitureType){

            this.furnitureTypeId = furnitureType.furnitureTypeId;
            this.furnitureDescription= furnitureType.furnitureDescription;
            this.size = furnitureType.size;
            this.color = furnitureType.color;

            return this;

        }

        public FurnitureType build(){

            return new FurnitureType(this);

        }


    }

    @Override
    public String toString() {
        return "FurnitureType{"+
                ", furnitureTypeId=" + furnitureTypeId +
                ", furnitureDescription=" + furnitureDescription +
                ", size=" + size +
                ", color=" + color +

                '}';
    }
}
