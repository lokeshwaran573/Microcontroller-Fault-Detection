
package com.fault;

public class Main {

    public static void main(String[] args) {

        FaultDetector detector = new FaultDetector();

        System.out.println("==========================================");
        System.out.println("   MICROCONTROLLER FAULT DETECTION SYSTEM");
        System.out.println("==========================================");

        // Existing log detection
        String[] logs = {
            "SYSTEM_NORMAL",
            "SENSOR_NOT_RESPONDING",
            "COMMUNICATION_TIMEOUT",
            "WATCHDOG_RESET",
            "ABNORMAL_TEMPERATURE"
        };

        System.out.println("\n--- LOG BASED FAULT DETECTION ---");

        for (String log : logs) {
            System.out.println("Input Log : " + log);
            System.out.println("Result    : " + detector.detectFault(log));
            System.out.println("------------------------------------------");
        }

        // Simulated sensor readings
        double[][] sensorData = {
            {35.0, 5.0, 1.0},
            {75.0, 5.0, 1.0},
            {35.0, 6.0, 1.0},
            {35.0, 5.0, 3.0}
        };

        System.out.println("\n--- SENSOR BASED FAULT DETECTION ---");

        for (double[] sensor : sensorData) {

            System.out.println("Temperature : " + sensor[0] + " C");
            System.out.println("Voltage     : " + sensor[1] + " V");
            System.out.println("Current     : " + sensor[2] + " A");

            String result = detector.detectSensorFault(
                sensor[0], sensor[1], sensor[2]
            );

            System.out.println("Status      : " + result);
            System.out.println("------------------------------------------");
        }

        System.out.println("\nFault Detection Completed!");
    }
}
