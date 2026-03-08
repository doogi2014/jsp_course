
public class AlarmClock extends Clock {
	
	public String alarmTime;

	public AlarmClock(String time) {
		super(time);
	}

	public void alarm() {
		if(this.alarmTime.equals(this.time)) {
			System.out.println("アラームが鳴りました!");
		}
	}
	
	public void setAlarm(String time) {
		this.alarmTime = time;
	}
}
