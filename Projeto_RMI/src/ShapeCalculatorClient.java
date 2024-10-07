import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ShapeCalculatorClient {
    public static void main(String[] args) {
        try {
            
            Registry registry = LocateRegistry.getRegistry("localhost");
            
            
            ShapeCalculator stub = (ShapeCalculator) registry.lookup("ShapeCalculator");

            
            Scanner scanner = new Scanner(System.in);

            
            System.out.print("Digite o raio do círculo: ");
            double radius = scanner.nextDouble();
            double circleArea = stub.calculateCircleArea(radius);
            System.out.println("Área do Círculo: " + circleArea);

           
            System.out.print("Digite o lado do quadrado: ");
            double side = scanner.nextDouble();
            double squareArea = stub.calculateSquareArea(side);
            System.out.println("Área do Quadrado: " + squareArea);

            
            System.out.print("Digite a largura do retângulo: ");
            double width = scanner.nextDouble();
            System.out.print("Digite a altura do retângulo: ");
            double height = scanner.nextDouble();
            double rectangleArea = stub.calculateRectangleArea(width, height);
            System.out.println("Área do Retângulo: " + rectangleArea);

            
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}