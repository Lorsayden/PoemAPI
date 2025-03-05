package app.controllers;

import app.dtos.PoemDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoemController {

    private static List<PoemDTO> dogs = new ArrayList<>(Arrays.asList(
            new PoemDTO(1, "Fido", "Puddel", 'M', 3),
            new PoemDTO(2, "Melia", "Labrador", 'F', 5),
            new PoemDTO(3, "Shep", "Schaefer", 'M', 6)
    ));


    public PoemDTO getById(int id) throws Exception{
        try{
            dogs.get(id);
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return dogs.get(id);
    }

    public List<PoemDTO> getAll(){
        return dogs;
    }

    public PoemDTO setDog(int id, PoemDTO dog){
        dogs.set(id, dog);
        return dog;
    }

    public PoemDTO createDog(PoemDTO dog){
        int id = dogs.size() + 1;
        dog.setId(id);
        dogs.add(dog);
        return dogs.get(id);
    }
}
