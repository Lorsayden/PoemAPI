package app.controllers;

import app.dtos.DogDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DogController {

    private static List<DogDTO> dogs = new ArrayList<>(Arrays.asList(
            new DogDTO(1, "Fido", "Puddel", 'M', 3),
            new DogDTO(2, "Melia", "Labrador", 'F', 5),
            new DogDTO(3, "Shep", "Schaefer", 'M', 6)
    ));


    public DogDTO getById(int id) throws Exception{
        try{
            dogs.get(id);
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return dogs.get(id);
    }

    public List<DogDTO> getAll(){
        return dogs;
    }

    public DogDTO setDog(int id, DogDTO dog){
        dogs.set(id, dog);
        return dog;
    }

    public DogDTO createDog(DogDTO dog){
        int id = dogs.size() + 1;
        dog.setId(id);
        dogs.add(dog);
        return dogs.get(id);
    }
}
