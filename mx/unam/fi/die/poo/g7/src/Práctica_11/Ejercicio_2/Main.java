// Importes
package mx.unam.fi.die.poo.g7.src.Práctica_11.Ejercicio_2;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;

// Clase principal que contiene el método main para ejecutar la aplicación
public class Main {
    public static void main(String[] args) {
        // Configuramos el JFrame (ventana principal de la aplicación) y lo hacemos visible en el centro de la pantalla
        JFrame frame = new JFrame("Lector de archivos .txt");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Configuramos el JTextArea donde se mostrará el contenido del archivo
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Hacemos que el JTextArea no sea editable por el usuario
        frame.add(textArea);

        // Ruta del archivo respecto a la de la terminal en la que se ejecuta el programa (Funciona de mejor manera desde la raíz del dispositivo)
        String rutaArchivo = "./mx/unam/fi/die/poo/g7/src/Práctica_11/Ejercicio_2/archivo.txt";

        // Intentamos leer el contenido del archivo y mostrarlo en el JTextArea
        try {
            String contenido = Files.readString(Path.of(rutaArchivo));
            int cantidadPalabras = contenido.split("\\s+").length; // Separamos el contenido en palabras usando espacios como delimitador
            textArea.setText("Cantidad de palabras: " + cantidadPalabras + "\n\n" + contenido);
        } catch (IOException e) {
            textArea.setText("No se pudo leer el archivo: " + rutaArchivo + " -| " + e.getMessage());
        }

        frame.setVisible(true); // Hacemos visible la ventana después de agregar todos los componentes
    }
}