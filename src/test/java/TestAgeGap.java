import org.example.DeathCauseStatistic;
import org.junit.Test;

public class TestAgeGap {
    @Test
    public void test(){
        DeathCauseStatistic stats = DeathCauseStatistic.fromCsvLine("A02.1          ,5,-,-,-,-,-,-,-,-,-,-,-,-,1,2,-,1,1,-,-,-");
        DeathCauseStatistic.AgeBracketDeaths death = stats.ageGapDeaths(4);
        System.out.println(death.toString());
    }
}
