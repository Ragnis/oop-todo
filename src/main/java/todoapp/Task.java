package todoapp;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task
{
	private static int maxId = 0;

	private int id;
	private LocalDateTime deadline;
	private String name;
	private boolean done;

	/**
	 * Create a new Task instance
	 */
	public Task(int id, String name, LocalDateTime deadline, boolean done)
	{
		this.id = id;
		this.name = name;
		this.deadline = deadline;
		this.done = done;

		if (id > Task.maxId)
		{
			Task.maxId = id;
		}
	}

	/**
	 * Create a new Task instance and auto-generate the ID.
	 */
	public Task(String name, LocalDateTime deadline)
	{
		this(Task.maxId + 1, name, deadline, false);
	}

	/**
	 * Get id.
	 *
	 * @return id as int.
	 */
	public int getId()
	{
	    return id;
	}

	/**
	 * Get deadline.
	 *
	 * @return deadline as LocalDateTime.
	 */
	public LocalDateTime getDeadline()
	{
		return deadline;
	}

	/**
	 * Set deadline.
	 *
	 * @param deadline the value to set.
	 */
	public void setDeadline(LocalDateTime deadline)
	{
		this.deadline = deadline;
	}

	/**
	 * Get name.
	 *
	 * @return name as String.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set name.
	 *
	 * @param name the value to set.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Get done.
	 *
	 * @return done as boolean.
	 */
	public boolean getDone()
	{
		return done;
	}

	/**
	 * Set done.
	 *
	 * @param done the value to set.
	 */
	public void setDone(boolean done)
	{
		this.done = done;
	}

	protected int getNumericDate()
	{
		int year = deadline.getYear();
		int month = deadline.getMonthValue();
		int day = deadline.getDayOfMonth();

		return year * 10000 + month * 100 + day;
	}

	public String toString()
	{
		String done = this.done ? "x" : " ";
		String deadline = this.deadline.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

		return String.format("%-2d %s [%s] %s", id, deadline, done, name);
	}
}
