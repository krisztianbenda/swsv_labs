package hu.bme.mit.swsv;

import hu.bme.mit.swsv.impl.WiperControllerImpl;
import org.apache.xmlbeans.impl.common.XPath;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@GraphWalker(start = "init", stopCondition = EdgeCoverage.class, stopConditionValue = "80", pathGenerator = RandomPath.class)
public class WiperModelTest extends XPath.ExecutionContext implements WiperModel{

    private WiperController wiperController;
    private WiperMode wiperMode;
    private double wiperSpeed;

    @Mock
    private WiperMotor wiperMotor;

    @Override
    public void e_AutoLightToHeavy() {
        if (wiperMode != WiperMode.AUTO)
            wiperController.setWiperSwitch(WiperMode.AUTO);
        wiperMode = WiperMode.AUTO;
        wiperController.rainIntensityChanged(RainMode.HEAVY);
    }

    @Override
    public void e_SwitchOffToTwo() {
        if (wiperMode != WiperMode.OFF)
            wiperController.setWiperSwitch(WiperMode.OFF);
        wiperMode = WiperMode.OFF;
        wiperController.rainIntensityChanged(RainMode.HEAVY);
    }

    @Override
    public void e_AutoHeavyOff() {
        if (wiperMode != WiperMode.AUTO)
            wiperController.setWiperSwitch(WiperMode.AUTO);
        wiperMode = WiperMode.AUTO;
        wiperController.rainIntensityChanged(RainMode.NO);
    }

    @Override
    public void e_SwitchOneToTwo() {
        if (wiperMode != WiperMode.SPEED_ONE)
            wiperController.setWiperSwitch(WiperMode.SPEED_ONE);
        wiperMode = WiperMode.SPEED_ONE;
        wiperController.rainIntensityChanged(RainMode.HEAVY);
    }

    @Override
    public void e_AutoLightOn() {
        if (wiperMode != WiperMode.AUTO)
            wiperController.setWiperSwitch(WiperMode.AUTO);
        wiperMode = WiperMode.AUTO;
        wiperController.rainIntensityChanged(RainMode.LIGHT);
    }

    @Override
    public void e_AutoLightOff() {
        if (wiperMode != WiperMode.AUTO)
            wiperController.setWiperSwitch(WiperMode.AUTO);
        wiperMode = WiperMode.AUTO;
        wiperController.rainIntensityChanged(RainMode.NO);

    }

    @Override
    public void e_SwitchTwoToOne() {
        if (wiperMode != WiperMode.SPEED_TWO)
            wiperController.setWiperSwitch(WiperMode.SPEED_TWO);
        wiperMode = WiperMode.SPEED_TWO;
        wiperController.rainIntensityChanged(RainMode.LIGHT);
    }

    @Override
    public void e_SwitchOneToOff() {
        if (wiperMode != WiperMode.SPEED_ONE)
            wiperController.setWiperSwitch(WiperMode.SPEED_ONE);
        wiperMode = WiperMode.SPEED_ONE;
        wiperController.rainIntensityChanged(RainMode.NO);
    }

    @Override
    public void e_AutoHeavyOn() {
        if (wiperMode != WiperMode.AUTO)
            wiperController.setWiperSwitch(WiperMode.AUTO);
        wiperMode = WiperMode.AUTO;
        wiperController.rainIntensityChanged(RainMode.HEAVY);
    }

    @Override
    public void e_SwitchTwoToOff() {
        if (wiperMode != WiperMode.SPEED_TWO)
            wiperController.setWiperSwitch(WiperMode.SPEED_TWO);
        wiperMode = WiperMode.SPEED_TWO;
        wiperController.rainIntensityChanged(RainMode.NO);
    }

    @Override
    public void e_AutoHeavyToLight() {
        if (wiperMode != WiperMode.AUTO)
            wiperController.setWiperSwitch(WiperMode.AUTO);
        wiperMode = WiperMode.AUTO;
        wiperController.rainIntensityChanged(RainMode.LIGHT);
    }

    @Override
    public void v_SpeedOne() {
        if (wiperSpeed != 1){
            wiperSpeed = 1;
            wiperMotor.setInterval(wiperSpeed);
        }
        if (wiperMode != WiperMode.SPEED_ONE)
            wiperMode = WiperMode.SPEED_ONE;
    }

    @Override
    public void v_SpeedTwo() {
        if (wiperSpeed != 0.5){
            wiperSpeed = 0.5;
            wiperMotor.setInterval(wiperSpeed);
        }
        if (wiperMode != WiperMode.SPEED_TWO)
            wiperMode = WiperMode.SPEED_TWO;

    }

    @Override
    public void e_SwitchOffToOne() {
        if (wiperMode != WiperMode.OFF)
            wiperController.setWiperSwitch(WiperMode.OFF);
        wiperMode = WiperMode.OFF;
        wiperController.rainIntensityChanged(RainMode.LIGHT);
    }

    @Override
    public void init() {
        MockitoAnnotations.initMocks(this);
        wiperController = new WiperControllerImpl(wiperMotor);
        wiperController.setWiperSwitch(WiperMode.OFF);
        wiperMode = WiperMode.OFF;
        wiperController.rainIntensityChanged(RainMode.NO);
        wiperSpeed = 0.0;
    }

    @Override
    public void Off() {
        if (wiperSpeed != 0.0) {
            wiperSpeed = 0.0;
            wiperMotor.setInterval(wiperSpeed);
        }
        if (wiperMode != WiperMode.OFF)
            wiperMode = WiperMode.OFF;
    }

}
