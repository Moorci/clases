package Ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class Recorrido {

	public static void main(String[] args) {
		FileInputStream serviceAccount;
		try {
			serviceAccount = new FileInputStream("resources/empresaBD.json");

			FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId("ejerciciobdad")
					.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

			Firestore db = firestoreOptions.getService();
			eliminar1(db);
			eliminar2(db);
			modificarEmpleado(db);
			insertarDepartamentoyEmpleados(db);

			QuerySnapshot query = db.collection("Departamento").get().get();
			List<QueryDocumentSnapshot> departamentos = query.getDocuments();
			for(QueryDocumentSnapshot departamento: departamentos) {
				System.out.println("ID: "+ departamento.getId());
				System.out.println("Nombre: "+ departamento.getString("dpto_nom"));
				System.out.println("Localizacion: "+ departamento.getString("dpto_loc"));
				
				DocumentReference ref = departamento.getReference();
				List<QueryDocumentSnapshot> empleados = ref.collection("Empleados").get().get().getDocuments();
				for (QueryDocumentSnapshot empleado : empleados) {
					System.out.println("\tID: " + empleado.getId());
					System.out.println("\t\tNombre: " + empleado.get("emple_ap1"));
					System.out.println("\t\tOficio: " + empleado.get("oficio"));
					System.out.println("\t\tFecha de alta: " + empleado.getTimestamp("fecha_alt"));
					System.out.println("\t\tComision: " + empleado.getLong("comision"));
					System.out.println("\t\tSalario: " + empleado.getDouble("salario"));
					System.out.println("\t\tDIR: " + empleado.getReference().getId());
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
	private static void eliminar1(Firestore db) {
	    try {
	        // Obtener todos los departamentos
	        List<QueryDocumentSnapshot> departamentos = db.collection("Departamento").get().get().getDocuments();

	        for (QueryDocumentSnapshot departamento : departamentos) {
	            // Verificar si el departamento está en MADRID
	            if ("MADRID".equalsIgnoreCase(departamento.getString("dpto_loc"))) {
	                // Obtener todos los empleados del departamento
	                List<QueryDocumentSnapshot> empleados = departamento.getReference()
	                        .collection("Empleados").get().get().getDocuments();

	                // Eliminar cada empleado
	                for (QueryDocumentSnapshot empleado : empleados) {
	                    empleado.getReference().delete();
	                    System.out.println("Empleado eliminado en MADRID: " + empleado.getId());
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private static void eliminar2(Firestore db) {
	    try {
	        // Obtener todos los departamentos
	        List<QueryDocumentSnapshot> departamentos = db.collection("Departamento").get().get().getDocuments();

	        for (QueryDocumentSnapshot departamento : departamentos) {
	            // Verificar si el departamento es CONTABILIDAD
	            if ("CONTABILIDAD".equalsIgnoreCase(departamento.getString("dpto_nom"))) {
	                List<QueryDocumentSnapshot> empleados = departamento.getReference()
	                        .collection("Empleados").get().get().getDocuments();

	                QueryDocumentSnapshot mejorPagado = null;
	                double salarioMax = 0;

	                // Buscar al empleado con mayor salario
	                for (QueryDocumentSnapshot empleado : empleados) {
	                    Double salario = empleado.getDouble("salario");
	                    if (salario != null && salario > salarioMax) {
	                        salarioMax = salario;
	                        mejorPagado = empleado;
	                    }
	                }

	                // Eliminar al empleado con mayor salario
	                if (mejorPagado != null) {
	                    mejorPagado.getReference().delete();
	                    System.out.println("Empleado mejor pagado eliminado de CONTABILIDAD: " + mejorPagado.getId());
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private static void modificarEmpleado(Firestore db) {
	    try {
	        // Obtener todos los departamentos
	        List<QueryDocumentSnapshot> departamentos = db.collection("Departamento").get().get().getDocuments();

	        for (QueryDocumentSnapshot departamento : departamentos) {
	            List<QueryDocumentSnapshot> empleados = departamento.getReference()
	                    .collection("Empleados").get().get().getDocuments();

	            for (QueryDocumentSnapshot empleado : empleados) {
	                // Verificar si el apellido es GIL
	                if ("GIL".equalsIgnoreCase((String) empleado.get("emple_ap1"))) {
	                    Map<String, Object> nuevosDatos = new HashMap<>();
	                    nuevosDatos.put("salario", 1300.0);
	                    nuevosDatos.put("fecha_alt", com.google.cloud.Timestamp.now().toDate().toInstant()
	                            .minus(java.time.Duration.ofDays(1)));

	                    // Actualizar los datos del empleado
	                    empleado.getReference().update(nuevosDatos);
	                    System.out.println("Empleado GIL actualizado.");
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private static void insertarDepartamentoyEmpleados(Firestore db) {
        CollectionReference empresa = db.collection("DEPARTAMENTO");

        Map<String, Object> dep = new HashMap<>();
        dep.put("nombre", "INFORMATICA");
        dep.put("localización", "Bilbao");
        DocumentReference depNew = empresa.document();
        depNew.set(dep);

        Map<String, Object> empleado = new HashMap<>();
        empleado.put("apellido", "RUIZ");
        empleado.put("cargo", "DIRECTOR");
        empleado.put("salario", 2300);
        empleado.put("comision", 1000);

        CollectionReference empleadosCol = depNew.collection("EMPLEADOS");
        empleadosCol.add(empleado);

        try {
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


	}
}
