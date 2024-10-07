import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ShapeCalculatorServer implements ShapeCalculator {
    public ShapeCalculatorServer() {}

    @Override
    public double calculateCircleArea(double radius) throws RemoteException {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateSquareArea(double side) throws RemoteException {
        return side * side;
    }

    @Override
    public double calculateRectangleArea(double width, double height) throws RemoteException {
        return width * height;
    }

    public static void main(String[] args) {
        try {
            ShapeCalculatorServer server = new ShapeCalculatorServer();
            ShapeCalculator stub = (ShapeCalculator) UnicastRemoteObject.exportObject(server, 0);
            
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("ShapeCalculator", stub);
            
            System.out.println("Servidor de cálculo de áreas inicializado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}