document.addEventListener("DOMContentLoaded",()=>{

const search=document.getElementById("searchBilling");

if(search){

search.addEventListener("keyup",()=>{

const value=search.value.toLowerCase();

document.querySelectorAll("#billingTable tr").forEach(row=>{

row.style.display=row.innerText.toLowerCase().includes(value)?"":"none";

});

});

}

document.querySelectorAll(".deleteBilling").forEach(btn=>{

btn.onclick=function(){

return confirm("Delete Bill?");

}

});

});