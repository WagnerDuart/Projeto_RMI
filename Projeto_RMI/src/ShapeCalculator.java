import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ShapeCalculator extends Remote {
    double calculateCircleArea(double radius) throws RemoteException;
    double calculateSquareArea(double side) throws RemoteException;
    double calculateRectangleArea(double width, double height) throws RemoteException;
}