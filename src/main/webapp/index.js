const getMyProducts = function() {
	const httpRequest = new XMLHttpRequest();
const request = 'http://localhost:8080/pyrography/webapi/products';
httpRequest.open('GET', request);

httpRequest.onreadystatechange = function() {
	if(httpRequest.readyState == 4 && httpRequest.status == 200) {
		console.log(httpRequest.responseText);
		document.getElementById("arrayOfProducts").innerHTML = httpRequest.responseText
	}
}

httpRequest.send();
}

const clearMyProducts = function() {
	document.getElementById("arrayOfProducts").innerHTML = '';
}