import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LoginController implements Initializable {
	@FXML
	private TextField userNameText, hostText, passwordText;
	@FXML
	private VBox login;
	@FXML
	private Text errorText;
	
	Connection conn;
	
	public LoginController() {
		// TODO Auto-generated constructor stub
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
		
		conn = null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void login() throws IOException {
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://"+ hostText.getText() + " /test?" +
		                                   "user=" + userNameText.getText() + "&password=" + passwordText.getText());


		} catch (SQLException ex) {
		    // handle any errors
			errorText.setVisible(true);
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("USE BookDB");
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UserLogin.fxml"));
	        Parent userLogin = loader.load(); //load view into parent
	        UserLoginController myctr = loader.getController();//get controller created by FXMLLoader
	        myctr.getConnection(conn);//use MyLoader class method for getConnection()
	        
	        login.getScene().setRoot(userLogin);
		}
		catch (SQLException ex){
		    // handle any errors
			errorText.setVisible(true);
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
