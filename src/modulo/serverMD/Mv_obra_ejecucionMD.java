package modulo.serverMD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import modulo.serverDP.Mv_obra_ejecucionDP;

public class Mv_obra_ejecucionMD {
	private Connection con  = null;

	public Mv_obra_ejecucionMD() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String qryReg_obra_ejecucion(String param){
		String result = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
		Double inversion_contratada = 0.0;
		Double inversion_autorizada = 0.0;
		
		String sqlTxt = "SELECT obra.id_nom_obra_ejecucion, nom_obra_ejecucion, obra.id_area_gen, nom_area_gen, " +
				"obra.id_nom_municipio, nom_municipio,coor.id_coordinacion,nom_coordinacion," +
				"nom_localidad,metas, metas_alcanzadas,inversion_autorizada, inversion_contratada, inv_autorizada_amp, inv_contratada_amp," +
				"obra.id_nom_pro_inversion, n_corto_pro_inv, avance_fisico, avance_estimado, avance_admon,obra.id_pro_anual, pro_anual," +
				"no_beneficiarios,proceso_obra, nom_ejecutor,  clave_admon, dele.id_distrito, CONCAT(nom_distrito,' ', texto_distrito) AS nom_distrito," +
				"fecha_inicio_real, fecha_termino_real, fecha_entrega_recepcion, fecha_inicio_contrato, fecha_termino_contrato," +
				"fecha_inicio_ampliacion, fecha_termino_ampliacion, obra.id_organizacion, nom_organizacion," +
				"oficios_autorizacion, fechas_of_autorizacion, fechas_recibido_oficio, latitud, longitud" +
				" FROM portalin_obras.mv_nom_obra_ejecucion obra" +
				" LEFT JOIN portalin_obras.mv_nom_obra_autorizada ofaut ON ofaut.id_nom_obra_ejecucion = obra.id_nom_obra_ejecucion" +
				" LEFT JOIN portalin_catalogo.cg_nom_pro_anual panu ON panu.id_pro_anual = obra.id_pro_anual" +
				" LEFT JOIN portalin_catalogo.cg_nom_pro_inversion pinv ON pinv.id_nom_pro_inversion = obra.id_nom_pro_inversion" +
				" LEFT JOIN portalin_catalogo.cg_nom_area_general agen ON agen.id_area_gen = obra.id_area_gen" +
				" LEFT JOIN portalin_catalogo.cg_nom_organizacion orga ON orga.id_organizacion = obra.id_organizacion" +
				" LEFT JOIN portalin_catalogo.cg_nom_municipio muni ON muni.id_nom_municipio = obra.id_nom_municipio" +
				" LEFT JOIN portalin_catalogo.cg_nom_coordinacion coor ON coor.id_coordinacion = muni.id_coordinacion" +
				" LEFT JOIN portalin_catalogo.cg_nom_distelect dele ON dele.id_distrito = muni.id_distrito" +
					param;//WHERE obra.id_nom_obra_ejecucion = 3 
		//msg("qryReg_obra_ejecucion sqlTxt: "+sqlTxt);
		try {
	        Statement stmt = con.createStatement();
	    	ResultSet rs = stmt.executeQuery(sqlTxt);
		    if(rs.next()){
		    	obj = new JSONObject();
			    	
		    	inversion_autorizada = rs.getDouble("inversion_autorizada") + rs.getDouble("inv_autorizada_amp");
		    	inversion_contratada = rs.getDouble("inversion_contratada") + rs.getDouble("inv_contratada_amp");
		    	
		    	obj.put("id_nom_obra_ejecucion",  rs.getInt("id_nom_obra_ejecucion"));
		    	obj.put("nom_obra_ejecucion", rs.getString("nom_obra_ejecucion"));
		    	obj.put("id_area_gen", rs.getInt("id_area_gen"));
		    	obj.put("nom_area_gen", rs.getString("nom_area_gen"));
		    	obj.put("id_nom_municipio", rs.getInt("id_nom_municipio"));
		    	obj.put("nom_municipio", rs.getString("nom_municipio"));
		    	obj.put("id_coordinacion", rs.getInt("id_coordinacion"));
		    	obj.put("nom_coordinacion", rs.getString("nom_coordinacion"));
		    	obj.put("nom_localidad", rs.getString("nom_localidad"));
		    	obj.put("metas", rs.getString("metas"));
		    	obj.put("metas_alcanzadas", rs.getString("metas_alcanzadas")); 
		    	obj.put("inversion_autorizada", inversion_autorizada);
	            obj.put("inversion_contratada", inversion_contratada);
	            obj.put("id_nom_pro_inversion", rs.getInt("id_nom_pro_inversion"));
	            obj.put("nom_pro_inversion", rs.getString("n_corto_pro_inv"));
	            obj.put("avance_fisico", rs.getDouble("avance_fisico"));
	            obj.put("avance_admon", rs.getDouble("avance_admon"));
	            obj.put("id_pro_anual", rs.getInt("id_pro_anual"));
	            obj.put("pro_anual", rs.getInt("pro_anual"));
	            obj.put("num_beneficiarios", rs.getInt("no_beneficiarios"));
	            obj.put("id_organizacion", rs.getInt("id_organizacion"));
	            obj.put("nom_organizacion", rs.getString("nom_organizacion"));
	            obj.put("id_distrito", rs.getInt("id_distrito"));
	            obj.put("nom_distrito", rs.getString("nom_distrito"));
	            obj.put("fecha_inicio_real", rs.getDate("fecha_inicio_real"));
	            obj.put("fecha_termino_real", rs.getDate("fecha_termino_real"));
	            obj.put("fecha_entrega_recepcion", rs.getDate("fecha_entrega_recepcion"));
	            obj.put("fecha_inicio_contrato", rs.getDate("fecha_inicio_contrato"));
	            obj.put("fecha_termino_contrato", rs.getDate("fecha_termino_contrato"));
	            obj.put("fecha_inicio_ampliacion", rs.getDate("fecha_inicio_ampliacion"));
	            obj.put("fecha_termino_ampliacion", rs.getDate("fecha_termino_ampliacion"));
	            obj.put("latitud", rs.getDouble("latitud"));
	            obj.put("longitud", rs.getDouble("longitud"));
	            obj.put("oficios_autorizacion", rs.getString("oficios_autorizacion"));
	            //obj.put("fechas_of_autorizacion", rs.getString("fechas_of_autorizacion"));
	            //obj.put("fechas_recibido_oficio", rs.getString("fechas_recibido_oficio"));
	            obj.put("clave_admon", rs.getString("clave_admon"));
	            
	        
		    	jsonArray.put(obj);
		    	}
           stmt.close();
			}
		catch (JSONException e) {msg("DefaultListItem.toString JSONException: "+e.getMessage());  	}
		catch(Exception e) {msg("Mv_obra_ejecucionMD qryReg_obra_ejecucion: " + e.getMessage().toString());}   
		//msg("qryReg_obra_ejecucion relCuentaObras.size="+relCuentaObras.size());
		if(jsonArray.length() > 0)
			result = "{\"success\":\"true\",\"registros\": " +jsonArray.toString() + "}";
		else
			result = "{\"success\":\"false\",\"registros\": []}";
		
		return result;
	}
	
	public String qryCata_obra_ejecucion(String param){
		String result = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
	
		Double inversion_contratada = 0.0;
		Double inversion_autorizada = 0.0;
		
		if(param != null && param.length() > 0)
			param += " AND obra.baja_logica = 0"; 
		else
			param = " WHERE obra.baja_logica = 0";
		
		String sqlTxt = "SELECT obra.id_nom_obra_ejecucion, nom_obra_ejecucion, obra.id_area_gen, nom_area_gen, " +
				"obra.id_nom_municipio, nom_municipio,coor.id_coordinacion,nom_coordinacion," +
				"nom_localidad,metas, metas_alcanzadas,inversion_autorizada, inversion_contratada, inv_autorizada_amp, inv_contratada_amp," +
				"obra.id_nom_pro_inversion, n_corto_pro_inv, avance_fisico, avance_estimado, avance_admon,obra.id_pro_anual, pro_anual," +
				"no_beneficiarios,proceso_obra, nom_ejecutor,  clave_admon, dele.id_distrito, CONCAT(nom_distrito,' ', texto_distrito) AS nom_distrito," +
				"fecha_inicio_real, fecha_termino_real, fecha_entrega_recepcion, fecha_inicio_contrato, fecha_termino_contrato," +
				"fecha_inicio_ampliacion, fecha_termino_ampliacion, obra.id_organizacion, nom_organizacion," +
				"oficios_autorizacion, fechas_of_autorizacion, fechas_recibido_oficio, latitud, longitud" +
				" FROM portalin_obras.mv_nom_obra_ejecucion obra" +
				" LEFT JOIN portalin_obras.mv_nom_obra_autorizada ofaut ON ofaut.id_nom_obra_ejecucion = obra.id_nom_obra_ejecucion" +
				" LEFT JOIN portalin_catalogo.cg_nom_pro_anual panu ON panu.id_pro_anual = obra.id_pro_anual" +
				" LEFT JOIN portalin_catalogo.cg_nom_pro_inversion pinv ON pinv.id_nom_pro_inversion = obra.id_nom_pro_inversion" +
				" LEFT JOIN portalin_catalogo.cg_nom_area_general agen ON agen.id_area_gen = obra.id_area_gen" +
				" LEFT JOIN portalin_catalogo.cg_nom_organizacion orga ON orga.id_organizacion = obra.id_organizacion" +
				" LEFT JOIN portalin_catalogo.cg_nom_municipio muni ON muni.id_nom_municipio = obra.id_nom_municipio" +
				" LEFT JOIN portalin_catalogo.cg_nom_coordinacion coor ON coor.id_coordinacion = muni.id_coordinacion" +
				" LEFT JOIN portalin_catalogo.cg_nom_distelect dele ON dele.id_distrito = muni.id_distrito" +
				param;//obra.id_nom_obra_ejecucion = 3 AND obra.baja_logica = 0"
		
		//msg("qryCata_obra_ejecucion sqlTxt: "+sqlTxt);
		try {
	        Statement stmt = con.createStatement();
	    	ResultSet rs = stmt.executeQuery(sqlTxt);
		    while(rs.next()){
		     	obj = new JSONObject();
		    	inversion_autorizada = rs.getDouble("inversion_autorizada") + rs.getDouble("inv_autorizada_amp");
		    	inversion_contratada = rs.getDouble("inversion_contratada") + rs.getDouble("inv_contratada_amp");
		    	
		    	obj.put("id_nom_obra_ejecucion",  rs.getInt("id_nom_obra_ejecucion"));
		    	obj.put("nom_obra_ejecucion", rs.getString("nom_obra_ejecucion"));
		    	obj.put("id_area_gen", rs.getInt("id_area_gen"));
		    	obj.put("nom_area_gen", rs.getString("nom_area_gen"));
		    	obj.put("id_nom_municipio", rs.getInt("id_nom_municipio"));
		    	obj.put("nom_municipio", rs.getString("nom_municipio"));
		    	obj.put("id_coordinacion", rs.getInt("id_coordinacion"));
		    	obj.put("nom_coordinacion", rs.getString("nom_coordinacion"));
		    	obj.put("nom_localidad", rs.getString("nom_localidad"));
		    	obj.put("metas", rs.getString("metas"));
		    	obj.put("metas_alcanzadas", rs.getString("metas_alcanzadas")); 
		    	obj.put("inversion_autorizada", inversion_autorizada);
	            obj.put("inversion_contratada", inversion_contratada);
	            obj.put("id_nom_pro_inversion", rs.getInt("id_nom_pro_inversion"));
	            obj.put("nom_pro_inversion", rs.getString("n_corto_pro_inv"));
	            obj.put("avance_fisico", rs.getDouble("avance_fisico"));
	            obj.put("avance_admon", rs.getDouble("avance_admon"));
	            obj.put("id_pro_anual", rs.getInt("id_pro_anual"));
	            obj.put("pro_anual", rs.getInt("pro_anual"));
	            obj.put("num_beneficiarios", rs.getInt("no_beneficiarios"));
	            obj.put("id_organizacion", rs.getInt("id_organizacion"));
	            obj.put("nom_organizacion", rs.getString("nom_organizacion"));
	            obj.put("id_distrito", rs.getInt("id_distrito"));
	            obj.put("nom_distrito", rs.getString("nom_distrito"));
	            obj.put("fecha_inicio_real", rs.getDate("fecha_inicio_real"));
	            obj.put("fecha_termino_real", rs.getDate("fecha_termino_real"));
	            obj.put("fecha_entrega_recepcion", rs.getDate("fecha_entrega_recepcion"));
	            obj.put("fecha_inicio_contrato", rs.getDate("fecha_inicio_contrato"));
	            obj.put("fecha_termino_contrato", rs.getDate("fecha_termino_contrato"));
	            obj.put("fecha_inicio_ampliacion", rs.getDate("fecha_inicio_ampliacion"));
	            obj.put("fecha_termino_ampliacion", rs.getDate("fecha_termino_ampliacion"));
	            obj.put("latitud", rs.getDouble("latitud"));
	            obj.put("longitud", rs.getDouble("longitud"));
	            obj.put("oficios_autorizacion", rs.getString("oficios_autorizacion"));
	            //obj.put("fechas_of_autorizacion", rs.getString("fechas_of_autorizacion"));
	            //obj.put("fechas_recibido_oficio", rs.getString("fechas_recibido_oficio"));
	            obj.put("clave_admon", rs.getString("clave_admon"));
		    	
	           	jsonArray.put(obj);
		    	}
           stmt.close();
		}
		catch (JSONException e) {msg("DefaultListItem.toString JSONException: "+e.getMessage());  	}
		catch(Exception e) { msg("Mv_obra_ejecucionMD qryCata_obra_ejecucion: " + e.getMessage().toString());}   
		//msg("qryReg_obra_ejecucion relCuentaObras.size="+relCuentaObras.size());
		
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
