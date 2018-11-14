package org.myorg.testautomation;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class SimpleTest extends ExecutionContext implements Login {
    public final static Path MODEL_PATH = Paths.get("org/myorg/testautomation/Login.graphml");
    @Override
    public void e_InvalidCredentials() {
        System.out.println("e_InvalidCredentials: Insert test code here!");
    }

    @Override
    public void v_LoginPrompted() {
        System.out.println("v_LoginPrompted: Insert test code here!");
    }

    @Override
    public void e_ToggleRememberMe() {
        System.out.println("e_ToggleRememberMe: Insert test code here!");
    }

    @Override
    public void e_Exit() {
        System.out.println("e_Exit: Insert test code here!");
    }

    @Override
    public void e_ValidPremiumCredentials() {
        System.out.println("e_ValidPremiumCredentials: Insert test code here!");
    }

    @Override
    public void e_Close() {
        System.out.println("e_Close: Insert test code here!");
    }

    @Override
    public void e_Logout() {
        System.out.println("e_Logout: Insert test code here!");
    }

    @Override
    public void e_Init() {
        System.out.println("e_Init: Insert test code here!");
    }

    @Override
    public void v_Browse() {
        System.out.println("v_Browse: Insert test code here!");
    }

    @Override
    public void e_StartClient() {
        System.out.println("e_StartClient: Insert test code here!");
    }

    @Override
    public void v_ClientNotRunning() {
        System.out.println("v_ClientNotRunning: Insert test code here!");
    }

    @Test
    public void runSmokeTest() {
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new SimpleTest())
            .setPathGenerator(new AStarPath(new ReachedVertex("v_Browse")))
            .setStart("e_Init")
            .execute();
    }

    @Test
    public void runFunctionalTest() {
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new SimpleTest())
            .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
            .setStart("e_Init")
            .execute();
    }

    @Test
    public void runStabilityTest() {
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new SimpleTest())
            .setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)))
            .setStart("e_Init")
            .execute();
    }
}

