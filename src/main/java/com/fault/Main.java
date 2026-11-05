
package com.fault;

public class Main {

    public static void main(String[] args) {

        FaultDetector detector = new FaultDetector();

        String[] logs = {
            "SYSTEM_NORMAL",
            "SENSOR_NOT_RESPONDING",
            "COMMUNICATION_TIMEOUT",
            "WATCHDOG_RESET",
            "ABNORMAL_TEMPERATURE"
        };

        System.out.println("==========================================");
        System.out.println("   MICROCONTROLLER FAULT DETECTION SYSTEM");
        System.out.println("==========================================");

        for (String log : logs) {

            String result = detector.detectFault(log);

            System.out.println("Input Log : " + log);
            System.out.println("Result    : " + result);

            System.out.println("------------------------------------------");
        }

        System.out.println("Fault Detection Completed!");
    }
}
