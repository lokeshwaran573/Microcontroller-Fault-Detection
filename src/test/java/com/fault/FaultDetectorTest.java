
package com.fault;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FaultDetectorTest {

    FaultDetector detector = new FaultDetector();

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
}
