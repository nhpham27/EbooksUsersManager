import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainController implements Initializable {
	Connection conn;
	String userName;
	
	@FXML
	private ListView<String> resultList;
	@FXML
	private Text errorText;
	@FXML
	private TextField searchBox;
	
	public MainController() {
		// TODO Auto-generated constructor stub
	}
	
	public void getUserName(String name) {
		this.userName = name;
	}
	
	public void getConnection(Connection conn) {
		this.conn = conn;
	}
	
	public void viewUsers() {
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = conn.createStatement();
		    //rs = stmt.executeQuery("USE BookDB");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

		    if (stmt.execute("SELECT * FROM ViewUsers")) {
		        rs = stmt.getResultSet();
		        resultList.getItems().clear();
		        resultList.getItems().add("UserID\t\t\tUserName");
		        while (rs.next()) {
		        	resultList.getItems().add(rs.getString(1) + "\t\t\t\t" + rs.getString(2));
		        }
		        
		    }

		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
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
	
	public void viewBooks() {
		Statement stmt = null;
		ResultSet rs = null;
		errorText.setVisible(false);
		
		try {
		    stmt = conn.createStatement();
		    //rs = stmt.executeQuery("USE BookDB");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

		    if (stmt.execute("SELECT * FROM Books")) {
		        rs = stmt.getResultSet();
		        resultList.getItems().clear();
		        while (rs.next()) {
		        	resultList.getItems().add(rs.getString(1)+ ". " + rs.getString(2) + "------" + rs.getString(3));
		        }
		    }

		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
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
	
	public void viewMyBooks() {
		Statement stmt = null;
		ResultSet rs = null;
		errorText.setVisible(false);

		try {
		    stmt = conn.createStatement();
		    //rs = stmt.executeQuery("USE BookDB");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...
		    String s = "CALL getUserBooks(\'" + this.userName + "\')";
		    if (stmt.execute(s)) {
		        rs = stmt.getResultSet();
		        resultList.getItems().clear();
		        int counter = 1;
		        while (rs.next()) {
		        	resultList.getItems().add(counter + ". " + rs.getString(1));
		        	counter++;
		        }
		    }

		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
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
	
	public void addBook() {
		try {
			String str = resultList.getSelectionModel().getSelectedItem().toString();
			errorText.setVisible(false);
			int i = 0;
			for(;i < str.length(); i++) {
				if(str.charAt(i) == '.')
					break;
			}
			
			String bookID = str.substring(0, i);
			this.addBookHelper(bookID);
		}catch(NullPointerException e) {
			errorText.setText("Added item is not selected from list");
			errorText.setVisible(true);
			System.out.println("Added item is not selected from list");
		}
	}
	
	private void addBookHelper(String bookID) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		    stmt = conn.createStatement();
		    //rs = stmt.executeQuery("USE BookDB");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...
		    String s = "CALL addUserBook(" + bookID
		    						+ ",\'" + this.userName + "\')";
		    if (stmt.execute(s)) {
		    	System.out.println("");
		    }
		    else {
		    	System.out.println("Added BookID: " + bookID);
		    }

		}
		catch (SQLException ex){
		    // handle any errors
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
	
	public void deleteBook() {
		try {
			String str = resultList.getSelectionModel().getSelectedItem().toString();
			
			int i = 0;
			for(;i < str.length(); i++) {
				if(str.charAt(i) == ' ')
					break;
			}
			
			String bookName = str.substring(i+1);
			this.deleteBookHelper(bookName);
			this.viewMyBooks();
		}catch(NullPointerException e) {
			errorText.setText("Added item is not selected from list");
			errorText.setVisible(true);
			System.out.println("Added item is not selected from list");
		}
	}
	
	private void deleteBookHelper(String bookName) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		    stmt = conn.createStatement();
		    //rs = stmt.executeQuery("USE BookDB");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...
		    String s = "CALL deleteUserBook(" + "\'" + bookName + "\')";
		    if (stmt.execute(s)) {
		    	System.out.println("");
		    }
		    else {
		    	errorText.setText("Deleted Book " + bookName);
		    	errorText.setVisible(true);
		    }

		}
		catch (SQLException ex){
		    // handle any errors
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
	
	public void searchBook() {
		String bookName = searchBox.getText();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		    stmt = conn.createStatement();
		    //rs = stmt.executeQuery("USE BookDB");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...
		    String s = "CALL getBookID(" + "\'" + bookName + "\')";
		    if (stmt.execute(s)) {
		    	rs = stmt.getResultSet();
		        if (rs.next()) {
		        	int temp = Integer.parseInt(rs.getString(1)) - 1;
		        	resultList.getSelectionModel().select(temp);
		        	resultList.getFocusModel().focus(temp);
		        	resultList.scrollTo(temp);
		        }
		    }

		}
		catch (SQLException ex){
		    // handle any errors
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
