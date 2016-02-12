package ${name};

@Entity
@NamedQueries({
    @NamedQuery(
    name="${name}.findAll",
    query="SELECT entity FROM ${name} entity"
    )
})
<#if audited>
@Audited
@AuditedByDefault
</#if>
public class ${name}<#if audited> extends AuditableEntity</#if> {

	<#assign attributes = attributes>
	<#list attributes as attribut>
    <#if attribut.annotations??>
    <#list attribut.annotations as annot>
        @${annot.name}
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


