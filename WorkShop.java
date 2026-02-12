import java.util.ArrayList;
import java.util.List;
public class WorkShop<T extends Car> {
    private List<T> carsInWorkshop = new ArrayList<>();
    void LoadCars(T car){
        carsInWorkshop.add(car);
    }
    public T removeCar(){
        return carsInWorkshop.remove(0);
    }
}