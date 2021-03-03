/**
 * 
 */

let fullname = document.getElementById("info_fullName");
let dob = document.getElementById("info_dob");
let phone = document.getElementById("info_phone");
let email = document.getElementById("info_email");
let id = document.getElementById("info_id");
let position = document.getElementById("info_position");
let amount = document.getElementById("info_amount");

function getEmployee(){
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://3.141.97.16:8088/ExpenseReimbursementSystem/api/viewProfile')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let employee = JSON.parse(xhr.response)
			
			fullname.textContent = employee.first_name + " " + employee.last_name
			let parsedDob = new Date(employee.dob)
			dob.textContent = parsedDob.getFullYear() + "-" + parsedDob.getMonth()+ "-" + parsedDob.getDay()
			let parsedPhone = employee.prim_phone
			let parsedPhoneString = parsedPhone.toString()

			let str = parsedPhoneString.substring(0,3)
			let str1 = parsedPhoneString.substring(3,6)
			let str2 = parsedPhoneString.substring(6)
			
			phone.textContent = str + "-" + str1 + "-" + str2
			email.textContent = employee.email
			id.textContent = employee.empl_id
			position.textContent = employee.position
			amount.textContent = employee.amount_reimbursed_of_the_year
			
			
			
		}
	}
	
}

window.onload = () => {
	getEmployee()
	editphone_div.hidden = true;
}

let editphone_div = document.getElementById("editphone_div")
let button_phone = document.getElementById("phone_update")
let phone_input = document.getElementById("phone")
let phone_after_massage = document.getElementById("phone_after_massage")

button_phone.addEventListener("click", function(){
	
	let phone_rex = /[0-9]{3}-[0-9]{3}-[0-9]{4}/
	
	if(button_phone.textContent == "Update Phone Number"){
		editphone_div.hidden = !editphone_div.hidden;
		phone_after_massage.textContent = "";
	}else if(phone_rex.test(phone_input)){
		
		alert("Phone number has been updated!")
	}
	
	
	if(!editphone_div.hidden){
		button_phone.textContent = "Confirm Update"
	}else{
		button_phone.textContent = "Update Phone Number"
	}
});


