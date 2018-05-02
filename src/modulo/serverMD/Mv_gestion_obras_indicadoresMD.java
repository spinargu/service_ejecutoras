package modulo.serverMD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import modulo.serverDP.Mv_indicadores_obraDP;
import modulo_control.Functions;

public class Mv_gestion_obras_indicadoresMD {
	protected Connection con = null;
	protected Functions fun = new Functions();
	
	public Mv_gestion_obras_indicadoresMD() {
		// TODO Auto-generated constructor stub
	}
	
	public String  qryMv_indicadores_estrategicos(String param){//2
		String sqlTxt = "SELECT id_nom_obra_ejecucion,id_conceptos_alineacion_obra, id_tipo_alineacion_obra," +
				" nom_indicadores_estrategicos AS nom_catalogo_alineacion" +
				" FROM mv_conceptos_alineacion_obra conc " +
				" INNER JOIN portalin_catalogo.cg_nom_indicadores_estrategicos indi ON indi.id_nom_indicadores_estrategicos = conc.id_nom_catalogo_alineacion " +
				" WHERE id_tipo_alineacion_obra = 2 " + param;//AND id_nom_obra_ejecucion = 3010";
		
		return qryGenerica_indicadores(sqlTxt);
	}
	
	public String  qryMv_desarrollo_sostenible(String param){//3
		String sqlTxt = "SELECT id_nom_obra_ejecucion,id_conceptos_alineacion_obra, id_tipo_alineacion_obra, id_nom_catalogo_alineacion," +
				 " nom_objetivos_desarrollo_sostenible AS nom_catalogo_alineacion" +
				 " FROM mv_conceptos_alineacion_obra conc " +
				 " INNER JOIN portalin_catalogo.cg_nom_objetivos_desarrollo_sostenible indi ON indi.id_nom_objetivos_desarrollo_sostenible = conc.id_nom_catalogo_alineacion" +
				 " WHERE id_tipo_alineacion_obra = 3 " + param;//AND id_nom_obra_ejecucion = 3010";
		
		return qryGenerica_indicadores(sqlTxt);
	}
	
	public String  qryMv_ejes_plan_estatal(String param){//4
		String sqlTxt = "SELECT id_nom_obra_ejecucion,id_conceptos_alineacion_obra, id_tipo_alineacion_obra, id_nom_catalogo_alineacion," +
				 " nom_ejes_plan_estatal_desarollo  AS nom_catalogo_alineacion " +
				 " FROM mv_conceptos_alineacion_obra conc " +
				 " INNER JOIN portalin_catalogo.cg_nom_ejes_plan_estatal_desarollo indi ON indi.id_nom_ejes_plan_estatal_desarollo = conc.id_nom_catalogo_alineacion" +
				 " WHERE id_tipo_alineacion_obra = 4 " + param;//AND id_nom_obra_ejecucion = 3010";
		
		return qryGenerica_indicadores(sqlTxt);
	}
	
	public String  qryMv_ejes_transversales(String param){//5
		String sqlTxt = "SELECT id_nom_obra_ejecucion,id_conceptos_alineacion_obra, id_tipo_alineacion_obra, id_nom_catalogo_alineacion," +
				 " nom_ejes_transversales  AS nom_catalogo_alineacion " +
				 " FROM mv_conceptos_alineacion_obra conc " +
				 " INNER JOIN portalin_catalogo.cg_nom_ejes_transversales indi ON indi.id_nom_ejes_transversales = conc.id_nom_catalogo_alineacion " +
				 " WHERE id_tipo_alineacion_obra = 5 " + param;//AND id_nom_obra_ejecucion = 3010";
		
		return qryGenerica_indicadores(sqlTxt);
	}
	
	public String  qryMv_programas_presupuestarios(String param){//6
		String sqlTxt = "SELECT id_nom_obra_ejecucion,id_conceptos_alineacion_obra, id_tipo_alineacion_obra, id_nom_catalogo_alineacion," +
				 " nom_programas_presupuestarios  AS nom_catalogo_alineacion" +
				 " FROM mv_conceptos_alineacion_obra conc" +
				 " INNER JOIN portalin_catalogo.cg_nom_programas_presupuestarios indi ON indi.id_nom_programas_presupuestarios = conc.id_nom_catalogo_alineacion" +
				 " WHERE id_tipo_alineacion_obra = 6 " + param;//AND id_nom_obra_ejecucion = 3010";
		
		return qryGenerica_indicadores(sqlTxt);
	}
	
	public String  qryMv_indicadores_tacticos(String param){//7
		String sqlTxt = "SELECT id_nom_obra_ejecucion,id_conceptos_alineacion_obra, id_tipo_alineacion_obra, id_nom_catalogo_alineacion," +
				 " nom_indicadores_tacticos  AS nom_catalogo_alineacion" +
				 " FROM mv_conceptos_alineacion_obra conc" +
				 " INNER JOIN portalin_catalogo.cg_nom_indicadores_tacticos indi ON indi.id_nom_indicadores_tacticos = conc.id_nom_catalogo_alineacion" +
				 " WHERE id_tipo_alineacion_obra = 7 " + param;//AND id_nom_obra_ejecucion = 3010";
		
		return qryGenerica_indicadores(sqlTxt);
	}
	
	public String  qryMv_indicadores_transversales(String param){//8
		String sqlTxt = "SELECT id_nom_obra_ejecucion,id_conceptos_alineacion_obra, id_tipo_alineacion_obra, id_nom_catalogo_alineacion," +
				 " nom_indicadores_transversales  AS nom_catalogo_alineacion" +
				 " FROM mv_conceptos_alineacion_obra conc" +
				 " INNER JOIN portalin_catalogo.cg_nom_indicadores_transversales indi ON indi.id_nom_indicadores_transversales = conc.id_nom_catalogo_alineacion" +
				 " WHERE id_tipo_alineacion_obra = 8 " + param;//AND id_nom_obra_ejecucion = 3010";
		
		return qryGenerica_indicadores(sqlTxt);
	}
	
	private String  qryGenerica_indicadores(String sqlTxt){
		String result = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
	
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlTxt);
	        while (rs.next()) {
	           	obj = new JSONObject();
	        	obj.put("id_nom_obra_ejecucion", rs.getInt("id_nom_obra_ejecucion"));
		         obj.put("id_conceptos_alineacion_obra", rs.getInt("id_conceptos_alineacion_obra"));
		         //obj.put("id_tipo_alineacion_obra", id_tipo_alineacion_obra);
		         obj.put("nom_catalogo_alineacion", rs.getString("nom_catalogo_alineacion"));
		    
	           	jsonArray.put(obj);
	         	}
	        stmt.close();
			}
		catch (JSONException e) {msg("DefaultListItem.toString JSONException: "+e.getMessage());  	}
	     catch (SQLException ex) {msg("Mv_gestion_obras_indicadoresMD qryGenerica_indicadores: " + ex.getMessage());}
		
		if(jsonArray.length() > 0)
			result = "{\"success\":\"true\",\"registros\": " +jsonArray.toString() + "}";
		else
			result = "{\"success\":\"false\",\"registros\": []}";
		
		return result; 
	}
	
	public String  qryMv_impacto_social(String param){
		String result = null;
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
		
		String sqlTxt = "SELECT id_nom_obra_ejecucion,id_conceptos_alineacion_obra, id_tipo_alineacion_obra," +
				 " descripcion_localidades_beneficiadas, descripcion_beneficios_obra" +
				 " FROM mv_conceptos_alineacion_obra" +
				 " WHERE id_tipo_alineacion_obra = 1  " + param; //AND id_nom_obra_ejecucion = 3010";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlTxt);
	        while (rs.next()) {
	           	obj = new JSONObject();
	        	 obj.put("id_nom_obra_ejecucion", rs.getInt("id_nom_obra_ejecucion"));
		         obj.put("id_conceptos_alineacion_obra", rs.getInt("id_conceptos_alineacion_obra"));
		         obj.put("id_tipo_alineacion_obra", rs.getInt("id_tipo_alineacion_obra"));
		         obj.put("descripcion_localidades_beneficiadas", rs.getString("descripcion_localidades_beneficiadas"));
		         obj.put("descripcion_beneficios_obra", rs.getString("descripcion_beneficios_obra"));
		 
	           	jsonArray.put(obj);
	         	}
	        stmt.close();
			}
		 catch (JSONException e) {msg("DefaultListItem.toString JSONException: "+e.getMessage());  	}
	     catch (SQLException ex) {msg("Mv_gestion_obras_indicadoresMD qryMv_conceptos_impacto_social: " + ex.getMessage());}
		
		if(jsonArray.length() > 0)
			result = "{\"success\":\"true\",\"registros\": " +jsonArray.toString() + "}";
		else
			result = "{\"success\":\"false\",\"registros\": []}";
		
		return result;
	}
	
	private ArrayList <Mv_indicadores_obraDP>  qryMv_conceptos_alineacion_obra(int id_nom_obra_ejecucion){//, int id_tipo_alineacion_obra
		ArrayList <Mv_indicadores_obraDP>relCuentas = new ArrayList<Mv_indicadores_obraDP>();
		
		String sqlTxt = "SELECT id_conceptos_alineacion_obra, id_tipo_alineacion_obra, id_nom_catalogo_alineacion," +
				" descripcion_localidades_beneficiadas, descripcion_beneficios_obra " +
				" FROM mv_conceptos_alineacion_obra " +
				" WHERE id_nom_obra_ejecucion = " + id_nom_obra_ejecucion ;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlTxt);
	        while (rs.next()) {
	        	Mv_indicadores_obraDP bd = new Mv_indicadores_obraDP();
	        	bd.setId_conceptos_alineacion_obra(rs.getInt("id_conceptos_alineacion_obra"));
	        	bd.setId_tipo_alineacion_obra(rs.getInt("id_tipo_alineacion_obra"));
	        	bd.setId_nom_catalogo_alineacion(rs.getInt("id_nom_catalogo_alineacion"));
	        	bd.setDescripcion_localidades_beneficiadas(rs.getString("descripcion_localidades_beneficiadas"));
	        	bd.setDescripcion_beneficios_obra(rs.getString("descripcion_beneficios_obra"));
	           	relCuentas.add(bd);
	         	}
	        stmt.close();
			}
	     catch (SQLException ex) {msg("Mv_gestion_obras_indicadoresMD qryMv_conceptos_alineacion_obra: " + ex.getMessage());}
		return relCuentas;
		
	}
	
	protected void msg(String text){System.out.println(text);}
	
	public void setCon(Connection con) {
		this.con = con;
	}

}
