package modulo.serverDP;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Mv_croquis_obraDP {
	private int id_croquis_obra = 0;
	private int id_nom_obra_ejecucion = 0;
	private int id_tipo_imagen = 0;
	private String grafico  = null;
	private String nom_file_grafico = null;
	private String observacion  = null;
	private Date fecha_edicion = null;
	
	private String nom_file_date  = null;
	
	public Mv_croquis_obraDP() {
		// TODO Auto-generated constructor stub
	}
	
	public JSONObject getJSONObject_list() {
		JSONObject obj = new JSONObject();
		try {
            obj.put("id_nom_obra_ejecucion", id_nom_obra_ejecucion);
            obj.put("id_tipo_imagen", id_tipo_imagen);
            obj.put("nom_file_grafico", nom_file_grafico);
            obj.put("grafico", grafico);
     
            
        } catch (JSONException e) {
            msg("DefaultListItem.toString JSONException: "+e.getMessage());
        }
		return obj;
	}
	
	private void msg(String text){System.out.println(text); 	}

	public int getId_croquis_obra() {
		return id_croquis_obra;
	}

	public void setId_croquis_obra(int id_croquis_obra) {
		this.id_croquis_obra = id_croquis_obra;
	}

	public int getId_nom_obra_ejecucion() {
		return id_nom_obra_ejecucion;
	}

	public void setId_nom_obra_ejecucion(int id_nom_obra_ejecucion) {
		this.id_nom_obra_ejecucion = id_nom_obra_ejecucion;
	}

	public int getId_tipo_imagen() {
		return id_tipo_imagen;
	}

	public void setId_tipo_imagen(int id_tipo_imagen) {
		this.id_tipo_imagen = id_tipo_imagen;
	}

	public String getGrafico() {
		return grafico;
	}

	public void setGrafico(String grafico) {
		this.grafico = grafico;
	}

	public String getNom_file_grafico() {
		return nom_file_grafico;
	}

	public void setNom_file_grafico(String nom_file_grafico) {
		this.nom_file_grafico = nom_file_grafico;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFecha_edicion() {
		return fecha_edicion;
	}

	public void setFecha_edicion(Date fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}

	public String getNom_file_date() {
		return nom_file_date;
	}

	public void setNom_file_date(String nom_file_date) {
		this.nom_file_date = nom_file_date;
	}

}
