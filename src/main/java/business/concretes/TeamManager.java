package business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.abstracts.TeamService;
import dataAcces.abstracts.TeamDao;
import entities.concretes.Player;
import entities.concretes.Team;

@Service
public class TeamManager implements TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
	

	public TeamManager(TeamDao teamDao) {
		super();
		this.teamDao = teamDao;
	}
	
	

	public List<Team> getAllTeam() {
		// TODO Auto-generated method stub
		return this.teamDao.findAll();
	}
	
	


	@Override
	public List<Player> findByTeamId(List<Integer> id) {
		List teamCapacity = this.teamDao.findByTeamId(id);
		
		if(teamCapacity.size()>18) {
			System.out.println("Takımda ki oyuncu sayısı 18 den fazla");
			return null;
		}
		return this.teamDao.findByTeamId(id);
	}



	@Override
	public Player deleteById(int teamId, int playerId) {
		
		return this.teamDao.deletePlayersById(teamId, playerId);
	}



	@Override
	public Player updateById(int teamId, int playerId,String isim) {
		// TODO Auto-generated method stub
		return this.teamDao.updatePlayersById(teamId, playerId, isim);
	}



	@Override
	public void add(Player player) {
		
		this.teamDao.save(player);
		
	}



	@Override
	public List<Team> getAll() {
		// TODO Auto-generated method stub
		return this.teamDao.findAll();
	}


	
	

}
