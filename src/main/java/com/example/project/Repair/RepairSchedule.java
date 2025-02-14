package com.example.project.Repair;

import java.util.ArrayList;

public class RepairSchedule {
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n) {
        numberOfMechanics=n;
        schedule= new ArrayList<>();
    }

    public ArrayList<CarRepair> getSchedule() {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b) {
        if(m>=0 && m< numberOfMechanics && b>=0){
            for(CarRepair s: schedule){
                if(s.getBayNum()==b || s.getMechanicNum()==m){
                    return false;
                }
            }
            schedule.add(new CarRepair(m, b));
            return true;
        } else {return false;}
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics() {
        ArrayList<Integer> mechanics= new ArrayList<Integer>();
        int change=0;
        for (int index = 0; index < numberOfMechanics; index++) {
            mechanics.add(index);
        }
        System.out.println(mechanics);
        for(CarRepair s: schedule){
                mechanics.remove(s.getMechanicNum()-change);
                change++;

        }
        System.out.println(mechanics);
        return mechanics;
    }

    /** Removes an element from schedule when a repair is complete.
        THIS METHOD HAS BEEN ADDED FOR ILLUSTRATIVE PURPOSES ONLY,
        AS DESCRIBED IN PART B; you do NOT need to call this
        method as part of your solution to part B
      */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }

    public static void main(String[] args) {
                //create repair schedule with 3 mechanics
    RepairSchedule schedule = new RepairSchedule(3); 
    ArrayList<Integer> availableMechanics = schedule.availableMechanics();

       schedule.addRepair(0, 1);
      System.out.println(schedule.getSchedule().size());
      schedule.addRepair(0, 1);
      System.out.println(schedule.getSchedule().size());

      schedule.addRepair(1, 1);
      System.out.println(schedule.getSchedule().size());

      schedule.addRepair(1, 2);
      availableMechanics = schedule.availableMechanics();
      System.out.println(availableMechanics.contains(2));
    }
}
