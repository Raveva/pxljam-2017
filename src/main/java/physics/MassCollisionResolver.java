package physics;

import core.components.ColliderComponent;
import core.components.PhysicsComponent;
import core.entity.EntityContainer;
import maths.Vector;

/**
 * Created by Callum Li on 9/17/17.
 */
public class MassCollisionResolver {

    private EntityContainer entities;

    public MassCollisionResolver(EntityContainer entities) {
        this.entities = entities;
    }


    public void resolveCollisions() {
        ColliderComponent[] colliders = entities.getAllComponents(ColliderComponent.class).toArray(new ColliderComponent[0]);

        for (int i = 0; i < colliders.length; i++) {
            for (int j = i+1; j < colliders.length; j++) {
                ColliderComponent c1 = colliders[i];
                ColliderComponent c2 = colliders[j];

                if (CollisionUtil.intersect(c1.getCollider(), c2.getCollider())) {

                    PhysicsComponent pc1 = c1.getEntity().getComponents(PhysicsComponent.class).stream().findAny().orElse(new PhysicsComponent(c1.getEntity()));
                    PhysicsComponent pc2 = c2.getEntity().getComponents(PhysicsComponent.class).stream().findAny().orElse(new PhysicsComponent(c2.getEntity()));


                    System.out.println(c1.getEntity() + " is colliding with " + c2.getEntity());

                    Vector v = CollisionUtil.minimumDistanceVector((AABBCollider) c1.getCollider(), (AABBCollider) c2.getCollider());

                    if (pc1.getInverseMass() < pc2.getInverseMass()) {
                        pc2.getEntity().translate(v.x, v.y);
                    } else {
                        pc1.getEntity().translate(-v.x, -v.y);
                    }
                }
            }
        }

    }
}
