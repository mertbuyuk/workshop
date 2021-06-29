package dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import entities.concretes.Player;
import entities.concretes.Team;

public interface TeamDao extends JpaRepository<Team, Integer> {
	
	//@Query("From Team where teamId=:teamId")
	List<Player> findByTeamId(List<Integer> id);
	
	@Query("delete from Team p where teamId=:teamId and p.playerId = :playerId")
	Player deletePlayersById(int teamId,int playerId);
	
	@Query("update Player p set p.name=:isim where p.teamId=:teamId and playerId = :playerId")
	Player updatePlayersById(int teamId,int playerId,String isim);
	
}
