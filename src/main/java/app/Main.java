package app;

import app.controllers.PoemController;
import app.dtos.PoemDTO;
import app.dtos.ErrorMessage;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {


    //get("/{id}", ctx -> ctx.result("This is the demo endpoint with ID " + ctx.pathParam("id")));

    public static void main(String[] args) {

        PoemController dogController = new PoemController();

        Javalin app = Javalin.create(config -> {
            config.router.contextPath = "/api";
            config.router.apiBuilder(() -> {
                path("dog", () -> {

                    get("/", ctx -> ctx.json(dogController.getAll()));
                    //get("/demo", ctx -> ctx.result("This is the demo endpoint!"));

                    get("/{id}", ctx -> {
                        try{
                            PoemDTO dog = dogController.getById(Integer.parseInt(ctx.pathParam("id")));
                            ctx.json(dog);
                        } catch (Exception ex){
                            ErrorMessage error = new ErrorMessage("No dog with that id");
                            ctx.status(404).json(error);
                        }
                    });

                    post("/", ctx->{
                       PoemDTO incomingDog = ctx.bodyAsClass(PoemDTO.class);
                       PoemDTO returnedDog = dogController.createDog(incomingDog);
                       ctx.json(returnedDog);
                    });

                    /*put("/{id}", ctx->{
                        int id = Integer.parseInt(ctx.pathParam("id"));
                        DogDTO incommingDog = ctx.bodyAsClass(DogDTO.class);
                        for(int i = 0; i < dogs.size(); i++){
                            if(dogs.get(i).getId() == id){
                                incommingDog.setId(id);
                                dogs.set(i, incommingDog);
                            }
                        }
                        ctx.json(dogs.get(id - 1));
                    });*/
                });
            });
        });
        app.start(7070);
    }
}
