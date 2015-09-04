package com.michelin.solutions.electrum.controller;

import com.michelin.solutions.electrum.domain.VehicleSummary;
import com.michelin.solutions.electrum.test.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class VehicleSummaryControllerTest extends AbstractTest {

    @Autowired
    private VehicleSummaryController vehicleSummaryController;

    @Test
    public void testFindByRegistrationNumber() throws Exception {
        VehicleSummary vehicleSummary = vehicleSummaryController.findByRegistrationNumber("P-18NO99");
        assert vehicleSummary != null;
    }
}