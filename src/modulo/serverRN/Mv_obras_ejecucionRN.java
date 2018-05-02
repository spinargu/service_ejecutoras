package modulo.serverRN;

import java.sql.Connection;
import java.sql.SQLException;

import modulo.serverMD.Mv_catalogo_obrasMD;
import modulo.serverMD.Mv_gestion_croquis_obraMD;
import modulo.serverMD.Mv_gestion_obras_indicadoresMD;
import modulo.serverMD.Mv_nom_trabajos_ejecutadosMD;
import modulo.serverMD.Mv_obra_ejecucionMD;
import modulo_control.Functions;
import modulo_pool_jdbc.ObjectRegistry;
import modulo_pool_jdbc.Pool;

public class Mv_obras_ejecucionRN {
	private Functions fun = new Functions();
	private Connection con  = null;
	
	private String param1 = null;
	private String param2 = null;
	private String param3 = null; 
	private String param4 = null;
	private String param5 = null;
	private String param6 = null;

	/*http://stackoverflow.com/questions/4841952/convert-arraylistmycustomclass-to-jsonarray*/
		
	public Mv_obras_ejecucionRN() {
		// TODO Auto-generated constructor stub
	}
	
	public void connectBD(){
		Pool  pool = (Pool) ObjectRegistry.getInstance().getDataAccessObject();;
		try {
			con = pool.dataSource.getConnection();
		} catch (SQLException e) {
		e.printStackTrace();
		}
  	}
	
	public void disconnectBD(){
		try {
			if(con != null && !con.isClosed()) {
				con.close();
				}
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	
	//http://localhost:8080/service_ejecutoras/server/DownloadArObras.jsp?param1=1&param2=1&param3=48&param4=6&param5=19
		
	//http://portalinf.net/service_ejecutoras/server/DownloadArObras.jsp?param1=1&param2=1&param3=48&param4=6&param5=19
	//param1 = id_area_gen param2 = id_coordinacion  param3 = id_nom_municipio param4 = id_nom_pro_inversion param5 = id_pro_anual item=6 id_distrito
	public String downloadArObrasAsync(){
		String result = null;
		boolean success = false;
		
		String parameter = prepareParams();
		
		if(parameter == null)
			return "{\"success\":"+success+",\"registros\": []}";
		
		connectBD();
		Mv_obra_ejecucionMD moe = new Mv_obra_ejecucionMD();
		moe.setCon(con);
		result = moe.qryCata_obra_ejecucion(parameter); 
		disconnectBD();

		return result;
	}
	
	//http://localhost:8080/service_ejecutoras/server/DownloadCataObras.jsp?item=5
	
	//http://portalinf.net/service_ejecutoras/server/DownloadCataObras.jsp?item=1
	//item=1 id_area_gen  item=2 id_coordinacion item=3 id_nom_municipio item=4 id_nom_pro_inversion item=5 id_pro_anual item=6 id_distrito
	public String downloadCataObras(String item_){//  /server/DownloadCataObras.jsp
		String result = null;
		boolean success = false;
		int item = fun.gInt(item_);
		
		if(item_ == null)
			return "{\"success\":"+success+",\"registros\":[]}";
		
		connectBD();
		Mv_catalogo_obrasMD mco = new Mv_catalogo_obrasMD();
		mco.setCon(con);
		
		if(item == 1)
			result = mco.qryCataAreaGen();
		else if(item == 2)
			result = mco.qryCataNomCoordinaciones();
		else if(item == 3)
			result = mco.qryCataNomMunicipios();
		else if(item == 4)
			result = mco.qryCataProInversion();
		else if(item == 5)
			result = mco.qryCataProAnualObra();
		else if(item == 6)
			result = mco.qryCataNomDistrito();
		
		disconnectBD();
			
		return result;
	}
	
	
	
	//http://localhost:8080/service_ejecutoras/server/DownloadRegObras.jsp?id=3
	
	//http://portalinf.net/service_ejecutoras/server/DownloadRegObras.jsp?id=4
	public String downloadRegObrasAsync(String id){//  /server/DownloadRegObras.jsp
		String result = null;
		boolean success = false;
		
		if(id == null)
			return "{\"success\":"+success+",\"registros\": []}";
		
		connectBD();
		Mv_obra_ejecucionMD moe = new Mv_obra_ejecucionMD();
		moe.setCon(con);
		result = moe.qryReg_obra_ejecucion(" WHERE obra.id_nom_obra_ejecucion ="+id);
		disconnectBD();
		
		return result;
	}
	
	//http://portalinf.net/service_ejecutoras/server/DownloadArrTrabajos.jsp?id=4&tipo=1  tipo es 1 o 2
	public String downloadArrTrabajosAsync(String id, String tipo){//  /server/DownloadRegObras.jsp
		String result = null;
		boolean success = false;
		
		if(id == null || tipo == null)
			return "{\"success\":"+success+",\"registros\": []}";
		
		connectBD();
		Mv_nom_trabajos_ejecutadosMD moe = new Mv_nom_trabajos_ejecutadosMD();
		moe.setCon(con);
		result = moe.qryCata_trabajos_programados(" WHERE id_nom_obra_ejecucion = "+id + " AND id_tipo_trabajos = " +tipo );
		disconnectBD();
			
		return result;
	}
	
	//http://portalinf.net/service_ejecutoras/server/DownloadArrIndicadores.jsp?id=3010&tipo=1  tipo es 1, 2
	public String downloadArrIndicadoresAsync(String id, String tipo_){//  /server/DownloadRegObras.jsp
		String result = null;
		boolean success = false;
		int tipo = fun.gInt(tipo_);
		
		if(id == null || tipo_ == null)
			return "{\"success\":"+success+",\"registros\": []}";
		
		connectBD();
		Mv_gestion_obras_indicadoresMD goi = new Mv_gestion_obras_indicadoresMD();
		goi.setCon(con);
		
		if(tipo == 1)
			result = goi.qryMv_impacto_social(" AND id_nom_obra_ejecucion = " + id);
		else if(tipo == 2)
			result = goi.qryMv_indicadores_estrategicos(" AND id_nom_obra_ejecucion = " + id);
		else if(tipo == 3)
			result = goi.qryMv_desarrollo_sostenible(" AND id_nom_obra_ejecucion = " + id);
		else if(tipo == 4)
			result = goi.qryMv_ejes_plan_estatal(" AND id_nom_obra_ejecucion = " + id);
		else if(tipo == 5)
			result = goi.qryMv_ejes_transversales(" AND id_nom_obra_ejecucion = " + id);
		else if(tipo == 6)
			result = goi.qryMv_programas_presupuestarios(" AND id_nom_obra_ejecucion = " + id);
		else if(tipo == 7)
			result = goi.qryMv_indicadores_tacticos(" AND id_nom_obra_ejecucion = " + id);
		else if(tipo == 8)
			result = goi.qryMv_indicadores_transversales(" AND id_nom_obra_ejecucion = " + id);
		
		disconnectBD();
		
		return result;
	}
	
	//http://portalinf.net/service_ejecutoras/server/DownloadArrImagenesCroquis.jsp?id=3010
		public String downloadArrImagenesCroquisAsync(String id){//  /server/DownloadRegObras.jsp
			String result = null;
			boolean success = false;
			
			if(id == null)
				return "{\"success\":"+success+",\"registros\": []}";
			
			connectBD();
			Mv_gestion_croquis_obraMD moe = new Mv_gestion_croquis_obraMD();
			moe.setCon(con);
			result = moe.qryList_croquis_obra(" WHERE id_nom_obra_ejecucion ="+id);
			disconnectBD();
		
			return result;
		}

	
	private String prepareParams(){
		String parameter = null;
		//param1 = id_area_gen param2 = id_coordinacion  param3 = id_nom_municipio param4 = id_nom_pro_inversion param5 = id_pro_anual
		if( fun.gInt(param1) > 0)
			parameter = " WHERE obra.id_area_gen =" + param1;
		
		if(fun.gInt(param3) > 0){
			if(parameter == null)
				parameter = " WHERE obra.id_nom_municipio =" + param3;
			else
				parameter += " AND obra.id_nom_municipio =" + param3;
			}
		else if(fun.gInt(param2) > 0){//son excluyentes
			if(parameter == null)
				parameter = " WHERE muni.id_coordinacion =" + param2;
			else
				parameter += " AND muni.id_coordinacion =" + param2;
			}
		else if(fun.gInt(param6) > 0){//son excluyentes
			if(parameter == null)
				parameter = " WHERE muni.id_distrito =" + param6;
			else
				parameter += " AND muni.id_distrito =" + param6;
			}
		
		if(fun.gInt(param4) > 0){
			if(parameter == null)
				parameter = " WHERE obra.id_nom_pro_inversion =" + param4;
			else
				parameter += " AND obra.id_nom_pro_inversion =" + param4;
			}
		
		if(fun.gInt(param5) > 0){
			if(parameter == null)
				parameter = " WHERE obra.id_pro_anual = " + param5 ;
			else
				parameter += " AND obra.id_pro_anual = " + param5 ;
			}
		
		return parameter;
	}
	
	protected void msg(String text){System.out.println(text); 	}
	
	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public String getParam6() {
		return param6;
	}

	public void setParam6(String param6) {
		this.param6 = param6;
	}

}
