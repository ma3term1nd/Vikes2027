package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;

public class ColorSensor {

    NormalizedColorSensor colorSensor;
    public float normRed, normGreen, normBlue;
    /*  ---------------GAIN-----------------
        higher gain for darker places
        lower gain for brighter places
        always greater than or equal to 1
    */
    public float gain = 2;

    public enum DetetctedColor {
        RED_POLLEN,
        BLUE_POLLEN,
        YELLOW_POLLEN,
        UNKNOWN
    }

    public ColorSensor (HardwareMap hwMap) { //constructor
        colorSensor = hwMap.get(NormalizedColorSensor.class, "ColorSensor");
        colorSensor.setGain(gain); //adjust to light level
        if (colorSensor instanceof SwitchableLight) {
            ((SwitchableLight)colorSensor).enableLight(true);
        }
    }

    public DetetctedColor getDetectedColor () { //returns either YELLOW_POLLEN or UNKNOWN
        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        normRed = colors.red/colors.alpha;
        normGreen = colors.green/colors.alpha;
        normBlue = colors.blue/colors.alpha;

        //todo: test colors and add if statements based on amounts of RGB

        if (    normRed > 0.5 &&
                normGreen > 0.5 &&
                normBlue > 0.5      ) { // YELLOW_POLLEN

            return DetetctedColor.YELLOW_POLLEN;

        } else { // BLUE OR RED POLLEN

            return DetetctedColor.UNKNOWN;

        }
    } //end method

    // ----------------------------
    // GETTER/SETTER METHODS
    // ----------------------------

    public float getNormRed() {
        return normRed;
    }

    public float getNormGreen() {
        return normGreen;
    }

    public float getNormBlue() {
        return normBlue;
    }

    public float getGain() {
        return this.gain;
    }

    public void increaseGain() {
        this.gain += 0.005;
        colorSensor.setGain(gain); //update gain
    }

    public void decreaseGain() {
        this.gain -= 0.005;
        colorSensor.setGain(gain); //update gain
    }

}
