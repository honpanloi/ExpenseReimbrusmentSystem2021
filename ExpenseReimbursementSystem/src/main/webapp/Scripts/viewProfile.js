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

	xhr.open('GET', 'http://localhost:8080/ExpenseReimbursementSystem/api/viewProfile')
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
}



