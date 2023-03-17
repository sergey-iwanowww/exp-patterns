package ru.isg.patterns.behavioral.memento;

/**
 * Created by s.ivanov on 17.09.2018.
 */
public class Main {

	public static void main(String[] args) {

		Game firstAttempt = new Game();

		System.out.println("game started: " + firstAttempt);

		firstAttempt.goToNextLevel();

		System.out.println("game before saving: " + firstAttempt);
		File file = new File(firstAttempt.save());

		Game secondAttempt = new Game();
		secondAttempt.load(file.getSave());

		System.out.println("game after loading: " + secondAttempt);
	}
}

// Theory

// Object whose state you want to save
class Originator {

	int field1;
	String field2;

	public Snapshot createSnapshot() {
		return new Snapshot(field1, field2);
	}

	public void restoreState(Snapshot snapshot) {
		field1 = snapshot.getField1();
		field2 = snapshot.getField2();
	}
}

class Snapshot {
	int field1;
	String field2;
	public Snapshot(int field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
	}

	public int getField1() {
		return field1;
	}

	public void setField1(int field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
}

// Storage for snapshots
class Caretaker {
	Snapshot[] snapshots;
}

// Example

class Game {
	private int progressInMs;
	private String levelName;

	public Game() {
		this.progressInMs = 0;
		this.levelName = "level 1";
	}

	public Save save() {
		return new Save(progressInMs, levelName);
	}
	public void load(Save save) {
		progressInMs = save.getProgressInMs();
		levelName = save.getLevelName();
	}

	public void goToNextLevel() {
		levelName = "level 2";
		progressInMs = 60 * 1000;
	}

	@Override
	public String toString() {
		return "Game{" +
				"progressInMs=" + progressInMs +
				", levelName='" + levelName + '\'' +
				'}';
	}
}

class Save {
	private int progressInMs;
	private String levelName;

	public Save(int progressInMs, String levelName) {
		this.progressInMs = progressInMs;
		this.levelName = levelName;
	}

	public int getProgressInMs() {
		return progressInMs;
	}

	public void setProgressInMs(int progressInMs) {
		this.progressInMs = progressInMs;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
}

class File {
	private Save save;

	public File(Save save) {
		this.save = save;
	}

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}
}