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

public class UpdateMongo {
	public static void main(String args[]) 
	{
		MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = conexion.getDatabase("nombreBD");
		MongoCollection alumnos = database.getCollection("studium");
		alumnos.updateOne(eq("nombre", "Ana"), combine(set("apellido", "Andrea"), set("nota", 8)));
	}
}
