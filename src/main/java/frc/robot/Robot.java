package frc.robot;


import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.LiftDriveCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.HatchDownCommand;
import frc.robot.commands.HatchUpCommand;
import frc.robot.subsystems.DriveTrain;
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

    @Override
    public void robotInit() {
        oi = new OI();

        networkTable = NetworkTableInstance.getDefault();

        driveTrain = new DriveTrain();
        driveTrain.setDefaultCommand(new DriveCommand());

        frontLeftLegSystem = new FrontLeftLegSystem();
        frontRightLegSystem = new FrontRightLegSystem();
        rearLegSystem = new RearLegSystem();
        liftSystem = new LiftSystem(frontLeftLegSystem, frontRightLegSystem, rearLegSystem);
        frontLeftLegSystem.setDefaultCommand(new LiftDriveCommand(frontLeftLegSystem));
        frontRightLegSystem.setDefaultCommand(new LiftDriveCommand(frontRightLegSystem));
        rearLegSystem.setDefaultCommand(new LiftDriveCommand(rearLegSystem));

        hatchSystem = new HatchSystem();
        Robot.oi.getJoy2ButtonA().whenPressed(new HatchDownCommand());
        Robot.oi.getJoy2ButtonX().whenPressed(new HatchUpCommand());

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
