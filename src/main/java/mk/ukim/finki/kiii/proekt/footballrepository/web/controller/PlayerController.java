package mk.ukim.finki.kiii.proekt.footballrepository.web.controller;

import mk.ukim.finki.kiii.proekt.footballrepository.model.Player;
import mk.ukim.finki.kiii.proekt.footballrepository.model.Team;
import mk.ukim.finki.kiii.proekt.footballrepository.model.enumerations.PlayerPosition;
import mk.ukim.finki.kiii.proekt.footballrepository.service.PlayerService;
import mk.ukim.finki.kiii.proekt.footballrepository.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/", "/players"})
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;

    public PlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping
    public String getPlayersPage(Model model) {
        List<Player> players = this.playerService.listAll();
        model.addAttribute("players", players);
        model.addAttribute("bodyContent", "players");

        return "master-template";
    }

    @GetMapping("/edit-form/{id}")
    public String editPlayerPage(@PathVariable Long id, Model model) {
        Player player = this.playerService.findByid(id);
        PlayerPosition[] positions = PlayerPosition.values();
        List<Team> teams = this.teamService.listAll();

        model.addAttribute("player", player);
        model.addAttribute("positions", positions);
        model.addAttribute("teams", teams);
        model.addAttribute("bodyContent", "player-form");

        return "master-template";
    }

    @GetMapping("/add-form")
    public String addPlayerPage(Model model) {
        PlayerPosition[] positions = PlayerPosition.values();
        List<Team> teams = this.teamService.listAll();

        model.addAttribute("positions", positions);
        model.addAttribute("teams", teams);
        model.addAttribute("bodyContent", "player-form");

        return "master-template";
    }

    @PostMapping("/save")
    public String saveTeam(@RequestParam(required = false) Long id,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam PlayerPosition position,
                           @RequestParam Team team) {
        if(id!=null) {
            this.playerService.update(id, name, surname, position, team);
        }
        else {
            this.playerService.create(name, surname, position, team);
        }

        return "redirect:/players";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.playerService.deleteById(id);

        return "redirect:/players";
    }


}
