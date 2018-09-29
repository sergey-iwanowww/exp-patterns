package ru.isg.pattern11chainofresp;

/**
 * Created by s.ivanov on 17.09.2018.
 */
public class Main {
	public static void main(String[] args) {
		Logger fileLogger = new FileLogger(new EmailLogger(new SmsLogger(null)));
		fileLogger.write("debug!!!", AbstractLogger.DEBUG_LEVEL);
		fileLogger.write("info!!!", AbstractLogger.INFO_LEVEL);
		fileLogger.write("error!!!", AbstractLogger.ERROR_LEVEL);
	}
}

interface Logger {
	void write(String message, int level);
}

abstract class AbstractLogger implements Logger {

	public static int ERROR_LEVEL = 3;
	public static int INFO_LEVEL = 2;
	public static int DEBUG_LEVEL = 1;

	protected Logger next;
}

class FileLogger extends AbstractLogger {
	public FileLogger(Logger next) {
		this.next = next;
	}
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
	public EmailLogger(Logger next) {
		this.next = next;
	}
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
	public SmsLogger(Logger next) {
		this.next = next;
	}
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