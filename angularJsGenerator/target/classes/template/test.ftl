<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Our latest product:
  <a href="${latestProduct.url}">${latestProduct.name}</a>!
  
  
  	<#assign seq = listElement>
	<#list seq as x>
	  ${x_index + 1}. ${x}<#if x_has_next>,</#if>
	</#list>  
  
</body>
</html>  