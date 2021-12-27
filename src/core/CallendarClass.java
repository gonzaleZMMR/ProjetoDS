package core;

import java.time.LocalDateTime;

public class CallendarClass {
	
	private String callendarMessage;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private int repeatRate;

	public CallendarClass(String callendarMessage, LocalDateTime startDate, LocalDateTime endDate, int repeatRate) {
		super();
		this.callendarMessage = callendarMessage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.repeatRate = repeatRate;
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
	
}
