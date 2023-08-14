package com.amaap.taskmaster;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageManagernew{
    private static final String file="tasks.dat";

    public List<TaskToPerforms> load()
    {
        try
        {
            ObjectInputStream is=new ObjectInputStream(new FileInputStream(file));
            ArrayList<TaskToPerforms> ltp=(ArrayList<TaskToPerforms>)is.readObject();
            System.out.println("Tasks are loaded successfully in file...");
            return ltp;
        } catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
        catch(ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void save(List<TaskToPerforms> tp)
    {

        try
        {
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(tp);
            System.out.println("Tasks are saved successfully in file...");
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}

