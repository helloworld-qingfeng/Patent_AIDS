package Service;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ReplaceIPMI {

    /*
       清洗词组
     */
    abstract String clean_cizu(String CiZu);


    /*
    [分行]
     1.将文本域的  替换词组 进行操作
         1.2 将替换词组中 以 [换行符] 作为分隔符；
         1.3 生成一个list集合返回
     */
    abstract List<?> branch_Reference_Mark(String str);


    /*
        [分隔]-有序
      1.将指定list集合中的元素，以指定分隔符 进行分隔；
      2.将每个 父子 构成 的字符串 词组进行分类标号
          比如
          挡板A、挡板扣A1、挡板扣扣A2、
          火箭B、火箭扣B1、火箭扣扣B2、
       3、返回 具有括号的 词组、无括号的词组、词组 本身
     */
    abstract  List<?> separate__Reference_Mark(List<String> list, String Separator);



   /*
        [分隔]-无序
        1.将指定的list集合中的元素，以指定分隔符进行分隔；
        2.将分隔出来的，按照正常 数字递增顺序进行标号：
    */
    abstract List<?> WuXu_separate__Reference_Mark(String[] strs, String Separator);


    /*
        1.将词组中的分隔符（用户随意填的），进行替换成指定的分隔符；
     */

    abstract String Cleaning_separator(String str,String separator);



    /*
      1.开始替换权利要求书;
     */
    abstract String Replacement_claims(List<List<String>> list,String claims);


    /*
       1.开始替换说明书实施例
     */
    abstract String  Replacement_instructions(List<List<String>> list,String instructions);


    /*
       查重，附图标记查重
     */
    abstract void Check_duplicate(List<List<String>> list);

    /*
        权利要求书的主题提取，已标号，和未标号，均可
     */
    abstract String Unlabeled_Extract_topic(String document);


    /*
       权利要求书、说明书中的标点符号的清洗
     */
    abstract  String  Cleaning_of_punctuation_marks(String data);

    /*
       修复新旧主题;
     */
    abstract String Repair_old_and_new(String old_ZhuTi,String new_ZhuTi,String text);


    /*
       有序词组处理；
     */
    abstract List<?> Ordered_phrases(String Reference_marks,ReplaceIPMI replace);

    /*
       无序词组处理；
     */
    abstract List<?> Unordered_phrases(String Reference_marks,ReplaceIPMI replace);

    /*
       输出 词组 给前台页面;
     */
    abstract String Echo_phrases(List<List<String>>  separate__Reference_Mark);


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
    abstract void Subject_number_detection_of_claims(String right_claiming_document,String new_right_claiming_document,String No_theme,String Yes_theme,List<List<String>> separate__Reference_Mark,ReplaceIPMI replace, HttpSession session);
}
