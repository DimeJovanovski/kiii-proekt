package mk.ukim.finki.kiii.proekt.footballrepository.service;

import mk.ukim.finki.kiii.proekt.footballrepository.model.Team;

import java.util.List;

public interface TeamService {
    Team findByid(Long id);
    Team create(String name, String country, String city, String stadium);
    Team update(Long id, String name, String stadium);
    void deleteById(Long id);
    List<Team> listAll();
    List<Team> searchTeams(String sq);
}
