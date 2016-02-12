

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private long id;

@Column(nullable = false)
private String name;

@Column(nullable = false)
private String jsonValue;

public long getId() {
return id;
}

public void setId(long id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getJsonValue() {
return jsonValue;
}

public void setJsonValue(String jsonValue) {
this.jsonValue = jsonValue;
}
}




package ${packageName};

import javax.persistence.*;


@Entity
public class ${name} {

	<#assign attributes = attributes>
	<#list attributes as attribut>
    <#if attribut.annotations??>
    <#list attribut.annotations as annot>
        @${annot.name}<#if annot.parameters??><#list annot.parameters as annotParam>(${annotParam.name} = ${annotParam.value}<#sep>,)</#list></#if>
    </#list>
    </#if>
    <#if attribut.listObject>
        List<${attribut.type}> ${attribut.name};
    <#else>
        ${attribut.type} ${attribut.name};
    </#if>

	</#list>

    <#list attributes as attribut>
        public ${attribut.type} get${attribut.upperLetterName}() {
            return ${attribut.name};
        }

        public void set${attribut.upperLetterName}(${attribut.type} ${attribut.name}) {
            this.${attribut.name} = ${attribut.name};
        }

    </#list>

}


