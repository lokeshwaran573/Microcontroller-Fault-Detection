
package com.fault;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FaultDetectorTest {

    FaultDetector detector = new FaultDetector();

    // Existing log-based tests

    @Test
    void testNormalCondition() {
        assertEquals(
            "NORMAL - No Fault Detected",
            detector.detectFault("SYSTEM_NORMAL")
        );
    }

    @Test
    void testSensorFailure() {
        assertEquals(
            "WARNING - Sensor Failure",
            detector.detectFault("SENSOR_NOT_RESPONDING")
        );
    }

    @Test
    void testCommunicationFailure() {
        assertEquals(
            "WARNING - Communication Failure",
            detector.detectFault("COMMUNICATION_TIMEOUT")
        );
    }

    @Test
    void testWatchdogReset() {
        assertEquals(
            "CRITICAL - Watchdog Reset",
            detector.detectFault("WATCHDOG_RESET")
        );
    }

    @Test
    void testAbnormalTemperature() {
        assertEquals(
            "CRITICAL - Abnormal Operating Condition",
            detector.detectFault("ABNORMAL_TEMPERATURE")
        );
    }

    @Test
    void testInvalidLog() {
        assertEquals("INVALID LOG", detector.detectFault(""));
    }

    // New sensor-based tests

    @Test
    void testNormalSensorReadings() {
        assertEquals(
            "NORMAL - All Sensors Working",
            detector.detectSensorFault(35.0, 5.0, 1.0)
        );
    }

    @Test
    void testHighTemperature() {
        assertEquals(
            "CRITICAL - High Temperature",
            detector.detectSensorFault(75.0, 5.0, 1.0)
        );
    }

    @Test
    void testAbnormalVoltage() {
        assertEquals(
            "CRITICAL - Voltage Abnormal",
            detector.detectSensorFault(35.0, 6.0, 1.0)
        );
    }

    @Test
    void testAbnormalCurrent() {
        assertEquals(
            "WARNING - Current Abnormal",
            detector.detectSensorFault(35.0, 5.0, 3.0)
        );
    }

    @Test
    void testInvalidSensorData() {
        assertEquals(
            "INVALID SENSOR DATA",
            detector.detectSensorFault(Double.NaN, 5.0, 1.0)
        );
    }
}
