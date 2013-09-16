//$(document).ready(function(){  
//  });
//});

window.onload = function(){
	var promos = document.getElementById("Promos");
	var items = promojson.promos;	
	
	for(var i = 0; i < items.length; i++)
	{
		var div = document.createElement("div");
		div.setAttribute("class", "promotion");
		promos.appendChild(div);
		
		var a = document.createElement("a");
		a.href = "Login.html";		
		
		div.appendChild(a);
		
		var img = document.createElement("img");
		img.src = items[i].image;
		
		a.appendChild(img);		
		
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
}

function Login(){
  alert("Você se logou com sucesso");
}
