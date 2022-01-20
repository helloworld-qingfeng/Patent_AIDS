package Service;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface RepalceIPMI_First_label {
    /*
    将 先标号的 词组（First_label）中的数字和汉字错分开，并形成新的所谓的集合；
 */
    abstract List<?> extract_First_label_phrase(String Reference_markss, String Separator_A, String Separator_B,CiZu cizu);


    /*
       词组去重
     */
    abstract String Check_duplicate(List<List<String>> list,CiZu cizu);


    /*
      替换权利要求书
     */
    abstract String Forward_Replacement_claims(List<List<String>> list, String claims, int number);


    /*
     替换说明书实施例
     */
    abstract String Forward_Replacement_instructions(List<List<String>> list, String instructions, int number);


    /*
   权利要求书、说明书中的标点符号的清洗
 */
    abstract String Cleaning_of_punctuation_marks(String data);


    /*
    修复新旧主题;
  */
    abstract String Repair_old_and_new(String old_ZhuTi, String new_ZhuTi, String text);


    /*
    权利要求书的主题提取，已标号，和未标号，均可
 */
    abstract String Unlabeled_Extract_topic(String document);



    /*
         升序
     */
    abstract List<?> ShengXu(List<List<String>> list,CiZu ciZu);

}
