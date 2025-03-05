package app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO
{
    int id;
    String name;
    PoemDTO poemDTO;

    public AuthorDTO(String name, PoemDTO poemDTO) {
        this.name = name;
        this.poemDTO = poemDTO;
    }
}
