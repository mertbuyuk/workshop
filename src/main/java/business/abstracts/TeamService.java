package business.abstracts;

import java.util.List;


import entities.concretes.Player;
import entities.concretes.Team;

public interface TeamService {
	//List<Player> findByTeamId(int id);

	List<Player> findByTeamId(List<Integer> id);
	
	Player deleteById(int teamId, int playerId);
	
	Player updateById(int teamId, int playerId, String isim);

	void add(Player player);
	
	List<Team> getAll();
	
}
