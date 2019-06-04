import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductArrayApplication {
    public static void main(String[] args){
        calculateProductArrayBasic(new long[]{5,1,4,2,3});
    }

    public static long[] calculateProductArrayBasic(long[] input){
        if(input!=null){
            if(input.length!=0){
                if(input.length==1){
                    if(input[0]==0){
                        return new long[]{1};
                    }else{
                        return new long[]{input[0]};
                    }
                }else {
                    List<Long> entrada=Arrays.stream(input).boxed().collect(Collectors.toList());
                    List<Long> resultado=new ArrayList<>();
                    List<Object> convertorlista=new ArrayList<>();

                    for(int count=0;count<entrada.size();count++){
                        if(count>0){
                            convertorlista.addAll(entrada.subList(0,count));
                        }
                        convertorlista.addAll(Arrays.stream(input).boxed().collect(Collectors.toList()).subList(count+1,input.length));



                        if(count!=entrada.size()-1){
                            convertorlista.add("-");
                        }
                        System.out.println(convertorlista);
                    }
                    for (Object Lista : convertorlista) {
                        if (Lista instanceof Long) {
                            if (resultado.size() > 0) {
                                Long temp = resultado.get(resultado.size() - 1);
                                resultado.set(resultado.size() - 1, temp * (Long) Lista);
                            } else {
                                resultado.add((Long) Lista);
                            }
                        } else {
                            resultado.add(1L);
                        }
                    }

                    System.out.println(resultado);
                    return resultado.stream().mapToLong(l -> l).toArray();
                }
            }else{
                return new long[]{};
            }
        }else{
            return null;
        }
    }
}