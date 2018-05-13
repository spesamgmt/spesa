package com.spesa.codeGenerator.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.spesa.pojo.DTO.CodeGeneratorDTO;
import com.spesa.pojo.DTO.FieldDTO;

public class CodeWritingUtility {

	public String  controllerName = "";
	public String   formName = "";



	public void writeJSP( CodeGeneratorDTO CodeGeneratorDTO , String contextPath){

		PrintWriter writer =  null;

		try {
			String[] tokens = CodeGeneratorDTO.getTitle().split("\\s");
			for (int i = 0; i < tokens.length; i++) {
				String token = tokens[i];
				controllerName = controllerName + token.substring(0, 1).toUpperCase() + token.substring(1, token.length());
			}
			System.out.println(controllerName);
			formName = Character.toLowerCase(controllerName.charAt(0)) + controllerName.substring(1, controllerName.length());
			System.out.println(formName);


			if(CodeGeneratorDTO.getFieldList()!= null && CodeGeneratorDTO.getFieldList().size() != 0){
				System.out.println(new File("C:\\generated_code\\"+formName+"\\JSPs").mkdirs());
				File file = new File("C:\\generated_code\\"+formName+"\\JSPs");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+formName+"JSP.jsp", "UTF-8");

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
						"<title>"+CodeGeneratorDTO.getTitle()+"</title>\n"+
						"</head>\n"+
						"<body >\n"+
						"<div class='col-md-10 first-one'>\n"+
						"<div class='first-one-inner'>\n"+
						" <h3 class='tittle'>"+CodeGeneratorDTO.getTitle()+"</h3>\n");

				writer.println("<form:form action='"+contextPath+"/all/"+formName+"/save' method='post' commandName='"+formName+"' >\n"+
						"<%@ include file='/JSPs/acknowledgement.jsp' %>	\n");

				for(FieldDTO FieldDTO : CodeGeneratorDTO.getFieldList()){
					writer.println("<div>\n");
					if(FieldDTO.getElement().equals("radiobutton" )){
						String[] labels  = FieldDTO.getLabel().split(",");
						for(String label :labels){
							writer.println("<form:radiobutton path='"+FieldDTO.getPath()+"' value='"+label+"'/>"+label+"\n"+
									"<font color='red'><form:errors path='"+FieldDTO.getPath()+"' /></font>\n");
						}
					}else if (FieldDTO.getElement().equals("textarea")){
						writer.println("<form:textarea rows=\"5\" cols=\"30\" placeholder='"+FieldDTO.getLabel()+"' path='"+FieldDTO.getPath()+"' class='text' />\n");
					}else{

						writer.println("<form:input type='"+FieldDTO.getElement()+"' placeholder='"+FieldDTO.getLabel()+"' path='"+FieldDTO.getPath()+"' class='text' />\n");
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


	public void writeController( CodeGeneratorDTO CodeGeneratorDTO , String contextPath){

		PrintWriter writer =  null;

		try {

			if(CodeGeneratorDTO.getFieldList()!= null && CodeGeneratorDTO.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\controller").mkdirs());
				File file = new File("C:\\generated_code\\"+formName+"\\controller");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"Controller.java", "UTF-8");


				writer.println("package com.spesa."+formName+".controller;\n"+
						"import java.util.ArrayList;\n"+
						"import java.util.List;\n"+

				"import javax.servlet.http.HttpServletRequest;\n"+
				"import org.springframework.stereotype.Controller;\n"+
				"import org.springframework.web.bind.annotation.ModelAttribute;\n"+
				"import org.springframework.web.bind.annotation.RequestMapping;\n"+
				"import org.springframework.web.bind.annotation.RequestMethod;\n"+
				"import org.springframework.web.servlet.ModelAndView;\n"+
				"import com.spesa."+formName+".service."+controllerName+"Service;\n"+
				"import com.spesa.pojo.DTO."+controllerName+"DTO;\n\n"+
				
				"@Controller\n"+
				"@RequestMapping(method=RequestMethod.GET,  value=\"/"+formName+"\")"+
				"public class "+controllerName+"Controller {\n\n\n"+
				
				"@Autowired\n"+
					"private "+controllerName+"Service "+formName+"ServiceImpl;\n\n"+
					
					"@RequestMapping(method=RequestMethod.GET,  value=\"/create\")\n"+
					"public ModelAndView loadCreatePage(){\n"+
					"ModelAndView modelAndView = new ModelAndView();\n"+
					controllerName+"DTO "+formName+"DTO = new "+controllerName+"DTO();\n"+
					"modelAndView.addObject(\""+formName+"\", "+formName+"DTO);\n"+
					"			modelAndView.setViewName(\""+formName+"JSP\");\n"+	
					"			return modelAndView;\n"+
						"		}\n\n\n");


				writer.println("@RequestMapping(method=RequestMethod.POST,  value=\"/save\")\n"+
						"public ModelAndView save"+controllerName+"(@ModelAttribute(\""+formName+"\") "+controllerName+"DTO "+formName+"DTO){\n"+
						"System.out.println(\"saving part here\");\n"+	
						"ModelAndView modelAndView = new ModelAndView();\n\n"+
						""+formName+"ServiceImpl.add"+controllerName+"("+formName+"DTO);\n"+
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

	public void writeForm( CodeGeneratorDTO CodeGeneratorDTO ){

		PrintWriter writer =  null;

		try {

			if(CodeGeneratorDTO.getFieldList()!= null && CodeGeneratorDTO.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\DTOandDo").mkdirs());
				File file = new File("C:\\generated_code\\"+formName+"\\DTOandDo");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"DTO.java", "UTF-8");

				writer.println(
						"package com.spesa.pojo.DTO;\n"+
						"import java.util.List;\n"+
						"public class "+controllerName+"DTO{\n\n\n");

				for(FieldDTO FieldDTO : CodeGeneratorDTO.getFieldList()){
					writer.println("private String "+FieldDTO.getPath()+";\n");
				}


				for(FieldDTO FieldDTO : CodeGeneratorDTO.getFieldList()){

					String variable = Character.toUpperCase(FieldDTO.getPath().charAt(0)) + FieldDTO.getPath().substring(1, FieldDTO.getPath().length());
					writer.println("public String get"+variable+"() {\n"+
							"return "+FieldDTO.getPath()+";\n"+
							"}");
				}

				for(FieldDTO FieldDTO : CodeGeneratorDTO.getFieldList()){
					String variable = Character.toUpperCase(FieldDTO.getPath().charAt(0)) + FieldDTO.getPath().substring(1, FieldDTO.getPath().length());
					writer.println("public void set"+variable+"(String "+FieldDTO.getPath()+") {\n"+
							"this."+FieldDTO.getPath()+" = "+FieldDTO.getPath()+";\n"+
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
	
	public void writeDo( CodeGeneratorDTO CodeGeneratorDTO ){

		PrintWriter writer =  null;

		try {

			if(CodeGeneratorDTO.getFieldList()!= null && CodeGeneratorDTO.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\DTOandDo").mkdirs());
				File file = new File("C:\\generated_code\\"+formName+"\\DTOandDo");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"Mst.java", "UTF-8");

				writer.println(
						"package com.spesa.pojo.DO;\n"+
						"import java.util.List;\n"+
						"public class "+controllerName+"Mst{\n\n\n");

				for(FieldDTO FieldDTO : CodeGeneratorDTO.getFieldList()){
					writer.println("private String "+FieldDTO.getPath()+";\n");
				}


				for(FieldDTO FieldDTO : CodeGeneratorDTO.getFieldList()){

					String variable = Character.toUpperCase(FieldDTO.getPath().charAt(0)) + FieldDTO.getPath().substring(1, FieldDTO.getPath().length());
					writer.println("public String get"+variable+"() {\n"+
							"return "+FieldDTO.getPath()+";\n"+
							"}");
				}

				for(FieldDTO FieldDTO : CodeGeneratorDTO.getFieldList()){
					String variable = Character.toUpperCase(FieldDTO.getPath().charAt(0)) + FieldDTO.getPath().substring(1, FieldDTO.getPath().length());
					writer.println("public void set"+variable+"(String "+FieldDTO.getPath()+") {\n"+
							"this."+FieldDTO.getPath()+" = "+FieldDTO.getPath()+";\n"+
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
	
	public void writeService( CodeGeneratorDTO CodeGeneratorDTO , String contextPath){

		PrintWriter writer =  null;

		try {

			if(CodeGeneratorDTO.getFieldList()!= null && CodeGeneratorDTO.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\service").mkdirs());
				File file = new File("C:\\generated_code\\"+formName+"\\service");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"Service.java", "UTF-8");


				writer.println("package com.spesa."+formName+".service;\n"+
						"import java.util.List;\n"+
				
				"import com.spesa.pojo.DTO."+controllerName+"DTO;\n\n"+
				
				"public interface "+controllerName+"Service {\n\n\n"+
				
				"public void add"+controllerName+"("+controllerName+"DTO "+formName+"DTO);\n");
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
	
	public void writeServiceImpl( CodeGeneratorDTO CodeGeneratorDTO , String contextPath){

		PrintWriter writer =  null;

		try {

			if(CodeGeneratorDTO.getFieldList()!= null && CodeGeneratorDTO.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\service").mkdirs());
				File file = new File("C:\\generated_code\\"+formName+"\\service");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"ServiceImpl.java", "UTF-8");


				writer.println("package com.spesa."+formName+".service;\n"+
						"import java.util.List;\n"+
				"import org.springframework.beans.factory.annotation.Autowired;\n"+
				"import org.springframework.stereotype.Service;\n"+

				"import com.spesa."+formName+".DAO."+controllerName+"DAO;\n"+
				"import com.spesa.pojo.DTO."+controllerName+"DTO;\n\n"+
				
				"@Service\n"+
				"public class "+controllerName+"ServiceImpl implements "+controllerName+"Service{\n\n\n"+

				"@Autowired\n"+
				"private "+controllerName+"DAO  "+formName+"DAO;\n"+
				
				"public void add"+controllerName+"("+controllerName+"DTO "+formName+"DTO){\n"+
					formName+"DAO.add"+controllerName+"("+formName+"DTO);\n");
				writer.print("}\n");
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
	
	public void writeDAO( CodeGeneratorDTO CodeGeneratorDTO , String contextPath){

		PrintWriter writer =  null;

		try {

			if(CodeGeneratorDTO.getFieldList()!= null && CodeGeneratorDTO.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\DAO").mkdirs());
				File file = new File("C:\\generated_code\\"+formName+"\\DAO");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"DAO.java", "UTF-8");


				writer.println("package com.spesa."+formName+".DAO;\n"+
						"import java.util.List;\n"+
				
				"import com.spesa.pojo.DTO."+controllerName+"DTO;\n\n"+
				
				"public interface "+controllerName+"DAO {\n\n\n"+
				
				"public void add"+controllerName+"("+controllerName+"DTO "+formName+"DTO);\n");
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

	public void writeDaoImpl( CodeGeneratorDTO CodeGeneratorDTO , String contextPath){

		PrintWriter writer =  null;

		try {

			if(CodeGeneratorDTO.getFieldList()!= null && CodeGeneratorDTO.getFieldList().size() != 0){

				System.out.println(new File("C:\\generated_code\\"+formName+"\\DAO").mkdirs());
				File file = new File("C:\\generated_code\\"+formName+"\\DAO");
				writer = new PrintWriter(file.getAbsolutePath()+"\\"+controllerName+"DaoImpl.java", "UTF-8");


				writer.println("package com.spesa."+formName+".DAO;\n"+
						"import java.util.List;\n"+
				
				"import com.spesa.pojo.DTO."+controllerName+"DTO;\n\n"+
				"import com.spesa.pojo.DO."+controllerName+"Mst;\n\n"+
				"import org.hibernate.SessionFactory;\n"+
				"import org.springframework.beans.BeanUtils;\n"+
				"import org.springframework.beans.factory.annotation.Autowired;\n"+
				"import org.springframework.stereotype.Repository;\n\n"+
				"@Repository\n"+
				"public class "+controllerName+"DaoImpl implements "+controllerName+"DAO{\n\n\n"+

				"@Autowired\n"+
				"private SessionFactory sessionFactory;\n"+
				
				"public void add"+controllerName+"("+controllerName+"DTO "+formName+"DTO) {\n"+
				controllerName+"Mst "+formName+"Mst = new "+controllerName+"Mst(); \n"+
				"BeanUtils.copyProperties("+formName+"DTO, "+formName+"Mst);\n"+
						"sessionFactory.getCurrentSession().saveOrUpdate("+formName+"Mst);\n"+
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

}
