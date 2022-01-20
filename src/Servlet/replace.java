package Servlet;




import Service.ReplaceIPMI;
import Service.replace_demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/replace_Read-label")
public class replace extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //设置字符集;
        String Reference_markss = req.getParameter("Reference-mark");  //请粘贴附图标记词组
        String right_claiming_document = req.getParameter("right-claiming-document");   ///请粘贴权利要求书内容
        String Replace_document = req.getParameter("Replace-document");  //获取说明书实施例内容;
        String fruit = req.getParameter("Fruit");  //获取单选项，查看是否有序，还是无序
        HttpSession session = req.getSession(); //获取seesion对象：
        session.setMaxInactiveInterval(3);  //设置时间;



        if(Reference_markss != null && Reference_markss.length()>0){   //词组必须不能是空的;


            ReplaceIPMI replace = new replace_demo();  //多态;
            String Reference_marks = replace.clean_cizu(Reference_markss);  //清洗词组

            //说明书和权利要求书至少有一个不能是空的：
            if( (right_claiming_document !=null && right_claiming_document.length()>0) ||  (Replace_document != null && Replace_document.length()>0)){

                //标号词组序列集合；
                List<List<String>> separate__Reference_Mark = new ArrayList<>();


                if(fruit.equals("Youxu")){    //有序指引；

                    // 开始标号，生成 有括号、无括号、词组本身、词组序列集合的  集合;
                    //并且去重;
                    separate__Reference_Mark = (List<List<String>>) replace.Ordered_phrases(Reference_marks, replace);

                    //获取词组;
                    String cizu = replace.Echo_phrases(separate__Reference_Mark);
                    session.setAttribute("cizu",cizu);  //设置查询结果的域对象;



                    String new_right_claiming_document = "";  //清洗权利要求书的数据,即，将其中的,替换为，
                    String No_theme = ""; //提取清洗后的，未标号的权利要求书中的 主题;
                    String Yes_theme = ""; //提取 已裱好 后的 权利要求书中的  主题;


                    //权利要求书中，不是空的；
                    if(right_claiming_document !=null && right_claiming_document.length()>0) {
                        //标号、新旧查询以及修补；
                        replace.Subject_number_detection_of_claims(right_claiming_document, new_right_claiming_document, No_theme, Yes_theme, separate__Reference_Mark, replace,session);

                    }


                    //说明书实施例，不是空的；
                    if(Replace_document != null && Replace_document.length()>0){

                        //清洗数据,即，将其中的,替换为，
                        String new_Replace_document = replace.Cleaning_of_punctuation_marks(Replace_document);
                        //清洗数据后的 说明书实施例 进行标号；
                        String instructions = replace.Replacement_instructions(separate__Reference_Mark,new_Replace_document);


                        //查看权利要求书是否是空、并且未标号的权利要求书的主题，并不是error、并且以标号的 权要主题，得有;
                        if( (right_claiming_document !=null) && (right_claiming_document.length()>0)  &&  (!"error".equals(No_theme)) && (Yes_theme.length()>0 && Yes_theme != null)) {

                            /*
                                传参：【说明书专用主题】、标号后的说明书实施例文本

                                  1.将标号过的 专利名称主题（如果存在标号），括号进行剔除；形成 说明书 专用主题;
                                  2.将说明书专用主题 与 未标号的权要主题 对比
                                    2.1：对称--不修改，直接返回 说明书标号的文本;
                                    2.2: 不对称
                                      2.2.1 调用其他方法修改，返回 新旧修改后的 说明书标号的文本；
                             */

                            String new_instructions = replace.Repair_old_and_new(No_theme, Yes_theme.replaceAll("（","").replaceAll("）",""), instructions);
                            //设置 说明书实施例的 域对象
                            session.setAttribute("instructions",new_instructions); //设置查询结果的域对象;

                        }else {
                            //权利要求书是空的，则 不进行 新旧主题的修补。
                            // 直接输出 说明书实施例内容
                            session.setAttribute("instructions",instructions); //设置查询结果的域对象;
                        }

                    }

                }else {
                    //无序指引;

                    // 开始标号，生成 有括号、无括号、词组本身、词组序列集合的  集合;
                    //并且去重;
                    separate__Reference_Mark = (List<List<String>>) replace.Unordered_phrases(Reference_marks, replace);

                    //获取词组;
                    //词组本身序列排序
                    String cizu = replace.Echo_phrases(separate__Reference_Mark);
                    session.setAttribute("cizu",cizu);  //设置查询结果的域对象;


                    String new_right_claiming_document = "";  //清洗权利要求书的数据,即，将其中的,替换为，
                    String No_theme = ""; //提取清洗后的，未标号的权利要求书中的 主题;
                    String Yes_theme = ""; //提取 已裱好 后的 权利要求书中的  主题;


                    //权利要求书中，不是空的；
                    if(right_claiming_document !=null && right_claiming_document.length()>0) {
                        //标号、新旧查询以及修补；
                        replace.Subject_number_detection_of_claims(right_claiming_document, new_right_claiming_document, No_theme, Yes_theme, separate__Reference_Mark, replace,session);

                    }

                    //说明书实施例，不是空的；
                    if(Replace_document != null && Replace_document.length()>0){

                        //清洗数据,即，将其中的,替换为，
                        String new_Replace_document = replace.Cleaning_of_punctuation_marks(Replace_document);
                        //清洗数据后的 说明书实施例 进行标号；
                        String instructions = replace.Replacement_instructions(separate__Reference_Mark,new_Replace_document);


                        //查看权利要求书是否是空、并且未标号的权利要求书的主题，并不是error、并且以标号的 权要主题，得有;
                        if( (right_claiming_document !=null) && (right_claiming_document.length()>0)  &&  (!"error".equals(No_theme)) && (Yes_theme.length()>0 && Yes_theme != null)) {

                            //   权利要求书不是空，
                            //   并且  未标号的 权要主题  不是error,
                            //   并且  以标号的 权要主题，得有;
                            //  则 开始 新旧主题的修补


                            /*
                                传参：【说明书专用主题】、标号后的说明书实施例文本

                                  1.将标号过的 专利名称主题（如果存在标号），括号进行剔除；形成 说明书 专用主题;
                                  2.将说明书专用主题 与 未标号的权要主题 对比
                                    2.1：对称--不修改，直接返回 说明书标号的文本;
                                    2.2: 不对称
                                      2.2.1 调用其他方法修改，返回 新旧修改后的 说明书标号的文本；
                             */

                            String new_instructions = replace.Repair_old_and_new(No_theme, Yes_theme.replaceAll("（","").replaceAll("）",""), instructions);
                            //设置 说明书实施例的 域对象
                            session.setAttribute("instructions",new_instructions); //设置查询结果的域对象;

                        }else {
                            //权利要求书是空的，则 不进行 新旧主题的修补。
                            // 直接输出 说明书实施例内容
                            session.setAttribute("instructions",instructions); //设置查询结果的域对象;
                        }

                    }


                }

            }


        }

        resp.setStatus(302);
        resp.sendRedirect(req.getContextPath()+"/Rear-label.jsp"); //重定向





















//          List<String> YouKuoHao = separate__Reference_Mark.get(0); //无括号
////        List<String> WuKuoHao = separate__Reference_Mark.get(1); //有括号
////        List<String> CiZu = separate__Reference_Mark.get(2); //词组本身;


//        一次请求;
//        req.setAttribute("claims",claims);   //设置查询时间的域对象
//        req.setAttribute("cizu",cizu);  //设置查询结果的域对象
//        req.getRequestDispatcher(req.getContextPath()+"/index.jsp").forward(req,resp);
    }
}
