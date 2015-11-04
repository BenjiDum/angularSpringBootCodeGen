<alert id="steperrors" ng-repeat="alert in alerts" type="danger" close="closeAlert($index)">{{alert.msg}}</alert>

<div ng-include src="'${objectName}/${objectName}.create.partial.html'"></div>
<div ng-include src="'${objectName}/${objectName}.edit.partial.html'"></div>

<br/>

<div>
	<button class="btn btn-primary" ng-click="openCreateModal()">Create an ${objectName}</button>
    <a ng-href="{{urlExportData}}" class="btn btn-primary">Export Date</a>
</div>
<br/>
<div id="list-${objectName}Information" class="content scaffold-list" role="main">
    <h1>Liste des ${objectName}</h1>

    <table class="table table-hover table-nomargin table-bordered" id="${objectName}Information">
        <thead>
            <tr>
            	<#assign attributes = listElement>
            	<#list attributes as attr>
				<th>${attr}</th>
				</#list>
                <th>Edition ?</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="${objectName} in ${objectName}List">
            	<#assign attributes = listElement>
            	<#list attributes as attr>
				<td>{{${objectName}.${attr}}}</td>
				</#list>
                <td>
                    <button title="Edit" class="btn btn-primary glyphicon glyphicon-pencil" ng-click="openEditModal(${objectName})"></button>
                </td>
            </tr>
        </tbody>
    </table>
</div>