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

    public AuthorDTO(String name) {
        this.name = name;
    }
}
