package modulo.serverDP;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import modulo_control.Functions_dates;

public class Mv_obra_ejecucionDP {
	private Functions_dates fud = new Functions_dates();
	private int id_nom_obra_ejecucion = 0;
	private String nom_obra_ejecucion = null;
	private int id_area_gen = 0;
	private String nom_area_gen = null;
	private int id_nom_municipio = 0;
	private String nom_municipio = null;
	private int id_coordinacion = 0;
	private String nom_coordinacion = null;
	private String nom_localidad = null;
	private String metas = null; 
	private String  metas_alcanzadas = null;
	private double inversion_autorizada = 0.0;
	private double inversion_contratada = 0.0;
	//private double inversion_total = 0.0;
	private int id_nom_pro_inversion = 0;
	private String nom_pro_inversion = null;
	private double avance_fisico = 0.0;
	private double avance_estimado = 0.0;
	private double avance_admon = 0.0;
	private double latitud  = 0.0;
	private double longitud  = 0.0;	
	private int id_pro_anual = 0;
	private int pro_anual = 0;
	private int num_beneficiarios = 0;
	
	
	private String proceso_obra = null;
	private String nom_ejecutor = null;
	private Date fecha_edicion = null;
	
	private int id_organizacion = 0;
	private String nom_organizacion = null;
	private int id_distrito = 0;
	private String nom_distrito = null;
	private Date fecha_inicio_real = null;
	private Date fecha_termino_real = null;
	private Date fecha_entrega_recepcion = null;
	private Date fecha_inicio_contrato = null;
	private Date fecha_termino_contrato = null;
	private Date fecha_inicio_ampliacion = null;
	private Date fecha_termino_ampliacion = null;
	
	private String oficios_autorizacion = null;
	private String fechas_of_autorizacion = null;
	private String fechas_recibido_oficio = null;
	private String clave_admon = null;
	
	private String fecha_edicion_print = null;
	  

	public Mv_obra_ejecucionDP() {
		// TODO Auto-generated constructor stub
	}
	
	public JSONObject getJSONObject_list() {
		JSONObject obj = new JSONObject();
		try {
            obj.put("id_nom_obra_ejecucion", id_nom_obra_ejecucion);
            obj.put("nom_obra_ejecucion", nom_obra_ejecucion);
            obj.put("nom_municipio", nom_municipio);
           // obj.put("inversion_total", inversion_total);
         //   obj.put("inversion_autorizada", inversion_autorizada);
            obj.put("inversion_contratada", inversion_contratada);
            //obj.put("latitud", latitud);
            //obj.put("longitud", longitud);
            
            
        } catch (JSONException e) {
            msg("DefaultListItem.toString JSONException: "+e.getMessage());
        }
		return obj;
	}
	
	public JSONObject getJSONObject_reg() {
		JSONObject obj = new JSONObject();
		try {
            obj.put("id_nom_obra_ejecucion", id_nom_obra_ejecucion);
            obj.put("nom_obra_ejecucion", nom_obra_ejecucion);
            obj.put("id_coordinacion", id_coordinacion);
            obj.put("nom_coordinacion", nom_coordinacion);
            obj.put("id_nom_municipio", id_nom_municipio);
            obj.put("nom_municipio", nom_municipio);
            obj.put("nom_localidad", nom_localidad);
            obj.put("metas", metas);
            obj.put("metas_alcanzadas", metas_alcanzadas);
           // obj.put("inversion_total", inversion_total);
            obj.put("inversion_autorizada", inversion_autorizada);
            obj.put("inversion_contratada", inversion_contratada);
            obj.put("latitud", latitud);
            obj.put("longitud", longitud);
            
            obj.put("avance_fisico", avance_fisico);
           // obj.put("avance_estimado", avance_estimado);
            obj.put("avance_admon", avance_admon);
           // obj.put("proceso_obra", proceso_obra);
           // obj.put("nom_ejecutor", nom_ejecutor);
           // obj.put("fecha_edicion", fecha_edicion);
            obj.put("id_area_gen", id_area_gen);
            obj.put("nom_area_gen", nom_area_gen);
            obj.put("id_nom_pro_inversion", id_nom_pro_inversion);
            obj.put("nom_pro_inversion", nom_pro_inversion);
            obj.put("id_pro_anual", id_pro_anual);
            obj.put("pro_anual", pro_anual);
            obj.put("num_beneficiarios", num_beneficiarios);
            
            obj.put("id_organizacion", id_organizacion);
            obj.put("nom_organizacion", nom_organizacion);
            obj.put("id_distrito", id_distrito);
            obj.put("nom_distrito", nom_distrito);
            
            obj.put("fecha_inicio_real", fecha_inicio_real);
            obj.put("fecha_termino_real", fecha_termino_real);
            obj.put("fecha_entrega_recepcion", fecha_entrega_recepcion);
            obj.put("fecha_inicio_contrato", fecha_inicio_contrato);
            obj.put("fecha_termino_contrato", fecha_termino_contrato);
            obj.put("fecha_inicio_ampliacion", fecha_inicio_ampliacion);
            obj.put("fecha_termino_ampliacion", fecha_termino_ampliacion);
            obj.put("clave_admon", clave_admon);
            obj.put("oficios_autorizacion", oficios_autorizacion);
           // obj.put("fechas_of_autorizacion", fechas_of_autorizacion);
           // obj.put("fechas_recibido_oficio", fechas_recibido_oficio);
           // obj.put("fecha_edicion_print", fecha_edicion_print);
            
        } catch (JSONException e) {
            msg("DefaultListItem.toString JSONException: "+e.getMessage());
        }
		return obj;
	}
	
	private void msg(String text){System.out.println(text); 	}

	public int getId_nom_obra_ejecucion() {
		return id_nom_obra_ejecucion;
	}

	public void setId_nom_obra_ejecucion(int id_nom_obra_ejecucion) {
		this.id_nom_obra_ejecucion = id_nom_obra_ejecucion;
	}

	public String getNom_municipio() {
		return nom_municipio;
	}

	public void setNom_municipio(String nom_municipio) {
		this.nom_municipio = nom_municipio;
	}

	public String getNom_obra_ejecucion() {
		return nom_obra_ejecucion;
	}

	public void setNom_obra_ejecucion(String nom_obra_ejecucion) {
		this.nom_obra_ejecucion = nom_obra_ejecucion;
	}

	

	public double getInversion_contratada() {
		return inversion_contratada;
	}

	public void setInversion_contratada(double inversion_contratada) {
		this.inversion_contratada = inversion_contratada;
	}



	public double getAvance_fisico() {
		return avance_fisico;
	}

	public void setAvance_fisico(double avance_fisico) {
		this.avance_fisico = avance_fisico;
	}

	public double getAvance_estimado() {
		return avance_estimado;
	}

	public void setAvance_estimado(double avance_estimado) {
		this.avance_estimado = avance_estimado;
	}

	public double getAvance_admon() {
		return avance_admon;
	}

	public void setAvance_admon(double avance_admon) {
		this.avance_admon = avance_admon;
	}

	public String getProceso_obra() {
		return proceso_obra;
	}

	public void setProceso_obra(String proceso_obra) {
		this.proceso_obra = proceso_obra;
	}

	public String getNom_ejecutor() {
		return nom_ejecutor;
	}

	public void setNom_ejecutor(String nom_ejecutor) {
		this.nom_ejecutor = nom_ejecutor;
	}

	public Date getFecha_edicion() {
		return fecha_edicion;
	}

	public void setFecha_edicion(Date fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
		fecha_edicion_print = fud.decodePrintDateLower(fecha_edicion);
	}

	public int getPro_anual() {
		return pro_anual;
	}

	public void setPro_anual(int pro_anual) {
		this.pro_anual = pro_anual;
	}

	public String getNom_pro_inversion() {
		return nom_pro_inversion;
	}

	public void setNom_pro_inversion(String nom_pro_inversion) {
		this.nom_pro_inversion = nom_pro_inversion;
	}

	public String getNom_area_gen() {
		return nom_area_gen;
	}

	public void setNom_area_gen(String nom_area_gen) {
		this.nom_area_gen = nom_area_gen;
	}

	public String getClave_admon() {
		return clave_admon;
	}

	public void setClave_admon(String clave_admon) {
		this.clave_admon = clave_admon;
	}

	

	public String getFecha_edicion_print() {
		return fecha_edicion_print;
	}

	public void setFecha_edicion_print(String fecha_edicion_print) {
		this.fecha_edicion_print = fecha_edicion_print;
	}

	

	public int getId_area_gen() {
		return id_area_gen;
	}

	public void setId_area_gen(int id_area_gen) {
		this.id_area_gen = id_area_gen;
	}

	public int getId_nom_municipio() {
		return id_nom_municipio;
	}

	public void setId_nom_municipio(int id_nom_municipio) {
		this.id_nom_municipio = id_nom_municipio;
	}

	public int getId_coordinacion() {
		return id_coordinacion;
	}

	public void setId_coordinacion(int id_coordinacion) {
		this.id_coordinacion = id_coordinacion;
	}

	public String getNom_coordinacion() {
		return nom_coordinacion;
	}

	public void setNom_coordinacion(String nom_coordinacion) {
		this.nom_coordinacion = nom_coordinacion;
	}

	public String getNom_localidad() {
		return nom_localidad;
	}

	public void setNom_localidad(String nom_localidad) {
		this.nom_localidad = nom_localidad;
	}

	public String getMetas() {
		return metas;
	}

	public void setMetas(String metas) {
		this.metas = metas;
	}

	public String getMetas_alcanzadas() {
		return metas_alcanzadas;
	}

	public void setMetas_alcanzadas(String metas_alcanzadas) {
		this.metas_alcanzadas = metas_alcanzadas;
	}

	public int getId_nom_pro_inversion() {
		return id_nom_pro_inversion;
	}

	public void setId_nom_pro_inversion(int id_nom_pro_inversion) {
		this.id_nom_pro_inversion = id_nom_pro_inversion;
	}

	public int getId_pro_anual() {
		return id_pro_anual;
	}

	public void setId_pro_anual(int id_pro_anual) {
		this.id_pro_anual = id_pro_anual;
	}

	public int getNum_beneficiarios() {
		return num_beneficiarios;
	}

	public void setNum_beneficiarios(int num_beneficiarios) {
		this.num_beneficiarios = num_beneficiarios;
	}

	public Date getFecha_inicio_real() {
		return fecha_inicio_real;
	}

	public void setFecha_inicio_real(Date fecha_inicio_real) {
		this.fecha_inicio_real = fecha_inicio_real;
	}

	public Date getFecha_termino_real() {
		return fecha_termino_real;
	}

	public void setFecha_termino_real(Date fecha_termino_real) {
		this.fecha_termino_real = fecha_termino_real;
	}

	public Date getFecha_entrega_recepcion() {
		return fecha_entrega_recepcion;
	}

	public void setFecha_entrega_recepcion(Date fecha_entrega_recepcion) {
		this.fecha_entrega_recepcion = fecha_entrega_recepcion;
	}

	public Date getFecha_inicio_contrato() {
		return fecha_inicio_contrato;
	}

	public void setFecha_inicio_contrato(Date fecha_inicio_contrato) {
		this.fecha_inicio_contrato = fecha_inicio_contrato;
	}

	public Date getFecha_termino_contrato() {
		return fecha_termino_contrato;
	}

	public void setFecha_termino_contrato(Date fecha_termino_contrato) {
		this.fecha_termino_contrato = fecha_termino_contrato;
	}

	public Date getFecha_inicio_ampliacion() {
		return fecha_inicio_ampliacion;
	}

	public void setFecha_inicio_ampliacion(Date fecha_inicio_ampliacion) {
		this.fecha_inicio_ampliacion = fecha_inicio_ampliacion;
	}

	public Date getFecha_termino_ampliacion() {
		return fecha_termino_ampliacion;
	}

	public void setFecha_termino_ampliacion(Date fecha_termino_ampliacion) {
		this.fecha_termino_ampliacion = fecha_termino_ampliacion;
	}

	public String getNom_distrito() {
		return nom_distrito;
	}

	public void setNom_distrito(String nom_distrito) {
		this.nom_distrito = nom_distrito;
	}

	public String getNom_organizacion() {
		return nom_organizacion;
	}

	public void setNom_organizacion(String nom_organizacion) {
		this.nom_organizacion = nom_organizacion;
	}

	public int getId_organizacion() {
		return id_organizacion;
	}

	public void setId_organizacion(int id_organizacion) {
		this.id_organizacion = id_organizacion;
	}

	public int getId_distrito() {
		return id_distrito;
	}

	public void setId_distrito(int id_distrito) {
		this.id_distrito = id_distrito;
	}

	public double getInversion_autorizada() {
		return inversion_autorizada;
	}

	public void setInversion_autorizada(double inversion_autorizada) {
		this.inversion_autorizada = inversion_autorizada;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getFechas_of_autorizacion() {
		return fechas_of_autorizacion;
	}

	public void setFechas_of_autorizacion(String fechas_of_autorizacion) {
		this.fechas_of_autorizacion = fechas_of_autorizacion;
	}

	public String getOficios_autorizacion() {
		return oficios_autorizacion;
	}

	public void setOficios_autorizacion(String oficios_autorizacion) {
		this.oficios_autorizacion = oficios_autorizacion;
	}

	public String getFechas_recibido_oficio() {
		return fechas_recibido_oficio;
	}

	public void setFechas_recibido_oficio(String fechas_recibido_oficio) {
		this.fechas_recibido_oficio = fechas_recibido_oficio;
	}
	
	

}
