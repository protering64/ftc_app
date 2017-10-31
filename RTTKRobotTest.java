package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
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
    boolean slowMode;
    boolean reverseMode;
    boolean superSlowMode;
    //boolean PressA;
    //boolean PressX;
    //boolean PressY;
    //boolean PreviousA;
    //boolean PreviousX;
    //boolean PreviousY;
    //boolean SeparateX;
    //boolean SeparateY;
    //boolean SeparateA;
    double servoPosition;

    DcMotor Right;
    DcMotor Left;
    DcMotor GrabRight1;
    DcMotor GrabLeft1;
    DcMotor GrabLeft2;
    DcMotor LiftLeft;
    DcMotor LiftRight;
    DcMotor Arm;
    Servo Claw;

@Override
public void runOpMode() {

    telemetry.addData("Status", "Initialized");
    telemetry.addData("SlowDown", "False");
    telemetry.addData("SlowWayDown","False");
    telemetry.addData("Reverse","False");
    telemetry.addData("RobotTest","Test1");
    telemetry.update();

    Left = hardwareMap.dcMotor.get("LeftMotor");
    Right = hardwareMap.dcMotor.get("RightMotor");
    GrabRight1 = hardwareMap.dcMotor.get("GrabRightMotor1");
    GrabLeft1 = hardwareMap.dcMotor.get("GrabLeftMotor1");
    GrabLeft2 = hardwareMap.dcMotor.get("GrabLeftMotor2");
    LiftLeft = hardwareMap.dcMotor.get("LiftLeftMotor");
    LiftRight = hardwareMap.dcMotor.get("LiftRightMotor");
    Arm = hardwareMap.dcMotor.get("arm");
    Claw = hardwareMap.servo.get("claw");
    Left.setDirection(DcMotor.Direction.REVERSE);
    Right.setDirection(DcMotor.Direction.FORWARD);
    LiftLeft.setDirection(DcMotor.Direction.FORWARD);
    LiftRight.setDirection(DcMotor.Direction.FORWARD);
    GrabRight1.setDirection(DcMotor.Direction.FORWARD);
    GrabLeft1.setDirection(DcMotor.Direction.FORWARD);
    GrabLeft2.setDirection(DcMotor.Direction.FORWARD);
    Arm.setDirection(DcMotor.Direction.FORWARD);
    Claw.setDirection(Servo.Direction.FORWARD);

    waitForStart();
SlowDown = false;
    SlowWayDown = false;
    Reverse = false;
    slowMode = false;
    reverseMode = false;
    superSlowMode = false;
    //PressA = false;
    //PressX = false;
    //PressY = false;
    //PreviousA = false;
    //PreviousX = false;
    //PreviousY = false;
    //SeparateA = false;
    //SeparateX = false;
    //SeparateY = false;
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
        if (gamepad1.dpad_up) {
            Arm.setPower(1);
        }
        else if (gamepad1.dpad_down){
            Arm.setPower(-1);
        }
        else {
            Arm.setPower(0);
        }
        if (gamepad1.dpad_right) {

            Claw.setPosition(0.755);
        }
        else if (gamepad1.dpad_left) {
            Claw.setPosition(0.2);
        }
        else if (gamepad1.back) {
            Claw.setPosition(0.57);
        }
        /*if (gamepad1.a == true && PreviousA == false) {
            if (PressA == false) {
                PreviousA = true;
                PressA = true;

                //if button A is pressed set both variables to true
                //both variables start out false
            }
        }
        else if (gamepad1.a == false) {
            if (PressA == true) {
                PressA = false;

                //if button A is released set PressA to false
                //keep PreviousA true
            }
        }
        else if (gamepad1.a == true && PreviousA == true) {
            PreviousY = false;
            //if PreviousA is true and button A is pressed set PreviousA to false
        }if (gamepad1.a == true && PreviousA == false) {
            if (PressA == false) {
                PreviousA = true;
                PressA = true;

                //if button A is pressed set both variables to true
                //both variables start out false
            }
        }
        else if (gamepad1.a == false) {
            if (PressA == true) {
                PressA = false;

                //if button A is released set PressA to false
                //keep PreviousA true
            }
        }
        else if (gamepad1.a == true && PreviousA == true) {
            PreviousA = false;
            //if PreviousA is true and button A is pressed set PreviousA to false
        }
        */
        if (gamepad1.a && !Reverse) {
            reverseMode = !reverseMode;
        }


            Left.setPower(reverseMode ? gamepad1.left_stick_y * -1 : gamepad1.left_stick_y);
            Right.setPower(reverseMode ? gamepad1.right_stick_y * -1: gamepad1.left_stick_y);




        Reverse = gamepad1.a;
        if (reverseMode) {
            telemetry.addData("Reverse", "reverseMode");
            telemetry.update();
        }
        /*else if (gamepad1.a) {


            Left.setPower(gamepad1.left_stick_y);
            Right.setPower(gamepad1.right_stick_y);

            telemetry.addData("Reverse","False");
            telemetry.update();
            Reverse = false;
        }
        */
        /*
        if (gamepad1.x == true && PreviousX == false) {
            if (PressX == false) {
                PreviousX = true;

                //if button X is pressed set both variables to true
                //both variables start out false
            }
        }
        else if (gamepad1.x == false) {
            if (PressX == false && PreviousX == true) {
                PressX = true;
                SeparateX = true;

                //if button X is released set PressX to false
                //keep PreviousX true
            }
        }
        else if (gamepad1.x == true && PreviousX == true && PressX == true && SeparateX == true) {
            PressX = false;
            PreviousX = false;
            //if all of the variables are true and the button is pressed set all variables to false
        }
        */
        if (gamepad1.x == true && !SlowDown) {
            slowMode = !slowMode;
        }
            Left.setPower(slowMode ? gamepad1.left_stick_y * 0.75 : gamepad1.left_stick_y);
            Right.setPower(slowMode ? gamepad1.right_stick_y * 0.75 : gamepad1.right_stick_y);



            if (gamepad1.right_bumper && slowMode) {
                GrabLeft1.setPower(-0.75);
                GrabLeft2.setPower(-0.75);
                GrabRight1.setPower(-0.75);
            }

            else if (gamepad1.right_trigger == 1 && slowMode) {
                GrabRight1.setPower(0.75);
                GrabLeft2.setPower(0.75);
                GrabLeft1.setPower(0.75);
            }
            if (gamepad1.left_bumper && slowMode) {
                LiftLeft.setPower(-0.75);
                LiftRight.setPower(-0.75);
            }

            else if (gamepad1.left_trigger == 1 && slowMode) {
                LiftLeft.setPower(0.75);
                LiftRight.setPower(0.75);
            }
            if (gamepad1.dpad_up && slowMode) {
                Arm.setPower(0.75);
            }
            else if (gamepad1.dpad_down && slowMode) {
                Arm.setPower(0.75);
            }


            if (slowMode) {
                telemetry.addData("SlowDown", "slowMode");
                telemetry.update();
            }

        SlowDown = gamepad1.x;
        /*else if (gamepad1.x == true) {
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
        */
        /*
        if (gamepad1.y == true && PreviousY == false) {
            if (PressY == false) {
                PreviousY = true;
                PressY = true;

                //if button Y is pressed set both variables to true
                //both variables start out false
            }
        }
        else if (gamepad1.y == false) {
            if (PressY == true) {
                PressY = false;

                //if button Y is released set PressY to false
                //keep PreviousY true
            }
        }
        else if (gamepad1.y == true && PreviousY == true) {
            PreviousY = false;
            //if PreviousY is true and button Y is pressed set PreviousY to false
        }
        */
        if (gamepad1.y && !SlowWayDown) {
            superSlowMode = !superSlowMode;
        }
                Left.setPower(superSlowMode ? gamepad1.left_stick_y * 0.25 : gamepad1.left_stick_y);
                Right.setPower(superSlowMode ? gamepad1.right_stick_y * 0.25 : gamepad1.right_stick_y);

            if (gamepad1.right_bumper && superSlowMode) {
                GrabLeft1.setPower(-0.5);
                GrabLeft2.setPower(-0.5);
                GrabRight1.setPower(-0.5);
            }

            else if (gamepad1.right_trigger == 1 && superSlowMode) {
                GrabRight1.setPower(0.5);
                GrabLeft2.setPower(0.5);
                GrabLeft1.setPower(0.5);
            }
            if (gamepad1.left_bumper && superSlowMode) {
                LiftLeft.setPower(-0.5);
                LiftRight.setPower(-0.5);
            }

            else if (gamepad1.left_trigger == 1 && superSlowMode) {
                LiftLeft.setPower(0.5);
                LiftRight.setPower(0.5);
            }
            if (gamepad1.dpad_up && superSlowMode) {
                Arm.setPower(0.5);
            }
            else if (gamepad1.dpad_down && superSlowMode) {
                Arm.setPower(-0.5);
            }




        SlowWayDown = gamepad1.y;
        if (superSlowMode) {
            telemetry.addData("SlowWayDown", "superSlowMode");
            telemetry.update();
        }
        /*
        else if (gamepad1.y) {

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
        */
        }
    }
}

