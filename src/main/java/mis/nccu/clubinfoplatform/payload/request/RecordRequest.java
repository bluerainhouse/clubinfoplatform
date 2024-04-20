package mis.nccu.clubinfoplatform.payload.request;

import jakarta.validation.constraints.NotBlank;

public class RecordRequest {
	@NotBlank
	private String login;
	
	private int highBp;
	
	private int lowBp;
	
	private int hr;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}
}
