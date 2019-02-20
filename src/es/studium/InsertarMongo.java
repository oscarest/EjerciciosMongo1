package es.studium;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import java.util.Arrays;

public class InsertarMongo {
	public static void main(String[] args) {
		MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = conexion.getDatabase("nombreBD");
		MongoCollection alumnos = database.getCollection("studium");
		/* Creamos un documento mediante new */
		Document documento = new Document("nombre", "Manolo").append("apellido", "García").append("edad", 28);
		/* Añadimos un único documento */
		alumnos.insertOne(documento);
		/* Insertamos varios documentos creados parseando strings */
		alumnos.insertMany(Arrays.asList(Document.parse("{ nombre: 'Ana', edad: 25, pagado: true, nota: 7 }"),
				Document.parse("{ nombre: 'Benito', apellido: 'Benítez', edad: 50, nota: 9.8 }"),
				Document.parse("{ nombre: 'Carmen', edad: 31, pagado: false, nota: 3 }")));
	}

}
