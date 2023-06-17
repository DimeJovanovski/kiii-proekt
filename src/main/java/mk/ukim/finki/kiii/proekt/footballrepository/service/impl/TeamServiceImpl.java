package mk.ukim.finki.kiii.proekt.footballrepository.service.impl;

import mk.ukim.finki.kiii.proekt.footballrepository.model.Team;
import mk.ukim.finki.kiii.proekt.footballrepository.model.exceptions.InvalidTeamIdException;
import mk.ukim.finki.kiii.proekt.footballrepository.repository.jpa.TeamRepository;
import mk.ukim.finki.kiii.proekt.footballrepository.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findByid(Long id) {
        return this.teamRepository.findById(id)
                .orElseThrow(() -> new InvalidTeamIdException(id));
    }

    @Override
    public Team create(String name, String country, String city, String stadium) {
        Team team = new Team(name, country, city, stadium);
        return this.teamRepository.save(team);
    }

    @Override
    public Team update(Long id, String name, String stadium) {
        Team team = this.teamRepository.findById(id)
                .orElseThrow(() -> new InvalidTeamIdException(id));
        team.setName(name);
        team.setStadium(stadium);
        return this.teamRepository.save(team);
    }

    @Override
    public void deleteById(Long id) {
        Team team = this.teamRepository.findById(id)
                .orElseThrow(() -> new InvalidTeamIdException(id));
        this.teamRepository.delete(team);
    }

    @Override
    public List<Team> listAll() {
        return this.teamRepository.findAll();
    }

    @Override
    public List<Team> searchTeams(String sq) {
        return this.teamRepository.findAllByNameLike(sq);
    }
}
