import com.core.GameObject;
import com.core.GameWorld;
import com.core.GameScene;
import com.core.RigidBody;
import com.core.util.Position;
import com.image.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {


        GameObject rockGO = new GameObject();
        GameObject esmeraldaGO = new GameObject();
        GameObject floorGO = new GameObject();
        GameObject floorGO2 = new GameObject();
        GameObject slimeGO = new PlayerGameObject();

        GameScene miEscena = new MiEscena();

        // Position
        // TODO feature setear posicion relativa a otro game object
        rockGO.setInitialPosition(new Position(300,260));
        esmeraldaGO.setInitialPosition(new Position(50,300));
        floorGO.setInitialPosition(new Position(-50,100));
        floorGO2.setInitialPosition(new Position(100,300));
        slimeGO.setInitialPosition(new Position(100,10));

        // Image Loading
        BufferedImage rockImg = null;
        BufferedImage slimeImg = null;
        BufferedImage mucusImg = null;
        BufferedImage floorImg = null;
        try {
            slimeImg = ImageLoader.load("Sprites\\slime.png");
            rockImg = ImageLoader.load("Sprites\\rock.png");
            mucusImg = ImageLoader.load("Sprites\\diamond2.png");
            floorImg = ImageLoader.load("Sprites\\floor.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        rockGO.setBufferedImage(rockImg);
        slimeGO.setBufferedImage(slimeImg);
        esmeraldaGO.setBufferedImage(mucusImg);
        floorGO.setBufferedImage(floorImg);
        floorGO2.setBufferedImage(floorImg);

        RigidBody rb = new RigidBody();
        rb.enableGravity();
        rb.setColliders(Arrays.asList(rockGO, floorGO, floorGO2));

        slimeGO.setMoveSpeed(2);
        slimeGO.setJumpHeight(100); // TODO jumping logic
        slimeGO.addRigidBody(rb);

        // objects added to this map will run in the game loop - update method (update + draw) on each obj
        miEscena.putGameObject("SLIME", slimeGO); // todo crear un field tag o algo para referenciar a los go
        miEscena.putGameObject("ROCK", rockGO);
        miEscena.putGameObject("ESMERALDA", esmeraldaGO);
        miEscena.putGameObject("FLOOR", floorGO);
        miEscena.putGameObject("FLOOR2", floorGO2);

        miEscena.setBackgroundColor(Color.WHITE);

        GameWorld gameWorld = new GameWorld();
        gameWorld.addGameScene(miEscena);
        gameWorld.start();
    }
}
