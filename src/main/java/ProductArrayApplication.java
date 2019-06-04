import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductArrayApplication {
    public static void main(String[] args){
        calculateProductArrayBasic(new long[]{1,2,3,4,5,6,7,8}); //Test 1
        calculateProductArrayBasic(new long[]{}); //Test 2
        calculateProductArrayBasic(new long[]{2}); //Test 3
        calculateProductArrayBasic(new long[]{3}); //Test 4
        calculateProductArrayBasic(new long[]{4,5}); //Test 5
        calculateProductArrayBasic(null); //Test 6
        calculateProductArrayBasic(new long[0]); //Test 7
        calculateProductArrayBasic(new long[]{1,3,5,7,9,0,1,3}); //Test 8
        calculateProductArrayBasic(new long[]{1,5,6,1,20,10,21,5}); //Test 9
        calculateProductArrayBasic(new long[]{1,1,6,7,8,4,4,1,9}); //Test 8
    }



    public static long[] calculateProductArrayBasic(long[] input){
        if(input!=null){
            if(input.length!=0){
                if(input.length==1){
                    if(input[0]==0){
                        System.out.print("Probando "+Arrays.toString(input));
                        input[0]=1;
                        System.out.print(" - Resultado "+Arrays.toString(input));
                        System.out.println();
                        return input;
                    }else{
                        System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+Arrays.toString(input));
                        return input;
                    }


                }else {
                    List<Long> entrada=Arrays.stream(input).boxed().collect(Collectors.toList());
                    List<Long> resultado=new ArrayList<>();
                    List<Object> Conversion=new ArrayList<>();


                    for(int count=0;count<entrada.size();count++){
                        if(count>0){
                            Conversion.addAll(entrada.subList(0,count));
                        }
                        Conversion.addAll(Arrays.stream(input).boxed().collect(Collectors.toList()).subList(count+1,input.length));

                        if(count!=entrada.size()-1){
                            Conversion.add("-");
                        }

                    }


                    for (Object segundalista : Conversion) {
                        if (segundalista instanceof Long) {
                            if (resultado.size() > 0) {
                                Long temp = resultado.get(resultado.size() - 1);
                                resultado.set(resultado.size() - 1, temp * (Long) segundalista);
                            } else {
                                resultado.add((Long) segundalista);
                            }

                        } else {
                            resultado.add(1L);
                        }
                    }



                    System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+resultado);
                    return resultado.stream().mapToLong(l -> l).toArray();
                }

            }else{
                System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+Arrays.toString(input));
                return input;
            }
        }else{
            System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+Arrays.toString(input));
            return input;
        }
    }
}