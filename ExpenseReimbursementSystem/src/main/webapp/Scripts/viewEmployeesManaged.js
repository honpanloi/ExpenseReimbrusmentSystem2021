/**
 * 
 */
let empl_id = document.getElementById("empl_id")
let view_btn = document.getElementById("view_btn")
let employee_btn = document.getElementById("employee_btn")

employee_btn.addEventListener("click", function(){
	
	let single_divs = document.getElementsByClassName("single_div")
	
	while(single_divs.length>0){
			single_divs[0].parentNode.removeChild(single_divs[0]);
	}
	getAllEmployees()
})

view_btn.addEventListener("click", function(){
	if(empl_id){
		
		let single_divs = document.getElementsByClassName("single_div")
		
		while(single_divs.length>0){
			single_divs[0].parentNode.removeChild(single_divs[0]);
		}
		
		let xhr = new XMLHttpRequest()

		xhr.open('GET', 'http://localhost:8080/ExpenseReimbursementSystem/api/getReimbursementByOwnerID?empl_id='+empl_id.value)
		xhr.send()
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				
				let reimbursement = JSON.parse(xhr.response)
			
				for(let r of reimbursement){
				
					let id_info = document.createElement("p")
					id_info.className = i
					let time_requested_info = document.createElement("p")
					time_requested_info.className = i
					let reimb_amount_info = document.createElement("p")
					reimb_amount_info.className = i
					let event_occurred_info = document.createElement("p")
					event_occurred_info.className = i
					let time_completed_info = document.createElement("p")
					time_completed_info.className = i
					let belongs_to_empl_id_info = document.createElement("p")
					belongs_to_empl_id_info.className = i
					let reimb_status_info = document.createElement("p")
					reimb_status_info.className = i
					
					reimb_status_info.textContent = r["reimb_status"]
					belongs_to_empl_id_info.textContent = r["belongs_to_empl_id"]
					id_info.textContent = r["reimb_id"]
					time_requested_info.textContent = r["time_requested"]
					reimb_amount_info.textContent = "$" + r["reimb_amount"]
					time_completed_info.textContent = r["time_completed"]
					let parsedDate = new Date(r["event_occurred"])
					event_occurred_info.textContent = parsedDate.getFullYear() + "-" + parsedDate.getMonth() + "-" + parsedDate.getDate()
					
					let single_div = document.createElement("div")
					let data_div = document.getElementById("data_holder")
					
					let id_dis = document.createElement('p')
					id_dis.className = d
					id_dis.textContent = "Reimbursement ID:"
					let time_requested_dis = document.createElement("p")
					time_requested_dis.className = d
					time_requested_dis.textContent = "Time requested:"
					let reimb_amount_dis = document.createElement("p")
					reimb_amount_dis.className = d
					reimb_amount_dis.textContent = "Amount of reimbursement:"
					let event_occurred_dis = document.createElement("p")
					event_occurred_dis.className = d
					event_occurred_dis.textContent = "Event occurred on:"
					let time_completed_dis = document.createElement("p")
					time_completed_dis.className = d
					time_completed_dis.textContent = "Time resolved:"
					let belongs_to_empl_id_dis = document.createElement("p")
					belongs_to_empl_id_dis.className = d
					belongs_to_empl_id_dis.textContent = "Requested by:"
					
					let reimb_status_dis = document.createElement("p")
					reimb_status_dis.className = d
					reimb_status_dis.textContent = "Result:"
					
					single_div.append(id_dis)
					single_div.append(id_info)
					single_div.append(belongs_to_empl_id_dis)
					single_div.append(belongs_to_empl_id_info)
					single_div.append(time_requested_dis)
					single_div.append(time_requested_info)
					single_div.append(reimb_amount_dis)
					single_div.append(reimb_amount_info)
					single_div.append(event_occurred_dis)
					single_div.append(event_occurred_info)
					single_div.append(reimb_status_dis)
					single_div.append(reimb_status_info)
					single_div.append(time_completed_dis)
					single_div.append(time_completed_info)
					
					single_div.className = "single_div"
					
					data_div.append(single_div)
				
				}
			}
		}
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