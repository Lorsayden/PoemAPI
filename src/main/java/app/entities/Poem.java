package app.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Setter;

public class Poem
{

    //Create a Poem entity. You decide which fields you want to have in the Poem entity.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    String title;

    String style;

    @Setter
    @ManyToOne
    private Author author;

    String poem;

}
