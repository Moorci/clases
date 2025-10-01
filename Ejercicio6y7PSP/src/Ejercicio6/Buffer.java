package Ejercicio6;

public class Buffer {
	
	private char contenido;
	private boolean bufferLleno = false;
	
	
	public void poner(char contenido) {
        
        this.contenido = contenido;
        this.bufferLleno = true;
    }
    
    public char recoger() {
        
        if(bufferLleno == true) {
            
        this.bufferLleno = false;
        return contenido;
        }
        else {
            return ' '; 
        }
       
    }

}
