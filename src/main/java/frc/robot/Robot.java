package frc.robot;


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.LiftDriveCommand;
import frc.robot.commands.autolift.LiftAllLegs;
import frc.robot.commands.autolift.LiftDriveForward;
import frc.robot.commands.autolift.RetractLeg;
import frc.robot.commands.autolift.RobotDriveForward;
import frc.robot.commands.BasketDownCommand;
import frc.robot.commands.BasketUpCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.HatchDownCommand;
import frc.robot.commands.HatchUpCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.basket.BasketSystem;
import frc.robot.subsystems.hatch.HatchSystem;
import frc.robot.subsystems.lift.FrontLeftLegSystem;
import frc.robot.subsystems.lift.FrontRightLegSystem;
import frc.robot.subsystems.lift.LiftSystem;
import frc.robot.subsystems.lift.RearLegSystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    public static DriveTrain driveTrain;
    public static OI oi;
    public static NetworkTableInstance networkTable;

    public static LiftSystem liftSystem;
    public static FrontLeftLegSystem frontLeftLegSystem;
    public static FrontRightLegSystem frontRightLegSystem;
    public static RearLegSystem rearLegSystem;

    public static HatchSystem hatchSystem;

    public static BasketSystem basketSystem;

    @Override
    public void robotInit() {
        oi = new OI();

        networkTable = NetworkTableInstance.getDefault();

        CameraServer.getInstance().startAutomaticCapture();

        // Drive Train
        driveTrain = new DriveTrain();
        driveTrain.setDefaultCommand(new DriveCommand());
        //Robot.oi.getJoy1ButtonX().whenPressed(new DriveShiftHighCommand());
        //Robot.oi.getJoy1ButtonB().whenPressed(new DriveShiftLowCommand());
    
        // Lift System
        frontLeftLegSystem = new FrontLeftLegSystem();
        frontRightLegSystem = new FrontRightLegSystem();
        rearLegSystem = new RearLegSystem();
        liftSystem = new LiftSystem(frontLeftLegSystem, frontRightLegSystem, rearLegSystem);
        frontLeftLegSystem.setDefaultCommand(new LiftDriveCommand(frontLeftLegSystem, LiftDriveCommand.FRONT_LEFT));
        frontRightLegSystem.setDefaultCommand(new LiftDriveCommand(frontRightLegSystem, LiftDriveCommand.FRONT_RIGHT));
        rearLegSystem.setDefaultCommand(new LiftDriveCommand(rearLegSystem, LiftDriveCommand.REAR));
        
        
        // Hatch Panel System
        hatchSystem = new HatchSystem();
        Robot.oi.getJoy1ButtonX().whenPressed(new HatchDownCommand());
        Robot.oi.getJoy1ButtonY().whenPressed(new HatchUpCommand());
        

        // Basket System
        basketSystem = new BasketSystem();
        Robot.oi.getJoy1ButtonA().whenPressed(new BasketDownCommand());
        Robot.oi.getJoy1ButtonB().whenPressed(new BasketUpCommand());

        DoubleSolenoid blank = new DoubleSolenoid(RobotMap.blank1, RobotMap.blank2);
        blank.set(Value.kOff);

        // Auto Lift Command
        CommandGroup lift = new CommandGroup();
        // List Robot
        CommandGroup liftRobot = new CommandGroup();
        liftRobot.addParallel(new LiftAllLegs(frontLeftLegSystem, 3));
        liftRobot.addParallel(new LiftAllLegs(frontRightLegSystem, 3));
        liftRobot.addParallel(new LiftAllLegs(rearLegSystem, 3));
        // Move Forward for 5 seconds
        CommandGroup moveForwardBlue = new CommandGroup();
        moveForwardBlue.addParallel(new LiftAllLegs(frontLeftLegSystem, 4));
        moveForwardBlue.addParallel(new LiftAllLegs(frontRightLegSystem, 4));
        moveForwardBlue.addParallel(new LiftAllLegs(rearLegSystem, 4));
        moveForwardBlue.addParallel(new LiftDriveForward(frontLeftLegSystem, 4));
        moveForwardBlue.addParallel(new LiftDriveForward(frontRightLegSystem, 4));
        // Retract rear leg
        CommandGroup retractRearLeg = new CommandGroup();
        retractRearLeg.addParallel(new LiftAllLegs(frontLeftLegSystem, 3));
        retractRearLeg.addParallel(new LiftAllLegs(frontRightLegSystem, 3));
        retractRearLeg.addParallel(new RetractLeg(rearLegSystem, 3));
        // Drive Forward with Drive Train
        CommandGroup driveForward = new CommandGroup();
        driveForward.addParallel(new LiftAllLegs(frontLeftLegSystem, 4));
        driveForward.addParallel(new LiftAllLegs(frontRightLegSystem, 4));
        driveForward.addParallel(new LiftDriveForward(frontLeftLegSystem, 4));
        driveForward.addParallel(new LiftDriveForward(frontRightLegSystem, 4));
        driveForward.addParallel(new RobotDriveForward(-.55, 4));
        // Retract remaining Legs
        CommandGroup retractFrontLegs = new CommandGroup();
        retractFrontLegs.addParallel(new RetractLeg(frontLeftLegSystem, 3));
        retractFrontLegs.addParallel(new RetractLeg(frontRightLegSystem, 3));
        retractFrontLegs.addParallel(new RobotDriveForward(-.45, 3));
        // Drive Forward
        CommandGroup driveFinal = new CommandGroup();
        driveFinal.addParallel(new RobotDriveForward(-.42, 2));

        lift.addSequential(liftRobot);
        lift.addSequential(moveForwardBlue);
        lift.addSequential(retractRearLeg);
        lift.addSequential(driveForward);
        lift.addSequential(retractFrontLegs);
        lift.addSequential(driveFinal);

        Robot.oi.getJoy1ButtonLB().whenPressed(lift);
        
    
        
        //driveTrain.switchToLowGear();

    }

    /**
     * This function is called every robot packet, no matter the mode. Use
     * this for items like diagnostics that you want ran during disabled,
     * autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        //driveTrain.switchToHighGear();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.

        /*if (m_autonomousCommand != null) {
          m_autonomousCommand.cancel();
        }*/
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
