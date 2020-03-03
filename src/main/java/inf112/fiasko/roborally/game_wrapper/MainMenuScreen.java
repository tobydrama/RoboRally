package inf112.fiasko.roborally.game_wrapper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {
    private final RoboRallyWrapper roboRallyWrapper;

    private final OrthographicCamera camera;
    private final Viewport viewport;

    public MainMenuScreen(final RoboRallyWrapper roboRallyWrapper) {
        this.roboRallyWrapper = roboRallyWrapper;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 400, 400);
        viewport = new ExtendViewport(400, 400, camera);
    }

    @Override
    public void show() {
        //Nothing to do
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 1f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        roboRallyWrapper.batch.setProjectionMatrix(camera.combined);

        roboRallyWrapper.batch.begin();
        roboRallyWrapper.font.draw(roboRallyWrapper.batch, "Robo Rally", 0, 250,
                200, 0, false);
        roboRallyWrapper.font.draw(roboRallyWrapper.batch, "Click anywhere to run the demo", 70, 200);
        roboRallyWrapper.batch.end();

        if (Gdx.input.isTouched()) {
            roboRallyWrapper.setScreen(roboRallyWrapper.screenManager.getBoardActiveScreen(this.roboRallyWrapper));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {
        //Nothing to do
    }

    @Override
    public void resume() {
        //Nothing to do
    }

    @Override
    public void hide() {
        //Nothing to do
    }

    @Override
    public void dispose() {
        //Nothing to do
    }
}