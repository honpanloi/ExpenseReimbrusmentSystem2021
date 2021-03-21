/**
 * 
 */

let photoInput = document.getElementById("photoInput")

let uploadButton = document.getElementById("uploadButton")

uploadButton.addEventListener("click", function(){

	let photo = photoInput.files[0]
	//console.log(photo.size)

	let xhr = new XMLHttpRequest();

	var formData = new FormData();
	formData.append("photo", photo)
	xhr.open('POST', 'http://localhost:8080/ExpenseReimbursementSystem/api/upload')
	xhr.send(formData)
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			
			console.log("file uploaded!")
			
		}else{
			console.log("file not uploaded...")
		}
	}
})
