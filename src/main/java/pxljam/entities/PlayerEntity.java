package pxljam.entities;

import core.components.ColliderComponent;
import core.components.PSpriteComponent;
import core.entity.Entity;
import maths.Vector;
import physics.AABBCollider;
import pxljam.scripts.Gravity;
import pxljam.scripts.PlayerController;

/**
 * This class handles the entity of the player within the game
 * @author Alex Mitchell
 */
public class PlayerEntity extends Entity{

    //Vector previous = new Vector(0,0);

    /**
     * Creates a PlayerEntity at a given position
     * @param x The x position
     * @param y The y position
     */
    public PlayerEntity(float x, float y, float z){
        super(new Vector(x,y,z));

        addComponent(new PSpriteComponent(this, "player", 1,1.5f)); //Todo change the PSprite component
        addComponent(new PlayerController(this));
        addComponent(new Gravity(this));
        addComponent(new ColliderComponent(this, new AABBCollider(new Vector(0.5f, 0.75f, z), new Vector(0.5f, 0.75f, z)))); //Todo Change the Collider component
    }
}


