package ru.isg.patterns.behavioral.chainofresp;

/**
 * Created by s.ivanov on 17.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		Logger fileLogger = new FileLogger();
		Logger emailLogger = new EmailLogger();
		fileLogger.setNext(emailLogger);
		Logger smsLogger = new SmsLogger();
		emailLogger.setNext(smsLogger);
		fileLogger.write("debug!!!", AbstractLogger.DEBUG_LEVEL);
		fileLogger.write("info!!!", AbstractLogger.INFO_LEVEL);
		fileLogger.write("error!!!", AbstractLogger.ERROR_LEVEL);
	}
}

// Theory and example

// Handler's interface with BL method and declaration of the setter of the next object
interface Logger {
	void write(String message, int level);
	void setNext(Logger logger);
}

// Abstract class for define setter of next object
abstract class AbstractLogger implements Logger {

	public static int ERROR_LEVEL = 3;
	public static int INFO_LEVEL = 2;
	public static int DEBUG_LEVEL = 1;

	protected Logger next;

	@Override
	public void setNext(Logger logger) {
		this.next = logger;
	}
}

// Concrete handlers
class FileLogger extends AbstractLogger {
	@Override
	public void write(String message, int level) {
		if (level >= DEBUG_LEVEL) {
			System.out.println("write to file: " + message);
		}
		if (next != null) {
			next.write(message, level);
		}
	}
}

class EmailLogger extends AbstractLogger {
	@Override
	public void write(String message, int level) {
		if (level >= INFO_LEVEL) {
			System.out.println("send email: " + message);
		}
		if (next != null) {
			next.write(message, level);
		}
	}
}

class SmsLogger extends AbstractLogger {
	@Override
	public void write(String message, int level) {
		if (level >= ERROR_LEVEL) {
			System.out.println("send sms: " + message);
		}
		if (next != null) {
			next.write(message, level);
		}
	}
}