package homework5;

import java.time.Duration;
import java.time.LocalDateTime;

public class MonitoredData {
	
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String activityLabel;
	
	/**
	 * @param startTime
	 * @param endTime
	 * @param activityLabel
	 */
	public MonitoredData(LocalDateTime startTime, LocalDateTime endTime, String activityLabel) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.activityLabel = activityLabel;
	}

	/**
	 * @return the startTime
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the activityLabel
	 */
	public String getActivityLabel() {
		return activityLabel;
	}

	/**
	 * @param activityLabel the activityLabel to set
	 */
	public void setActivityLabel(String activityLabel) {
		this.activityLabel = activityLabel;
	}
	
	public Duration getDuration()
	{
		return Duration.between(startTime, endTime);
	}
	
	@Override
	public String toString() {
		return startTime.format(DataPopulation.format) + "		" + endTime.format(DataPopulation.format) + "		" + activityLabel;
	}
}
