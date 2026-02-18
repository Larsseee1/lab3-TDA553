import java.util.ArrayList;
import java.util.List;
public class WorkShop<T extends Car> {
    public double x;
    public double y;
    public WorkShop(double x, double y){
        this.x = x;
        this.y = y;
    }
    public WorkShop(){}
    private List<T> carsInWorkshop = new ArrayList<>();
    void LoadCars(T car){
        carsInWorkshop.add(car);
        System.out.println("Car loaded");
    }
    public T removeCar(){
        return carsInWorkshop.remove(0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}