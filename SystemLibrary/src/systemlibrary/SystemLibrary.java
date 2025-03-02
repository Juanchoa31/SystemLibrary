package systemlibrary;

import javax.swing.JOptionPane;

public class SystemLibrary {

    public static void main(String[] args) {
        Book[] listBooks = new Book[100]; // Vector para guardar 100 libros
        int countBooks = 0; // Contador para los libros que se están enviando
        int opc;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "1. Añadir un libro\n"
                    + "2. Prestar un libro\n"
                    + "3. Devolver un libro\n"
                    + "4. Mostrar los libros disponibles\n"
                    + "5. Salir\nSeleccionar una opción"));

            switch (opc) {
                case 1:
                    // Registrar un libro
                    if (countBooks < listBooks.length) {
                        String title = JOptionPane.showInputDialog("Ingresa el nombre del libro");
                        String author = JOptionPane.showInputDialog("Ingresa el autor del libro");
                        int yearPublication = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el año de publicación"));

                        
                        listBooks[countBooks++] = new Book(title, author, yearPublication);
                        JOptionPane.showMessageDialog(null, "Libro añadido: " + title);
                    } else {
                        JOptionPane.showMessageDialog(null, "La biblioteca está llena, no se puede añadir más libros.");
                    }
                    break;

                case 2:
                    // Prestar un libro
                    String titleLend = JOptionPane.showInputDialog("Ingresa el título del libro que deseas prestar");
                    boolean bookAvailable = false;
                    for (int i = 0; i < countBooks; i++) {
                        if (listBooks[i].getTitle().equalsIgnoreCase(titleLend) && listBooks[i].getAvailable().equalsIgnoreCase("Disponible")) {
                            listBooks[i].setAvailable("Prestado");
                            JOptionPane.showMessageDialog(null, "El libro '" + titleLend + "' ha sido prestado.");
                            bookAvailable = true;
                            break;
                        }
                    }
                    if (!bookAvailable) {
                        JOptionPane.showMessageDialog(null, "El libro '" + titleLend + "' no está disponible para préstamo.");
                    }
                    break;

                case 3:
                    // Devolver un libro
                    String titleReturn = JOptionPane.showInputDialog("Ingrese el título del libro a devolver: ");
                    boolean bookReturn = false;
                    for (int i = 0; i < countBooks; i++) {
                        if (listBooks[i].getTitle().equalsIgnoreCase(titleReturn) && listBooks[i].getAvailable().equalsIgnoreCase("Prestado")) {
                            listBooks[i].setAvailable("Disponible");
                            JOptionPane.showMessageDialog(null, "El libro '" + titleReturn + "' ha sido devuelto.");
                            bookReturn = true;
                            break;
                        }
                    }
                    if (!bookReturn) {
                        JOptionPane.showMessageDialog(null, "El libro '" + titleReturn + "' no está prestado.");
                    }
                    break;

                case 4:
                    // Mostrar libros disponibles
                    boolean found = false;
                    JOptionPane.showMessageDialog(null, "Libros disponibles:");
                    for (int i = 0; i < countBooks; i++) {
                        if (listBooks[i].getAvailable().equals("Disponible")) {
                            JOptionPane.showMessageDialog(null, listBooks[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "No hay libros disponibles.");
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, intente nuevamente.");
            }

        } while (opc != 5);
    }
}
