package mis.nccu.clubinfoplatform.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "record")
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String login;
	
	private Date recordDate;
	
	private int highBp;
	
	private int lowBp;
	
	private int heartbeats;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public int getHighBp() {
		return highBp;
	}

	public void setHighBp(int highBp) {
		this.highBp = highBp;
	}

	public int getLowBp() {
		return lowBp;
	}

	public void setLowBp(int lowBp) {
		this.lowBp = lowBp;
	}

	public int getHeartbeats() {
		return heartbeats;
	}

	public void setHeartbeats(int heartbeats) {
		this.heartbeats = heartbeats;
	}

}