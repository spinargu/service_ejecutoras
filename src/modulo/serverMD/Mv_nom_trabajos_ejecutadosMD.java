package modulo.serverMD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Mv_nom_trabajos_ejecutadosMD {
	private Connection con = null;
	
	public Mv_nom_trabajos_ejecutadosMD() {
		// TODO Auto-generated constructor stub
	}
	
	public String qryCata_trabajos_programados(String param){
		String result = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
	
		String n_corto_unid_trabajos = "";
		String sqlTxt = "SELECT id_nom_trabajos_ejecutados,id_nom_obra_ejecucion,nom_trabajos_ejecutados," +
				" cantidad_trabajos, id_unidad_trabajos, id_tipo_trabajos, nom_unidad_metas,n_corto_unid_metas " +
				" FROM mv_nom_trabajos_ejecutados trab" +
				" LEFT JOIN portalin_catalogo.cg_nom_unidad_metas unid ON unid.id_unidad_metas = trab.id_unidad_trabajos" +
				param +//" WHERE id_nom_obra_ejecucion = "+id_nom_obra_ejecucion + " AND id_tipo_trabajos = " +id_tipo_trabajos +
				" ORDER BY id_nom_trabajos_ejecutados";
		
		//msg("Mv_nom_trabajos_ejecutadosMD qryCata_trabajos_ejecutados sqlTxt = "+sqlTxt);
		try {
		    Statement stmt = con.createStatement();
		   	ResultSet rs = stmt.executeQuery(sqlTxt);
		    while(rs.next()){
		    	n_corto_unid_trabajos = rs.getString("n_corto_unid_metas");
		    	if(n_corto_unid_trabajos != null)
		    		n_corto_unid_trabajos = n_corto_unid_trabajos.toLowerCase();
		    	
		       	obj = new JSONObject();
		    	//obj.put("id_nom_trabajos_ejecutados", rs.getInt("id_nom_trabajos_ejecutados"));
		    	obj.put("id_nom_obra_ejecucion", rs.getInt("id_nom_obra_ejecucion"));
	            obj.put("nom_trabajos_ejecutados", rs.getString("nom_trabajos_ejecutados"));
	            obj.put("cantidad_trabajos", rs.getDouble("cantidad_trabajos"));
	            obj.put("nom_unidad_trabajos", rs.getString("nom_unidad_metas"));
	            obj.put("n_corto_unid_trabajos", n_corto_unid_trabajos);
	            obj.put("id_tipo_trabajos", rs.getInt("id_tipo_trabajos"));
	            //obj.put("id_unidad_trabajos", rs.getInt("id_unidad_trabajos"));
	        
			   	jsonArray.put(obj);
			   	}
				
				stmt.close();
				}
		catch (JSONException e) {msg("DefaultListItem.toString JSONException: "+e.getMessage());  	}
		catch(Exception e) {msg("Mv_nom_trabajos_ejecutadosMD qryCata_trabajos_ejecutados: " + e.getMessage().toString());}    
				// msg(" qryCata_trabajos_ejecutados relCuentaObras.size="+relCuentaObras.size());   
		
		if(jsonArray.length() > 0)
			result = "{\"success\":\"true\",\"registros\": " +jsonArray.toString() + "}";
		else
			result = "{\"success\":\"false\",\"registros\": []}";
		
		return result;
	}
	
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	private void msg(String text){System.out.println(text);}

}
