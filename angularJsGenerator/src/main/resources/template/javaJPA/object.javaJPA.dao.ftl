package ${packageName}.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

import com.agaetis.spring.jdbc.lightorm.repository.LightOrmCrudRepository;
import ${packageCommonsName}.${objectNameUpper};

@Repository
public class ${objectNameUpper}DAO extends LightOrmCrudRepository<${objectNameUpper}>  {

	private static Logger logger = Logger.getLogger(${objectNameUpper}DAO.class);
	
	@Override
	public Class<${objectNameUpper}> getTableClass() {
		return ${objectNameUpper}.class;
	}

	public ${objectNameUpper} create(${objectNameUpper} ${objectName}) {
		return super.create(${objectName});
	}
	
	public void update(${objectNameUpper} ${objectName}) {
		super.update(${objectName});
	}
	
	public ${objectNameUpper} createOrUpdate(${objectNameUpper} ${objectName}) {
		return super.createOrUpdate(${objectName});
	}
	
	public void delete(${objectNameUpper} ${objectName}) {
		super.delete(${objectName});
	}
	
	<#assign attributes = listDatabaseElt>
	<#list attributes as attribut>
	public ${objectNameUpper} findBy${attribut.upperName}(String ${attribut.name}) {
		${objectNameUpper} result  = null;
		result = getJdbcTemplate().queryForObject(
				"select * from " + getEscapedTableName()
						+ " where  ${attribut.dbColumnName} =?", getRowMapper(),
				${attribut.name});
		return result;
	}
	
	public List<${objectNameUpper}> findAllBy${attribut.upperName}(String ${attribut.name}) {
		
		List<${objectNameUpper}> lResult = new ArrayList<${objectNameUpper}>();

		lResult = getJdbcTemplate().query(
				"select * from " + getEscapedTableName()
						+ " where ${attribut.dbColumnName} =?",
				getRowMapper(), ${attribut.name});

		return lResult;
		
	}
	
	</#list>
	
}