package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

public class ColorSensor {

    NormalizedColorSensor colorSensor;
    public float normRed, normGreen, normBlue;

    public enum DetetctedColor {
        RED_POLLEN,
        BLUE_POLLEN,
        YELLOW_POLLEN,

        UNKNOWN
    }

    public ColorSensor (HardwareMap hwMap) {
        colorSensor = hwMap.get(NormalizedColorSensor.class, "colorsensor");
        colorSensor.setGain(5); //adjust to light level
    }

    public void init () {

    }
    public DetetctedColor getDetectedColor () { //returns red, green, blue, and alpha(light level)
        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        normRed = colors.red/colors.alpha;
        normGreen = colors.green/colors.alpha;
        normBlue = colors.blue/colors.alpha;

        //todo: test colors and add if statements based on amounts of RGB

        if (    normRed > 0.5 &&
                normGreen > 0.5 &&
                normBlue > 0.5      ) { //GREEN ARTIFACT

            //return DetetctedColor.GREEN_ARTIFACT;

        } else if (    normRed < 0.5 &&
                normGreen < 0.5 &&
                normBlue < 0.5      ) { //PURPLE ARTIFACT

            //return DetetctedColor.PURPLE_ARTIFACT;

        } else {

            return DetetctedColor.UNKNOWN;

        }

        return null;

    }

}
