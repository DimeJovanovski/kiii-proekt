package mk.ukim.finki.kiii.proekt.footballrepository.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String city;
    private String stadium;

    public Team() {}

    public Team(String name, String country, String city, String stadium) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.stadium = stadium;
    }
}
