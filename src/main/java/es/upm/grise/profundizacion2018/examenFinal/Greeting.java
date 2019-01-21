package es.upm.grise.profundizacion2018.examenFinal;

import java.util.Calendar;

public class Greeting {
	
	Calendar calendar;
	
	public Greeting(Calendar calendar) {
		this.calendar = calendar;
	}
	
	public String getGreeting( Language language ) {
		// Get current hour
		int hour = calendar.get( Calendar.HOUR_OF_DAY );
		
		// Find out the greeting language
		if ( language == null )
			language = Message.getDefaultLanguage();
		
		// Get the moment of the day
		TimeOfTheDay moment;
		if( hour < 12 ) 
			moment = TimeOfTheDay.MORNING;
		else if ( hour < 18 )
			moment = TimeOfTheDay.AFTERNOON;
		else
			moment = TimeOfTheDay.EVENING;
			
		// Return the message		
		return Message.getMessage( moment, language );
	}
}
