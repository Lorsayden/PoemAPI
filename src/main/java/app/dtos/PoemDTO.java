package app.dtos;

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
    AuthorDTO authorDTO;

    public PoemDTO(String title, String style, String poem, AuthorDTO authorDTO) {
        this.title = title;
        this.style = style;
        this.poem = poem;
        this.authorDTO = authorDTO;
    }
}