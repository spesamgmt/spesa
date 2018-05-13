package com.spesa.codeGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.spesa.codeGenerator.form.CodeGeneratorForm;
import com.spesa.codeGenerator.form.FieldForm;

public class CodeWritingUtility {

	public String  controllerName = "";
	public String   formName = "";



	public void writeJSP( CodeGeneratorForm codeGeneratorForm , String contextPath){

		PrintWriter writer =  null;

		try {
			String[] tokens = codeGeneratorForm.getTitle().split("\\s");
			for (int i = 0; i < tokens.length; i++) {
				String token = tokens[i];
				controllerName = controllerName + token.substring(0, 1).toUpperCase() + token.substring(1, token.length());
			}
			System.out.println(controllerName);
			formName = Character.toLowerCase(controllerName.charAt(0)) + controllerName.substring(1, controllerName.length());
			System.out.println(formName);


			if(codeGeneratorForm.getFieldList()!= null && codeGeneratorForm.getFieldList().size() != 0){
				writer = new PrintWriter("C:\\generated_code\\JSPs\\"+formName+"JSP.jsp", "UTF-8");

				writer.println("<%@ page language='java' contentType='text/html; charset=ISO-8859-1' pageEncoding='ISO-8859-1'%>\n"+
						"<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form'%>\n"+
						"<%@ taglib uri='http://www.springframework.org/tags' prefix='spring'%>\n"+
						"<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>\n"+
						"<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>\n"+
						"<html>\n"+
						"<head>\n"+
						"<link href='"+contextPath+"/css/bootstrap.css' rel='stylesheet' type='text/css' media='all'>\n"+
						"<link href='"+contextPath+"/css/style.css' rel='stylesheet' type='text/css' media='all'/>\n"+
						"<script src='"+contextPath+"/js/jQuery_v3.2.1.js' type='text/javascript'></script>\n"+
						"<script src='"+contextPath+"/js/angular.min_v1.6.6.js' type='text/javascript'></script>\n");


				writer.println("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>\n"+
						"<title>"+codeGeneratorForm.getTitle()+"</title>\n"+
						"</head>\n"+
						"<body >\n"+
						"<div class='col-md-10 first-one'>\n"+
						"<div class='first-one-inner'>\n"+
						" <h3 class='tittle'>"+codeGeneratorForm.getTitle()+"</h3>\n");

				writer.println("<form:form action='"+contextPath+"/all/"+formName+"/save' method='post' commandName='"+formName+"' >\n"+
						"<%@ include file='/JSPs/acknowledgement.jsp' %>	\n");

				for(FieldForm fieldForm : codeGeneratorForm.getFieldList()){
					writer.println("<div>\n");
					if(fieldForm.getElement().equals("radiobutton" )){
						String[] labels  = fieldForm.getLabel().split(",");
						for(String label :labels){
							writer.println("<form:radiobutton path='"+fieldForm.getPath()+"' value='"+label+"'/>"+label+"\n"+
									"<font color='red'><form:errors path='"+fieldForm.getPath()+"' /></font>\n");
						}
					}else if (fieldForm.getElement().equals("textarea")){
						writer.println("<form:textarea rows=\"5\" cols=\"30\" placeholder='"+fieldForm.getLabel()+"' path='"+fieldForm.getPath()+"' class='text' />\n");
					}else{

						writer.println("<form:input type='"+fieldForm.getElement()+"' placeholder='"+fieldForm.getLabel()+"' path='"+fieldForm.getPath()+"' class='text' />\n");
					}

					writer.println("</div>\n");
				}		

				writer.println("<div class='submit'><input type='button' value='back' onclick=\"window.location.href='"+contextPath+"';\"> <input type='submit' value='save' ></div>\n"+
						"</form:form>\n"+
						"</div>\n"+
						"</div>\n"+

				"</body>\n"+
						"</html>\n");
				writer.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 


	public void writeController( CodeGeneratorForm codeGeneratorForm , String contextPath){

		PrintWriter writer =  null;

		try {

			if(codeGeneratorForm.getFieldList()!= null && codeGeneratorForm.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\controller").mkdirs());
				File file = new File("C:\\Saurabh\\Study stuffs\\base_Arch\\CodeGenerationUtility\\src\\main\\java\\com\\carRental\\"+formName+"\\controller");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"Controller.java", "UTF-8");


				writer.println("package com.carRental."+formName+".controller;\n"+
						"import java.util.ArrayList;\n"+
						"import java.util.List;\n"+

"import javax.servlet.http.HttpServletRequest;\n"+
"import org.springframework.stereotype.Controller;\n"+
"import org.springframework.web.bind.annotation.ModelAttribute;\n"+
"import org.springframework.web.bind.annotation.RequestMapping;\n"+
"import org.springframework.web.bind.annotation.RequestMethod;\n"+
"import org.springframework.web.servlet.ModelAndView;\n"+

"import com.carRental."+formName+".form."+controllerName+"Form;\n\n"+

"@Controller\n"+
"@RequestMapping(method=RequestMethod.GET,  value=\"/"+formName+"\")"+
"public class "+controllerName+"Controller {\n\n\n"+


	"@RequestMapping(method=RequestMethod.GET,  value=\"/create\")\n"+
	"public ModelAndView loadCreatePage(){\n"+
	"ModelAndView modelAndView = new ModelAndView();\n"+
	controllerName+"Form "+formName+"Form = new "+controllerName+"Form();\n"+
	"modelAndView.addObject(\""+formName+"\", "+formName+"Form);\n"+
	"			modelAndView.setViewName(\""+formName+"JSP\");\n"+	
	"			return modelAndView;\n"+
						"		}\n\n\n");


				writer.println("@RequestMapping(method=RequestMethod.POST,  value=\"/save\")\n"+
						"public ModelAndView save"+controllerName+"(@ModelAttribute(\""+formName+"\") "+controllerName+"Form "+formName+"Form){\n"+
						"System.out.println(\"saving part here\");\n"+	
						"ModelAndView modelAndView = new ModelAndView();\n\n"+

					"return modelAndView;\n"+
						"}\n");
				writer.print("}\n");

				writer.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeForm( CodeGeneratorForm codeGeneratorForm ){

		PrintWriter writer =  null;

		try {

			if(codeGeneratorForm.getFieldList()!= null && codeGeneratorForm.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\form").mkdirs());
				File file = new File("C:\\Saurabh\\Study stuffs\\base_Arch\\CodeGenerationUtility\\src\\main\\java\\com\\carRental\\"+formName+"\\form");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"Form.java", "UTF-8");

				writer.println(
						"package com.carRental."+formName+".form;\n"+
						"import java.util.List;\n"+
						"public class "+controllerName+"Form {\n\n\n");

				for(FieldForm fieldForm : codeGeneratorForm.getFieldList()){
					writer.println("private String "+fieldForm.getPath()+";\n");
				}


				for(FieldForm fieldForm : codeGeneratorForm.getFieldList()){

					String variable = Character.toUpperCase(fieldForm.getPath().charAt(0)) + fieldForm.getPath().substring(1, fieldForm.getPath().length());
					writer.println("public String get"+variable+"() {\n"+
							"return "+fieldForm.getPath()+";\n"+
							"}");
				}

				for(FieldForm fieldForm : codeGeneratorForm.getFieldList()){
					String variable = Character.toUpperCase(fieldForm.getPath().charAt(0)) + fieldForm.getPath().substring(1, fieldForm.getPath().length());
					writer.println("public void set"+variable+"(String "+fieldForm.getPath()+") {\n"+
							"this."+fieldForm.getPath()+" = "+fieldForm.getPath()+";\n"+
							"}");
				}
				writer.println("}");

				writer.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
