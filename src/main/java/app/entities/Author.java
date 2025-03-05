package app.entities;

import lombok.*;

import java.util.Set;

@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    String name;

    @Setter
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Poem> poems;

}
