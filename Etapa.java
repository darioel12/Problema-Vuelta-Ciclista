import java.util.*;
import java.io.*;
public class Etapa {

	public static Ciclista [] generalInicial (String fichero1){
		Ciclista [] corredores=new Ciclista[150];
		int dorsal=0;
		int contador=0;
		String nombre="";
		float tiempo=0;
		Ciclista cl=new Ciclista(dorsal,tiempo,nombre);
		for(int i=0;i<corredores.length;i++){
			corredores[i]=cl;
		}
		dorsal=1;
		try{
			Scanner entrada=new Scanner(new FileReader(fichero1));
			while(entrada.hasNext()){
				tiempo=entrada.nextFloat();
				nombre=entrada.nextLine();
				cl=new Ciclista(dorsal,tiempo,nombre);
				corredores[contador]=cl;
				dorsal++;
				contador++;
			}
			entrada.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		return corredores;
	}
	
	public static Ciclista [] clasEtapa(Ciclista[] corredores,String fichero2){
		int dorsal=0;
		float tiempo=0;
		int dorsalAux=0;
		float tiempoAux=0;
		int contador2=0;
		int puntero=0;
		Ciclista cl=null;
		try{
			Scanner entrada=new Scanner(new FileReader(fichero2));
			while(entrada.hasNext()){
				dorsal=entrada.nextInt();
				tiempo=entrada.nextFloat();
				while(contador2<corredores.length){
					dorsalAux=corredores[contador2].getDorsal();
					if(dorsal==dorsalAux){
						tiempoAux=corredores[contador2].getTiempo();
						tiempoAux+=tiempo;
						cl=new Ciclista(corredores[contador2].getDorsal(),tiempoAux,corredores[contador2].getNombre());
						corredores[contador2]=cl;
						puntero=contador2;
					}
					cl=new Ciclista(0,0,"");
					contador2++;
				}
				corredores[puntero].dorsal=0;
				tiempoAux=0;
				contador2=0;
			}
			entrada.close();
		}catch(java.io.IOException ioex){
			System.out.println(ioex);
		}
		return corredores;
	}

	public static Ciclista [] ordenarClas(Ciclista [] corredores){
		Ciclista [] aux=new Ciclista[corredores.length];
		float tiempo=1000000000;
		float tiempoAux=0;
		int contador=0;
		int puntero=0;
		Ciclista cl=null;
		for(int i=0;i<aux.length;i++){
			while (contador<corredores.length){
				tiempoAux=corredores[contador].getTiempo();
				if(tiempo>tiempoAux && tiempoAux!=0){
					tiempo=tiempoAux;
					cl=new Ciclista(corredores[contador].dorsal,tiempo,corredores[contador].nombre);
					aux[i]=cl;
					puntero=contador;
				}
				contador++;
			}
			corredores[puntero].tiempo=0;
			tiempo=10000000;
			contador=0;
		}
		return aux;
	}
	
	public static void clasGeneral(Ciclista [] corredores,String ficheroFinal){
		try{
			PrintWriter salida=new PrintWriter (new PrintWriter(ficheroFinal));
			for(int i=0;i<corredores.length;i++){
				salida.println(corredores[i].getTiempo()+" "+corredores[i].getNombre());
			}
			salida.close();
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	public static void imprime5PrimerosGeneral(Ciclista [] corredores){
		for(int i=0;i<5;i++){
			System.out.println((i+1)+" "+corredores[i].getTiempo()+" "+corredores[i].getNombre());
		}
	}
	
	public static void imprime10PrimerosClasEtapa(Ciclista [] corredores){
		for(int i=0;i<11;i++){
			System.out.println((i+1)+" "+corredores[i].getTiempo()+" "+corredores[i].getNombre());
		}
	}
	
	public static void main (String [] args){
		Ciclista [] corredores=generalInicial("GeneralInicial.txt");
		Ciclista [] corredores2=clasEtapa(corredores,"etapa.txt");
		Ciclista [] corredores3=ordenarClas(corredores2);
		imprime10PrimerosClasEtapa(corredores3);
	}

}
