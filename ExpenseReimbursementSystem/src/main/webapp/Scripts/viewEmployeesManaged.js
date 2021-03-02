/**
 * 
 */
let empl_id = document.getElementById("empl_id")
let view_btn = document.getElementById("view_btn")

view_btn.addEventListener("click", function(){
	if(empl_id){
		
	}
})


let d = "discription"
let i = "info"

function getAllEmployees(){
	let xhr = new XMLHttpRequest()

	xhr.open('GET', 'http://localhost:8080/ExpenseReimbursementSystem/api/getEmployeesManaged')
	xhr.send()
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			let allEmployees = JSON.parse(xhr.response)

			for (e of allEmployees){
				
				//generate description text
				let id_dis = document.createElement('p')
				id_dis.className = d
				id_dis.textContent = "Employee ID:"
				
				let empl_name_dis = document.createElement('p')
				empl_name_dis.className = d
				empl_name_dis.textContent = "Name:"
				
				let dob_dis = document.createElement("p")
				dob_dis.className = d
				dob_dis.textContent = "Date of birth:"
				
				let prim_phone_dis = document.createElement("p")
				prim_phone_dis.className = d
				prim_phone_dis.textContent = "Primary phone number:"
				
				let email_dis = document.createElement("p")
				email_dis.className = d
				email_dis.textContent = "Email:"
				
				let amount_reimbursed_of_the_year_dis = document.createElement("p")
				amount_reimbursed_of_the_year_dis.className = d
				amount_reimbursed_of_the_year_dis.textContent = "Amount reimbursed this year:"
				
				let position_dis = document.createElement("p")
				position_dis.className = d
				position_dis.textContent = "Position:"
								
				let is_manager_dis = document.createElement("p")
				is_manager_dis.className = d
				is_manager_dis.textContent = "Is a manager:"
				
				
				//generate employee actual info
				let id_info = document.createElement('p')
				id_info.className = i
				id_info.textContent = e["empl_id"]
				
				let empl_name_info = document.createElement('p')
				empl_name_info.className = i
				empl_name_info.textContent = e["first_name"] + " " + e["last_name"]
				
				let dob_info = document.createElement("p")
				dob_info.className = i
				let parsedDate = new Date(e["dob"])
				dob_info.textContent = parsedDate.getFullYear() + "-" + parsedDate.getMonth() + "-" + parsedDate.getDate()
				
				let prim_phone_info = document.createElement("p")
				prim_phone_info.className = i
				let parsedPhone = e["prim_phone"]
				let parsedPhoneString = parsedPhone.toString()
				prim_phone_info.textContent = parsedPhoneString.substring(0,3) + "-" + parsedPhoneString.substring(3,6) + "-" + parsedPhoneString.substring(6)
				
				let email_info = document.createElement("p")
				email_info.className = i
				email_info.textContent = e["email"]
				
				let amount_reimbursed_of_the_year_info = document.createElement("p")
				amount_reimbursed_of_the_year_info.className = i
				amount_reimbursed_of_the_year_info.textContent = "$" + e["amount_reimbursed_of_the_year"]
				
				let position_info = document.createElement("p")
				position_info.className = i
				position_info.textContent = e["position"]
								
				let is_manager_info = document.createElement("p")
				is_manager_info.className = i
				is_manager_info.textContent = e["is_manager"]
			
				
				//create a new div
				let single_div = document.createElement("div")
				single_div.className = "single_div"
				
				//append everything to this new div
				single_div.append(id_dis)
				single_div.append(id_info)
				single_div.append(empl_name_dis)
				single_div.append(empl_name_info)
				single_div.append(dob_dis)
				single_div.append(dob_info)
				single_div.append(prim_phone_dis)
				single_div.append(prim_phone_info)
				single_div.append(email_dis)
				single_div.append(email_info)
				single_div.append(amount_reimbursed_of_the_year_dis)
				single_div.append(amount_reimbursed_of_the_year_info)
				single_div.append(position_dis)
				single_div.append(position_info)
				single_div.append(is_manager_dis)
				single_div.append(is_manager_info)

				
				//append the new div to a predefined div in the html doc
				let data_div = document.getElementById("data_holder")
				data_div.append(single_div)
				
			}
		}
	}
}

window.onload = () => {
	getAllEmployees()
}