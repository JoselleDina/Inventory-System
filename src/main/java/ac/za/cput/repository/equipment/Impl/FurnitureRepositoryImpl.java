package ac.za.cput.repository.equipment.Impl;

<<<<<<< HEAD
import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.IRepository;
=======
import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.equipment.FurnitureRepository;
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df

import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
public class FurnitureRepositoryImpl implements ac.za.cput.repository.equipment.Impl.FurnitureRepository<Furniture, String>
{

    private Set<Furniture> furnitureDB;

    public FurnitureRepositoryImpl(){
=======
public class FurnitureRepositoryImpl implements FurnitureRepository {


    private static FurnitureRepository furnitureRepository = null;
    private Set<Furniture> furnitureDB;

    private FurnitureRepositoryImpl(){
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df

        this.furnitureDB = new HashSet<>();
    }

<<<<<<< HEAD
    @Override
    public Set<Furniture> getAll() {
=======
    public static FurnitureRepository getFurnitureRepository(){

        if(furnitureRepository== null){

            furnitureRepository = new FurnitureRepositoryImpl();
        }
        return furnitureRepository;

    }

    @Override
    public Set<Furniture> getAll() {

>>>>>>> ea9ea980a8f164536665761b728a23875a6585df
        return this.furnitureDB;
    }

    @Override
    public Furniture create(Furniture furniture) {
        this.furnitureDB.add(furniture);
        return furniture;
    }

    @Override
    public Furniture read(String furnitureId) {
<<<<<<< HEAD
        Furniture furniture = this.furnitureDB.stream()
=======

          Furniture furniture = this.furnitureDB.stream()
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df
                .filter(l -> l.getFurnitureId().equalsIgnoreCase(furnitureId))
                .findAny()
                .orElse(null);
        return furniture;
    }

<<<<<<< HEAD
    @Override
    public Furniture update(Furniture furniture) {
        Furniture furniture1 =read(furniture.getFurnitureId());
        if(furniture1 != null){
            this.furnitureDB.remove(furniture);
=======

    @Override
    public Furniture update(Furniture furniture) {
        Furniture oldDevice =read(furniture.getFurnitureId());
        if(oldDevice != null){
            this.furnitureDB.remove(oldDevice);
>>>>>>> ea9ea980a8f164536665761b728a23875a6585df
            this.furnitureDB.add(furniture);
        }
        return furniture;
    }

    @Override
    public void delete(String furnitureId) {
        Furniture furniture = read(furnitureId);
        if (furniture != null) this.furnitureDB.remove(furniture);

<<<<<<< HEAD
=======

>>>>>>> ea9ea980a8f164536665761b728a23875a6585df
    }
}
