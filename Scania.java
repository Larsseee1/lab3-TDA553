import java.awt.*;
public class Scania extends Truck{
    @Override
    public double speedFactor() {
        return 0;
    }
    public Scania(){
        super(2,300,0, Color.DARK_GRAY,"Scania",0,0,"NORTH");
    }
    private double angle;
    public double getAngle() {
        return angle;
    }
    protected void incAngle(int amount){
        if (angle+amount > 70 || angle+amount < 0 || isMoving()) {
            throw new IllegalArgumentException("Can't reach that angle");
        }
         else {
            angle += amount;
            if (angle == 0) {
                isRampUp = true;
            } else {
                isRampUp = false;
            }
        }
    }
    protected void decAngle(int amount){
        if (angle-amount > 70 || angle-amount < 0 || isMoving()) {
            throw new IllegalArgumentException("Can't reach that angle");
        }
        else{
            angle -= amount;
            if (angle == 0) {
                isRampUp = true;
            }
            else {
                isRampUp = false;
            }
        }
    }
}