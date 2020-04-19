import com.core.GameObject;
import com.core.action.Action;
import com.core.action.impl.*;
import com.input.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerGameObject extends GameObject {
    private static final Logger log = LoggerFactory.getLogger(PlayerGameObject.class);

    private Action fireAction;

    public PlayerGameObject() {
        fireAction = new FireAction();
    }

    @Override
    public void update() {
        super.update(); // animation stuff
        // Other stuff that you want to execute on every tick
        handleInput();
    }

    private void handleInput() {
        if (Input.isDown(Input.KEY_LEFT)) {
            getMovementSystem().setLeft();
        }
        if (Input.isDown(Input.KEY_RIGHT)) {
            getMovementSystem().setRight();
        }
        if (Input.isPressed(Input.KEY_UP)) {
            getMovementSystem().setUp();
        }
        if (Input.isDown(Input.KEY_DOWN)) {
            getMovementSystem().setDown();
        }
        if (Input.isPressed(Input.KEY_SPACE)) {

        }
    }
}
