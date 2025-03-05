package app;

import app.config.HibernateConfig;
import app.controllers.PoemController;
import app.dao.impl.PoemDAO;
import app.dtos.PoemDTO;
import app.dtos.ErrorMessage;
import app.entities.Poem;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {



    //get("/{id}", ctx -> ctx.result("This is the demo endpoint with ID " + ctx.pathParam("id")));

    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

        PoemController poemController = new PoemController();

        //Only used the first time you run the program
        // poemController.savePoemsToDatabase(emf);

        Javalin app = Javalin.create(config -> {
            config.router.contextPath = "/api";
            config.router.apiBuilder(() -> {
                path("poem", () -> {

                    get("/", ctx -> ctx.json(poemController.getAll(emf)));

                    get("/{id}", ctx -> {
                        try{
                            PoemDTO poem = poemController.getById(Integer.parseInt(ctx.pathParam("id")),emf);
                            ctx.json(poem);
                        } catch (Exception ex){
                            ErrorMessage error = new ErrorMessage("No poem with that id");
                            ctx.status(404).json(error);
                        }
                    });

                    post("/", ctx->{
                       PoemDTO incomingPoem = ctx.bodyAsClass(PoemDTO.class);
                       Poem returnedPoem = poemController.createPoemFromDTO(incomingPoem, emf);
                       ctx.json(returnedPoem);
                    });

                });
            });
        });
        app.start(7070);
    }
}



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