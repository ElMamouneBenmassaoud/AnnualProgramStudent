package g58112.webg5.pae.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Authority {
    @Id
    private long id;
    private String username;
    private String authority;
}
