package java8.worker.schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map.Entry;

public class WorkerSchedule{
    private HashMap< Integer, HashSet <String> > weekToWorkers;
    public WorkerSchedule(){
        weekToWorkers = new HashMap<>();
    }
    public void add(int week, HashSet<String> newe){
        if(!weekToWorkers.containsKey( week ) ){
            weekToWorkers.put(week, new HashSet<String>());
        }
        //HashSet<String> workers = weekToWorkers.get(week);
        /*for(String worker : newe){
            workers.add(worker);
        }*/
        //workers.addAll(newe);
        weekToWorkers.get(week).addAll(newe);
    }
    public void add(HashSet<Integer> week, ArrayList<String> newe){
        HashSet<String> nws = new HashSet<String>();
        nws.addAll(newe);
        for(Integer weeke : week){
            add(weeke, nws);
        }
    }
    public boolean isWorkingOnWeek(String name , int week){
        if(!weekToWorkers.containsKey( week ) ){
            return false;
        }
        return weekToWorkers.get(week).contains(name);
    }
    public HashSet<Integer> getWorkWeeks(String name){
        HashSet<Integer> assi = new HashSet<>();
        for(Entry<Integer, HashSet<String>> entry : weekToWorkers.entrySet()){
            Integer week = entry.getKey();
            if(isWorkingOnWeek(name, week)){
                assi.add(week);
            }
        } 
        return assi;
    }
    public boolean isEmptySc(){
        return weekToWorkers.isEmpty();
    }
}