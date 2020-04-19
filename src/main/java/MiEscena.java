import com.core.GameObject;
import com.core.GameScene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.awt.*;

public class MiEscena extends GameScene {
    private static final Logger log = LoggerFactory.getLogger(MiEscena.class);

    private GameObject slime;
    private GameObject rock;
    private GameObject esmeralda;
    private GameObject floor;
    public MiEscena(){

    }

    @Override
    protected void updateScene() {
        slime = gameObjectMap.get("SLIME");
        rock = gameObjectMap.get("ROCK");
        esmeralda = gameObjectMap.get("ESMERALDA");
        floor = gameObjectMap.get("FLOOR");
        // actualizar el estado del juego no relacionado a un game object.


//        if(slime != null && slime.hasCollition()){
//            gameObjectMap.remove("ESMERALDA");
//        }
//        if(slime != null && slime.hasCollition()){
//            log.info("SLIME COLISIONO CON EL PISO");
//        }
    }

    @Override
    protected void drawScene(Graphics2D g) {
        // aqui podes dibujar cosas que no sean considerados game objects
    }

}
