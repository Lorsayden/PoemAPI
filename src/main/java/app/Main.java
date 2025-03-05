package app;

import app.controllers.PoemController;
import app.dtos.PoemDTO;
import app.dtos.ErrorMessage;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {


    //get("/{id}", ctx -> ctx.result("This is the demo endpoint with ID " + ctx.pathParam("id")));

    public static void main(String[] args) {

        PoemController poemController = new PoemController();

        Javalin app = Javalin.create(config -> {
            config.router.contextPath = "/api";
            config.router.apiBuilder(() -> {
                path("poem", () -> {

                    get("/", ctx -> ctx.json(poemController.getAll()));
                    //get("/demo", ctx -> ctx.result("This is the demo endpoint!"));

                    get("/{id}", ctx -> {
                        try{
                            PoemDTO poem = poemController.getById(Integer.parseInt(ctx.pathParam("id")));
                            ctx.json(poem);
                        } catch (Exception ex){
                            ErrorMessage error = new ErrorMessage("No poem with that id");
                            ctx.status(404).json(error);
                        }
                    });

                    post("/", ctx->{
                       PoemDTO incomingPoem = ctx.bodyAsClass(PoemDTO.class);
                       PoemDTO returnedPoem = poemController.createPoem(incomingPoem);
                       ctx.json(returnedPoem);
                    });

                    /*put("/{id}", ctx->{
                        int id = Integer.parseInt(ctx.pathParam("id"));
                        DogDTO incommingPoem = ctx.bodyAsClass(PoemDTO.class);
                        for(int i = 0; i < poems.size(); i++){
                            if(poems.get(i).getId() == id){
                                incommingPoem.setId(id);
                                poems.set(i, incommingPoem);
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
