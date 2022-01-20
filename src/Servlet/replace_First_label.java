package Servlet;

import Service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/replace_First_label")
public class replace_First_label extends HttpServlet{
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
        String fruit = req.getParameter("Fruit");  //获取单选项，查看是正向序列，还是反向序列；


        HttpSession session = req.getSession(); //获取seesion对象：
        session.setMaxInactiveInterval(3);  //设置时间;
        session.setAttribute("cizu",Reference_markss);  //设置查询结果的域对象;


       // 词组不为空，并且词组长度不为0；
        if( Reference_markss != null && Reference_markss.length()>0){
            RepalceIPMI_First_label replace = new Replace_First_label_demo();
            CiZu ci = new CiZu();

            List<List<String>> all_phrase_a = (List<List<String>>) replace.extract_First_label_phrase(Reference_markss.replaceAll("。", ""), "；", "、",ci);//将词组中的数字和特征名词分开;
            List<List<String>> all_phrase = (List<List<String>>) replace.ShengXu(all_phrase_a, ci);



            String ChongFu = replace.Check_duplicate(all_phrase,ci);//词组去重;

            for(int i=0;i<all_phrase.get(0).size();i++){
                System.out.print(all_phrase.get(0).get(i));
                System.out.print(":");
                System.out.print(all_phrase.get(1).get(i));
                System.out.print(" ");
            }


            if(ChongFu.equals("有重复元素")){   //如果有重复元素 直接提醒;并且退出'
                //设置回话提醒
            }
//            for(int i=0;i<all_phrase.get(all_phrase.size()-1).size();i++){
//                System.out.print(all_phrase.get(0).get(i));
//                System.out.print("");
//                System.out.print(all_phrase.get(all_phrase.size()-1).get(i));
//            }
            /*
                判断是正向序列还是反向序列;
             */
            int ZOF = 0;
            if(fruit.equals("Youxu")){
                //正向序列
                ZOF = 0;
            }else if (fruit.equals("WuXu")){
                //反向序列
                ZOF = 1;
            }


            String new_right_claiming_document = "";  //清洗权利要求书的数据,即，将其中的,替换为，
            String No_theme = ""; //提取清洗后的，未标号的权利要求书中的 主题;
            String Yes_theme = ""; //提取 已裱好 后的 权利要求书中的  主题;


            //正向序列
                //权利要求书中，不是空的；(正向/反向 替换)-根据ZOF的值
                if(right_claiming_document !=null && right_claiming_document.length()>0) {

                    //发现是正向序列;
                    if(ZOF==0){
                        //如果是正向序列，那么需要进行 主题标号清除;

                        //清洗数据,即，将其中的[,]替换为[，]
                        new_right_claiming_document = replace.Cleaning_of_punctuation_marks(right_claiming_document);
                        //提取未标号的主题;
                        No_theme = replace.Unlabeled_Extract_topic(new_right_claiming_document);

                        //替换;
                        //并且获取替换后的权要
                        String claims = replace.Forward_Replacement_claims(all_phrase, new_right_claiming_document, ZOF);
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

                        //反向序列
                    String claims = replace.Forward_Replacement_claims(all_phrase, right_claiming_document, ZOF);
                    session.setAttribute("claims", claims);//设置查询时间的域对象;
                }


                //说明书实施例，不是空的；(正向/反向 替换)-根据ZOF的值
                if(Replace_document != null && Replace_document.length()>0){

                    //发现是正向序列;
                    if(ZOF==0){
                        //清洗数据,即，将其中的,替换为，
                        String new_Replace_document = replace.Cleaning_of_punctuation_marks(Replace_document);
                        //替换;
                        String instructions = replace.Forward_Replacement_instructions(all_phrase, new_Replace_document, ZOF);

                        //查看权利要求书是否是空、并且未标号的权利要求书的主题，并不是error、并且以标号的 权要主题，得有;
                        if( (right_claiming_document !=null) && (right_claiming_document.length()>0)  &&  (!"error".equals(No_theme)) && (Yes_theme.length()>0 && Yes_theme != null)) {
                            String new_instructions = replace.Repair_old_and_new(No_theme, Yes_theme.replaceAll("（","").replaceAll("）",""), instructions);
                            //设置 说明书实施例的 域对象
                            session.setAttribute("instructions",new_instructions); //设置查询结果的域对象;
                        }else {
                            //权利要求书是空的，则 不进行 新旧主题的修补。
                            // 直接输出 说明书实施例内容
                            session.setAttribute("instructions",instructions); //设置查询结果的域对象;
                        }
                    }else if(ZOF==1){
                        //正常的标号，反向序列：
                        String instructions = replace.Forward_Replacement_instructions(all_phrase, Replace_document, ZOF);
                        session.setAttribute("instructions",instructions); //设置查询结果的域对象;
                    }
                }
        }


        resp.setStatus(302);
        resp.sendRedirect(req.getContextPath()+"/First-label.jsp"); //重定向



    }
}
