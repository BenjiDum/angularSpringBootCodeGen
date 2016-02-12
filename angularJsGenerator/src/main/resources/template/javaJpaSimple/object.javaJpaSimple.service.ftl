
package ${packageCommonsName};


import ${packageName}.dao.${objectNameUpper}DAO;
import ${packageName}.service.${objectNameUpper}Service;
import ${packageCommonsName}.${objectNameUpper};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ${objectNameUpper}Service {

	private static final Logger logger = LoggerFactory.getLogger(${objectNameUpper}Service.class);

	@Autowired
	private ${objectNameUpper}DAO ${objectName}DAO;

	public byte[] exportData(String filename){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(baos, StandardCharsets.UTF_16LE.name()));

			//WRITE FILE HEADER
			//Write file first line
			<#assign attributes = listDatabaseElt>
			<#list attributes as attribut>
				writer.append("${attribut.upperName}");
				writer.append(';');
			</#list>
			writer.append("\r\n");

			//WRITE FILE BODY CONTENT
			List<${objectNameUpper}> ${objectNameUpper}List = ${objectName}DAO.findAll();

			for (${objectNameUpper} element : ${objectNameUpper}List){
				<#assign attributes = listDatabaseElt>
				<#list attributes as attribut>
				writer.append(element.get${attribut.upperName}());
				writer.append(';');
				</#list>
				writer.append("\r\n");
			}
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			logger.error("IOException : "+e.getMessage());
		}
		String lBaos = "";
		try {
			lBaos = baos.toString(StandardCharsets.UTF_16LE.name());
		} catch (UnsupportedEncodingException e) {
			logger.error("Exception during buffer conversion: " + e.getMessage());
		}
		byte[] result = lBaos.getBytes();
		return result;
	}

}




