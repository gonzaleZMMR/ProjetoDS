package calendar;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CallendarEvent implements Serializable{
	
	private int id;
	
	private String callendarMessage;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private int repeatRate;
	
	private int timeBeforeAlert;
	
	private String phoneNumber;
	
	public CallendarEvent() {
	}

	public CallendarEvent(int id, String callendarMessage, LocalDateTime startDate, LocalDateTime endDate,
			int repeatRate, int timeBeforeAlert) {
		super();
		this.id = id;
		this.callendarMessage = callendarMessage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.repeatRate = repeatRate;
		this.timeBeforeAlert = timeBeforeAlert;
	}

	public CallendarEvent(String callendarMessage, LocalDateTime startDate, LocalDateTime endDate, int repeatRate,
			int timeBeforeAlert) {
		this.callendarMessage = callendarMessage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.repeatRate = repeatRate;
		this.timeBeforeAlert = timeBeforeAlert;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCallendarMessage() {
		return callendarMessage;
	}

	public void setCallendarMessage(String callendarMessage) {
		this.callendarMessage = callendarMessage;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	//Repeat rate will be in seconds so it makes the tests easier
	public int getRepeatRate() {
		return repeatRate * 1000;
	}

	public void setRepeatRate(int repeatRate) {
		this.repeatRate = repeatRate;
	}

	public int getTimeBeforeAlert() {
		return timeBeforeAlert;
	}

	public void setTimeBeforeAlert(int timeBeforeAlert) {
		this.timeBeforeAlert = timeBeforeAlert;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CallendarEvent [callendarMessage=" + callendarMessage + ", startDate=" + startDate + ", endDate="
				+ endDate + ", repeatRate=" + repeatRate + ", timeBeforeAlert=" + timeBeforeAlert + "]";
	}
	
}
