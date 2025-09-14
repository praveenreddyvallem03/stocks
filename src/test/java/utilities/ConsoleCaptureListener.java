package utilities;

	import org.testng.IExecutionListener;
	import java.util.Arrays;

	public class ConsoleCaptureListener implements IExecutionListener {
	    private static final String LOG_PATH   = "target/run-console.log";
	    private static final String XLSX_PATH  = "target/run-console.xlsx";

	    // <-- Put your Gmail and App password here (hardcoded)
	    private static final String SMTP_USER = "praveenrsas@gmail.com";
	    private static final String SMTP_PASS = "oqhp ytjr qtom qksh";

	    @Override
	    public void onExecutionStart() {
	        ConsoleCapture.start(LOG_PATH);
	    }

	    @Override
	    public void onExecutionFinish() {
	        ConsoleCapture.stop();
	        LogToExcelWriter.write(LOG_PATH, XLSX_PATH);

	        EmailSender.send(
	                "smtp.gmail.com", 587,
	                SMTP_USER, SMTP_PASS,
	                SMTP_USER,
	                "praveenvallem2002@gmail.com",
	                "[BDD] Daily Automation Report",
	                "Attached: console log and Excel.",
	                Arrays.asList(LOG_PATH, XLSX_PATH)
	        );
	    }
	
}
