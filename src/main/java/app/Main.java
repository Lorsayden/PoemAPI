package app;

import app.controllers.DogController;
import app.dtos.DogDTO;
import app.dtos.ErrorMessage;
import io.javalin.Javalin;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.jetty.servlet.ErrorPageErrorHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {


    //get("/{id}", ctx -> ctx.result("This is the demo endpoint with ID " + ctx.pathParam("id")));

    public static void main(String[] args) {

        DogController dogController = new DogController();

        Javalin app = Javalin.create(config -> {
            config.router.contextPath = "/api";
            config.router.apiBuilder(() -> {
                path("dog", () -> {

                    get("/", ctx -> ctx.json(dogController.getAll()));
                    //get("/demo", ctx -> ctx.result("This is the demo endpoint!"));

                    get("/{id}", ctx -> {
                        try{
                            DogDTO dog = dogController.getById(Integer.parseInt(ctx.pathParam("id")));
                            ctx.json(dog);
                        } catch (Exception ex){
                            ErrorMessage error = new ErrorMessage("No dog with that id");
                            ctx.status(404).json(error);
                        }
                    });

                    post("/", ctx->{
                       DogDTO incomingDog = ctx.bodyAsClass(DogDTO.class);
                       DogDTO returnedDog = dogController.createDog(incomingDog);
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
