import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class UserLoginController implements Initializable {
	Connection conn;
	
	@FXML
	private TextField passwordText, userNameText;
	
	@FXML
	private VBox userLogin;
	
	@FXML
	private Text errorText;
	
	public UserLoginController() {
		// TODO Auto-generated constructor stub
	}
	
	void getConnection(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void login() throws IOException {
		String userName = userNameText.getText();
		String password = passwordText.getText();
		boolean check = false;
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = conn.createStatement();
		    //rs = stmt.executeQuery("USE BookDB");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

		    if (stmt.execute("SELECT UserName, Password FROM Users")) {
		        rs = stmt.getResultSet();
		        ResultSetMetaData rsmd = rs.getMetaData();
		        int columnsNumber = rsmd.getColumnCount();
		        while (rs.next()) {
		        	String temp1 = rs.getString(1);
		        	String temp2 = rs.getString(2);
		        	if(temp1.contains(userName)  && temp2.contains(password) 
		        			&& userName.contains(temp1)  && password.contains(temp2)) {
		        		check = true;
		        		break;
		        	}
		        }
		        
		        if(check == true) {
		        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Main.fxml"));
		            Parent main = loader.load(); //load view into parent
		            MainController myctr = loader.getController();//get controller created by FXMLLoader
		            myctr.getConnection(conn);//use MyLoader class method for getConnection()
		            myctr.getUserName(userName);
		            userLogin.getScene().setRoot(main);
		        }
		        else
		        	errorText.setVisible(true);
		    }

		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
			errorText.setVisible(true);
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
	}

}
