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

    @Setter
    @ManyToOne
    private Author author;

    String poem;

}
