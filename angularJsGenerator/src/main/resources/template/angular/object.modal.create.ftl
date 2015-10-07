<script type="text/ng-template" id="${objectName}CreateModalContent.html">
	<div class="modal-header">
		<div class="button-close"><button class="btn btn-danger glyphicon glyphicon-remove" ng-click="cancel()" ></button></div>
		<h3 class="modal-title">Create an ${objectName}</h3>
	</div>
	<form novalidate class="simple-form">
		<div class="modal-body">
			<#assign attributes = listElement>
        	<#list attributes as attr>
				<div class="row">
					<label for="${attr}Create" class="col-sm-2 control-label">${attr} : </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="${attr}Create" value="{{created${objectNameUpper}.${attr}}}" ng-model="created${objectNameUpper}.${attr}">
					</div>
				</div>
				<br/>
			</#list>
		</div>
		<div class="modal-footer">
			 <button title="Validate" type="submit" class="btn btn-primary glyphicon glyphicon-ok" ng-click="edit(created${objectNameUpper})" ></button>
			<button title="Cancel" class="btn btn-warning glyphicon glyphicon-new-window" ng-click="cancel()"></button>
		</div>
	</form>
</script>
