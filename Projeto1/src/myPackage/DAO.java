package myPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
private Connection connection = null;
public DAO() {
 try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 try {
	connection = DriverManager.getConnection("jdbc:mysql://localhost/dados", "root", "123456");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public List<Notas> getLista() {
	List<Notas> notas = new ArrayList<Notas>();
		PreparedStatement stmt;
		try{
		stmt = connection.prepareStatement("SELECT * FROM Nota");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Notas nota = new Notas();
			nota.setId(rs.getInt("id"));
			nota.setNome(rs.getString("nome"));
			nota.setText(rs.getString("text"));

			notas.add(nota);
		}
		rs.close();
		stmt.close();
		 }
catch (SQLException e) {
	
	e.printStackTrace();
}
		return notas;
		}
public void close() {
try {
	connection.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public void adiciona(Notas nota) {
String sql = "INSERT INTO Nota" +
"(nome,text) values(?,?)";
PreparedStatement stmt;
try {
stmt = connection.prepareStatement(sql);
stmt.setString(1,nota.getNome());
stmt.setString(2,nota.getText());
stmt.execute();
stmt.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public void altera(Notas nota) {
String sql = "UPDATE Nota SET " + 
"nome=?, text=? WHERE id=?";
PreparedStatement stmt;
try {
	stmt = connection.prepareStatement(sql);
	stmt.setString(1, nota.getNome());
	stmt.setString(2, nota.getText());
	stmt.setInt(3, nota.getId());
	stmt.execute();
	stmt.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
public void remove(Integer id) {
PreparedStatement stmt;
try {
	stmt = connection.prepareStatement("DELETE FROM Nota WHERE id=?");
	stmt.setLong(1, id);
	stmt.execute();
	stmt.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}
