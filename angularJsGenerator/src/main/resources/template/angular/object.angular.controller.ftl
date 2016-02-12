'use strict';

angular.module('${angularModuleName}')
    .controller('${lowerCaseName}Controller', [function () {
        var self = this;
        self.entity = {
            type: '${name}',
            id: '${idField}'
        };

        self.columns = [
            <#assign attributes = attributes>
            <#list attributes as attribut>
            <#if attribut.tabView??>
            <#if attribut.tabView>
            {name : '${attribut.name}',                        field :'${attribut.name};'}<#sep>,
            </#if>
            </#if>
            </#list>
        ]

        self.previewFields = [
        <#list attributes as attribut>
            <#if attribut.previewView??>
                <#if attribut.previewView>
                {name : '${attribut.name}',                        field :'${attribut.name};'}<#sep>,
                </#if>
            </#if>
        </#list>
        ]

        self.editFields = [
        <#list attributes as attribut>
            <#if attribut.editView??>
                <#if attribut.editView>
                {name : '${attribut.name}',                        field :'${attribut.name};'}<#sep>,
                </#if>
            </#if>
        </#list>
        ]

}]);