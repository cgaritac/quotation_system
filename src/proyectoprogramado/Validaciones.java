/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramado;

/**
 *
 * @author cgari
 */
public class Validaciones {
    
     //Método para determinar si hay datos en una variable
    public String StringVacios(String valor, String tipo, int min, int max){
        
        //Declaración de variables
        String resultado = "";
        
        //Condicional para evaluar si hay datos en una variable
         if(valor.isEmpty()){
            return resultado = "- El parámetro " + tipo +" no puede estar vacío \n"; //Regresa el valor de la variable            
        }else if (valor.length() < min){
            return resultado = "- El parámetro " + tipo +" no puede ser menor a " + min + " caracteres \n"; //Regresa el valor de la variable   
        }else if(valor.length() > max){
            return resultado = "- El parámetro " + tipo +" no puede ser mayor a " + max + " caracteres \n"; //Regresa el valor de la variable   
        }else{
             return resultado = ""; //Regresa el valor de la variable
         }       
    }  
    
    //Método para determinar si hay datos de tipo entero en una variable
    public String EnterosVacios(String valor, String tipo) {

        //Declaración de variables
        String resultado = "";

        //Condicional para evaluar si hay datos en una variable
        if (valor.isEmpty()) {
            return resultado = "- El parámetro " + tipo + " no puede estar vacío \n"; //Regresa el valor de la variable        
        } else {
            try //Prueba si existe una excepción
            {
                int valorEntero = Integer.parseInt(valor); //Convierte el valor de una variable a entero y lo asigna a otra variable
                resultado += numerosNegativos(valorEntero, tipo); //LLama el método "numerosNegativos" de la clase "Validaciones" y asigna el valor a la variable 

                if (tipo.equals("edad") && valorEntero < 18) {
                    resultado += "- La " + tipo + " debe ser mayor a 18 años \n"; //Regresa el valor de la variable           
                }

                if (tipo.equals("año del vehículo") && valorEntero > 2021) {
                    resultado += "- El " + tipo + " debe ser menor o igual a 2021 \n"; //Regresa el valor de la variable      
                }

                if (tipo.equals("kilometraje") && valorEntero < 1) {
                    resultado += "- El " + tipo + " debe ser mayor a 0 kilómetros \n"; //Regresa el valor de la variable      
                }

                return resultado; //Regresa el valor de la variable
            } catch (NumberFormatException e) //Atrapa la excepción NumberFormatException en caso de que ocurra en el bloque "Try"
            {
                return resultado = "- El parámetro " + tipo + " debe ser un número entero \n"; //Regresa el valor de la variable
            }
        }
    }

    //Metodo que se encarga de evaluar si el número ingresado por el usuario es negativo
    public String numerosNegativos(int valor, String tipo){
        
        //Declaración de variables
        String resultado = "";
        
        //Condicional para evaluar si un valor es menor a 0
        if(valor < 0)
            {
                return resultado = "- El parámetro " + tipo + " debe ser un número entero positivo \n"; //Regresa el valor de la variable                 
            }else
            {
                return resultado = ""; //Regresa el valor de la variable   
            }            
    }    
    
    public String seleccionRadioButton(boolean rdb1, boolean rdb2, String tipo){
        
        //Declaración de variables
        String resultado = "";
        
        //Condicional para evaluar si una u otra variable son "true"
        if(rdb1 || rdb2 )
            {
                return resultado = ""; //Regresa el valor de la variable               
            }else
            {
                return resultado = "- Debe seleccionar una opción del parámetro " + tipo + "\n"; //Regresa el valor de la variable 
            }            
    }              
    
}
