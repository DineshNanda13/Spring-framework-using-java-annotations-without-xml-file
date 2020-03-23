# Spring-framework-using-java-annotations-without-xml-file
Illustration of registering beans and injecting dependencies without using XML file. Java source code is created instead of XML file.

// File name: CricketConfig.java

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

//File name : Leagues.java

package cricket_Leagues;

public interface Leagues {
	
	public String getLeagueName();
	
	public String getLeagueFixtures();
}

//File name : IndianPremierLeague.java

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

// File name : BigBash.java

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

//File name : Fixtures.java

package cricket_Leagues;

public interface Fixtures {
	
	public String getFixtures();

}

//File name : LeagueFixtures.java

package cricket_Leagues;

import java.util.Random;

public class LeagueFixtures implements Fixtures {

	@Override
	public String getFixtures() {
		String arr[] = {"It is played in April", "It is played in November"};
		
		Random random = new Random();
		int position = random.nextInt(arr.length);
		return arr[position];
		
	}

}

// File name : league.properties

foo.country = India
foo.website = ipl.com

//File name : LeagueApp.java

package cricket_Leagues;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LeagueApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CricketConfig.class);
		
		IndianPremierLeague theLeagues = context.getBean("indianPremierLeague", IndianPremierLeague.class);
		
		System.out.println(theLeagues.getLeagueName());
		System.out.println(theLeagues.getLeagueFixtures());
		
		System.out.println("Country name: "+theLeagues.getCountry());
		System.out.println("Website: "+theLeagues.getWebsite());
		
		context.close();

	}

}
