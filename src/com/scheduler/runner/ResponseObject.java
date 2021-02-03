package com.scheduler.runner;

public class ResponseObject {

    private Boolean successFul;
    private String message;
    private Appointment appointment;

    ResponseObject(Boolean successFul, String message) {
        this.successFul = successFul;
        this.message = message;
    }

    public Boolean getSuccessFul() {
        return successFul;
    }

    public String getMessage() {
        return message;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "successFul=" + successFul +
                ", message='" + message + '\'' +
                '}';
    }
}
