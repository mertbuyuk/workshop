package entities.concretes;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player")

public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="player_id")
	private int playerId;
	
	@ManyToOne()
    @JoinColumn(name="team_id")
    private Team teamId;
	
	private String name;
	private String surname;
	private String position;
	private String nationality;
	private int number;
	
}