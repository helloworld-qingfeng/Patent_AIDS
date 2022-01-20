package Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Replace_First_label_demo implements RepalceIPMI_First_label {
       /*
           将 先标号的 词组（First_label）中的数字和汉字错分开，并形成新的所谓的集合；
       */
    @Override
    public List<?> extract_First_label_phrase(String Reference_markss, String Separator_A, String Separator_B,CiZu cizu) {

        List<String> phrase_number  = new ArrayList<>(); //装词组的 序列号的；
        List<String> phrase_str  = new ArrayList<>(); //装词组的 特征名称的；
        List<Integer> number_length = new ArrayList<>(); //装序列号的个数的;
        List<List<String>> all_phrase = new ArrayList<>(); //用来装 序列号 特征名称的2个集合
        /*
           1、底板；2、卧式搅拌机；3、进料门；4、进料口；
           分隔为
           1、底板
           2、卧式搅拌机
           3、进料门
         */
        String[] split = Reference_markss.split(Separator_A);   //开始按照 某指定符号进行分隔

        for (String str:split) {
            if(str.length()>0 && str != null){
                       /*
                            1、底板
                            2、卧式搅拌机

                              分隔为
                           1 底板
                           2 卧式搅拌机
                       */
                String[] split1 = str.split(Separator_B);   //二次分隔

                if(split1.length==2 && split1 != null ){    //二次分隔，数组长度必须是2，因为 number+str；对应的2个
                    if(split1[0].length()>0 && split1[1].length()>0){
                        phrase_number.add(split1[0]); //数字
                        phrase_str.add(split1[1]); //特征名词
                        number_length.add(split1[0].length()); //序列号的个数：
                    }
                }

            }
        }
        all_phrase.add(phrase_number);
        all_phrase.add(phrase_str);
        cizu.setCi_zu_xu_lie_count(number_length);
        return all_phrase; //返回集合;
    }


    /*
      词组去重
    */
    @Override
    public String Check_duplicate(List<List<String>> list,CiZu cizu) {
        List<String> CiZu = list.get(list.size()-1); //词组本身;
        String ChongFu = "";
        for  ( int  i  =   0 ; i  <  CiZu.size()  -   1 ; i ++ )  {
            for  ( int  j  =  CiZu.size()  -   1 ; j  >  i; j -- )  {
                if  (CiZu.get(j).equals(CiZu.get(i)))  {
                    ChongFu="有重复元素";
                    list.get(0).remove(j);
                    list.get(1).remove(j);
                    cizu.getCi_zu_xu_lie_count().remove(j);
                }
            }
        }
        return ChongFu;
    }


    /*
      替换权利要求书
     */
    @Override
    public String Forward_Replacement_claims(List<List<String>> list, String claims,int number) {
        List<String> YouKuoHao = list.get(0);  //序号;
        List<String> CiZu = list.get(list.size()-1);   //词组本身：

        if(number==0){
            //(正向替换)
            for(int i=0;i<CiZu.size();i++){
                String xuhao = CiZu.get(i)+"（"+YouKuoHao.get(i)+"）";  //词组和序列结合  挡板（12）；
                claims=claims.replaceAll(CiZu.get(i),xuhao);
            }
            return claims;
        }else if(number==1){
            //(反向替换)
            for(int i=0;i<CiZu.size();i++){
                String Jiehe = CiZu.get(i)+"（"+YouKuoHao.get(i)+"）";  //词组和序列结合  挡板（12）；
                claims=claims.replaceAll(YouKuoHao.get(i),Jiehe);   //反向替换;
            }
            return claims;
        }
        return null;
    }


    /*
     替换说明书实施例
    */
    @Override
    public String Forward_Replacement_instructions(List<List<String>> list, String instructions,int number) {
        List<String> YouKuoHao = list.get(0);  //序号;
        List<String> CiZu = list.get(list.size()-1);   //词组本身：

        if(number==0){
            //(正向替换)
            for(int i=0;i<CiZu.size();i++){
                String xuhao = CiZu.get(i)+YouKuoHao.get(i);  //词组和序列结合  挡板12；
                instructions=instructions.replaceAll(CiZu.get(i),xuhao);
            }
        }else if(number==1){
            //(反向替换)
            for(int i=0;i<CiZu.size();i++){
                String Jiehe = CiZu.get(i)+YouKuoHao.get(i);  //词组和序列结合  挡板12；
                instructions=instructions.replaceAll(YouKuoHao.get(i),Jiehe);
            }
        }


        return instructions;
    }


    /*
     权利要求书、说明书中的标点符号的清洗
    */
    @Override
    public String Cleaning_of_punctuation_marks(String data) {
        if(data != null && data.length()>0){
            return data.replaceAll(",", "，").replaceAll("\\．","\\.");   //清理数据；
        }else {
            return "null";
        }
    }


    /*
    修复新旧主题;
     */
    @Override
    public String Repair_old_and_new(String old_ZhuTi, String new_ZhuTi, String text) {
        if(old_ZhuTi.equals(new_ZhuTi)){   //标号后的权利要求书的主题，与未标号的权利要求书的主题，是否对称；
            return text;  //对称;不做任何操作,返回原文本对象;
        }else {
            //不对称，进行修复;
            //新主题检索，用旧主题替换;
            String new_claims = text.replaceAll(new_ZhuTi, old_ZhuTi);
            return new_claims; //返回修改后的文本;
        }
    }




    /*
    权利要求书的主题提取，已标号，和未标号，均可
    */
    @Override
    public String Unlabeled_Extract_topic(String document) {
        String[] split = document.split(System.lineSeparator());   //分隔权要，以换行符分隔，至少获取 权1的 主题那个 大行;
        String right_claiming_document = split[0];  //获取 权1的 主题那个 大行;
        String substring = "";  //创建一个空字符串，用以容纳 提取的 未标号的 专利主题;

        //不等于空，且长度大于0；
        if(right_claiming_document != null && (right_claiming_document.length()>0)){
            int First_Point_number_index = right_claiming_document.indexOf(".");  //返回第一个 点号 的索引值；
            int First_comma_index = right_claiming_document.indexOf("，");  //返回第一个 逗号 的索引值；

            //如果2个索引值，有1个是-1代表有问题，不进行调取猪蹄子的操作；
            if( (First_comma_index != -1) && ( First_Point_number_index != -1) ){
                //返回主题值;并且剔除[一种]
                substring = right_claiming_document.substring(First_Point_number_index+1, First_comma_index).replaceAll("一种","");
            }else {
                //如果2个索引值，有1个是-1代表有问题，抛出error错误，浏览器接受处理；
                return "error";
            }
        }
        return substring;
    }

    @Override
    public List<?> ShengXu(List<List<String>> list,CiZu cizu) {
        /*

         */
        List<String> new_tezheng = new ArrayList<>();
        List<String> new_xulie = new ArrayList<>();
        List<List<String>> new_list = new ArrayList<>();
        int max = 0;

        while (cizu.getCi_zu_xu_lie_count().size()!=0){
            max = cizu.getCi_zu_xu_lie_count().get(0);

            for(int i=cizu.getCi_zu_xu_lie_count().size()-1;i>0;i--){
                if(cizu.getCi_zu_xu_lie_count().get(i)>max){
                    max=cizu.getCi_zu_xu_lie_count().get(i);
                }
            }

            for(int j=0;j<cizu.getCi_zu_xu_lie_count().size();j++){
                if(max==cizu.getCi_zu_xu_lie_count().get(j)) {
                    cizu.getCi_zu_xu_lie_count().remove(j);
                    new_xulie.add(list.get(0).get(j));
                    new_tezheng.add(list.get(1).get(j));
                    list.get(0).remove(j);
                    list.get(1).remove(j);
                    j--;
                }
            }

        }
        new_list.add(new_xulie);
        new_list.add(new_tezheng);
        return new_list;
    }

}
