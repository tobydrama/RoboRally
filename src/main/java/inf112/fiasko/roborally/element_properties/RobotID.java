package inf112.fiasko.roborally.element_properties;

/**
 * This class represents an id for marking specific robots
 */
public enum RobotID {
    ROBOT_1 (1),
    ROBOT_2 (2),
    ROBOT_3 (3),
    ROBOT_4 (4),
    ROBOT_5 (5),
    ROBOT_6 (6),
    ROBOT_7 (7),
    ROBOT_8 (8);

    private final int robotID;

    /**
     * Constructor to let a robotID be represented by a numerical identifier
     * @param robotID <p>The numerical identifier assigned to the robot ID</p>
     */
    RobotID(int robotID) {
        this.robotID = robotID;
    }

    /**
     * Gets the numerical id used for identification of a robot id
     * @return <p>The numerical id of the robot id</p>
     */
    public int getRobotIDID() {
        return this.robotID;
    }

    /**
     * Gets a robot ID value from its numerical representation
     * @param robotID <p>The numerical representation of a robot id</p>
     * @return <p>The enum value representing the robot ID, or null if the id is invalid</p>
     */
    public static RobotID getRobotIDFromID(int robotID) {
        for (RobotID type : RobotID.values()) {
            if (type.robotID == robotID) {
                return type;
            }
        }
        return null;
    }
}
