package es.studium;
import java.util.Arrays;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
public class ConsultarMongo {
	public static void main(String[] args) {
		MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = conexion.getDatabase("nombreBD");
		MongoCollection alumnos = database.getCollection("studium");
		/* Buscar todos los alumno */
		FindIterable busquedaTodos = alumnos.find();
		/* Buscar todos los alumnos llamados "Ana" */
		FindIterable busquedaAna = alumnos.find(eq("nombre", "Ana"));
		/* Buscar todos los alumnos que han aprobado */
		FindIterable busquedaAprobados = alumnos.find(lte("nota", 50));
		/* Buscar todos los alumnos llamados Ana que han aprobado */
		FindIterable busquedaAnaAprobados = alumnos.find(and(eq("nombre", "Ana"), gte("nota", 5)));
		/* Recorremos todos los resultados y los mostramos */
		for (Object alumno : busquedaAprobados) {
			System.out.println(((Document) alumno).toJson());
		}
	}

}
