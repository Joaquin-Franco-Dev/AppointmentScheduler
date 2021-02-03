package com.scheduler.runner;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalTime startTime = LocalTime.now();
        LocalTime endTime = LocalTime.now().plusMinutes(15);

        System.out.println("startTime is : " + startTime);
        System.out.println("endTime is : " + endTime +"\n");

        AppointmentScheduler appointment = new AppointmentScheduler();

        //System.out.println("Successful - Scheduling appointment : Joaquin");
        ResponseObject responseObject = appointment.scheduleAppointment("Joaquin", startTime, endTime);
        System.out.println(responseObject.toString());

        System.out.println();
        //System.out.println("Conflict - Scheduling appointment : Larry");
        ResponseObject responseObject2 = appointment.scheduleAppointment("Larry", startTime, endTime);
        System.out.println(responseObject2.toString());

        System.out.println();
        //System.out.println("Successful - Scheduling appointment : Joaquin");
        ResponseObject responseObject3 = appointment.scheduleAppointment("Mary", LocalTime.now().plusMinutes(20), LocalTime.now().plusMinutes(30));
        System.out.println(responseObject3.toString());

        System.out.println();
        //System.out.println("Conflict - Scheduling appointment : Larry");
        ResponseObject responseObject4 = appointment.scheduleAppointment("Samuel", LocalTime.now().plusMinutes(20), LocalTime.now().plusMinutes(30));
        System.out.println(responseObject4.toString());


    }

}




