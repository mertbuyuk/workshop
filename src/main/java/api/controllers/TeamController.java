package api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.abstracts.TeamService;
import entities.concretes.Player;
import entities.concretes.Team;

@RestController
@RequestMapping("/api/team")
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@PostMapping("/add")
	public void add(@RequestBody Player player) {
		this.teamService.add(player);
	}
	
	@GetMapping("/getAll")
	public List<Team> getAll() {
		return this.teamService.getAll();
	}
	
	@GetMapping("/findFromTeam")
	public List<Player> findFromTeam(@RequestParam List<Integer> id) {
		return this.teamService.findByTeamId(id);
	}
	
	@PostMapping("/delete")
	public Player deleteByıd(@RequestParam int teamId,@RequestParam int id) {
		return this.teamService.deleteById(teamId,id);
	}
	
	@PostMapping("/update")
	public Player updateById(@RequestParam int teamId,@RequestParam int playerId,@RequestParam String isim){
		return this.teamService.updateById(teamId,playerId, isim);
	}
	
	

}
