window.onload = function(){
	var promos = document.getElementById("PromoAsideBody");
	var items = promojson.promos;

	for(var i = 0; i < items.length && i < 4; i++)
	{
		var div = document.createElement("div");
		div.setAttribute("class", "promotionaside");
		promos.appendChild(div);
		
		var img = document.createElement("img");
		img.src = items[i].image;
		
		div.appendChild(img);
		
		var h4promo = document.createElement("h4");
		h4promo.innerHTML = items[i].promo;
		
		div.appendChild(h4promo);
		
		var poldprice = document.createElement("p");
		poldprice.innerHTML = "De: " + items[i].oldprice;
		
		div.appendChild(poldprice);
		
		var pnewprice = document.createElement("p");
		pnewprice.innerHTML = "Por: " + items[i].newprice;
		
		div.appendChild(pnewprice);		
	}
	
	/*
	var button = document.getElementById("Cadastrar");
	button.attachEvent('onclick', 
		function(){
			window.location.href="Register.html";
		}
	)
	*/
};