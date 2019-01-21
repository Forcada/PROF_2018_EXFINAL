package es.upm.grise.profundizacion2018.examenFinal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GreetingTest {
	
	@Mock Calendar mockCalendar;
	
	@Before
	public void init() {
		
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void smokeTest1() {
		
		given(mockCalendar.get(Calendar.HOUR_OF_DAY)).willReturn(10);
		
		Greeting greeting = new Greeting(mockCalendar);
		assertThat(greeting.getGreeting(null)).isEqualTo("Good morning");
	}
	
	@Test
	public void smokeTest2() {

		given(mockCalendar.get(Calendar.HOUR_OF_DAY)).willReturn(10);
		
		Greeting greeting = new Greeting(mockCalendar);
		assertThat(greeting.getGreeting(Language.ENGLISH)).isEqualTo("Good morning");
	}
	
	@Test
	public void smokeTest3() {

		given(mockCalendar.get(Calendar.HOUR_OF_DAY)).willReturn(10);
		
		Greeting greeting = new Greeting(mockCalendar);
		assertThat(greeting.getGreeting(Language.SPANISH)).isEqualTo("Buenos días");
	}

}
