<script type="text/ng-template" id="${objectName}CreateModalContent.html">
	<div class="modal-header">
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
			 <input type="submit" class="btn btn-primary" ng-click="edit(created${objectNameUpper})" value="Save"></button>
			<button class="btn btn-warning" ng-click="cancel()">Cancel</button>
		</div>
	</form>
</script>
