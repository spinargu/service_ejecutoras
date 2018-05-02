package modulo.serverDP;

import org.json.JSONException;
import org.json.JSONObject;

public class Mv_indicadores_obraDP {
	//mv_conceptos_alineacion_obra
		private int id_conceptos_alineacion_obra = 0;
		private int id_nom_obra_ejecucion = 0;
		private int id_tipo_alineacion_obra = 0;
		private int id_nom_catalogo_alineacion = 0; 
		private String descripcion_localidades_beneficiadas = null;
		private String descripcion_beneficios_obra = null;
		private String nom_catalogo_alineacion = null;
		//cg_rel_tipo_alineacion_obra
		//id_tipo_alineacion_obra
		private String nombre_id_campo = null;
		private int tipo_seleccion_multiple = 0;
		private int tipo_campo_integer = 0;
		
		private int id_edit_indicador = 0;
		
		public Mv_indicadores_obraDP() {
			// TODO Auto-generated constructor stub
		}
		
		public JSONObject getJSONObject_list() {
			JSONObject obj = new JSONObject();
			try {
				 obj.put("id_nom_obra_ejecucion", id_nom_obra_ejecucion);
		         obj.put("id_conceptos_alineacion_obra", id_conceptos_alineacion_obra);
		         obj.put("id_tipo_alineacion_obra", id_tipo_alineacion_obra);
		         obj.put("nom_catalogo_alineacion", nom_catalogo_alineacion);
	            
	        } catch (JSONException e) {
	            msg("DefaultListItem.toString JSONException: "+e.getMessage());
	        }
			return obj;
		}
		
		public JSONObject getJSONObject_reg() {
			JSONObject obj = new JSONObject();
			try {
	            obj.put("id_nom_obra_ejecucion", id_nom_obra_ejecucion);
	            obj.put("id_conceptos_alineacion_obra", id_conceptos_alineacion_obra);
	            obj.put("id_tipo_alineacion_obra", id_tipo_alineacion_obra);
	            obj.put("descripcion_localidades_beneficiadas", descripcion_localidades_beneficiadas);
	            obj.put("descripcion_beneficios_obra", descripcion_beneficios_obra);
	                 
	        } catch (JSONException e) {
	            msg("DefaultListItem.toString JSONException: "+e.getMessage());
	        }
			return obj;
		}
		
		private void msg(String text){System.out.println(text);}
		

		public int getId_conceptos_alineacion_obra() {
			return id_conceptos_alineacion_obra;
		}

		public void setId_conceptos_alineacion_obra(int id_conceptos_alineacion_obra) {
			this.id_conceptos_alineacion_obra = id_conceptos_alineacion_obra;
		}

		public int getId_nom_obra_ejecucion() {
			return id_nom_obra_ejecucion;
		}

		public void setId_nom_obra_ejecucion(int id_nom_obra_ejecucion) {
			this.id_nom_obra_ejecucion = id_nom_obra_ejecucion;
		}

		public int getId_tipo_alineacion_obra() {
			return id_tipo_alineacion_obra;
		}

		public void setId_tipo_alineacion_obra(int id_tipo_alineacion_obra) {
			this.id_tipo_alineacion_obra = id_tipo_alineacion_obra;
		}

		public String getDescripcion_localidades_beneficiadas() {
			return descripcion_localidades_beneficiadas;
		}

		public void setDescripcion_localidades_beneficiadas(
				String descripcion_localidades_beneficiadas) {
			this.descripcion_localidades_beneficiadas = descripcion_localidades_beneficiadas;
		}

		public String getDescripcion_beneficios_obra() {
			return descripcion_beneficios_obra;
		}

		public void setDescripcion_beneficios_obra(
				String descripcion_beneficios_obra) {
			this.descripcion_beneficios_obra = descripcion_beneficios_obra;
		}

		public String getNombre_id_campo() {
			return nombre_id_campo;
		}

		public void setNombre_id_campo(String nombre_id_campo) {
			this.nombre_id_campo = nombre_id_campo;
		}

		public int getTipo_seleccion_multiple() {
			return tipo_seleccion_multiple;
		}

		public void setTipo_seleccion_multiple(int tipo_seleccion_multiple) {
			this.tipo_seleccion_multiple = tipo_seleccion_multiple;
		}

		public int getTipo_campo_integer() {
			return tipo_campo_integer;
		}

		public void setTipo_campo_integer(int tipo_campo_integer) {
			this.tipo_campo_integer = tipo_campo_integer;
		}

		public int getId_nom_catalogo_alineacion() {
			return id_nom_catalogo_alineacion;
		}

		public void setId_nom_catalogo_alineacion(int id_nom_catalogo_alineacion) {
			this.id_nom_catalogo_alineacion = id_nom_catalogo_alineacion;
		}

		public int getId_edit_indicador() {
			return id_edit_indicador;
		}

		public void setId_edit_indicador(int id_edit_indicador) {
			this.id_edit_indicador = id_edit_indicador;
		}

		public String getNom_catalogo_alineacion() {
			return nom_catalogo_alineacion;
		}

		public void setNom_catalogo_alineacion(String nom_catalogo_alineacion) {
			this.nom_catalogo_alineacion = nom_catalogo_alineacion;
		}

}
