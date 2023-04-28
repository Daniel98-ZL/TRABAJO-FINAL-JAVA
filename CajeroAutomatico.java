import java.util.Scanner;
public class CajeroAutomatico {

    public static void main(String[] args) {
        System.out.println("Bienvenido al New Perú Bank");
        Scanner leer = new Scanner(System.in);
        String[] usuarios = {"Daniel Zapana", "Luzvi Mamani", "Toribio Lucano", "Evelyn Lucano", "Luis Zapana"};
        String[] clientes = {"11111111", "22222222", "33333333", "44444444", "55555555"};
        String[] passwords = {"abc123", "def456", "ghi789", "jkl012", "mno345"};
        int intentos = 3;
        boolean clienteValido = false;
        
        while (intentos > 0 && !clienteValido) {
            System.out.print("Ingrese su DNI: ");
            String dni = leer.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String password = leer.nextLine();
            
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i].equals(dni) && passwords[i].equals(password)) {
                    clienteValido = true;
                    break;
                }
            }
            
            if (!clienteValido) {
                System.out.println("DNI o contraseña incorrectos. Intente nuevamente.");
                intentos--;
            }
        }
        
        if (clienteValido) {
            System.out.println("");
            System.out.println("Bienvenido " + usuarios[0]);
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            
            int opcion;
            do {
                System.out.print("Ingrese la opción deseada: ");
                opcion = leer.nextInt();
                
                switch (opcion) {
                    case 1:
                        System.out.println("Su saldo actual es de S/ 5000");
                        break;
                    case 2:
                        System.out.print("Ingrese el monto a retirar: ");
                        double montoRetiro = leer.nextDouble();
                        
                        if (montoRetiro <= 0) {
                            System.out.println("Monto inválido. Intente nuevamente.");
                        } else if (montoRetiro > 5000) {
                            System.out.println("El monto a retirar excede su saldo actual. Intente nuevamente.");
                        } else {
                            System.out.println("Retiro exitoso. Su nuevo saldo es de S/ " + (5000 - montoRetiro));
                        }
                        
                        break;
                    case 3:
                        System.out.print("Ingrese el monto a depositar: ");
                        double montoDeposito = leer.nextDouble();
                        
                        if (montoDeposito <= 0) {
                            System.out.println("Monto inválido. Intente nuevamente.");
                        } else {
                            System.out.println("Depósito exitoso. Su nuevo saldo es de S/ " + (5000 + montoDeposito));
                        }
                        
                        break;
                    case 4:
                        System.out.println("Gracias por utilizar nuestros servicios.");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
                
            } while (opcion != 4);
            
        } else {
            System.out.println("Ha excedido el número de intentos permitidos. La aplicación se cerrará.");
        }
        leer.close();
    }
}
