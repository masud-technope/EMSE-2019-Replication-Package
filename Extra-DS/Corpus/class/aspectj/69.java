package spacewar;

class EnergyPacket extends SpaceObject {

    //Can't be changed for now!!!
    private static final int SIZE = 5;

    int getSize() {
        return SIZE;
    }

    private double energy;

    double getEnergy() {
        return energy;
    }

     EnergyPacket(Game theGame, double xP, double yP, double xV, double yV, double e) {
        super(theGame, xP, yP, xV, yV);
        energy = e;
    }

    void handleCollision(SpaceObject obj) {
        die();
    }
}
