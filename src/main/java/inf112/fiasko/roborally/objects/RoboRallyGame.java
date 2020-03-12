package inf112.fiasko.roborally.objects;

import inf112.fiasko.roborally.element_properties.Action;
import inf112.fiasko.roborally.element_properties.Position;
import inf112.fiasko.roborally.element_properties.RobotID;
import inf112.fiasko.roborally.element_properties.TileType;
import inf112.fiasko.roborally.utility.BoardLoaderUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class represent a game which is drawable using libgdx
 */
public class RoboRallyGame implements IDrawableGame {
    private Board gameBoard;

    public RoboRallyGame(boolean debug) {
        if (debug) {
            initializeDebugMode();
        } else {
            initializeGame();
        }
    }

    public RoboRallyGame() {
        initializeGame();
    }

    @Override
    public int getWidth() {
        return gameBoard.getBoardWidth();
    }

    @Override
    public int getHeight() {
        return gameBoard.getBoardHeight();
    }

    @Override
    public List<Tile> getTilesToDraw() {
        return gameBoard.getTiles();
    }

    @Override
    public List<Wall> getWallsToDraw() {
        return gameBoard.getWalls();
    }

    @Override
    public List<Robot> getRobotsToDraw() {
        return gameBoard.getAliveRobots();
    }

    /**
     * Makes the game thread wait a given time amount before continuing.
     * @throws InterruptedException If interrupted while trying to sleep.
     */
    private void sleep() throws InterruptedException {
        long cycleDelay = 600;
        TimeUnit.MILLISECONDS.sleep(cycleDelay);
    }
    /**
     * Initializes the game with a debugging board
     */
    private void initializeDebugMode() {
        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot(RobotID.ROBOT_1, new Position(0, 16)));
        robots.add(new Robot(RobotID.ROBOT_2, new Position(1, 16)));
        robots.add(new Robot(RobotID.ROBOT_3, new Position(2, 16)));
        try {
            gameBoard = BoardLoaderUtil.loadBoard("boards/all_tiles_test_board.txt", robots);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the game with a playable board
     */
    private void initializeGame() {
        try {
            List<Robot> robots = new ArrayList<>();
            robots.add(new Robot(RobotID.ROBOT_1, new Position(1, 1)));
            robots.add(new Robot(RobotID.ROBOT_2, new Position(1, 2)));
            robots.add(new Robot(RobotID.ROBOT_3, new Position(1, 3)));
            gameBoard = BoardLoaderUtil.loadBoard("boards/Checkmate.txt", robots);
            new Thread(() -> {
                try {
                    runGameLoop();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Does whatever the game wants to do
     * @throws InterruptedException If interrupted while trying to sleep
     */
    private void runGameLoop() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        makeMove(RobotID.ROBOT_1, Action.MOVE_1);
        makeMove(RobotID.ROBOT_1, Action.MOVE_2);
        makeMove(RobotID.ROBOT_1, Action.BACK_UP);
        makeMove(RobotID.ROBOT_1, Action.BACK_UP);
        makeMove(RobotID.ROBOT_1, Action.MOVE_3);
        makeMove(RobotID.ROBOT_1, Action.ROTATE_LEFT);
        makeMove(RobotID.ROBOT_1, Action.U_TURN);
        makeMove(RobotID.ROBOT_1, Action.ROTATE_RIGHT);
        makeMove(RobotID.ROBOT_2, Action.ROTATE_LEFT);
        makeMove(RobotID.ROBOT_2, Action.MOVE_3);
        makeMove(RobotID.ROBOT_2, Action.MOVE_3);
        makeMove(RobotID.ROBOT_2, Action.BACK_UP);
        makeMove(RobotID.ROBOT_2, Action.U_TURN);
        makeMove(RobotID.ROBOT_2, Action.BACK_UP);
        makeMove(RobotID.ROBOT_2, Action.BACK_UP);
        makeMove(RobotID.ROBOT_2, Action.BACK_UP);
        makeMove(RobotID.ROBOT_2, Action.MOVE_3);
        makeMove(RobotID.ROBOT_2, Action.BACK_UP);
        makeMove(RobotID.ROBOT_2, Action.BACK_UP);
        makeMove(RobotID.ROBOT_2, Action.ROTATE_LEFT);
        makeMove(RobotID.ROBOT_2, Action.U_TURN);
        makeMove(RobotID.ROBOT_2, Action.MOVE_1);
    }

    /**
     * Makes the given robot move according to to the action input.
     * @param robotID The ID of the robot to move.
     * @param action The specific movement the robot is to take.
     * @throws InterruptedException If interrupted wile trying to sleep.
     */
    private void makeMove(RobotID robotID, Action action) throws InterruptedException {
        if (!gameBoard.isRobotAlive(robotID)) {
            return;
        }
        sleep();
        switch (action) {
            case MOVE_1:
                gameBoard.moveRobotForward(robotID);
                break;
            case MOVE_2:
                gameBoard.moveRobotForward(robotID);
                moveForward(robotID);
                break;
            case MOVE_3:
                gameBoard.moveRobotForward(robotID);
                moveForward(robotID);
                moveForward(robotID);
                break;
            case ROTATE_RIGHT:
                gameBoard.rotateRobotRight(robotID);
                break;
            case ROTATE_LEFT:
                gameBoard.rotateRobotLeft(robotID);
                break;
            case U_TURN:
                gameBoard.rotateRobotLeft(robotID);
                gameBoard.rotateRobotLeft(robotID);
                break;
            case BACK_UP:
                gameBoard.reverseRobot(robotID);
                break;
            default:
                throw new IllegalArgumentException("Not a recognized action.");
        }
    }

    /**
     * Helper method for makeMove. Takes care of movement forward of given robot.
     * @param robotID ID of the given robot.
     * @throws InterruptedException If interrupted wile sleeping.
     */
    private void moveForward(RobotID robotID) throws InterruptedException {
        if (!gameBoard.isRobotAlive(robotID)) {
            return;
        }
        sleep();
        gameBoard.moveRobotForward(robotID);
    }

    /**
     * Rotates all robots that are standing on cogWheel tiles on the board.
     * @throws InterruptedException If interrupted while sleeping.
     */
    private void rotateCogwheels() throws InterruptedException {
        List<BoardElementContainer<Tile>> cogWheelsLeft = gameBoard.getPositionsOfTileOnBoard(TileType.COGWHEEL_LEFT);
        List<BoardElementContainer<Tile>> cogWheelsRight = gameBoard.getPositionsOfTileOnBoard(TileType.COGWHEEL_RIGHT);

        for (BoardElementContainer<Tile> cogLeft : cogWheelsLeft) {
            if (!gameBoard.hasRobotOnPosition(cogLeft.getPosition())) {
                return;
            }
            sleep();
            makeMove(gameBoard.getRobotOnPosition(cogLeft.getPosition()), Action.ROTATE_LEFT);
        }
        for (BoardElementContainer<Tile> cogRight : cogWheelsRight) {
            if (!gameBoard.hasRobotOnPosition(cogRight.getPosition())) {
                return;
            }
            sleep();
            makeMove(gameBoard.getRobotOnPosition(cogRight.getPosition()), Action.ROTATE_RIGHT);
        }
    }
}