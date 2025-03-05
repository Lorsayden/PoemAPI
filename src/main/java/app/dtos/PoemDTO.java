package app.dtos;

import app.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoemDTO {

    int id;
    String title;
    String style;
    String poem;
    Author author;

    public PoemDTO(String title, String style, String poem, Author author) {
        this.title = title;
        this.style = style;
        this.poem = poem;
        this.author = author;
    }
}