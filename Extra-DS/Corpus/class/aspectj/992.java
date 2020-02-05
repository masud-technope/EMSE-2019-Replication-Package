package spacewar;

class Bullet extends SpaceObject {

    //Can't be changed for now!!!
    private static final int SIZE = 3;

    private static int LIFETIME = 50;

    private int lifeLeft;

     Bullet(Game theGame, double xP, double yP, double xV, double yV) {
        super(theGame, xP, yP, xV, yV);
        lifeLeft = LIFETIME;
    }

    int getSize() {
        return SIZE;
    }

    void handleCollision(SpaceObject obj) {
        die();
    }

    void clockTick() {
        if (--lifeLeft == 0)
            die();
        super.clockTick();
    }
}
