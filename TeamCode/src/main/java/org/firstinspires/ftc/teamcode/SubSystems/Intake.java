package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Intake {

    //instance variables
    DcMotorEx IntakeMotor, TransferMotor;

    double MotorPower = 0.5;

    //constructor: assigns hardware and intakeSpeed
    public Intake(HardwareMap hwMap){
        //instance variable

        IntakeMotor = hwMap.get(DcMotorEx.class, "IntakeMotor");
        IntakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        TransferMotor = hwMap.get(DcMotorEx.class, "TransferMotor");
        TransferMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void intakeIn(){
        IntakeMotor.setPower(MotorPower);
        TransferMotor.setPower(MotorPower);
    }
    public void intakeOut(){
        IntakeMotor.setPower(-MotorPower);
        TransferMotor.setPower(MotorPower);
    }
    public void intakeOff(){
        IntakeMotor.setPower(0);
        TransferMotor.setPower(0);
    }

}
