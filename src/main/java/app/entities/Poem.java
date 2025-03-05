package app.entities;

import lombok.Setter;

public class Poem
{

    //Create a Poem entity. You decide which fields you want to have in the Poem entity.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    String title;

    String style = ENUM;

    @Setter
    @ManyToOne
    private Author author;

}
