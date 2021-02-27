/**
 * 
 */

let fullname = document.getElementById("info_name");
let empl_id = document.getElementById("info_empl_id");
let manger_name = document.getElementById("info_manger_name");
let amount = document.getElementById("info_amount_reimb");

function getManager(){
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://localhost:8080/ExpenseReimbursementSystem/api/viewManagerByEmployeeID')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let manager = JSON.parse(xhr.response)
			
			console.log(manager)
			
			manger_name.textContent = manager.first_name + " " + manager.last_name
			
		}
	}
}

function getEmployee(){
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://localhost:8080/ExpenseReimbursementSystem/api/viewProfile')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let employee = JSON.parse(xhr.response)
			
			fullname.textContent = employee.first_name + " " + employee.last_name
			empl_id.textContent = employee.empl_id
			amount.textContent = "$"+employee.amount_reimbursed_of_the_year
			
		}
	}
	
}

window.onload = () => {
	getManager()
	getEmployee()
}