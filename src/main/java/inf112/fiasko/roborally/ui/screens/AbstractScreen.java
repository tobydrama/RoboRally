package inf112.fiasko.roborally.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * This class overrides methods of screens which are often unused
 */
public abstract class AbstractScreen implements Screen {
    protected final int applicationWidth = 600;
    protected final int applicationHeight = 800;

    protected final OrthographicCamera camera = new OrthographicCamera();
    protected final Stage stage = new Stage();
    protected final InputMultiplexer inputMultiplexer = new InputMultiplexer();
    protected Viewport viewport;

    @Override
    public void show() {
        inputMultiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(inputMultiplexer);
        stage.cancelTouchFocus();
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
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        stage.draw();
        stage.act();
    }
}
