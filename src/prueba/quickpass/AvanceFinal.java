/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.quickpass;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AvanceFinal {
    public static void main(String[] args) {
        QuickPass[] quickpasses = new QuickPass[100];
        QuickPass[] quickpassesEliminados = new QuickPass[100];
        int count = 0;
        int countEliminados = 0;
        String nombreArchivo = "Historial.txt";
        ManejoArchivos.crearArchivo(nombreArchivo);

        while (true) {
            String menu = """
                          MENU DE OPCIONES
                          1. Agregar Quickpass 
                          2. Consultar Quickpass 
                          3. Eliminar Quickpass 
                          4. Reportes
                          5. Salir""";
            String opcion = JOptionPane.showInputDialog(menu);

            if (opcion.equals("1")) { //agregar un Quickpass
                String filial = JOptionPane.showInputDialog("Ingrese la filial:");
                String codigo;
                boolean codigoValido;
                do {
                    codigo = JOptionPane.showInputDialog("Ingrese el codigo (este debe iniciar con 101):");
                    codigoValido = codigo.matches("101\\d{7}");
                    if (!codigoValido) {
                        JOptionPane.showMessageDialog(null, "Codigo invalido. Debe comenzar con 101 y tener 10 digitos");
                    }
                } while (!codigoValido);
                String placa = JOptionPane.showInputDialog("Ingrese la placa:");

                quickpasses[count] = new QuickPass(filial, codigo, placa);
                count++;

                String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
                String contenido = quickpasses[count - 1].toFormattedString(fecha);
                ManejoArchivos.escribirArchivo(nombreArchivo, contenido);
                JOptionPane.showMessageDialog(null, "QuickPass agregado correctamente");

            } else if (opcion.equals("2")) { // consulta de quickpass por codigo
                String subMenu = """
                                 CONSULTA
                                 1. Consultar todos los Quickpass 
                                 2. Consultar por filial 
                                 3. Consultar uno especifico 
                                 4. Consultar Quickpass eliminados 
                                 5. Inactivar Quickpass 
                                 6. Consultar estado de Quickpass 
                                 7. Volver al menu principal""";
                String subOpcion = JOptionPane.showInputDialog(subMenu);

                if (subOpcion.equals("1")) { // consultar todos los Quickpass
                    ManejoArchivos.leerArchivo(nombreArchivo);
                } else if (subOpcion.equals("2")) { // consultar por filial
                    String filial = JOptionPane.showInputDialog("Ingrese la filial:");
                    String mensaje = "";
                    for (int i = 0; i < count; i++) {
                        if (quickpasses[i].getFilial().equals(filial)) {
                            mensaje += quickpasses[i].toString() + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                } else if (subOpcion.equals("3")) { // consultar uno especifico
                    String codigo = JOptionPane.showInputDialog("Ingrese el codigo:");
                    QuickPass qp = null;
                    for (int i = 0; i < count; i++) {
                        if (quickpasses[i].getCodigo().equals(codigo)) {
                            qp = quickpasses[i];
                            break;
                        }
                    }
                    if (qp != null) {
                        JOptionPane.showMessageDialog(null, qp.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Quickpass no encontrado");
                    }
                } else if (subOpcion.equals("4")) { // consultar Quickpass eliminados
                    String mensaje = "";
                    if (countEliminados == 0) {
                        mensaje = "No se han eliminado QuickPass";
                    }else{ 
                        for (int i = 0; i < countEliminados; i++) {
                            mensaje += quickpassesEliminados[i].toString() + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    
                } else if (subOpcion.equals("5")) { // inactivar quickpass
                    String codigo = JOptionPane.showInputDialog("Ingrese el codigo del Quickpass que desea inactivar:");
                    boolean encontrado = false;
                    for (int i = 0; i < count; i++) {
                        if (quickpasses[i].getCodigo().equals(codigo)) {
                            quickpasses[i].setActivo(false);
                            encontrado = true;
                            JOptionPane.showMessageDialog(null, "Quickpass inactivado exitosamente");
                            
                            // actualizar archivo con el estado de los quickpass
                            String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
                            // aqui se va a vaciar la informacion actual del archivo 
                            ManejoArchivos.crearArchivo(nombreArchivo);
                            // para luego escribirla actualizada, este bloque completo se repite durante el programa pero siempre cumple la msima funcion de actualizar el archivo
                            for (int j = 0; j < count; j++) {
                                String contenido = quickpasses[j].toFormattedString(fecha);
                                 ManejoArchivos.escribirArchivo(nombreArchivo, contenido);
                            }
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "Quickpass no encontrado");
                    }
                    
                } else if (subOpcion.equals("6")) { // consultar estado de quickpass por codigo
                    String codigo = JOptionPane.showInputDialog("Ingrese el codigo:");
                    QuickPass qp = null;
                    for (int i = 0; i < count; i++) {
                        if (quickpasses[i].getCodigo().equals(codigo)) {
                            qp = quickpasses[i];
                            break;
                        }
                    }
                    if (qp != null) {
                        if (qp.getActivo()) {
                            JOptionPane.showMessageDialog(null, "Aceptado");
                        } else {
                            JOptionPane.showMessageDialog(null, "Rechazado");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Rechazado");
                    }
                } else if (subOpcion.equals("7")) {
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                }
            } else if (opcion.equals("3")) { // eliminar un quickpass
                String subMenu = """
                                 ELIMINAR
                                 1. Eliminar por codigo 
                                 2. Eliminar por placa""";
                String subOpcion = JOptionPane.showInputDialog(subMenu);

                if (subOpcion.equals("1")) { // eliminar por codigo
                    String codigo = JOptionPane.showInputDialog("Ingrese el codigo:");
                    boolean encontrado = false;
                    for (int i = 0; i < count; i++) {
                        if (quickpasses[i].getCodigo().equals(codigo)) {
                            quickpassesEliminados[countEliminados] = quickpasses[i];
                            countEliminados++;
                            quickpasses[i] = quickpasses[count - 1];
                            quickpasses[count - 1] = null;
                            count--;
                            
                            String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
                            ManejoArchivos.crearArchivo(nombreArchivo);
                            for (int j = 0; j < count; j++) {
                                String contenido = quickpasses[j].toFormattedString(fecha);
                                ManejoArchivos.escribirArchivo(nombreArchivo, contenido);
                            }
                            JOptionPane.showMessageDialog(null, "Quickpass eliminado exitosamente");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "Quickpass no encontrado");
                    }
                    
                }else if (subOpcion.equals("2")) { // eliminar por placa
                    String placa = JOptionPane.showInputDialog("Ingrese la placa:");
                    boolean encontrado = false;
                    for (int i = 0; i < count; i++) {
                        if (quickpasses[i].getPlaca().equals(placa)) {
                            quickpassesEliminados[countEliminados] = quickpasses[i];
                            countEliminados++;
                            quickpasses[i] = quickpasses[count - 1];
                            quickpasses[count - 1] = null;
                            count--;
                            
                            String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
                            ManejoArchivos.crearArchivo(nombreArchivo);
                            for (int j = 0; j < count; j++) {
                                String contenido = quickpasses[j].toFormattedString(fecha);
                                ManejoArchivos.escribirArchivo(nombreArchivo, contenido);
                            }
                            JOptionPane.showMessageDialog(null, "Quickpass eliminado exitosamente");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "Quickpass no encontrado");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                }
                    
            } else if (opcion.equals("4")) { // reportes
                String subMenu = """
                                 REPORTES
                                 1. Total de accesos registrados
                                 2. Total de accesos por filial
                                 3. Total de quickpass registrados
                                 4. Total de quickpass Activos e Inactivos
                                 5. Total de quickpass eliminados
                                 6. Volver al menu principal""";
                String subOpcion = JOptionPane.showInputDialog(subMenu);

                if (subOpcion.equals("1")) {
                    mostrarTotalAccesos(quickpasses, count);
                } else if (subOpcion.equals("2")) {
                    mostrarTotalAccesosPorFilial(quickpasses, count);
                } else if (subOpcion.equals("3")) {
                    mostrarTotalQuickpassRegistrados(quickpasses, count);
                } else if (subOpcion.equals("4")) {
                    mostrarTotalQuickpassActivosEInactivos(quickpasses, count);
                } else if (subOpcion.equals("5")) {
                    mostrarTotalQuickpassEliminados(quickpassesEliminados, countEliminados);
                } else if (subOpcion.equals("6")) {

                } else {
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                }
            } else if (opcion.equals("5")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }
    }
    
        public static void mostrarHistoricoAccesosPorFilial(QuickPass[] quickpasses, int count, String nombreArchivo) {
        String filial = JOptionPane.showInputDialog("Ingrese la filial:");
        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (quickpasses[i].getFilial().equals(filial)) {
                mensaje.append(quickpasses[i].toString()).append("\n");
            }
        }
        if (mensaje.length() > 0) {
            JOptionPane.showMessageDialog(null, mensaje.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay accesos para la filial seleccionada");
        }
    }

    public static void mostrarTotalAccesos(QuickPass[] quickpasses, int count) {
        JOptionPane.showMessageDialog(null, "Total de accesos registrados: " + count);
    }

    public static void mostrarTotalAccesosPorFilial(QuickPass[] quickpasses, int count) {
        String[] filialesProcesadas = new String[count];
        int[] conteos = new int[count];
        int numFiliales = 0;

        for (int i = 0; i < count; i++) {
            String filial = quickpasses[i].getFilial();
            boolean yaContada = false;
            
            for (int j = 0; j < numFiliales; j++) {
                if (filialesProcesadas[j].equals(filial)) {
                    conteos[j]++;
                    yaContada = true;
                    break;
                }
            }
            if (!yaContada) {
                filialesProcesadas[numFiliales] = filial;
                conteos[numFiliales] = 1;
                numFiliales++;
            }
        }
        StringBuilder mensaje = new StringBuilder("Total de accesos por filial:\n");
        for (int i = 0; i < numFiliales; i++) {
            mensaje.append("Filial: ").append(filialesProcesadas[i]).append(" - Total accesos: ").append(conteos[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public static void mostrarTotalQuickpassRegistrados(QuickPass[] quickpasses, int count) {
        JOptionPane.showMessageDialog(null, "Total de QuickPass registrados: " + count);
    }

    public static void mostrarTotalQuickpassActivosEInactivos(QuickPass[] quickpasses, int count) {
        int activos = 0;
        int inactivos = 0;
        for (int i = 0; i < count; i++) {
            if (quickpasses[i].getActivo()) {
                activos++;
            } else {
                inactivos++;
            }
        }
        JOptionPane.showMessageDialog(null, "QuickPass Activos: " + activos + ", QuickPass Inactivos: " + inactivos);
    }

    public static void mostrarTotalQuickpassEliminados(QuickPass[] quickpassesEliminados, int countEliminados) {
    JOptionPane.showMessageDialog(null, "Total de QuickPass eliminados: " + countEliminados);
    }
}
