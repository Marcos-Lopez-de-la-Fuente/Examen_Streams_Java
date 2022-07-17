import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            ArrayList<String> idsIbuprofenos = idIbuprofenos();
            ArrayList<Usuario> usuarios = buscarUsuarios(idsIbuprofenos);
            escribirUsuarios(usuarios);

        } catch (FileNotFoundException e) {
            System.out.println("Asegurese que la ruta de los archivos es correcta.");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> idIbuprofenos() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("serie.txt"));
        ArrayList<String> listas = new ArrayList<String>();
        String linea = "";

        while (linea != null) {
            linea = bufferedReader.readLine();
            if (linea != null) {
                String respuesta = "";
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) != ';') {
                        respuesta = respuesta + linea.charAt(i);
                    } else if (linea.charAt(i) == ';') {
                        listas.add(respuesta);
                        respuesta = "";
                    }
                }
            }
        }
        bufferedReader.close();
        return listas;
    }

    public static ArrayList<Usuario> buscarUsuarios(ArrayList<String> idsIbuprofenos) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("usuarios.obj")));

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        boolean finalArchivo = false;
        while (!finalArchivo) {
            try {
                Usuario usuario = (Usuario) objectInputStream.readObject();

                for (int i = 0; i < usuario.getLista().size(); i++) {
                    if (usuario.getLista().get(i).getNombre().equals("Ibuprofeno")) {
                        for (int ii = 0; ii < idsIbuprofenos.size(); ii++) {
                            if (usuario.getLista().get(i).getId().equals(idsIbuprofenos.get(ii))) {
                                usuarios.add(usuario);
                            }
                        }
                    }
                }
            } catch (EOFException e) {
                finalArchivo = true;
            }
        }
        objectInputStream.close();
        return usuarios;
    }

    public static void escribirUsuarios(ArrayList<Usuario> usuarios) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Resultat.txt"));
        for (int i = 0; i < usuarios.size(); i++) {
            String nombre = usuarios.get(i).getNombre();
            int telefono = usuarios.get(i).getTelefono();
            bufferedWriter.write("Nombre: " + nombre + " Telefono: " + telefono + "\n");
        }
        bufferedWriter.close();
    }
}
