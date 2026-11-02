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
    public float gain = 11;

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

        if (    normRed > 0 &&
                normGreen > 0 &&
                normBlue > 0      ) { // YELLOW_POLLEN

            return DetetctedColor.YELLOW_POLLEN;

        } else if (    normRed > 0 &&
                       normGreen > 0 &&
                       normBlue > 0      ) { // RED_POLLEN

            return DetetctedColor.RED_POLLEN;

        } else if (    normRed > 0 &&
                       normGreen > 0 &&
                       normBlue > 0      ) { // BLUE_POLLEN

            return DetetctedColor.BLUE_POLLEN;

        } else { // BLUE OR RED POLLEN

            return DetetctedColor.UNKNOWN;

        }
    } //end method

    // ----------------------------
    // GETTER/SETTER METHODS
    // ----------------------------

    public float getNormRed() {
        return colorSensor.getNormalizedColors().red;
    }

    public float getNormGreen() {
        return colorSensor.getNormalizedColors().green;
    }

    public float getNormBlue() {
        return colorSensor.getNormalizedColors().blue;
    }

    public float getAlpha() {
        return colorSensor.getNormalizedColors().alpha;
    }

    public float getGain() {
        return this.gain;
    }

    public void increaseGain() {
        this.gain += 0.05;
        colorSensor.setGain(gain); //update gain
    }

    public void decreaseGain() {
        this.gain -= 0.05;
        colorSensor.setGain(gain); //update gain
    }

}
