package mk.ukim.finki.kiii.proekt.footballrepository.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.kiii.proekt.footballrepository.model.enumerations.PlayerPosition;
import lombok.NonNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Enumerated(value = EnumType.STRING)
    private PlayerPosition position;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Team team;

    public Player() {}

    public Player(String name, String surname, PlayerPosition position, Team team) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.team = team;
    }
}
