package app.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Entity
public class Poem
{

    //Create a Poem entity. You decide which fields you want to have in the Poem entity.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    String title;

    String style;

    @Column(columnDefinition = "TEXT")
    String poem;

    public Poem(String title, String style, String poem, Author author){
        this.title = title;
        this.style = style;
        this.poem = poem;
        this.author = author;
    }

    @Setter
    @ManyToOne
    private Author author;


}
