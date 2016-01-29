package ${packageName}.controller;

import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;

import ${packageName}.dao.${objectNameUpper}DAO;
import ${packageName}.service.${objectNameUpper}Service;
import ${packageCommonsName}.${objectNameUpper};



@RestController
@RequestMapping("${springDataRestBaseUri}")
public class ${objectNameUpper}Controller {

	
	private static Logger logger = Logger.getLogger(${objectNameUpper}Controller.class);
	
	@Autowired
	private ${objectNameUpper}DAO ${objectName}DAO;

	@Autowired
	private ${objectNameUpper}Service ${objectName}Service;
	
	@RequestMapping(value="/v1/${objectName}/all", method = RequestMethod.GET)
	public List<${objectNameUpper}> getAll${objectNameUpper}() {
		return ${objectName}DAO.findAll();
	}

	@RequestMapping(value="/v1/${objectName}/create", method = RequestMethod.POST)
	ResponseEntity<?> create${objectNameUpper}(@RequestBody ${objectNameUpper} input) {
		
		${objectName}DAO.create(input);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(input.getId()).toUri());
		return new ResponseEntity<>(input, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/v1/${objectName}/update", method = RequestMethod.POST)
	ResponseEntity<?> update${objectNameUpper}(@RequestParam(value="id") String id, @RequestBody ${objectNameUpper} input) {
		
		${objectName}DAO.createOrUpdate(input);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(input.getId()).toUri());
		return new ResponseEntity<>(input, httpHeaders, HttpStatus.CREATED);
	}
	
	<#assign attributes = listDatabaseElt>
	<#list attributes as attribut>
	@RequestMapping(method = RequestMethod.GET, value = "/v1/${objectName}/findBy${attribut.upperName}/{${attribut.name}}")
	public ${objectNameUpper} findBy${attribut.upperName}(
			@PathVariable("${attribut.name}") String ${attribut.name}) {
		return ${objectName}DAO.findBy${attribut.upperName}(${attribut.name});
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/v1/${objectName}/findAllBy${attribut.upperName}/{${attribut.name}}")
	public List<${objectNameUpper}> findAllBy${attribut.upperName}(
			@PathVariable("${attribut.name}") String ${attribut.name}) {
		return ${objectName}DAO.findAllBy${attribut.upperName}(${attribut.name});
	}
	
	</#list>


	@RequestMapping(value="/v1/${objectName}/exportData", method = RequestMethod.GET)
	@Produces({"text/csv"})
	public void exportCSV${objectNameUpper}(HttpServletResponse response) throws IOException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

		Date formatDate = new Date();

		final String FILE_NAME = "export-${objectName}-"+formatter.format(formatDate)+".csv";

		byte[] csv = ${objectName}Service.exportData(FILE_NAME);

		response.setContentType("text/csv;charset="+StandardCharsets.UTF_16LE.name());
		response.setHeader("Content-Disposition", "attachment; filename="+ FILE_NAME);
		response.setContentLength(csv.length);
		ServletOutputStream out = response.getOutputStream();
		out.write(csv);

	}

		
}