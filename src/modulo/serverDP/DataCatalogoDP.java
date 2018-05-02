package modulo.serverDP;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class DataCatalogoDP {
	private static Map<Character, Character> MAP_NORM;
	private int id_catalogo;
	private String nom_catalogo;
	private String clave_area_gen;

	public DataCatalogoDP() {
		// TODO Auto-generated constructor stub
	}
	
	public DataCatalogoDP(int id_catalogo, String nom_catalogo) {
		this.id_catalogo = id_catalogo;
	    this.nom_catalogo = nom_catalogo;
	  }
	
	public DataCatalogoDP(int id_catalogo, String nom_catalogo,  String clave_area_gen) {
		this.id_catalogo = id_catalogo;
	    this.nom_catalogo = nom_catalogo;
	    this.clave_area_gen = clave_area_gen;
	  }
	
	public JSONObject getJSONObject() {
		JSONObject obj = new JSONObject();
		try {
            obj.put("id_catalogo", id_catalogo);
            obj.put("nom_catalogo", nom_catalogo);
                   
        } catch (JSONException e) {
            msg("DefaultListItem.toString JSONException: "+e.getMessage());
        }
		return obj;
	}
	
	public JSONObject getJSONObject_3param() {
		JSONObject obj = new JSONObject();
		try {
            obj.put("id_catalogo", id_catalogo);
            obj.put("nom_catalogo", nom_catalogo);
            obj.put("clave_area_gen", clave_area_gen);
                   
        } catch (JSONException e) {
            msg("DefaultListItem.toString JSONException: "+e.getMessage());
        }
		return obj;
	}
	
	private void msg(String text){System.out.println(text); 	}

	public String toString() {
	    return "id_catalogo = " + id_catalogo + ", nom_catalogo = " + nom_catalogo;
	}
	
	private String removeAccentsXXX(String value){
		 if (MAP_NORM == null || MAP_NORM.size() == 0)   {
		        MAP_NORM = new HashMap<Character, Character>();
		        MAP_NORM.put('�', 'A');
		        MAP_NORM.put('�', 'A');
		        MAP_NORM.put('�', 'A');
		        MAP_NORM.put('�', 'A');
		        MAP_NORM.put('�', 'A');
		        MAP_NORM.put('�', 'E');
		        MAP_NORM.put('�', 'E');
		        MAP_NORM.put('�', 'E');
		        MAP_NORM.put('�', 'E');
		        MAP_NORM.put('�', 'I');
		        MAP_NORM.put('�', 'I');
		        MAP_NORM.put('�', 'I');
		        MAP_NORM.put('�', 'I');
		        MAP_NORM.put('�', 'U');
		        MAP_NORM.put('�', 'U');
		        MAP_NORM.put('�', 'U');
		        MAP_NORM.put('�', 'U');
		        MAP_NORM.put('�', 'O');
		        MAP_NORM.put('�', 'O');
		        MAP_NORM.put('�', 'O');
		        MAP_NORM.put('�', 'O');
		        MAP_NORM.put('�', 'O');
		        MAP_NORM.put('�', 'N');
		        MAP_NORM.put('�', 'C');
		        MAP_NORM.put('�', 'A');
		        MAP_NORM.put('�', 'O');
		        MAP_NORM.put('�', 'S');
		        MAP_NORM.put('�', '3');
		        MAP_NORM.put('�', '2');
		        MAP_NORM.put('�', '1');
		        MAP_NORM.put('�', 'a');
		        MAP_NORM.put('�', 'a');
		        MAP_NORM.put('�', 'a');
		        MAP_NORM.put('�', 'a');
		        MAP_NORM.put('�', 'a');
		        MAP_NORM.put('�', 'e');
		        MAP_NORM.put('�', 'e');
		        MAP_NORM.put('�', 'e');
		        MAP_NORM.put('�', 'e');
		        MAP_NORM.put('�', 'i');
		        MAP_NORM.put('�', 'i');
		        MAP_NORM.put('�', 'i');
		        MAP_NORM.put('�', 'i');
		        MAP_NORM.put('�', 'u');
		        MAP_NORM.put('�', 'u');
		        MAP_NORM.put('�', 'u');
		        MAP_NORM.put('�', 'u');
		        MAP_NORM.put('�', 'o');
		        MAP_NORM.put('�', 'o');
		        MAP_NORM.put('�', 'o');
		        MAP_NORM.put('�', 'o');
		        MAP_NORM.put('�', 'o');
		        MAP_NORM.put('�', 'n');
		        MAP_NORM.put('�', 'c');
		    }

		    if (value == null) {
		        return "";
		    }
		    
		    StringBuilder sb = new StringBuilder(value);

		    for(int i = 0; i < value.length(); i++) {
		        Character c = MAP_NORM.get(sb.charAt(i));
		        if(c != null) {
		            sb.setCharAt(i, c.charValue());
		        }
		    }

		    return sb.toString();
	}

}
