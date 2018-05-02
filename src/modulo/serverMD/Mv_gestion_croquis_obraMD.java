package modulo.serverMD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Mv_gestion_croquis_obraMD {
	private Connection con;
	
	public Mv_gestion_croquis_obraMD() {
		// TODO Auto-generated constructor stub
	}
	
	public String qryList_croquis_obra(String param){
		String result = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = new JSONObject();
		
		String nom_file_grafico = null;
		String nom_file_date = null;
		String sqlTxt = " SELECT id_croquis_obra, id_nom_obra_ejecucion, id_tipo_imagen," +
				" grafico, nom_file_grafico, observacion, fecha_edicion" +
				" FROM portalin_croquisobras.mv_croquis_obra" + param;
				//" WHERE id_nom_obra_ejecucion = " + id_nom_obra_ejecucion;
		
		try {
	        Statement stmt = con.createStatement();
	    	ResultSet rs = stmt.executeQuery(sqlTxt);
		    while(rs.next()){
		    	obj = new JSONObject();
		    	obj.put("id_croquis_obra", rs.getInt("id_croquis_obra"));
		    	obj.put("id_nom_obra_ejecucion", rs.getInt("id_nom_obra_ejecucion"));
	            obj.put("id_tipo_imagen", rs.getInt("id_tipo_imagen"));
	            obj.put("nom_file_grafico", rs.getString("nom_file_grafico"));
	            obj.put("grafico", rs.getString("grafico"));
  
		    	jsonArray.put(obj);
		    	}
		    stmt.close();
		    }
		catch (JSONException e) {msg("DefaultListItem.toString JSONException: "+e.getMessage());  	}
		catch(Exception e) {  msg("Mv_gestion_croquis_obraMD qryReg_croquis_obra: " + e.getMessage().toString());  } 
		
		if(jsonArray.length() > 0)
			result = "{\"success\":\"true\",\"registros\": " +jsonArray.toString() + "}";
		else
			result = "{\"success\":\"false\",\"registros\": []}";
			
		return result; 
	}
	
	private void msg(String text){System.out.println(text); 	}
	
	public void setCon(Connection con) {
		this.con = con;
	}

}
