// $(document).ready(function(){
//   $("#btn1").click(function(){
//     $("#test1").text("Hello world!");
//   });
//   $("#btn2").click(function(){
//     $("#test2").html("<b>Hello world!</b>");
//   });
//   $("#btn3").click(function(){
//     $("#test3").val("Dolly Duck");
//   });
// });

// $(document).ready(adjustmargin("enumeration"));

function adjustmargin(enumeration){
	// document.write("Hello World");
	// console.log("");
	// print("Hello");
	var x = document.getElementByClassName("enumeration").parentElement.style.color;
	document.write(x);
	// print(x);
}

function swap(id1,id2) {
	let cont1 = document.getElementById(id1).innerHTML;
	let cont2 = document.getElementById(id2).innerHTML;
	document.getElementById(id1).innerHTML = cont2;
	document.getElementById(id2).innerHTML = cont1;
}

function insertion(id1,status){
	var elements = document.getElementsByClassName(id1);
	var action = "none";
	if(status=="1"){
		action = "inline";
	}
	for(var i = 0;i<elements.length;i++){
		elements[i].style.display = action;
	}
}

function omission(class_name, id, status){
	var element1 = document.getElementsByClassName(class_name)[0];
	var element2 = document.getElementById(id);
	var action1 = "inline";
	var action2 = "none";
	if(status==0){
		action1 = "none";
		action2 = "inline";
	}
	let cont1 = element1.innerHTML;
	let cont2 = element2.innerHTML;
	element1.innerHTML = cont2;
	element2.innerHTML = cont1;
	element1.style.display = action1;
	element2.style.display = action2;
}

function substitution(class_name, id){
	var element1 = document.getElementsByClassName(class_name)[0];
	var element2 = document.getElementById(id);
	let cont1 = element1.innerHTML;
	let cont2 = element2.innerHTML;
	element1.innerHTML = cont2;
	element2.innerHTML = cont1;
}

