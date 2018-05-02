package modulo.serverDP;

import org.json.JSONException;
import org.json.JSONObject;

public class Mv_nom_trabajos_ejecutadosDP {
	private int id_nom_trabajos_ejecutados = 0;
	private int id_nom_obra_ejecucion = 0;
	private String nom_trabajos_ejecutados = null;
	private double cantidad_trabajos = 0.00;
	private int id_unidad_trabajos = 0;
	private int id_tipo_trabajos = 0;
	private String nom_unidad_trabajos = null;
	private String n_corto_unid_trabajos = null;
	
	public Mv_nom_trabajos_ejecutadosDP() {
		// TODO Auto-generated constructor stub
	}
	
	public JSONObject getJSONObject_reg() {
		JSONObject obj = new JSONObject();
		try {
            obj.put("id_nom_obra_ejecucion", id_nom_obra_ejecucion);
            obj.put("nom_trabajos_ejecutados", nom_trabajos_ejecutados);
            obj.put("cantidad_trabajos", cantidad_trabajos);
            obj.put("nom_unidad_trabajos", nom_unidad_trabajos);
            obj.put("n_corto_unid_trabajos", n_corto_unid_trabajos);
            obj.put("id_tipo_trabajos", id_tipo_trabajos);
                 
        } catch (JSONException e) {
            msg("DefaultListItem.toString JSONException: "+e.getMessage());
        }
		return obj;
	}
	
	private void msg(String text){System.out.println(text);}

	public int getId_nom_trabajos_ejecutados() {
		return id_nom_trabajos_ejecutados;
	}

	public void setId_nom_trabajos_ejecutados(int id_nom_trabajos_ejecutados) {
		this.id_nom_trabajos_ejecutados = id_nom_trabajos_ejecutados;
	}

	public int getId_nom_obra_ejecucion() {
		return id_nom_obra_ejecucion;
	}

	public void setId_nom_obra_ejecucion(int id_nom_obra_ejecucion) {
		this.id_nom_obra_ejecucion = id_nom_obra_ejecucion;
	}

	public String getNom_trabajos_ejecutados() {
		return nom_trabajos_ejecutados;
	}

	public void setNom_trabajos_ejecutados(String nom_trabajos_ejecutados) {
		this.nom_trabajos_ejecutados = nom_trabajos_ejecutados;
	}

	public double getCantidad_trabajos() {
		return cantidad_trabajos;
	}

	public void setCantidad_trabajos(double cantidad_trabajos) {
		this.cantidad_trabajos = cantidad_trabajos;
	}

	public int getId_unidad_trabajos() {
		return id_unidad_trabajos;
	}

	public void setId_unidad_trabajos(int id_unidad_trabajos) {
		this.id_unidad_trabajos = id_unidad_trabajos;
	}

	public int getId_tipo_trabajos() {
		return id_tipo_trabajos;
	}

	public void setId_tipo_trabajos(int id_tipo_trabajos) {
		this.id_tipo_trabajos = id_tipo_trabajos;
	}

	public String getNom_unidad_trabajos() {
		return nom_unidad_trabajos;
	}

	public void setNom_unidad_trabajos(String nom_unidad_trabajos) {
		this.nom_unidad_trabajos = nom_unidad_trabajos;
	}

	public String getN_corto_unid_trabajos() {
		return n_corto_unid_trabajos;
	}

	public void setN_corto_unid_trabajos(String n_corto_unid_trabajos) {
		this.n_corto_unid_trabajos = n_corto_unid_trabajos;
	}
	
	
}
