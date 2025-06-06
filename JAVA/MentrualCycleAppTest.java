import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class MentrualCycleAppTest {
	
	@Test
	public void testCalculateNextPeriodDate() {
		LocalDate lastPeriodDate = LocalDate.of(2024, 7, 2);
		int cycleLength = 23;
		LocalDate expectedNextPeriod = LocalDate.of(2024, 7, 25);
		assertEquals(expectedNextPeriod, MenstrualCycleApp.calculateNextPeriodDate(lastPeriodDate, cycleLength));
	}

	@Test
	public void testCalculateOvulationDate() {
		LocalDate lastPeriodDate = LocalDate.of(2024, 7, 1);
		LocalDate expectedOvulationDate = LocalDate.of(2024, 7, 15);
		assertEquals(expectedOvulationDate, MenstrualCycleApp.calculateOvulationDate(lastPeriodDate));
	}
}