import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    WorkShop<Volvo240> volvoWorkshop = new WorkShop<>(300,0);
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Saab95());
        cc.cars.add(new Volvo240());
        //cc.cars.add(new Scania());
        //cc.cars.add(new Saab95());
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        int offset = 0;
        //Turn right

        for(Car car: cc.cars){
            car.turnRight();
            car.setyPos(offset);
            offset += 100;
        }
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            for (Car car : cars) {
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                //Skapa en if-sats så bilen ej kan åka utanför bild
                if (car.getX() >= 0 && car.getX() <= 686) {

                    car.move();
                    x = (int) Math.round(car.getX());
                    y = (int) Math.round(car.getY());
                } else {
                    car.turnLeft();
                    car.turnLeft();
                    car.move();
                }

                if (car.getX() > 300 && car instanceof Volvo240) {
                    volvoWorkshop.LoadCars((Volvo240) car);
                }


                    //frame.drawPanel.moveit(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }
            }
        }

        // Calls the gas method for each car once
        void gas(int amount) {

            double gas = ((double) amount) / 100;
            for (Car car : cars) {
                car.gas(gas);
                System.out.println(car.getCurrentSpeed());
            }
        }

        void brake(int amount) {
            double gas = ((double) amount) / 100;
            for (Car car : cars) {
                car.brake(gas);
                System.out.println(car.getCurrentSpeed());
            }
        }
    }


