function myFunction()
{
var regExp = /\(([^)]+)\)/;
var selectedModelNumber = regExp.exec(document.getElementById('car-models').value);
var spanElement=document.getElementById('model-number').innerHTML= selectedModelNumber[1];

document.getElementById('btn-click').addEventListener('click', function()
{
var link = document.getElementById('car-models').value;
var finalURL="";
for(let i=0; i< link.length;i++){
if(link.charAt(i)=== "("){
break;
}
else{
finalURL=finalURL.concat(link.charAt(i));
}
}
window.location.href= finalURL + '.html';
//console.log(finalURL);
})

}

