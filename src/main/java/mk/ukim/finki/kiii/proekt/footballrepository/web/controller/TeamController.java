package mk.ukim.finki.kiii.proekt.footballrepository.web.controller;

import mk.ukim.finki.kiii.proekt.footballrepository.model.Team;
import mk.ukim.finki.kiii.proekt.footballrepository.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String getTeamsPage(Model model) {
        List<Team> teams = this.teamService.listAll();
        model.addAttribute("teams", teams);
        model.addAttribute("bodyContent", "teams");

        return "master-template";
    }

    @GetMapping("/edit-form/{id}")
    public String editTeamPage(@PathVariable Long id, Model model) {
        Team team = this.teamService.findByid(id);
        model.addAttribute("team", team);
        model.addAttribute("bodyContent", "team-form");

        return "master-template";
    }

    @GetMapping("/add-form")
    public String addTeamPage(Model model) {
        model.addAttribute("bodyContent", "team-form");

        return "master-template";
    }

    @PostMapping("/save")
    public String saveTeam(@RequestParam(required = false) Long id,
                           @RequestParam String name,
                           @RequestParam(required = false) String country,
                           @RequestParam(required = false) String city,
                           @RequestParam String stadium) {
        if(id!=null) {
            this.teamService.update(id, name, stadium);
        }
        else {
            this.teamService.create(name, country, city, stadium);
        }

        return "redirect:/teams";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.teamService.deleteById(id);

        return "redirect:/teams";
    }


}
