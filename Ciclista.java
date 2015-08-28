
public class Ciclista {
	
	public  float tiempo =0;
	public  String nombre="";
	public  int dorsal=0;
	
	public Ciclista(int d,float t, String nb){
		tiempo=t;
		nombre=nb;
		dorsal=d;
	}
	
	public int getDorsal(){
		return dorsal;
	}
	public float getTiempo(){
		return tiempo;
	}
	public void setNombre(String nb){
		nombre=nb;
	}
	
	public void setTiempo(float t){
		tiempo=t;
	}
	public String getNombre(){
		return nombre;
	}

}
