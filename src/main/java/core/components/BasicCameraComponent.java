package core.components;

import core.entity.Entity;
import maths.Vector;

/**
 * Created by dhack on 17-Sep-17.
 */
public class BasicCameraComponent extends Component{

    public BasicCameraComponent(Entity entity) {
        super(entity);
    }

    public void getPos(){


        //getEntity().getComponents(PSpriteComponent.class).stream().findAny().map((e) -> e.getDimensions()).orElse(new Vector(0, 0));

    }
}
