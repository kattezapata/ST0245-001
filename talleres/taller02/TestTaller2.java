
public class TestTaller2 {

	
	public static boolean ejercicio1(){
		int a, b, c, d;
		a=MCD.gcd(12,36);
		b=MCD.gcd(8,12);
		c=MCD.gcd(72,108);
		d=MCD.gcd(162, 270);
		if(a==12 && b==4 && c==36 && d==54)
			return true;
		return false;
	}
	

	public static boolean ejercicio2(){
		boolean a, b, c, d;
		a=Punto2.sumaGrupo(new int[] {2, 4, 8}, 9);
		b=Punto2.sumaGrupo(new int[] {2, 4, 8}, 8);
		c=Punto2.sumaGrupo(new int[] {10, 2, 2, 5}, 9);
		d=Punto2.sumaGrupo(new int[] {10, 2, 2, 5}, 17);
		if(!a && b && c && d)
			return true;
		return false;
	}
	
	
	public static void ejercicio3(){
		System.out.println("Para la cadena 'abc' el resultado debe ser similar a:");
		System.out.println("a, ab, abc, ac, b, bc, c\n");
		Punto3.combinations("abc");

		System.out.println("Para la cadena 'Eafit' el resultado debe ser similar a:");
		System.out.println("E, Ea, Eaf, Eafi, Eafit, Eaft, Eai, Eait, Eat, Ef, Efi, Efit, Eft, Ei, Eit, Et, a, af, afi, afit, aft, ai, ait, at, f, fi, fit, ft, i, it, t\n");
		Punto3.combinations("Eafit");
		
		System.out.println("Para la cadena 'Hola' el resultado debe ser similar a:");
		System.out.println("H, Ho, Hol, Hola, Hoa, Hl, Hla, Ha, o, ol, ola, oa, l, la, a\n");
		Punto3.combinations("Hola");

		System.out.println("Para la cadena 'Hi' el resultado debe ser similar a:");
		System.out.println("H, i, Hi\n");
		Punto3.combinations("Hi");
	}
	
	
	
	public static void main(String[] args){	
        //Ejercicio1
        if(ejercicio1())
            System.out.println("Ejercicio 1 Correcto");
        else
        System.out.println("Ejercicio 1 Incorrecto");
        
        //Ejercicio2
        if(ejercicio2())
            System.out.println("Ejercicio 2 Correcto");
        else
        System.out.println("Ejercicio 2 Incorrecto");
        
        
        //Ejercicio3
        ejercicio3();
        
        

    }
}
