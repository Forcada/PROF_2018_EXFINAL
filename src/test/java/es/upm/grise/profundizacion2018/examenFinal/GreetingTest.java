package es.upm.grise.profundizacion2018.examenFinal;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GreetingTest {
	
	@Mock Calendar mockCalendar;
	@Mock Message mockMessage;
	
	Greeting greeting;
	
	@Before
	public void init() {
		
		MockitoAnnotations.initMocks(this);
		
		given(mockCalendar.get(Calendar.HOUR_OF_DAY)).willReturn(10);
		given(mockMessage.getDefaultLanguage()).willReturn(Language.ENGLISH);
		given(mockMessage.getMessage(TimeOfTheDay.MORNING, Language.ENGLISH)).willReturn("Good morning");
		given(mockMessage.getMessage(TimeOfTheDay.MORNING, Language.SPANISH)).willReturn("Buenos días");
		
		greeting = new Greeting(mockCalendar, mockMessage);
	}

	@Test
	public void smokeTest1() {
		
		then(greeting.getGreeting(null)).isEqualTo("Good morning");
	}
	
	@Test
	public void smokeTest2() {
		
		then(greeting.getGreeting(Language.ENGLISH)).isEqualTo("Good morning");
	}
	
	@Test
	public void smokeTest3() {
		
		then(greeting.getGreeting(Language.SPANISH)).isEqualTo("Buenos días");
	}

	@Test
	public void smokeTest4() {

		greeting.getGreeting(null);
		
		verify(mockMessage).getDefaultLanguage();
		verify(mockMessage).getMessage(TimeOfTheDay.MORNING, Language.ENGLISH);
	}

	@Test
	public void smokeTest5() {

		greeting.getGreeting(Language.ENGLISH);
		
		verify(mockMessage, never()).getDefaultLanguage();
		verify(mockMessage).getMessage(TimeOfTheDay.MORNING, Language.ENGLISH);
	}

}
