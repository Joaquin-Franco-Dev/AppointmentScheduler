package com.scheduler.runner;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class AppointmentScheduler {

    // Time slots for the day in 1 minute slots
    private static String[] dayAppointment  = new String[24 * 60];
    private static Integer appointmentId = 1;
    private static String AVAILABLE = "Available";

    static {
         Arrays.fill(dayAppointment, AVAILABLE);
    }

    public ResponseObject scheduleAppointment(String name, LocalTime startTime, LocalTime endTime) {

        ResponseObject responseObject = null;

        // Convert seconds of day to minutes of day
        int startMinuteOfDay = startTime.toSecondOfDay() / 60;
        int endMinuteOfDay = endTime.toSecondOfDay() / 60;

        for (int i = startMinuteOfDay; i < endMinuteOfDay ; i++) {
            if (dayAppointment[i] != AVAILABLE) {
                responseObject = new ResponseObject(Boolean.FALSE, "Conflict with " +dayAppointment[i]);
                return responseObject;
            }
        }

        if (completeSchedulingAppointment(name, startMinuteOfDay, endMinuteOfDay)) {
            Appointment appointment = new Appointment(name, startTime.format(DateTimeFormatter.ofPattern("HH:mm")), endTime.format(DateTimeFormatter.ofPattern("HH:mm")));
            responseObject = new ResponseObject(Boolean.TRUE, appointment.getName()+", scheduled at " +appointment.getStartDateTime() + " until " + appointment.getEndDateTime());
            responseObject.setAppointment(appointment);
        } else {
            responseObject = new ResponseObject(Boolean.FALSE, "Internal error encountered scheduling appointment");
        }
        return responseObject;
    }

    private boolean completeSchedulingAppointment(String name, int startTime, int endTime) {

        try {
            for (int i = startTime; i < endTime; i++) {
                dayAppointment[i] = appointmentId + " scheduled to " + name;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        appointmentId++;
        return true;
    }
}
