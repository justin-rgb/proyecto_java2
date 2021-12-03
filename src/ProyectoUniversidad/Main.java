package ProyectoUniversidad;

import java.util.Scanner;
import ProyectoUniversidad.Colas.Cola;
import ProyectoUniversidad.Colas.NodoC;
import ProyectoUniversidad.ListaS1.ListaS1;
import ProyectoUniversidad.ListaS2.ListaS2;
import ProyectoUniversidad.pila.NodoP;

public class Main {
    public static final int LUNES = 0;
    public static final int MARTES = 1;
    public static final int MIERCOLES = 2;
    public static final int JUEVES = 3;
    public static final int VIERNES = 4;
    private static final int CANT_DIAS = 5;
    private static final int MATRICULA_MINIMA_UNIVERSIDAD = 3;
    private static final int MATRICULA_MAXIMO_UNIVERSIDAD = 10;
    private static final ListaS1 alumnos = new ListaS1();
    private static final ListaS2 materias = new ListaS2();
    private static final Cola llamados = new Cola();
    private static double totalRecaudado = 0;

    private static final int MATRICULAR = 1;
    private static final int CONGELACION = 2;
    private static final int REPORTE = 3;
    private static final int ESTADISTICAS = 4;
    private static final int SALIR = 5;

    public static void main(String[] args) {
        
        // Configuraciones
        cargarHorarios();
        
        // Programa principal
        int opc = SALIR;
        
        do{
            System.out.println("************************************** UNIVERSIDAD PROGRESO *************************************************");
            opc = menu();
            switch(opc){
                case MATRICULAR:{
                    funcion_1();
                    break;
                }
                case CONGELACION:{
                    funcion_2();
                    break;
                }
                case ESTADISTICAS:{
                    funcion_3();
                    break;
                }
                case REPORTE: {
                    funcion_4();
                    break;
                }
                default:
            }
        } while (opc != SALIR);
    }
    
    private static int menu(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1 _ MATRICULA ALUMNOS.");
        System.out.println("2 _ CONGELACION.");
        System.out.println("3 _ REPORTE.");
        System.out.println("4 _ ESTADISTICAS.");
        System.out.println("5 _ SALIR.");
        System.out.print("Ingrese una opcion : ");
        
        return sc.nextInt();
    }
    
    private static void cargarHorarios(){
        String c1 = "M1/LUNES/ESTRUCTURA DE DATOS/ARIEL ORTEGA/10:00/12:00/15/99500";
        String c2 = "M2/MARTES/INFORMATICA/MANUEL RODRIGUEZ/10:00/12:00/10/98700";
        String c3 = "M3/MIERCOLES/FISICA/JULIO GARCIA/10:00/12:00/1/105000";
        String c4 = "M4/JUEVES/ANALISIS MATEMATICO/MANUEL RODRIGUEZ/10:00/12:00/4/103200";
        String c5 = "M5/VIERNES/DISEÑO GRAFICO/PIÑEDA SALAS/10:00/12:00/10/104000";     
        
        Materia m1 = convertir(c1);
        Materia m2 = convertir(c2);
        Materia m3 = convertir(c3);
        Materia m4 = convertir(c4);
        Materia m5 = convertir(c5);
        
        materias.agregar(m1);
        materias.agregar(m2);
        materias.agregar(m3);
        materias.agregar(m4);
        materias.agregar(m5);
    }
    
    private static void mostrarMateria(String dia){
        int size = materias.size();
        
        for (int i = 0; i < size; i++){
            Materia obj = materias.get(i);
            
            if (obj.getDia().equals(dia)){
                System.out.println(obj);
            }
        }
    }
    
    private static Materia convertir(String cadena){
        final int CODIGO = 0;
        final int DIA = 1;
        final int MATERIA = 2;
        final int PROFESOR = 3;
        final int HORARIO_INICIO = 4;
        final int HORARIO_FIN = 5;
        final int AULA = 6;
        final int COSTO = 7;
        
        Materia materia = new Materia();
        String[] partes = cadena.split("/");

        String codigo = partes[CODIGO];
        String dia = partes[DIA];
        String mat = partes[MATERIA];
        String prof = partes[PROFESOR];
        String hIni = partes[HORARIO_INICIO];
        String hFin = partes[HORARIO_FIN];
        String aula = partes[AULA];
        String costo = partes[COSTO];
        
        materia.setId(codigo);
        materia.setDia(dia);
        materia.setNombre(mat);
        materia.setProfesor(prof);
        materia.setHorarioInicio(hIni);
        materia.setHorarioFin(hFin);
        materia.setDia(dia);
        materia.setAula(Integer.parseInt(aula));
        materia.setCosto(Double.parseDouble(costo));
        
        return materia;
    }
    
    private static void mostrarHorarios(){    
        final int DIAS = 5;
        
        for (int i = 0; i < DIAS; i++){
            switch(i){
                case LUNES:{
                    System.out.println("************* LUNES ******************");
                    mostrarMateria("LUNES");
                    break;
                }
                case MARTES:{
                    System.out.println("************* MARTES ******************");
                    mostrarMateria("MARTES");
                    break;
                }
                case MIERCOLES:{
                    System.out.println("************* MIERCOLES ******************");
                    mostrarMateria("MIERCOLES");
                    break;
                }
                case JUEVES:{
                    System.out.println("************* JUEVES ******************");
                    mostrarMateria("JUEVES");
                    break;
                }
                case VIERNES:{
                    System.out.println("************* VIERNES ******************");
                    mostrarMateria("VIERNES");
                    break;
                }
            }
        }
    }
    
    private static void guardarPago(double pago){
        totalRecaudado += pago;
    }
    
    private static void pressAnyKeyToContinue() {
        System.out.println("\n\nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
    
    private static void calcularMedioPago(double total, int n){
        final int CONTADO = 1;
        final int TARJETA = 2;
        boolean band = true;
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        
        System.out.println(String.format("TOTAL A PAGAR (%d materias inscriptas) : %.2f", n, total));
       
        while (band) {
            System.out.print("SELECCIONE UN MEDIO DE PAGO((1)CONTADO/(2)TARJETA DEBITO < 5% descuento >) = ");
            opcion = sc.nextInt();

            if (!(opcion >= 1 && opcion <= 2)) {
                System.out.println("Mal ingresado, intentelo de nuevo.");
            } else {
                band = false;
            }
        }

        switch (opcion){
             case CONTADO:{
                 guardarPago(total);
                 break;
             }
             case TARJETA:{
                 guardarPago(total * 0.95);
                 break;
             }
         }
         
        System.out.println("MATRICULA REALIZADA!");
    }
    
    private static void funcion_1(){
        boolean band = false;
        double total = 0;
        Estudiante estudiante = new Estudiante();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        
        int cantidad = alumnos.size();
        
        System.out.println(String.format("MATRICULA DE ALUMNADO (%d / %d <Minimo : %d>)\n", cantidad, MATRICULA_MAXIMO_UNIVERSIDAD, MATRICULA_MINIMA_UNIVERSIDAD));
        
        System.out.print("Ingrese el nombre del alumno : ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese el apellido del alumno : ");
        String apellido = sc.nextLine();
        
        System.out.print("Ingrese la cedula del alumno : ");
        String cedula = sc.nextLine();
        
        System.out.print("Ingrese el telefono/celular del alumno : ");
        String telefono = sc.nextLine();
        
        System.out.print("Ingrese el genero del alumno (H/M) : ");
        String genero = sc.nextLine();
        
        System.out.print("Ingrese el lugar de residencia del alumno: ");
        String residencia = sc.nextLine();
        
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCedula(cedula.toUpperCase());
        estudiante.setTel(telefono);
        estudiante.setGenero(genero.toUpperCase());
        estudiante.setResidencia(residencia);
        
        System.out.println("\n\nMATERIAS PRIMER CUATRIMESTRE DE LA UNIVERSIDAD\n");
        String resp = "N";
        mostrarHorarios();
        
        do{
            boolean bandera = true;
            
            System.out.print("Ingrese el codigo de la materia a inscribirse : ");
            String codigo = sc1.nextLine();
            codigo = codigo.toUpperCase();
            
            if (materias.existe(codigo)){
                Materia mat = materias.buscar(codigo);
                
                if (!mat.estaLleno()){
                    if (estudiante.getMaterias().existe(codigo)){
                        System.out.println("Usted ya se inscribio a esta materia.");
                    } else{
                        
                        if (alumnos.existe(cedula)) {
                            System.out.println("La cedula ingresada ya existe, intente la matriculacion nuevamente.");
                        } else {
                            estudiante.getMaterias().push(new NodoP(mat));
                            mat.incrementarAlumnado();
                            total += mat.getCosto();
                            band = true;
                        }

                    }
                } else{
                    System.out.println("No se pudo inscribir, se alcanzo el cupo. Fue agreagado a cola de vacantes para ser llamados proximamente.");
                    
                    llamados.push(new NodoC(estudiante));
                }
            } else{
                System.out.println("No existe el codigo de materia ingresado.");
                bandera = false;
            }
            
            if (bandera) {
                System.out.println("Desea elegir otra materia? (S / N)");
                resp = sc.nextLine();
            } else{
                resp = "S";
            }
            
        } while (!resp.toUpperCase().equals("N"));        
        
        if (band) {
            calcularMedioPago(total, estudiante.getMaterias().size());
            estudiante.setMatricula(cantidad);
            alumnos.agregar(estudiante);
        }
        
        pressAnyKeyToContinue();
    }
    
    private static void funcion_2(){
        System.out.println("******************************** CONGELAMIENTO DE MATERIAS ***********************************");
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese la cedula del alumno : ");
        String cedula = sc.nextLine();
        cedula = cedula.toUpperCase();
        Estudiante estudiante = null;
        
        if (alumnos.existe(cedula)){
            estudiante = alumnos.buscar(cedula);
            
            System.out.println("************* INFORMACION ALUMNO *************\n");
            System.out.println(estudiante);
            System.out.println("************* MATERIAS ACTIVAS *************");
            estudiante.mostrarMateriasActivas();
            
            System.out.println("************* MATERIAS CONGELADAS *************\n");
            
            estudiante.mostrarMateriasCongeladas();
            
            String resp = "N";
            
            do{
                System.out.println("Desea congelar materias? (S / N)");
                resp = sc.nextLine();
              
                if (!resp.toUpperCase().equals("N")) {
                    System.out.print("Ingrese el codigo de la materia a congelar : ");
                    String codigo = sc.nextLine();
                    codigo = codigo.toUpperCase();

                    if (estudiante.getMaterias().size() != 0) {
                        if (estudiante.getMaterias().existe(codigo)) {
                            estudiante.congelarMateria(codigo);

                            System.out.println("La operacion se hizo con éxito.");
                        } else {
                            System.out.println("El codigo de la materia no esta registrado en las materias del alumno.");
                        }
                    } else {
                        System.out.println("No hay materias activas para congelar el proximo cuatrimestre.");
                    }
                }

            } while(!resp.toUpperCase().equals("N"));
        } else{
            System.out.println("La matricula del alumno no existe.");
        }
        
        pressAnyKeyToContinue();
    }
    
    private static void funcion_3(){
        System.out.println("************************** ESTADISTICAS UNIVERSIDAD PROGRESO ********************************");
    
        System.out.println(String.format("MATRICULA MINIMA UNIVERSIDAD: %d", MATRICULA_MINIMA_UNIVERSIDAD));
        System.out.println(String.format("HABILITACION/CURSADO? = %s", alumnos.size() >= MATRICULA_MINIMA_UNIVERSIDAD? "SI":"NO"));
        System.out.println(String.format("TOPE MAXIMO? = %s", alumnos.size() > MATRICULA_MAXIMO_UNIVERSIDAD? "SI":"NO"));
        System.out.println(String.format("Alumnado matriculados : %d", alumnos.size()));
        System.out.println(String.format("Alumnos ha ser llamados por falta de vacantes : %d ", llamados.size()));
        System.out.println(String.format("Materias matriculadas : %d", materias.size()));
        System.out.println(String.format("Cantidad de mujeres : %d", calcularGenero("M")));
        System.out.println(String.format("Cantidad de hombres : %d", calcularGenero("H")));
        System.out.println(String.format("Total recaudado : %.2f colones", totalRecaudado));
        
        pressAnyKeyToContinue();
        
    }
    
    private static void funcion_4(){
        System.out.println("************************** REPORTE UNIVERSIDAD PROGRESO ********************************\n");
        
        System.out.println(String.format("Total materias congeladas (cuatrimestre actual): %d materias", calcularMateriasCongeladas()));
        System.out.println(String.format("Listado alumnos : %d inscriptos\n", alumnos.size()));
        
        int size = alumnos.size();
        int c = 0;
        
        System.out.println(String.format("|%-15s|%-25s|%-16s|%-21s|", " MATRICULA",
                " APELLIDO Y NOMBRE",
                " NRO. MAT. ACT.", " NRO. MAT. CONGELADAS"));
        for (int i = 0; i < size; i++) {
            Estudiante obj = alumnos.get(i);

            System.out.println(String.format("|%-15s|%-25s|%-16s|%-21s|", obj.getMatricula(),
                    obj.getApellido().toUpperCase() + ", " + obj.getNombre(),
                    String.valueOf(obj.getMaterias().size()),
                    String.valueOf(obj.getCongeladas().size())));
            
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t**Detalle de MAT. ACTIVAS :\n");
            for (int j = 0; j < obj.getMaterias().size(); j++) {
                Materia materia = obj.getMaterias().get(j);
                
                System.out.println(String.format("\t\t\t\t\t\t\t%-5d %-20s (AULA %d)", j, materia.getNombre(), materia.getAula()));
            }
            
            System.out.println("\t\t\t\t\t\t\t**Detalle de MAT. GONGELADAS :\n");
            for (int j = 0; j < obj.getCongeladas().size(); j++) {
                Materia materia = obj.getCongeladas().get(j);
                
                System.out.println(String.format("\t\t\t\t\t\t\t%-5d %-20s (AULA %d)", j, materia.getNombre(), materia.getAula()));
            }
            
            System.out.println("");
        }
        
        pressAnyKeyToContinue();
    }
    
    private static int calcularGenero(String genero){
        int size = alumnos.size();
        int c = 0;
        
        for (int i = 0; i < size; i++){
            Estudiante obj = alumnos.get(i);
            
            if (obj.getGenero().equals(genero)){
                c++;
            }
        }
        
        return c;
    }
    
    public static int calcularMateriasCongeladas() {
        int size = alumnos.size();
        int c = 0;
        
        for (int i = 0; i < size; i++) {
            Estudiante obj = alumnos.get(i);

            c += obj.getCongeladas().size();

        }

        return c;
    }
}
