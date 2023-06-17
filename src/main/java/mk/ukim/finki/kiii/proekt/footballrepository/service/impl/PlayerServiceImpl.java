package mk.ukim.finki.kiii.proekt.footballrepository.service.impl;

import mk.ukim.finki.kiii.proekt.footballrepository.model.Player;
import mk.ukim.finki.kiii.proekt.footballrepository.model.Team;
import mk.ukim.finki.kiii.proekt.footballrepository.model.enumerations.PlayerPosition;
import mk.ukim.finki.kiii.proekt.footballrepository.model.exceptions.InvalidPlayerIdException;
import mk.ukim.finki.kiii.proekt.footballrepository.repository.jpa.PlayerRepository;
import mk.ukim.finki.kiii.proekt.footballrepository.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player findByid(Long id) {
        return this.playerRepository.findById(id)
                .orElseThrow(() -> new InvalidPlayerIdException(id));
    }

    @Override
    public Player create(String name, String surname, PlayerPosition position, Team team) {
        Player player = new Player(name, surname, position, team);
        return this.playerRepository.save(player);
    }

    @Override
    public Player update(Long id, String name, String surname, PlayerPosition position, Team team) {
        Player player = this.playerRepository.findById(id)
                .orElseThrow(() -> new InvalidPlayerIdException(id));
        player.setName(name);
        player.setSurname(surname);
        player.setPosition(position);
        player.setTeam(team);
        return this.playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        Player player = this.playerRepository.findById(id)
                .orElseThrow(() -> new InvalidPlayerIdException(id));
        this.playerRepository.delete(player);
    }

    @Override
    public List<Player> listAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public List<Player> searchPlayers(String sq) {
        return this.playerRepository.findAllByNameLike(sq);
    }
}
