package mk.ukim.finki.kiii.proekt.footballrepository.repository.jpa;


import mk.ukim.finki.kiii.proekt.footballrepository.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAllByNameLike(String sq);
}
