package cricket_Leagues;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:league.properties")
public class CricketConfig {
	
	@Bean
	public Fixtures leagueFixtures() {
		return new LeagueFixtures();
	}

	@Bean
	public Leagues indianPremierLeague() {
		
		IndianPremierLeague myIPL = new IndianPremierLeague(leagueFixtures());
		return myIPL;
	}
	
	@Bean
	public Leagues bigBash() {
		BigBash myBigBash = new BigBash(leagueFixtures());
		return myBigBash;
	}
}
