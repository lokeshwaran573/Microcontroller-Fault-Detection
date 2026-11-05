
package com.fault;

public class FaultDetector {

    public String detectFault(String log) {

        if (log == null || log.isBlank()) {
            return "INVALID LOG";
        }

        String data = log.toUpperCase();

        if (data.contains("ABNORMAL_TEMPERATURE")) {
            return "CRITICAL - Abnormal Operating Condition";
        }

        if (data.contains("WATCHDOG_RESET")) {
            return "CRITICAL - Watchdog Reset";
        }

        if (data.contains("SENSOR_NOT_RESPONDING")) {
            return "WARNING - Sensor Failure";
        }

        if (data.contains("COMMUNICATION_TIMEOUT")) {
            return "WARNING - Communication Failure";
        }

        return "NORMAL - No Fault Detected";
    }
}
