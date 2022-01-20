package javabean;

import Service.ReplaceIPMI;
import Service.replace_demo;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        List<Integer> new_list = new ArrayList<>();
        int max = 0;

        while(list.size()!=0){
            max = list.get(0);
            for(int i=list.size()-1;i>0;i--){
                if(list.get(i)>max){
                    max=list.get(i);
                }
            }

            for(int j=0;j<list.size();j++){
                if(max==list.get(j)){
                    new_list.add(list.get(j));
                    list.remove(j);
                    j--;
                }
            }
        }



        for(Integer i:new_list){
            System.out.println(i);
        }
    }
}
