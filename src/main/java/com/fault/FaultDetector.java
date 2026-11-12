
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

    // Sensor-based fault detection
    public String detectSensorFault(
            double temperature,
            double voltage,
            double current) {

        if (!Double.isFinite(temperature)
                || !Double.isFinite(voltage)
                || !Double.isFinite(current)) {
            return "INVALID SENSOR DATA";
        }

        if (temperature > 60) {
            return "CRITICAL - High Temperature";
        }

        if (temperature < 20) {
            return "WARNING - Low Temperature";
        }

        if (voltage < 4.5 || voltage > 5.5) {
            return "CRITICAL - Voltage Abnormal";
        }

        if (current < 0.1 || current > 2.0) {
            return "WARNING - Current Abnormal";
        }

        return "NORMAL - All Sensors Working";
    }
}
