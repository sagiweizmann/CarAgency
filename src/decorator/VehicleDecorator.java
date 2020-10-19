package decorator;


import abstract_classes.Vehicle;
import interfaces.IVehicle;

public class VehicleDecorator implements IVehicle {
    protected Vehicle decoratedVehicle;
    public VehicleDecorator(Vehicle decoratedVehicle)
    {
    this.decoratedVehicle=decoratedVehicle;
    }

    @Override
    public double getID() {
        return decoratedVehicle.getID();
    }

    @Override
    public void setImg(double id) {
    decoratedVehicle.setImg(id);
    }

    @Override
    public boolean getLock() {
        return decoratedVehicle.getLock();
    }

    @Override
    public void setLock(boolean lock) {
    decoratedVehicle.setLock(lock);
    }

    @Override
    public String getImg() {
        return decoratedVehicle.getImg();
    }

    @Override
    public void setImg(String img) {
    decoratedVehicle.setImg(img);
    }

    @Override
    public double GetDistance() {
        return decoratedVehicle.GetDistance();
    }

    @Override
    public boolean SetDistance(Double distance) {
        return decoratedVehicle.SetDistance(distance);
    }

    @Override
    public String GetModelName() {
        return decoratedVehicle.GetModelName();
    }

    @Override
    public boolean SetName(String model_name) {
        return decoratedVehicle.SetName(model_name);
    }

    @Override
    public int GetMaxPassangers() {
        return decoratedVehicle.GetMaxPassangers();
    }

    @Override
    public boolean SetMaxPassangers(int max_passangers) {
        return decoratedVehicle.SetMaxPassangers(max_passangers);
    }

    @Override
    public double GetSpeed() {
        return decoratedVehicle.GetSpeed();
    }

    @Override
    public boolean SetSpeed(double max_speed) {
        return decoratedVehicle.SetSpeed( max_speed);
    }
}
