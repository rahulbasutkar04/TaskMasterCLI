package com.amaap.taskmaster;

import java.io.*;
import java.time.*;
public class TaskToPerforms implements Serializable {

    private TaskPri priority;
    private boolean completed;
    private LocalDate reminderDate;
    private String description;
    private LocalDate dueDate;

    public TaskToPerforms(String description, LocalDate dueDate, TaskPri priority)
    {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }


    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public TaskPri getPriority()
    {
        return priority;
    }

    public void setPriority(TaskPri priority)
    {
        this.priority = priority;
    }
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }
    public LocalDate getReminderDate()
    {
        return reminderDate;
    }

    public void setReminderDate(LocalDate reminderDate)
    {
        this.reminderDate = reminderDate;
    }

    public String toString()
    {
        String newstr= "Description: " + description + ",DueDate:"+dueDate +",Priority:" +priority +",Completed: " + completed;
        return newstr;
    }

}
