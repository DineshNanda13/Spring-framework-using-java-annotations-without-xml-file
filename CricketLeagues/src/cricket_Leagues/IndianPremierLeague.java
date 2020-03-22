package cricket_Leagues;

import org.springframework.beans.factory.annotation.Value;

public class IndianPremierLeague implements Leagues {
	
	private Fixtures fixtures;
	
	@Value ("${foo.country}")
	private String country;
	
	@Value ("${foo.website}")
	private String website;
	
	public String getCountry() {
		return country;
	}

	public String getWebsite() {
		return website;
	}

	public IndianPremierLeague(Fixtures theFixtures) {
		super();
		this.fixtures = theFixtures;
	}

	@Override
	public String getLeagueName() {
		
		return "IPL is India's leaugue";
	}

	@Override
	public String getLeagueFixtures() {
		return fixtures.getFixtures();
	}

}
