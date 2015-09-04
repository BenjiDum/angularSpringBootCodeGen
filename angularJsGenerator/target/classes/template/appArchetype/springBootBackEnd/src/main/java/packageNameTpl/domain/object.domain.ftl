
package ${packageCommonsName}.domain;

import com.agaetis.spring.jdbc.lightorm.annotation.Column;
import com.agaetis.spring.jdbc.lightorm.annotation.Id;
import com.agaetis.spring.jdbc.lightorm.annotation.Table;

@Table("${objectNameTable}")
public class ${objectNameUpper} {

	@Id(autoIncrement = true)
	@Column("id")
	Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	<#assign attributes = listDatabaseElt>
	<#list attributes as attribut>
	@Column("${attribut.dbColumnName}")
	${attribut.javaType} ${attribut.name};
	</#list>
	
	
	<#assign attributesSet = listDatabaseElt>
	<#list attributesSet as attributSet>
	public ${attributSet.javaType} get${attributSet.upperName}() {
		return ${attributSet.name};
	}
	
	public void set${attributSet.upperName}(${attributSet.javaType} ${attributSet.name}) {
		this.${attributSet.name} = ${attributSet.name};
	}
	
	</#list>
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		${objectNameUpper} other = (${objectNameUpper}) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}


