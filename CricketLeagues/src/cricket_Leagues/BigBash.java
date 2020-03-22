package cricket_Leagues;

public class BigBash implements Leagues {

	private Fixtures fixtures;
	
	public BigBash(Fixtures theFixtures) {
		super();
		this.fixtures = theFixtures;
	}

	@Override
	public String getLeagueName() {
		return "Big Bash is Australia's league";
	}

	@Override
	public String getLeagueFixtures() {
		return fixtures.getFixtures();
	}

}
