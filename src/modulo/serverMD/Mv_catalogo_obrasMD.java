package modulo.serverMD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Mv_catalogo_obrasMD {
	private Connection con  = null;
	
	public Mv_catalogo_obrasMD() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String qryCataAreaGen(){
		String sqlTxt = "SELECT    id_area_gen, nom_area_gen, clave_area_gen " +
				" FROM portalin_catalogo.cg_nom_area_general "+
				" ORDER BY nom_area_gen";
		return qryGenerica_3param(sqlTxt);
	}
	
	public String qryCataNomCoordinaciones(){
		String sqlTxt = "SELECT   id_coordinacion, nom_coordinacion " +
				" FROM  portalin_catalogo.cg_nom_coordinacion "+
				" ORDER BY nom_coordinacion";
		return qryGenerica(sqlTxt);
	}
	
	public String qryCataNomMunicipios(){
		String sqlTxt = "SELECT   id_nom_municipio, nom_municipio " +
				" FROM  portalin_catalogo.cg_nom_municipio "+
				" ORDER BY nom_municipio";
		return qryGenerica(sqlTxt);
	}
	
	public String qryCataNomDistrito(){
		String sqlTxt = "SELECT   id_distrito, CONCAT(nom_distrito,' ', texto_distrito) AS nom_distrito " +
				 " FROM  portalin_catalogo.cg_nom_distelect " +
				 " WHERE NOT id_distrito = 19 " + //19 = cobertura estatal
				 " ORDER BY clave_distrito";
		return qryGenerica(sqlTxt);
	}
	
	public String qryCataProInversion(){
		String sqlTxt = "SELECT  id_nom_pro_inversion,n_corto_pro_inv " +
				" FROM portalin_catalogo.cg_nom_pro_inversion "+
				" ORDER BY n_corto_pro_inv";
		return qryGenerica(sqlTxt);
	}
	
	public String qryCataProAnualObra(){
		String sqlTxt = "SELECT id_pro_anual, pro_anual" +
				" FROM  portalin_catalogo.cg_nom_pro_anual "+
				" ORDER BY pro_anual DESC";
		
		return qryGenerica(sqlTxt);
	}
	
	private String qryGenerica(String sqlTxt){
		String result = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
	
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlTxt);
	        while (rs.next()) {
	        	obj = new JSONObject();
	        	obj.put("id_catalogo", rs.getInt(1));
	            obj.put("nom_catalogo", rs.getString(2));
	 
	           	jsonArray.put(obj);
	        	}
	        stmt.close();
			}
		catch (JSONException e) {msg("DefaultListItem.toString JSONException: "+e.getMessage());  	}
	     catch (SQLException ex) {msg("Mv_catalogo_obrasMD qryGenerica: " + ex.getMessage());}
		
		if(jsonArray.length() > 0)
			result = "{\"success\":\"true\",\"registros\": " +jsonArray.toString() + "}";
		else
			result = "{\"success\":\"false\",\"registros\": []}";
		
		return result;
	}
	
	private String qryGenerica_3param(String sqlTxt){
		String result = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
	
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlTxt);
	        while (rs.next()) {
	        	obj = new JSONObject();
	        	obj.put("id_catalogo", rs.getInt(1));
	            obj.put("nom_catalogo", rs.getString(2));
	            obj.put("clave_area_gen", rs.getString(3));
	 
	           	jsonArray.put(obj);
	        	}
	        stmt.close();
			}
		catch (JSONException e) {msg("DefaultListItem.toString JSONException: "+e.getMessage());  	}
	     catch (SQLException ex) {msg("Mv_catalogo_obrasMD qryGenerica_3param: " + ex.getMessage());}
		
		if(jsonArray.length() > 0)
			result = "{\"success\":\"true\",\"registros\": " +jsonArray.toString() + "}";
		else
			result = "{\"success\":\"false\",\"registros\": []}";
		
		return result; 
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	private void msg(String text){System.out.println(text); 	}

}
