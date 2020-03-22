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
