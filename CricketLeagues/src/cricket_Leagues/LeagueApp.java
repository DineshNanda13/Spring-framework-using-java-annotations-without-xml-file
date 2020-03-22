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
