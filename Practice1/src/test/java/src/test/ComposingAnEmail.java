package src.test;

import org.apache.log4j.Logger;

public class ComposingAnEmail {
	
	static public void compose()
	{
		System.out.println("Write the compose email logic");
		Logger log= Logger.getLogger("devpinoyLogger");
		log.debug("This is just a trial");
	}

	public static void main(String...args)
	{
		compose();
		Logger log =Logger.getLogger("devpinoyLogger");
		log.debug("Log");
		
	}
}
