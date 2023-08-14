package com.amaap.taskmaster;
import java.util.*;
import java.time.*;

public class AllTask {


    StorageManagernew st=new StorageManagernew();
    ArrayList<TaskToPerforms>taskp=new ArrayList<>();
    public AllTask() {
        loadTasks();
    }

    public void addTask(String description, LocalDate dueDate, TaskPri priority, LocalDate reminderDate)
    {
        TaskToPerforms tp;
        tp=new TaskToPerforms(description, dueDate, priority);
        tp.setReminderDate(reminderDate);
        this.taskp.add(tp);
        saveTasks();
    }

    public void listAllTasks()
    {
        if (taskp.isEmpty())
        {
            System.out.println("No Task available Please add taskToPerforms.");
            return;
        }
        System.out.println("All Tasks are:");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("INDEX\t\t\t"+"DETAILS\t\t\t"+"DUEDATE\t\t\t"+"PRIORITY\t"+"COMPLETED\t\t");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        int n=taskp.size();
        for (int i=0;i<n;i++)
        {
            TaskToPerforms tp=this.taskp.get(i);
            System.out.printf(" %5d | %20s | %10s | %10s | %5s%n",
                    i,tp.getDescription(),tp.getDueDate(),tp.getPriority(),tp.isCompleted() ? "Yes" : "No");
        }
        System.out.println("<------------------------------------------------------------------------------------------------------------>");
    }
    public void listTasksByPriority()
    {
        if (taskp.isEmpty())
        {
            System.out.println("No task available. Please add taskToPerforms.");
            return;
        }
        System.out.println("Followings are Tasks by Priority:");
        taskp.sort((tsp1, tsp2) -> tsp2.getPriority().compareTo(tsp1.getPriority()));
        listAllTasks();
    }

    public void listTasksByDueDate()
    {
        if (taskp.isEmpty())
        {
            System.out.println("No task available.... Please add task.");
            return;
        }
        System.out.println("Followings are the Tasks by DueDate:");
        taskp.sort((tsp1, tsp2) -> tsp1.getDueDate().compareTo(tsp2.getDueDate()));
        listAllTasks();
    }


    public void markTaskAsDone(int index)
    {
        if (taskp.isEmpty())
        {
            System.out.println("No task available... Please add task.");
            return;
        }
        if (index>=0 && index<taskp.size())
        {
            taskp.get(index).setCompleted(true);
            saveTasks();
        }
    }
    public void listPendingTasks()
    {
        System.out.println("Followings are the Pending Tasks:");
        int  pending=0;
        int n=taskp.size();
        for (int i=0;i<n;i++)
        {
            TaskToPerforms Tp=this.taskp.get(i);
            if (!Tp.isCompleted())
            {
                System.out.printf("%d\t%s-->(Due:\t%s, Priority:\t%s)%n", i,Tp.getDescription(),Tp.getDueDate(),Tp.getPriority());
                pending=1;
            }
        }
        if(pending==0) System.out.println("No pending task here ... Please add task.");

    }
    public void removecompletedtasks()
    {
        if (taskp.isEmpty())
        {
            System.out.println("No task available here.. Please add task.");
            return;
        }
        Iterator<TaskToPerforms> iterator=taskp.iterator();
        int count= 0;
        while (iterator.hasNext())
        {
            TaskToPerforms taskToPerforms=iterator.next();
            if (taskToPerforms.isCompleted())
            {
                iterator.remove();
                count++;
            }
        }
        if(count>0)
        {
            System.out.println("Completed task is  removed!");
        } else
        {
            System.out.println("completed task is not removed try again");
        }
    }
    public ArrayList<TaskToPerforms> getTasks()
    {
        return taskp;
    }
    public void loadTasks()
    {
        ArrayList<TaskToPerforms> loadedTaskToPerforms=(ArrayList<TaskToPerforms>)st.load();
        if (loadedTaskToPerforms!=null)
        {
            taskp=loadedTaskToPerforms;
        }

    }
    void saveTasks()
    {
        st.save(taskp);
    }

}