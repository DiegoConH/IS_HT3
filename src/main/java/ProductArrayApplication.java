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
                        System.out.println(convertedList);
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

                    System.out.println(result);
                    return result.stream().mapToLong(l -> l).toArray();
                }
            }else{
                return new long[]{};
            }
        }else{
            return null;
        }
    }
}