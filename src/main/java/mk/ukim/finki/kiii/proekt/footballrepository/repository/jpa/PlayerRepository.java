package mk.ukim.finki.kiii.proekt.footballrepository.repository.jpa;

import mk.ukim.finki.kiii.proekt.footballrepository.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>  {
    List<Player> findAllByNameLike(String sq);
}
