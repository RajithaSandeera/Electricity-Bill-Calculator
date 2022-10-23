package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Device {


    private SimpleStringProperty colDevice;
    private SimpleDoubleProperty colTime;
    private SimpleIntegerProperty colWatt;
    private SimpleIntegerProperty colQuantity;

    public Device() {
    }

    public Device(String colDevice, double colTime, int colWatt, int colQuantity) {
        this.colDevice = new SimpleStringProperty(colDevice);
        this.colTime = new SimpleDoubleProperty(colTime);
        this.colWatt = new SimpleIntegerProperty(colWatt);
        this.colQuantity = new SimpleIntegerProperty(colQuantity);
    }

    public String getColDevice() {
        return colDevice.get();
    }

    public void setColDevice(String colDevice) {
        this.colDevice = new SimpleStringProperty(colDevice);
    }

    public double getColTime() {
        return colTime.get();
    }

    public void setColTime(double colTime) {
        this.colTime = new SimpleDoubleProperty(colTime);
    }

    public int getColWatt() {
        return colWatt.get();
    }

    public void setColWatt(int colWatt) {
        this.colWatt = new SimpleIntegerProperty(colWatt);
    }

    public int getColQuantity() {
        return colQuantity.get();
    }

    public void setColQuantity(int colQuantity) {
        this.colQuantity = new SimpleIntegerProperty(colQuantity);
    }
}
