/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassExcercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author OWNER
 */
public class ElemSort  {
    public static final Comparator BY_WEIGHT = new WeightComparator();
    public static final Comparator BY_NAME = new NameComparator();
    
    private String name;
    private double weight;
    
    public ElemSort(String name, double weight){
        super();
        this.name = name;
        this.weight = weight;
    }
    
    public String getName(){
        return name;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public static List<ElemSort> getList(String file){
     
        List<ElemSort> elementList = new ArrayList<>();
        try(Scanner reader = new Scanner(ElemSort.class.getResourceAsStream(file))){
            String nextLine ="";
            
            while(reader.hasNext()){
                nextLine = reader.nextLine();
                ElemSort myElements = getElements(nextLine);
                
                if(myElements !=null){
                    elementList.add(myElements);
                }
            }
            return elementList;
        }
        
    }
    
    private static ElemSort getElements(String nextLine) {
        try{
            String[] elementString = nextLine.split(",");
            String name = elementString[0];
            double weight = Double.parseDouble(elementString[1]);
            ElemSort test = new ElemSort(name, weight);
            
            return test;
        }catch (NumberFormatException | IndexOutOfBoundsException e){
            System.err.println("Problem reading in "+ ""+ nextLine + "");
            return null;
        }
    }

    private static class WeightComparator implements Comparator<ElementNode> {

        

        @Override
        public int compare(ElementNode v, ElementNode w) {
            if(v.hashCode() < w.hashCode()){
                return -1;
            }else if(v.hashCode() > w.hashCode()){
                return 1;
            }else
                return 0;
        }
    }

    private static class NameComparator implements Comparator<ElementNode> {

        @Override
        public int compare(ElementNode v, ElementNode w) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
}
