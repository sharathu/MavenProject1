package src.generic;

import org.openqa.selenium.WebDriver;

import src.test.*;


public class ClassImport {
	WebDriver driver;
	public ClassImport(String ClassName, WebDriver driver) throws Exception
	{
		this.driver=driver;
		switch(ClassName)
		{
		case "TokenEnrollment":
			new TokenEnrollment(this.driver);
			break;
		case "IBE_Enrollment":
			//new IBE_Enrollment().ibeEnr();
			break;
		case "ComposingAnEmail":
			//ComposingAnEmail c= new ComposingAnEmail();
			ComposingAnEmail.compose();
			break;
		case "RequestPHR":
			new RequestPHR().requestPHR();
			break;
		case "EPM_Appointment":
			new EPM_Appointment().epmAppt();
			break;
		case "RealTimeAppointment":
			new RealTimeAppointment().realtimeAppt();
			break;
		case "MedicationRenewal":
			new MedicationRenewal().medsRenew();
			break;
		case "Payment":
			new Payment().payment();
			break;
			
		}
	}

}
