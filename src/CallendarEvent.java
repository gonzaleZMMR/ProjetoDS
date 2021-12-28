import java.time.LocalDateTime;

public class CallendarEvent{
	
	private int id;
	
	private String callendarMessage;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private int repeatRate;
	
	private int timeBeforeAlert;
	
	public CallendarEvent() {
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

	public int getRepeatRate() {
		return repeatRate;
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

	@Override
	public String toString() {
		return "CallendarEvent [callendarMessage=" + callendarMessage + ", startDate=" + startDate + ", endDate="
				+ endDate + ", repeatRate=" + repeatRate + ", timeBeforeAlert=" + timeBeforeAlert + "]";
	}
	
}
