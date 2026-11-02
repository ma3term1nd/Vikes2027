package org.firstinspires.ftc.teamcode.main;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SubSystems.ColorSensor;

@TeleOp(name = "TEST_TeleOp")
public class TEST_TeleOp extends OpMode {

    ColorSensor colorSensor;

    public void init() {
        colorSensor = new ColorSensor(hardwareMap);
    }

    public void loop() {
        if (gamepad1.a) {
            colorSensor.increaseGain();
        } else if (gamepad1.y) {
            colorSensor.decreaseGain();
        }

        telemetry.addData("GAIN: ", colorSensor.getGain());
        telemetry.addData("RED: ", colorSensor.getNormRed());
        telemetry.addData("GREEN: ", colorSensor.getNormGreen());
        telemetry.addData("BLUE: ", colorSensor.getNormBlue());
        telemetry.addData("ALPHA: ", colorSensor.getAlpha());
        telemetry.addData("CURRENT_COLOR: ", colorSensor.getDetectedColor());
        telemetry.update();

    }
}
