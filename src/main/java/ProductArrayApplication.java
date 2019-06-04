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
                    List<Long> inputList=Arrays.stream(input).boxed().collect(Collectors.toList());
                    List<Long> result=new ArrayList<>();
                    List<Object> convertedList=new ArrayList<>();

                    for(int count=0;count<inputList.size();count++){
                        if(count>0){
                            convertedList.addAll(inputList.subList(0,count));
                        }
                        convertedList.addAll(Arrays.stream(input).boxed().collect(Collectors.toList()).subList(count+1,input.length));

                        if(count!=inputList.size()-1){
                            convertedList.add("-");
                        }
                    }

                    for (Object aLista : convertedList) {
                        if (aLista instanceof Long) {
                            if (result.size() > 0) {
                                Long temp = result.get(result.size() - 1);
                                result.set(result.size() - 1, temp * (Long) aLista);
                            } else {
                                result.add((Long) aLista);
                            }
                        } else {
                            result.add(1L);
                        }
                    }

                    System.out.println("Probando "+Arrays.toString(input)+" - Resultado "+result);
                    return result.stream().mapToLong(l -> l).toArray();
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