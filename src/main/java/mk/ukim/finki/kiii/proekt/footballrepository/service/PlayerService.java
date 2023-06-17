package mk.ukim.finki.kiii.proekt.footballrepository.service;

import mk.ukim.finki.kiii.proekt.footballrepository.model.Player;
import mk.ukim.finki.kiii.proekt.footballrepository.model.Team;
import mk.ukim.finki.kiii.proekt.footballrepository.model.enumerations.PlayerPosition;

import java.util.List;

public interface PlayerService {
    Player findByid(Long id);
    Player create(String name, String surname, PlayerPosition position, Team team);
    Player update(Long id, String name, String surname, PlayerPosition position, Team team);
    void deleteById(Long id);
    List<Player> listAll();
    List<Player> searchPlayers(String sq);
}
