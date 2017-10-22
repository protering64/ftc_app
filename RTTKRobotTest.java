package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by FTC on 9/26/2017.
 */
@TeleOp
public class RTTKRobotTest extends LinearOpMode {

    boolean SlowDown;
    boolean SlowWayDown;
    boolean Reverse;

    DcMotor Right;
    DcMotor Left;
    DcMotor GrabRight1;
    DcMotor GrabLeft1;
    DcMotor GrabLeft2;
    DcMotor LiftLeft;
    DcMotor LiftRight;

@Override
public void runOpMode() {

    telemetry.addData("Status", "Initialized");
    telemetry.addData("SlowDown", "False");
    telemetry.addData("SlowWayDown","False");
    telemetry.addData("Reverse","False");
    telemetry.update();

    Left = hardwareMap.dcMotor.get("LeftMotor");
    Right = hardwareMap.dcMotor.get("RightMotor");
    GrabRight1 = hardwareMap.dcMotor.get("GrabRightMotor1");
    GrabLeft1 = hardwareMap.dcMotor.get("GrabLeftMotor1");
    GrabLeft2 = hardwareMap.dcMotor.get("GrabLeftMotor2");
    LiftLeft = hardwareMap.dcMotor.get("LiftLeftMotor");
    LiftRight =hardwareMap.dcMotor.get("LiftRightMotor");
    Left.setDirection(DcMotor.Direction.REVERSE);
    Right.setDirection(DcMotor.Direction.FORWARD);
    LiftLeft.setDirection(DcMotor.Direction.FORWARD);
    LiftRight.setDirection(DcMotor.Direction.FORWARD);
    GrabRight1.setDirection(DcMotor.Direction.FORWARD);
    GrabLeft1.setDirection(DcMotor.Direction.FORWARD);
    GrabLeft2.setDirection(DcMotor.Direction.FORWARD);

    waitForStart();
SlowDown = false;
    SlowWayDown = false;
    Reverse = false;
    while (opModeIsActive()) {
Left.setPower(gamepad1.left_stick_y);
Right.setPower(gamepad1.right_stick_y);

        /*if (gamepad1.left_stick_y >= 0.1 || gamepad1.left_stick_y <= -0.1) {
            Left.setPower(gamepad1.left_stick_y);
            Right.setPower(gamepad1.left_stick_y);
        }
        if (gamepad1.left_stick_x >= 0.1 || gamepad1.left_stick_x <= -0.1) {
            Left.setPower(gamepad1.left_stick_x);
            Right.setPower(gamepad1.left_stick_x * -1);
        }*/


        if (gamepad1.right_bumper) {
            GrabLeft1.setPower(-1);
            GrabLeft2.setPower(-1);
            GrabRight1.setPower(-1);
        }
        else if (gamepad1.right_trigger == 1) {
            GrabRight1.setPower(1);
            GrabLeft2.setPower(1);
            GrabLeft1.setPower(1);
        }

        else {
            GrabLeft2.setPower(0);
            GrabRight1.setPower(0);
            GrabLeft1.setPower(0);
        }




        if (gamepad1.left_trigger == 1) {
            LiftRight.setPower(1);
            LiftLeft.setPower(1);
        }

        else if (gamepad1.left_bumper) {
            LiftRight.setPower(-1);
            LiftLeft.setPower(-1);
        }

        else {
            LiftRight.setPower(0);
            LiftLeft.setPower(0);
        }
        if (gamepad1.a && Reverse == false) {
            Left.setPower(gamepad1.left_stick_y * -1);
            Right.setPower(gamepad1.right_stick_y * -1);

            telemetry.addData("Reverse","True");
            telemetry.update();
            Reverse = true;
        }
        else if (gamepad1.a && Reverse == true) {
            Left.setPower(gamepad1.left_stick_y);
            Right.setPower(gamepad1.right_stick_y);

            telemetry.addData("Reverse","False");
            telemetry.update();
            Reverse = false;
        }
        if (gamepad1.x && SlowDown == false) {
            Left.setPower(gamepad1.left_stick_y * 0.5);
            Right.setPower(gamepad1.right_stick_y * 0.5);
            while (gamepad1.left_trigger == 1) {
                LiftRight.setPower(0.5);
                LiftLeft.setPower(0.5);
            }

            while (gamepad1.left_bumper) {
                LiftRight.setPower(-0.5);
                LiftLeft.setPower(-0.5);
            }


        if (gamepad1.right_bumper) {
            GrabLeft1.setPower(-0.5);
            GrabLeft2.setPower(-0.5);
            GrabRight1.setPower(-0.5);
        }

        if (gamepad1.right_trigger == 1) {
            GrabRight1.setPower(0.5);
            GrabLeft2.setPower(0.5);
            GrabLeft1.setPower(0.5);
        }

            telemetry.addData("SlowDown", "True");
            telemetry.update();
            SlowDown = true;


        }
        else if (gamepad1.x && SlowDown == true) {
            Left.setPower(gamepad1.left_stick_y);
            Right.setPower(gamepad1.right_stick_y);

            while (gamepad1.left_bumper) {
                LiftRight.setPower(1);
                LiftLeft.setPower(1);
            }

            while (gamepad1.left_trigger == 1) {
                LiftRight.setPower(-1);
                LiftLeft.setPower(-1);
            }


        if (gamepad1.right_bumper) {
            GrabLeft1.setPower(-1);
            GrabLeft2.setPower(-1);
            GrabRight1.setPower(-1);
        }

        if (gamepad1.right_trigger == 1) {
            GrabRight1.setPower(1);
            GrabLeft2.setPower(1);
            GrabLeft1.setPower(1);
        }

            telemetry.addData("SlowDown", "False");
            telemetry.update();
            SlowDown = false;

        }
        if (gamepad1.y && SlowWayDown == false) {
            Left.setPower(gamepad1.left_stick_y * 0.25);
            Right.setPower(gamepad1.right_stick_y * 0.25);
            while (gamepad1.left_bumper) {
                LiftRight.setPower(0.25);
                LiftLeft.setPower(0.25);
            }

            while (gamepad1.left_trigger == 1) {
                LiftRight.setPower(-0.25);
                LiftLeft.setPower(-0.25);
            }


            if (gamepad1.right_bumper) {
                GrabLeft1.setPower(-0.25);
                GrabLeft2.setPower(-0.25);
                GrabRight1.setPower(-0.25);
            }

            if (gamepad1.right_trigger == 1) {
                GrabRight1.setPower(0.25);
                GrabLeft2.setPower(0.25);
                GrabLeft1.setPower(0.25);
            }

            telemetry.addData("SlowWayDown", "True");
            telemetry.update();
            SlowWayDown = true;
        }
        else if (gamepad1.y && SlowWayDown == true) {

            Left.setPower(gamepad1.left_stick_y);
            Right.setPower(gamepad1.right_stick_y);

            while (gamepad1.left_bumper) {
                LiftRight.setPower(1);
                LiftLeft.setPower(1);
            }

            while (gamepad1.left_trigger == 1) {
                LiftRight.setPower(-1);
                LiftLeft.setPower(-1);
            }


            if (gamepad1.right_bumper) {
                GrabLeft1.setPower(-1);
                GrabLeft2.setPower(-1);
                GrabRight1.setPower(-1);
            }

            if (gamepad1.right_trigger == 1) {
                GrabRight1.setPower(1);
                GrabLeft2.setPower(1);
                GrabLeft1.setPower(1);
            }

            telemetry.addData("SlowWayDown", "False");
            telemetry.update();
            SlowWayDown = false;
        }

        }
    }
}

