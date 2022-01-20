package Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class replace_demo implements ReplaceIPMI{

/*
     清洗词组
 */
    @Override
    public String clean_cizu(String CiZu) {
        /*
            将空格，替换为空
         */
        return CiZu.replaceAll(" ","");
    }


    /*
    [分行]
       1.将文本域的  替换词组 进行操作
           1.2 将替换词组中 以 [换行符] 作为分隔符；
           1.3 生成一个list集合返回
     */
    @Override
    public List<?> branch_Reference_Mark(String str) {
        //2.生成列表
        List<String> list = null;

        if(str != null && (str.length() > 0)){

            //开始处理
            //1.将替换词组中 以 换行符 作为分隔符；
            String[] split = str.split(System.lineSeparator());


            //2.生成列表
            list = new ArrayList<String>();

            //3.填装列表
            for (String str1:split) {
                if( (str1.length()>0) && (str1 != null)){
                    list.add(str1);
                }
            }

        }else {
            //否则
            return null;
        }
        return list;
    }



    /*
        将每个 父子 构成 的字符串 词组进行分类标号，即进行 同性分类；
        比如
        挡板A、挡板扣A1、挡板扣扣A2、
        火箭B、火箭扣B1、火箭扣扣B2、
     */

    @Override
    public List<?> separate__Reference_Mark(List<String> list, String Separator) {
        List<String> list_You_KuoHao = null;   //有（）的标号词组
        List<String> list_No_KuoHao = null;    //没有（）的标号词组
        List<String> list_CiZu = null;  //词组本身;
        List<String> list_CiZu_PaiXu = null; //词组序列

        List<List<String>> list_all = null;   //装有括号、没括号词组的list的list
        String[] strs = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        if(list != null && (list.size() >0)){

            list_You_KuoHao = new ArrayList<String>();
            list_No_KuoHao = new ArrayList<String>();
            list_CiZu = new ArrayList<>();
            list_CiZu_PaiXu = new ArrayList<>();
            //1.开始将每个list集合中的数据进行分隔；
            int count = 0;

            for (String str:list) {
                if(str != null && (str.length()>0)){
                    String[] split = str.replaceAll(System.lineSeparator(), "").split(Separator);
                    String head = strs[count];
                    int count_two = 1;

                    for (String str2:split) {
                        if(str2 != null && (str2.length()>0)){
                            list_CiZu.add(str2);  //词组本身
                            list_You_KuoHao.add(str2+"（"+head+count_two+"）");   //有括号
                            list_No_KuoHao.add(str2+head+count_two);  //无括号;
                            list_CiZu_PaiXu.add(head+count_two+"、"+str2);  //词组排序
                            count_two++;
                        }
                    }
                    count++;
                }else {
                    continue;
                }
            }
            list_all = new ArrayList<List<String>>();
            list_all.add(list_No_KuoHao);  //没有括号
            list_all.add(list_You_KuoHao);  //有括号
            list_all.add(list_CiZu);   //词组本身;
            list_all.add(list_CiZu_PaiXu); //词组序列;
            return list_all;
        }else{
            return null;
        }
    }


    /*
         将词组，按照数字递增的顺序，进行标号，即不分类；
     */
    @Override
    public List<?> WuXu_separate__Reference_Mark(String[] strs, String Separator) {

        List<String> list_You_KuoHao = null;   //有（）的标号词组
        List<String> list_No_KuoHao = null;    //没有（）的标号词组
        List<String> list_CiZu = null;  //词组本身;
        List<String> list_CiZu_PaiXu = null; //词组序列
        List<List<String>> list_all = null;   //装有括号、没括号词组的list的list

        if(strs != null && (strs.length >0)){

            list_You_KuoHao = new ArrayList<String>();
            list_No_KuoHao = new ArrayList<String>();
            list_CiZu = new ArrayList<>();
            list_CiZu_PaiXu = new ArrayList<>();

            int count = 1;
            for (String str:strs) {
                if(str != null && (str.length()>0)){
                    list_CiZu.add(str);   //词组本身;
                    list_You_KuoHao.add(str+"（"+count+"）");   //有括号
                    list_No_KuoHao.add(str+count);  //无括号;
                    list_CiZu_PaiXu.add(count+Separator+str);  //词组排序
                    count++;
                }else {
                    continue;
                }
            }

            list_all = new ArrayList<List<String>>();
            list_all.add(list_No_KuoHao);  //没有括号
            list_all.add(list_You_KuoHao);  //有括号
            list_all.add(list_CiZu);   //词组本身;
            list_all.add(list_CiZu_PaiXu); //词组序列;
            return list_all;

        }else {
            return null;
        }
    }


    /*
        将词组中的分隔符（用户随意填的），进行替换成指定的分隔符；
     */
    @Override
    public String Cleaning_separator(String str,String separator) {
        if(str != null && (str.length()>0)){
            return str.replaceAll(",",separator).
                    replaceAll("，",separator).
                    replaceAll("-",separator).
                    replaceAll(":",separator).
                    replaceAll("：",separator).
                    replaceAll("。",separator).
                    replaceAll("\\.",separator).
                    replaceAll("；",separator).
                    replaceAll("’",separator).
                    replaceAll("‘",separator).
                    replaceAll("“",separator).
                    replaceAll("”",separator);
        }else {
            return null;
        }
    }


    /*
       替换权利要求书;
    */
    @Override
    public String Replacement_claims(List<List<String>> list, String claims) {

        List<String> YouKuoHao = list.get(1); //有括号的词组;
        List<String> CiZu = list.get(2); //词组本身;
        for(int i=0;i<CiZu.size();i++){
            claims=claims.replaceAll(CiZu.get(i),YouKuoHao.get(i));
        }

        return claims;
    }


    /*
       替换说明书实施例
     */
    @Override
    public String Replacement_instructions(List<List<String>> list, String instructions) {
        List<String> YouKuoHao = list.get(0); //无括号的词组;
        List<String> CiZu = list.get(2); //词组本身;

        for(int i=0;i<CiZu.size();i++){
            instructions=instructions.replaceAll(CiZu.get(i),YouKuoHao.get(i));
        }

        return instructions;
    }



    /*
       查重，附图标记查重
     */
    @Override
    public void Check_duplicate(List<List<String>> list) {

        List<String> CiZu = list.get(2); //词组本身;

        for  ( int  i  =   0 ; i  <  CiZu.size()  -   1 ; i ++ )  {
            for  ( int  j  =  CiZu.size()  -   1 ; j  >  i; j -- )  {
                if  (CiZu.get(j).equals(CiZu.get(i)))  {
                    list.get(0).remove(j);
                    list.get(1).remove(j);
                    list.get(2).remove(j);
                    list.get(3).remove(j);
                }
            }
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
      修复新旧主题
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
         有序 词组处理；
       */
    @Override
    public List<?> Ordered_phrases(String Reference_marks,ReplaceIPMI replace) {
        //将词组过滤数据，任何标号作为分隔符的，统一替换为“、”
        String clean_strs = replace.Cleaning_separator(Reference_marks, "、");

        //将词组中的数据，以换行符进行分隔，形成 【父子关系】的列表；
        List<String> branch_Reference_Mark = (List<String>) replace.branch_Reference_Mark(clean_strs);

        //开始标号，生成 有括号、无括号、词组本身、词组序列集合的  集合;
        List<List<String>> separate__Reference_Mark = (List<List<String>>) replace.separate__Reference_Mark(branch_Reference_Mark, "、");

        //附图标记词组-开始去重
        replace.Check_duplicate(separate__Reference_Mark);

        return separate__Reference_Mark;
    }



    /*
        无序 词组处理
     */
    @Override
    public List<?> Unordered_phrases(String Reference_marks,ReplaceIPMI replace) {
        //将 [换行符] 替换为"";
        String reference_marks = Reference_marks.replaceAll(System.lineSeparator(), "");

        //清洗数据;任何标号作为分隔符的，统一替换为“、”
        String clean_string = replace.Cleaning_separator(reference_marks, "、");

        //清洗后的数据进行操作，按照“、”进行分隔；
        String[] split = clean_string.split("、");

        //将清洗后的数据进行标号;
        List<List<String>>  WuXu_separate__Reference_Mark = (List<List<String>>) replace.WuXu_separate__Reference_Mark(split, "、");


        //附图标记词组-开始去重
        replace.Check_duplicate(WuXu_separate__Reference_Mark);

        //返回集合
        return WuXu_separate__Reference_Mark;
    }


    /*
       输出 词组 给前台页面;
     */
    @Override
    public String Echo_phrases(List<List<String>> separate__Reference_Mark) {

        //词组本身序列排序（输出 说明书中的 想要的 结果段）
        List<String> CiZuPaiXu = separate__Reference_Mark.get(3); //无括号
        String cizu = "";
        for(int i=0;i<CiZuPaiXu.size();i++){
            if(i==CiZuPaiXu.size()-1){
                cizu+=CiZuPaiXu.get(i)+"。";
            }else {
                cizu+=CiZuPaiXu.get(i)+"；";
            }
        }

        return cizu;
    }


    /*
       1.权利要求书清洗、
       2.提取专利主题（未标号）、
       3.替换权要、
       4.判断替换的权要是否为空；
         4.1 为空结束；不进行新旧查询；
         4.2 不为空，进行新旧查询；
            4.2.1 新旧查询不对称，将 标号的权要，新旧替换，修补；
            4.2.2 返回seesion域对象；
     */
    @Override
    public void Subject_number_detection_of_claims(String right_claiming_document,String new_right_claiming_document,String No_theme,String Yes_theme,List<List<String>> separate__Reference_Mark,ReplaceIPMI replace, HttpSession session) {

        //清洗数据,即，将其中的[,]替换为[，]
        new_right_claiming_document = replace.Cleaning_of_punctuation_marks(right_claiming_document);

        //提取未标号的主题;
        No_theme = replace.Unlabeled_Extract_topic(new_right_claiming_document);

        //替换后的权要;
        String claims = replace.Replacement_claims(separate__Reference_Mark, new_right_claiming_document);

        //新旧主题复查，必要时进行修补;
        if (!"error".equals(No_theme)) {  //如果 未标号 的主题 提取到了，则进入程序;

            //提取 已标号 的主题;
            Yes_theme = replace.Unlabeled_Extract_topic(claims);
            //获取修补后的数据；
            String new_claims = replace.Repair_old_and_new(No_theme, Yes_theme, claims);
            //设置查询时间的域对象;
            session.setAttribute("claims", new_claims);
        } else {
            //未标号 的主题 没有提取到;
            session.setAttribute("claims", claims);//设置查询时间的域对象;
            session.setAttribute("error", "error"); //设置权要的主题那块，至少应当加个点
        }

    }

}
